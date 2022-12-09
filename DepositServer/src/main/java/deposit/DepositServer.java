package deposit;

import java.io.*;
import java.net.*;
import java.util.Properties;

public class DepositServer {
    private static int PORT;

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(DepositServer.class.getClassLoader().getResourceAsStream("server.properties"));
        PORT = Integer.parseInt(properties.getProperty("port"));

        try (ServerSocket servSocket = new ServerSocket(8080)) {
            System.out.println("Сервер запущен");
            while (true) {
                Socket socket = servSocket.accept();
                System.out.println("Был подключен новый клиент");
                try {
                    new ThreadServer(socket);
                } catch (IOException e) {
                    socket.close();
                }
            }
        }
    }
}
