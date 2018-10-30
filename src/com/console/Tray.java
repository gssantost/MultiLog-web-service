package com.console;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Tray {

    public static TrayIcon trayIcon;

    public Tray() {
        show();
    }

    public static void show() {
        if (!SystemTray.isSupported()) {
            System.exit(0);
        }
        trayIcon = new TrayIcon(createIcon("/com/resources/icon2.png", "Icon"));
        final SystemTray systemTray = SystemTray.getSystemTray();
        final PopupMenu menu = new PopupMenu();
        MenuItem about = new MenuItem("About");
        MenuItem exit = new MenuItem("Exit");

        about.addActionListener(e ->
                JOptionPane.showMessageDialog(null, "MultiLog 1.0.0 \nAuthors: GS - JL - FL - VF")
        );

        exit.addActionListener(e -> System.exit(0));

        menu.add(about);
        menu.addSeparator();
        menu.add(exit);
        trayIcon.setPopupMenu(menu);
        try {
            systemTray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    protected static Image createIcon(String path, String description) {
        URL imageURL = Tray.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}
