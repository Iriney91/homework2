package lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final static String SERVER_ADDR = "localhost";
    private final static int SERVER_PORT = 8189;

    public static void main(String[] args) {
        try {
            Socket sock = new Socket(SERVER_ADDR, SERVER_PORT);
            PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);
            Scanner sc = new Scanner(sock.getInputStream());
            Scanner in = new Scanner(System.in);

            new Thread(() -> {
                while (true) {
                    String str = in.nextLine();
                    pw.println(str);
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    String str = sc.nextLine();
                    System.out.println(str);
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
