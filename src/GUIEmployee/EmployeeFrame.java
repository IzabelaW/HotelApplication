package GUIEmployee;

import DAO.Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Izabela on 2017-01-06.
 */
public class EmployeeFrame extends JFrame{
    public JPanel panel;
    public JFrame frame = this;
    private JMenuBar menuBar;
    private Connector connector;
    private JMenu edit;
    private JMenu guests;
    private JMenu search;
    private JMenu reservations;
    private JTable ratingsTable;
    private JTable reservationsTable;
    private JPanel ratingsPanel;
    private JPanel reservationsPanel;
    private JMenuItem rooms;
    private JMenuItem typesOfRooms;
    private JMenuItem standards;
    private JMenuItem services;
    private JMenuItem searchRoom;
    private JMenuItem searchGuest;
    private JMenuItem presentGuests;
    private JMenuItem allGuests;
    private JMenuItem presentReservations;
    private JMenuItem allReservations;
    private JMenuItem addReservation;
    private JScrollPane ratingsScrollPane;
    private JScrollPane reservationsScrollPane;

    public EmployeeFrame(Connector connector) throws SQLException {
        this.connector = connector;

        rooms = new JMenuItem("Pokoje");
        standards = new JMenuItem("Standardy");
        typesOfRooms = new JMenuItem("Rodzaje pokojów");
        services = new JMenuItem("Usługi");
        searchGuest = new JMenuItem("Gościa");
        searchRoom = new JMenuItem("Pokój");
        presentGuests = new JMenuItem("Obecni");
        allGuests = new JMenuItem("Wszyscy");
        presentReservations = new JMenuItem("Obecne");
        allReservations = new JMenuItem("Wszystkie");
        addReservation = new JMenuItem("Dodaj");

        guests.add(presentGuests);
        guests.add(allGuests);

        reservations.add(presentReservations);
        reservations.add(allReservations);
        reservations.add(addReservation);

        edit.add(rooms);
        edit.add(typesOfRooms);
        edit.add(standards);
        edit.add(services);

        search.add(searchGuest);
        search.add(searchRoom);

        rooms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame roomsEditFrame = new JFrame("HotelApp");
                try {
                    roomsEditFrame.setContentPane(new RoomsEditFrame(connector).panel);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                roomsEditFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                roomsEditFrame.pack();
                roomsEditFrame.setVisible(true);
            }
        });

        typesOfRooms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame typesOfRoomsEditFrame = new JFrame("HotelApp");
                try {
                    typesOfRoomsEditFrame.setContentPane(new TypesOfRoomsEditFrame(connector).panel);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                typesOfRoomsEditFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                typesOfRoomsEditFrame.pack();
                typesOfRoomsEditFrame.setVisible(true);
            }
        });

        standards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame standardsEditFrame = new JFrame("HotelApp");
                try {
                    standardsEditFrame.setContentPane(new StandardsEditFrame(connector).panel);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                standardsEditFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                standardsEditFrame.pack();
                standardsEditFrame.setVisible(true);
            }
        });

        services.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame servicesEditFrame = new JFrame("HotelApp");
                try {
                    servicesEditFrame.setContentPane(new ServicesEditFrame(connector).panel);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                servicesEditFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                servicesEditFrame.pack();
                servicesEditFrame.setVisible(true);
            }
        });

        presentGuests.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame presentGuestFrame = new JFrame("HotelApp");
                try {
                    presentGuestFrame.setContentPane(new PresentGuestsFrame(connector).panel);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                presentGuestFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                presentGuestFrame.pack();
                presentGuestFrame.setVisible(true);
            }
        });

        allGuests.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame allGuestsFrame = new JFrame("HotelApp");
                try {
                    allGuestsFrame.setContentPane(new AllGuestsFrame(connector).panel);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                allGuestsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                allGuestsFrame.pack();
                allGuestsFrame.setVisible(true);
            }
        });

        presentReservations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame presentReservationsFrame = new JFrame("HotelApp");
                try {
                    presentReservationsFrame.setContentPane(new PresentReservationsFrame(connector).panel);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                presentReservationsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                presentReservationsFrame.pack();
                presentReservationsFrame.setVisible(true);
            }
        });

        allReservations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame allReservationsFrame = new JFrame("HotelApp");
                try {
                    allReservationsFrame.setContentPane(new AllReservationsFrame(connector).panel);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                allReservationsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                allReservationsFrame.pack();
                allReservationsFrame.setVisible(true);
            }
        });

        searchRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog searchForRoomDialog = new JDialog(frame,"HotelApp");
                searchForRoomDialog.setContentPane(new SearchForRoomFrame(connector).panel);
                searchForRoomDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                searchForRoomDialog.pack();
                searchForRoomDialog.setVisible(true);
            }
        });

        searchGuest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog searchForGuestDialog = new JDialog(frame,"HotelApp");
                searchForGuestDialog.setContentPane(new SearchForGuestFrame(connector).panel);
                searchForGuestDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                searchForGuestDialog.pack();
                searchForGuestDialog.setVisible(true);
            }
        });

        List<Rating> ratings = connector.getAllRatings();
        List<Reservation> reservations = connector.getReservations("SELECT * FROM rezerwacje_na_dziś");

        RatingsTableModel ratingsTableModel = new RatingsTableModel(ratings);
        ReservationTableModel reservationTableModel = new ReservationTableModel(reservations);

        ratingsScrollPane = new JScrollPane();
        ratingsPanel.add(ratingsScrollPane, BorderLayout.CENTER);

        ratingsTable = new JTable();
        ratingsTable.setModel(ratingsTableModel);
        ratingsScrollPane.setViewportView(ratingsTable);

        reservationsScrollPane = new JScrollPane();
        reservationsPanel.add(reservationsScrollPane, BorderLayout.CENTER);
        reservationsTable = new JTable();
        reservationsTable.setModel(reservationTableModel);
        reservationsScrollPane.setViewportView(reservationsTable);



    }


}
