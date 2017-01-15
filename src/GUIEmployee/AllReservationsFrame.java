package GUIEmployee;

import DAO.Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Izabela on 2017-01-14.
 */
public class AllReservationsFrame {
    public JPanel panel;
    private JLabel headerLabel;
    private JTextField searchTextField;
    private JButton searchButton;
    private Connector connector;
    private JScrollPane scrollPane;
    private JTable reservationsTable;

    public AllReservationsFrame(Connector connector) throws SQLException {
        this.connector = connector;

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = searchTextField.getText();
                List<Reservation> reservations = null;

                if (ID != null && ID.trim().length() > 0){
                    try {
                        reservations = connector.searchReservation(Integer.parseInt(ID), "{call szukaj_wszystkich_rezerwacji(?)}");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    try {
                        reservations = connector.getReservations("SELECT * FROM widok_wszystkich_rezerwacji");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

                ReservationTableModel reservationTableModel = new ReservationTableModel(reservations);
                reservationsTable.setModel(reservationTableModel);
            }
        });

        scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        reservationsTable = new JTable();
        scrollPane.setViewportView(reservationsTable);
    }
}
