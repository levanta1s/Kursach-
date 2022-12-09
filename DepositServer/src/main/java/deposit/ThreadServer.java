package deposit;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadServer extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ThreadServer(Socket s) throws IOException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        setConnection();
        start();
    }

    public static void setConnection(){
        try {
            Properties properties = new Properties();
            properties.load(ThreadServer.class.getClassLoader().getResourceAsStream("server.properties"));
            DatabaseConnection.getInstance().setDriverName(properties.getProperty("db_driver_name"));
            DatabaseConnection.getInstance().initConnection(properties.getProperty("db_url"), properties.getProperty("db_name"), properties.getProperty("db_pass"));
            System.out.println("Сервер соединен с базой данных");
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        int idOperation;
        ServerWork obj = new ServerWork(in, out);
        try {
            while (true) {
                String bufString = in.readLine();
                if (bufString.equals("END")) {
                    DatabaseConnection.getInstance().close();
                    System.out.println("Сервер отсоединен от базы данных");
                    break;
                }
                idOperation = Integer.parseInt(bufString);
                obj.getId(idOperation);
            }
            System.out.println("Клиент был отсоединен");
        } catch (IOException ex) {
            System.err.println("IO Exception");
        } catch (SQLException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                System.err.println("Socket not closed");
            }
        }
    }
}
