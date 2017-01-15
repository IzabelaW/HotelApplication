package GUIEmployee;

import DAO.Connector;
import GUIGuest.GuestWelcomeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Izabela on 2017-01-06.
 */
public class LogInFrame extends JFrame{
    public JPanel panel;
    private JFrame frame = this;
    private JTextField loginTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel headerLabel;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private Connector connector;

    public LogInFrame(Connector connector){
        this.connector = connector;
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog registerFrame = new JDialog(frame,"HotelApp");
                registerFrame.setContentPane(new RegisterFrame(connector).panel);
                registerFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                registerFrame.pack();
                registerFrame.setVisible(true);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginTextField.getText().trim();
                String password = passwordField.getText().trim();
                String type = null;
                try {
                    type = connector.logIn(login,password);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                if (type == null){
                    JOptionPane.showMessageDialog(null, "Niepoprawny login lub hasło!");

                } else if (type.equals("gość")) {
                    GuestWelcomeFrame guestWelcomeFrame = new GuestWelcomeFrame(connector);
                } else if (type.equals("pracownik")){
                    JFrame employeeFrame = new JFrame("HotelApp");
                    try {
                        employeeFrame.setContentPane(new EmployeeFrame(connector).panel);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    employeeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    employeeFrame.pack();
                    employeeFrame.setVisible(true);
                    dispose();
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
