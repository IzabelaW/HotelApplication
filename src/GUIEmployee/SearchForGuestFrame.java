package GUIEmployee;

import DAO.Connector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Izabela on 2017-01-09.
 */
public class SearchForGuestFrame {
    public JPanel panel;
    private JTextField textField;
    private JButton searchButton;
    private JTextArea textArea;
    private JLabel numberOfRoomLabel;
    private Connector connector;

    public SearchForGuestFrame (Connector connector) {
        this.connector = connector;

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String guest = null;
                try {
                    guest = connector.getGuest(textField.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                if (!guest.startsWith("null")) {
                    textArea.setText(guest);
                } else
                    JOptionPane.showMessageDialog(null,"Pokój jest wolny.");
            }
        });
    }


}
