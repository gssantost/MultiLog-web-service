package com.service;

import com.daos.LogDAO;
import com.entities.Log;
import com.utils.ConfigProperties;
import com.utils.FileManager;
import com.utils.LogParser;
import com.utils.Prop;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService
public class Logger {

    public static List<Log> logs;

    public static List<Log> get() {
        return logs;
    }

    public static void add(Log _log) {
        if (logs != null) {
            logs.add(_log);
        } else {
            logs = new ArrayList<Log>();
            logs.add(_log);
        }
    }

    @WebMethod
    public String ping() {
        return "Service available.";
    }


    @WebMethod
    public Boolean add(@WebParam(name = "description") String description, @WebParam(name = "logType") int logType, @WebParam(name = "moduleName") String module,
                       @WebParam(name = "statusCode") int statusCode, @WebParam(name = "platform") int platform) {
        Boolean didInsert = null;
        Log didLog = null;
        Log log = new Log();
        log.setDescription(description);
        log.setLogType(logType);
        log.setModule(module);
        log.setCode(statusCode);
        log.setUrl("/here");
        log.setPlatform(platform);
        try {
            didLog = new LogDAO().addLog(log);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            didInsert = false;
        }
        System.out.println("AFTER INSERT INTO DB");
        if (didLog != null) {
            System.out.println("DID LOG");
            didInsert = true;
            add(didLog);

            boolean textFiles = Boolean.valueOf(new Prop().getProperty("textFiles"));

            if (textFiles) {
                int size = 0;
                for(Log _log: this.logs) {
                    size = size + _log.getMessageFormat().length();
                }
                System.out.println("Logs size: " + size);
                if(Integer.valueOf(new Prop().getProperty("sizeFile")) < size) {
                    FileManager fm = new FileManager();
                    try {
                        fm.printLogs(this.logs);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } finally {
                        this.logs.clear();
                    }
                }
            }
        }
        return didInsert;
    }

    @WebMethod
    public String getLog(@WebParam(name = "date") String date) {
        List<Log> logs = null;
        try {
            logs = new LogDAO().get(date);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        JSONArray data = new LogParser().doArray(logs);
        return data.toString();
    }

    @WebMethod(operationName = "getLogByRange")
    public String getLogByRange(@WebParam(name = "dateFrom") String dateFrom, @WebParam(name = "dateTo") String dateTo) {
        List<Log> logs = null;
        try {
            logs = new LogDAO().get(dateFrom, dateTo);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        JSONArray data = new LogParser().doArray(logs);
        return data.toString();
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

}
