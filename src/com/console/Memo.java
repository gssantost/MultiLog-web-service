package com.console;


import com.entities.Log;
import com.utils.Prop;

import javax.swing.*;
import java.sql.Date;

public class Memo extends JFrame {
    private JPanel mainPanel;
    private JTextArea textArea;
    private JScrollPane textPane;
    private JButton clearButton;
    private Tray memoTray;

    public Memo() {
        //setSize(700, 700);
        memoTray = new Tray();
        setTitle("MultiLog Memo");
        setBounds(0, 0, 200, 500);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        clearButton.addActionListener(e -> {
            textArea.setText("");
            System.out.println("Cleared!");
        });
    }


    public void append(String text) {
        this.textArea.append(text);
    }

    public void log(Log log) {
        String logText =
                ">" + getTypeName(log) + " " +
                        ">DATE: " + new Date(log.getDate()) + "\t" +
                        ">DESCRIPTION: " + log.getDescription() + "\t" +
                        ">MODULE: " + log.getModule() + "\t" +
                        ">HTTP_STATUS: " + log.getCode() + "\n";

        String typeName = getTypeName(log);

        switch (typeName) {
            case "WARNING":
                if (Boolean.valueOf(new Prop().getProperty("warning"))) {
                    this.append(logText);
                }
                break;
            case "DEBUG":
                if (Boolean.valueOf(new Prop().getProperty("debug"))) {
                    this.append(logText);
                }
                break;
            case "ERROR":
                if (Boolean.valueOf(new Prop().getProperty("error"))) {
                    this.append(logText);
                }
                break;
        }
        //this.append(logText);
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
