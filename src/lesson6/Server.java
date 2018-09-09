package lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serv = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            Socket sock = serv.accept();
            System.out.println("Клиент подключился");
            Scanner in = new Scanner(System.in);
            Scanner sc = new Scanner(sock.getInputStream());
            PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);

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
            System.out.println("Ошибка инициализации сервера");
        }
    }
}