package GUIEmployee;

import DAO.Connector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Izabela on 2017-01-09.
 */
public class SearchForRoomFrame extends JDialog{
    public JPanel panel;
    private JLabel headerLabel;
    private JLabel PESELLabel;
    private JTextField PESELTextField;
    private JButton searchButton;
    private JTextArea textArea;
    private JPanel panel1;
    private Connector connector;

    public SearchForRoomFrame (Connector connector) {
        this.connector = connector;

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numberOfRoom = null;
                try {
                    numberOfRoom = connector.getNumberOfRoom(PESELTextField.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                if(!numberOfRoom.equals("0")) {
                    textArea.setText("Numer pokoju: " + numberOfRoom);
                } else
                    JOptionPane.showMessageDialog(null,"Obecnie nie ma w hotelu gościa o podanym peselu.");
            }
        });
    }

}
