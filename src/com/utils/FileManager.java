package com.utils;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileManager {

    private final String filePath = "C:\\Users\\Giovanny Santos\\IdeaProjects\\MultiLog-web-service\\src\\logs\\newFile.txt";

    public Boolean createFile() {
        Boolean didCreate = false;
        Path newFilePath = Paths.get(filePath);
        try {
            Files.createFile(newFilePath);
            didCreate = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return didCreate;
    }

    public Boolean createFile(String path) {
        Boolean didCreate = false;
        Path newFilePath = Paths.get(path);
        try {
            Files.createFile(newFilePath);
            didCreate = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return didCreate;
    }

    public void add(List<String> lines) throws IOException {
        /*FileWriter fw = new FileWriter(filePath, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(txt);
        bw.newLine();
        bw.close();*/
        Files.write(Paths.get(filePath), lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

}
