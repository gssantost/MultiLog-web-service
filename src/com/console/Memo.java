package com.console;


import com.entities.Log;

import javax.swing.*;
import java.sql.Date;

public class Memo extends JFrame {
    private JPanel mainPanel;
    private JTextArea textArea;
    private JScrollPane textPane;
    private JButton clearButton;

    public Memo() {
        //setSize(700, 700);
        setTitle("MultiLog Memo");
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
                ">DATE: " + new Date(log.getDate()) + "\t" +
                ">DESCRIPTION: " + log.getDescription() + "\t" +
                ">MODULE: " + log.getModule() + "\t" +
                ">HTTP_STATUS: " + log.getCode() + "\n";
        this.append(logText);
    }
}
