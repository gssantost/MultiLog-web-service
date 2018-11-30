package com.utils;



import com.daos.LogTypeDAO;
import com.entities.Log;
import com.entities.LogType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileManager {

    private String logsPath;

    public FileManager() {
        this.logsPath = System.getProperty("user.home") + "\\log";
    }

    public void add(List<String> lines) throws IOException {
        lines.add(0, "Log checked on " + new Date().toString() + "\n");
        Files.write(Paths.get(this.logsPath), lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public void printLog(Log log) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("Log added on " + new Date().toString() + "\n");
        String logText =
                getTypeName(log) + "\t" +
                        ">DATE: " + new Date(log.getDate()) + "\t" +
                        ">DESCRIPTION: " + log.getDescription() + "\t" +
                        ">MODULE: " + log.getModule() + "\t" +
                        ">HTTP_STATUS: " + log.getCode() + "\n";
        lines.add(logText);
        lines.add("\n");

        Files.write(Paths.get(this.logsPath), lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public void printLogs(List<Log> logs) throws IOException, ParseException {
        List<String> lines = new ArrayList<>();
        lines.add("Logs checked on " + new Date().toString() + "\n");
        for (Log _log : logs) {
            lines.add(_log.getMessageFormat());
        }
        lines.add("\n");
        this.logsPath = this.logsPath + getFormattedDate(new Date()) + ".txt";
        System.out.println("Logs saved at " + this.logsPath);
        Files.write(Paths.get(this.logsPath), lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    private String getTypeName(Log log) {
        String logType = "";
        switch (log.getLogType()) {
            case 1: logType = "WARNING"; break;
            case 2: logType = "DEBUG"; break;
            case 3: logType = "ERROR"; break;
        }
        return logType;
    }

    private String getFormattedDate(Date date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }



}
