package GUIEmployee;

import DAO.Connector;

import javax.swing.*;

/**
 * Created by Izabela on 2017-01-06.
 */
public class Main {

    public static void main (String[] args) throws Exception {
        Connector connector = new Connector();
        JFrame logInFrame = new JFrame("HotelApp");
        logInFrame.setContentPane(new LogInFrame(connector).panel);
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInFrame.pack();
        logInFrame.setVisible(true);
    }
}
