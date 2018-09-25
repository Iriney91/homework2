package lesson7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final static String SERVER_ADDR = "localhost";
    private final static int SERVER_PORT = 8189;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDR, SERVER_PORT);
            DataInputStream socin = new DataInputStream(socket.getInputStream());
            DataOutputStream socout = new DataOutputStream(socket.getOutputStream());
            Scanner in = new Scanner(System.in);

            new Thread(() -> {
                while (true) {
                    String str = in.nextLine();
                    try {
                        socout.writeUTF(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    try {
                        String str = socin.readUTF();
                        System.out.println(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
