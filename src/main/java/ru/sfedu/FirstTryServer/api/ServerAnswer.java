package ru.sfedu.FirstTryServer.api;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.*;
import java.util.Scanner;

import static ru.sfedu.FirstTryServer.Constants.PORT;

public class ServerAnswer {

    public ServerAnswer() {
    try (var s = new ServerSocket(PORT))
    {

        try (Socket incoming = s.accept())
        {
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();

            try (var in = new Scanner(inStream,StandardCharsets.UTF_8)){
                var out = new PrintWriter(new OutputStreamWriter(outStream,StandardCharsets.UTF_8),true);
                out.println("Hello, its nout ");
                var done = false;
                while (!done && in.hasNextLine()){
                    String line = in.nextLine();
                    out.println("Echo: "+line);
                    if (line.trim().equals("BYE")) done = true;
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
