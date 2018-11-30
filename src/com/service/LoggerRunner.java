package com.service;

import com.console.Memo;
import com.entities.Log;
import com.utils.ConfigProperties;
import com.utils.Prop;

import javax.xml.ws.Endpoint;
import java.awt.*;

public class LoggerRunner {

    private static final String ADDRESS = "http://localhost:8080/services/Logger";
    private static int logsSize = 0;

    public static void main(String[] args) {
        System.out.println("Web Service...");
        Object implementor = new Logger();
        Endpoint.publish(ADDRESS, implementor);

        EventQueue.invokeLater(() -> {
            try {
                Memo memo = new Memo();
                Logger logger = ((Logger) implementor);
                Runnable printThread = () -> {

                    memo.append("Waiting for logs to be available...\n\n");
                    while (logger.get() == null) {
                        sleep(2000);
                    }
                    while (logger.get().size() >= 0) {
                         Boolean echo = Boolean.valueOf(new Prop().getProperty("echo"));
                         if (echo) {
                             if (logger.get().isEmpty()) {
                                 sleep(1000);
                             } else {
                                 int size = logger.get().size();
                                 if(logsSize < size) {
                                     logsSize = size;
                                     int position = size-1;
                                     Log _log = logger.get().get(position);
                                     memo.log(_log);
                                     memo.append("\n");
//                                 logger.get().remove(position);
                                     sleep(1000);
                                 } else if(logsSize > size){
                                    logsSize = 0;
                                 }
                             }
                         } else {
                            //memo.append("ECHO property must be 'true' for get Logger output.\n");
                            sleep(2000);
                         }
                    }
                };
                new Thread(printThread).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
