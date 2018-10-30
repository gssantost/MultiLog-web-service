package com.service;

import com.daos.LogDAO;
import com.entities.Log;
import com.utils.ConfigProperties;
import com.utils.FileManager;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebService
public class Logger {

    public static List<Log> logs;

    public static List<Log> getLogList() {
        //System.out.println("Tamaño de ListLogs en el momento " + logs.size());
        return logs;
    }

    @WebMethod
    public String ping() {
        return "Service available.";
    }

    @WebMethod
    public Boolean add(@WebParam(name = "description") String description, @WebParam(name = "logType") int logType, @WebParam(name = "moduleName") String module,
                       @WebParam(name = "statusCode") int statusCode, @WebParam(name = "platform") int platform) {
        Boolean didInsert = null;
        Log log = new Log();
        log.setDescription(description);
        log.setLogType(logType);
        log.setModule(module);
        log.setCode(statusCode);
        log.setUrl("/here");
        log.setPlatform(platform);
        try {
            didInsert = new LogDAO().addLog(log);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return didInsert;
    }

    @WebMethod
    public Boolean delete(int id) {
        return null;
    }

    @WebMethod
    public void getLog(@WebParam(name = "date") String date) {
        try {
            logs = new LogDAO().get(date);
            FileManager fm = new FileManager();
            if (Boolean.valueOf(ConfigProperties.getInstance().getProperty("textFiles"))) {
                fm.printLogs(logs);
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    /*@WebMethod(operationName = "getLog1")
    public void getLog(@WebParam(name = "dateFrom") String dateFrom, @WebParam(name = "dateTo") String dateTo) {
        try {
            logs = new LogDAO().get(dateFrom, dateTo);
            FileManager fm = new FileManager();
            if (Boolean.valueOf(ConfigProperties.getInstance().getProperty("textFiles"))) {
                fm.printLogs(logs);
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }*/

}
