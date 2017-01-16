package GUIEmployee;

import DAO.Connector;

import javax.swing.*;

/**
 * Created by Izabela on 2017-01-06.
 */
public class Main {

    public static void main (String[] args) throws Exception {
        Connector connector = new Connector();
        LogInFrame logInFrame = new LogInFrame(connector);
        logInFrame.setVisible(true);
    }
}
