package client;

import com.Logger;
import com.LoggerService;

import javax.swing.*;

public class LogForm extends JFrame {

    private JTextField descriptionField;
    private JComboBox httpBox;
    private JComboBox moduleBox;
    private JComboBox logTypeBox;
    private JButton sendButton;
    private JPanel panel;

    private int[] status = {200, 400, 401, 402, 403, 404, 405, 406, 407, 500};
    private String[] modules = {"Authorization", "Security", "Configuration", "Environment"};
    private String[] logTypes = {"Warning", "Debug", "Error"};

    public LogForm() {
        setTitle("MULTILOG Desktop Emitter");

        for (int i = 0; i < status.length; i++) {
            httpBox.addItem(status[i]);
        }

        for (int i = 0; i < modules.length; i++) {
            moduleBox.addItem(modules[i]);
        }

        for (int i = 0; i < logTypes.length; i++) {
            logTypeBox.addItem(logTypes[i]);
        }

        setContentPane(panel);
        setBounds(100, 100, 730, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        sendButton.addActionListener(e -> {
            Logger service = new LoggerService().getLoggerPort();

            if (!descriptionField.getText().isEmpty()) {
                String description = descriptionField.getText();
                String moduleName = moduleBox.getSelectedItem().toString();
                service.add(
                        descriptionField.getText().trim(),
                        logTypeBox.getSelectedIndex() + 1,
                        moduleBox.getSelectedItem().toString(),
                        Integer.parseInt(httpBox.getSelectedItem().toString()), 1
                );
                descriptionField.setText("");
                httpBox.setSelectedIndex(0);
                moduleBox.setSelectedIndex(0);
                logTypeBox.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "No puede enviar un log sin descripción.");
            }

        });
    }


    public static void main(String[] args) {
        LogForm emitterClient = new LogForm();
    }

}

