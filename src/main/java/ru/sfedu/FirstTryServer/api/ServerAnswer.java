package ru.sfedu.FirstTryServer.api;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

import static ru.sfedu.FirstTryServer.Constants.BACKUP1C_FOLDER;
import static ru.sfedu.FirstTryServer.Constants.PORT;
import static ru.sfedu.FirstTryServer.utils.ConfigurationUtil.getConfigurationEntry;

public class ServerAnswer {

    public ServerAnswer() {
        var repeat=false;
    while (!repeat)
    try (var s = new ServerSocket(PORT))

    {

        try (Socket incoming = s.accept())
        {
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();

            try (var in = new Scanner(inStream,StandardCharsets.UTF_8)){
                var out = new PrintWriter(new OutputStreamWriter(outStream,StandardCharsets.UTF_8),true);
                Path absolute = Paths.get(getConfigurationEntry(BACKUP1C_FOLDER));
                Optional<Path> lastFilePath = Files.list(absolute)    // here we get the stream with full directory listing
                        .filter(f -> !Files.isDirectory(f))  // exclude subdirectories from listing
                        .max(Comparator.comparingLong(f -> f.toFile().lastModified()));  // finally get the last file using simple comparator by lastModified field
                        BasicFileAttributes attr;
                        attr = Files.readAttributes(Path.of(String.valueOf(lastFilePath.get())), BasicFileAttributes.class);
                        out.println("----------------------------------------"+new Date()+"--------------------------------------");
                        out.println("Creation date: " + attr.creationTime());
                        double d=attr.size();
                        out.println("size: " + (d/1024/1024)+"GB");

                var done = false;

                while (!done && in.hasNextLine()){//обработка полученных данных от клиента
                    String line = in.nextLine();
                    out.println("Echo: "+line);
                    if (line.trim().equals("BYE")) done = true;
                    if (line.trim().equals("STOP")) repeat = true; done= true;
                }




            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
