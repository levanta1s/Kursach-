package depositclient;

import depositclient.model.SocketStream;

import java.net.*;
import java.io.*;

import views.Authorization;

public class DepositClient extends SocketStream {

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName(null);
        socket = new Socket(address, 8080);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        Authorization signingIn = new Authorization();
        signingIn.setVisible(true);
        signingIn.setLocationRelativeTo(null);
    }

}
