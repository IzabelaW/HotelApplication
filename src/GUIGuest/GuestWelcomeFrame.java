package GUIGuest;

import DAO.Connector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kasia on 2017-01-06.
 */
public class GuestWelcomeFrame extends JFrame{
    Connector connector;
    private JPanel panel1;
    private JButton searchForRoomsButton;
    private JButton searchForBookingButton;
    private JTextField welcomeField;
    private String login = "kasia";


    public GuestWelcomeFrame(Connector connector){
        super("Hotel Application");
        this.connector = connector;
        setContentPane(panel1);
        pack();
        makeMenuPanel();
        setVisible(true);
    }

    private void makeMenuPanel(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        searchForRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchForRoomFrame searchForRoomFrame = new SearchForRoomFrame(connector);
                searchForRoomFrame.setLogin(login);
            }
        });

        searchForBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyBookingsFrame myBookingsFrame = new MyBookingsFrame(connector);
                myBookingsFrame.setLogin(login);
                myBookingsFrame.showBookings();
            }
        });
    }


    private void createUIComponents() {

    }


}

