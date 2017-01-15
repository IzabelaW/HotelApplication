package GUIEmployee;

import DAO.Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Izabela on 2017-01-08.
 */
public class AllGuestsFrame extends JFrame{
    public JPanel panel;
    private JLabel headerLabel;
    private JTextField searchTextField;
    private JButton searchButton;
    private Connector connector;
    private JScrollPane scrollPane;
    private JTable guestsTable;

    public AllGuestsFrame(Connector connector) throws SQLException {
        this.connector = connector;

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String PESEL = searchTextField.getText();
                List<Guest> guests = null;

                if (PESEL != null && PESEL.trim().length() > 0){
                    try {
                        guests = connector.searchGuest(PESEL);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    try {
                        guests = connector.getGuests("SELECT * FROM widok_wszystkich_gości");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

                GuestTableModel guestTableModel = new GuestTableModel(guests);
                guestsTable.setModel(guestTableModel);
            }
        });

        scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        guestsTable = new JTable();
        scrollPane.setViewportView(guestsTable);
    }

}
