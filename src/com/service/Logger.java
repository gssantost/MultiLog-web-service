package com.service;

import com.daos.LogDAO;
import com.entities.Log;
import com.utils.ConfigProperties;
import com.utils.FileManager;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebService
public class Logger {

    private static final String ADDRESS = "http://localhost:8080:/gger";
    //private FileManager fm;

    public static void main(String[] args) {
        Object implementor = new Logger();
        Endpoint.publish(ADDRESS, implementor);
    }

    @WebMethod
    public String ping() {
        return "Service available.";
    }

    @WebMethod
    public Boolean add(Log log) {
        Boolean didInsert = false;
        ConfigProperties configProperties = ConfigProperties.getInstance();
        if(Boolean.parseBoolean(configProperties.getProperty("activeDb"))) {
            try {
                 didInsert = new LogDAO().addLog(log);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return didInsert;
    }

    @WebMethod
    public Boolean delete(int id) {
        return null;
    }

    @WebMethod
    public void getLog(String date) {
        List<Log> logs = null;
        try {
            logs = new LogDAO().get(date);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        FileManager fm = new FileManager();
        List<String> lines = new ArrayList<>();
        for (Log _log : logs) {
            String logText =
                    ">DESCRIPTION: " + _log.getDescription() + "\n" +
                    ">MODULE: " + _log.getModule() + "\n" +
                    ">HTTP_STATUS: " + _log.getCode() + "\n";
            lines.add(logText);
            System.out.println(logText);
        }

        try {
            fm.add(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*private void save(String txt) {
        this.fm = new FileManager();
        try {
            if (this.fm.createFile()) {
                this.fm.add(txt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
