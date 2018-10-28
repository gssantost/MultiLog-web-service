package com.utils;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.List;

public class FileManager {

    private String logsPath;

    public FileManager() {
        this.logsPath = System.getProperty("user.home") + "\\mainLog.txt";
        System.out.println(this.logsPath);
    }

    public void add(List<String> lines) throws IOException {
        lines.add(0, "Log checked on " + new Date().toString());
        lines.add(lines.size(), "\n");
        Files.write(Paths.get(this.logsPath), lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

}
