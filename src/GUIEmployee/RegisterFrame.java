package GUIEmployee;

import DAO.Connector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Izabela on 2017-01-06.
 */
public class RegisterFrame extends JDialog {
    private JTextField loginTextField;
    private JPasswordField passwordTextField;
    private JPasswordField repeatPasswordTextField;
    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField PESELTextField;
    private JTextField IDNumberTextField;
    private JButton registerButton;
    private JRadioButton questRadioButton;
    private JRadioButton employeeRadioButton;
    public JPanel panel;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JLabel repeatPasswordLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel PESELLabel;
    private JLabel IDNumberLabel;
    private Connector connector;
    private JDialog dialog = this;

    public RegisterFrame(Connector connector){
        this.connector = connector;
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(questRadioButton);
        buttonGroup.add(employeeRadioButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginTextField.getText().trim();
                String password = passwordTextField.getText().trim();
                String repeatedPassword = repeatPasswordTextField.getText().trim();
                String name = nameTextField.getText().trim();
                String surname = surnameTextField.getText().trim();
                String PESEL = PESELTextField.getText().trim();
                String IDNumber = IDNumberTextField.getText().trim();
                String type;

                if(questRadioButton.isSelected()){
                    type = "gość";
                }
                else {
                    type = "pracownik";
                }

                if (!login.equals("") && !password.equals("") && !repeatedPassword.equals("") && !name.equals("") && !surname.equals("")
                        && !PESEL.equals("") && !IDNumber.equals("")){
                    if(!password.equals(repeatedPassword)){
                        JOptionPane.showMessageDialog(null,"Wpisane hasła różnią sie! Spróbuj ponownie.");
                    }
                    else {
                        try {
                            connector.addUser(login,password,name,surname,PESEL,IDNumber,type);
                            dispose(); //nie działa
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null,"Konto o wprowadzonych danych już istnieje: " + e1);
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Wypełnij wszystkie pola!");
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
