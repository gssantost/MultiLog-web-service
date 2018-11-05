package com.service;

import com.console.Memo;
import com.entities.Log;
import com.utils.ConfigProperties;

import javax.xml.ws.Endpoint;
import java.awt.*;

public class LoggerRunner {

    private static final String ADDRESS = "http://localhost:8080/services/Logger";

    public static void main(String[] args) {
        System.out.println("Web Service...");
        Object implementor = new Logger();
        Endpoint.publish(ADDRESS, implementor);

        EventQueue.invokeLater(() -> {
            try {
                Memo memo = new Memo();
                Logger temp = ((Logger) implementor);
                Runnable printThread = () -> {
                    while (temp.getLogList() == null) {
                        memo.append("Waiting for more logs to be available...\n\n");
                        sleep(2000);
                    }
                    while (temp.getLogList().size() >= 0) {
                         Boolean echo = Boolean.valueOf(ConfigProperties.getInstance().getProperty("echo"));
                         if (echo) {
                             if (temp.getLogList().isEmpty()) {
                                 memo.append("Waiting for more logs to be available...\n\n");
                                 sleep(2000);
                             } else {
                                 Log _log = temp.getLogList().get(0);
                                 memo.log(_log);
                                 memo.append("\n");
                                 temp.getLogList().remove(0);
                                 sleep(500);
                             }
                         } else {
                            memo.append("ECHO property must be 'true' for get Logger output.\n");
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
