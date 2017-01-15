package GUIEmployee;

import DAO.Connector;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class AddRoomDialog extends JDialog {
    private JPanel contentPane;
    private JButton addButton;
    private JLabel typeOfRoomLabel;
    private JTextField typeOfRoomTextField;
    private JCheckBox balkonyCheckBox;
    private JCheckBox swimmingPoolViewCheckBox;
    private JCheckBox seaViewCheckBox;
    private JButton cancelButton;
    private JTextField numberOfRoomTextField;
    private JLabel numberOfRoomLabel;
    private Connector connector;
    private RoomsEditFrame roomsEditFrame;
    private Room tmpRoom = null;
    private boolean updateMode = false;

    public AddRoomDialog(RoomsEditFrame roomsEditFrame, Connector connector, Room tmpRoom, boolean updateMode) {
        this.connector = connector;
        this.roomsEditFrame = roomsEditFrame;
        this.tmpRoom = tmpRoom;
        this.updateMode = updateMode;

        if (updateMode) {
            setTitle("Edycja pokoju");
            populateGui(tmpRoom);
        }

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String typeOfRoom = typeOfRoomTextField.getText();
                String numberOfRoom = numberOfRoomTextField.getText();
                boolean ifBalcony = false;
                boolean ifSwimmingPoolView = false;
                boolean ifSeaView = false;
                if (balkonyCheckBox.isSelected())
                    ifBalcony = true;
                if (swimmingPoolViewCheckBox.isSelected())
                    ifSwimmingPoolView = true;
                if (seaViewCheckBox.isSelected())
                    ifSeaView = true;

                Room room = null;

                if(!typeOfRoom.equals("") && !numberOfRoom.equals("")) {
                    if (updateMode){
                        room = tmpRoom;
                        room.setIfBalcony(ifBalcony);
                        room.setIfSeaView(ifSeaView);
                        room.setIfSwimmingPooView(ifSwimmingPoolView);
                        room.setNumberOfRoom(Integer.parseInt(numberOfRoom));
                        room.setTypeOfRoom(Integer.parseInt(typeOfRoom));
                    } else {
                        room = new Room(Integer.parseInt(numberOfRoom), Integer.parseInt(typeOfRoom), ifBalcony, ifSwimmingPoolView, ifSeaView);
                    }
                    try {
                        if (updateMode){
                            connector.updateRoom(room);
                        } else {
                            connector.addRoom(room);
                        }
                        setVisible(false);
                        dispose();
                        roomsEditFrame.refresh();
                        JOptionPane.showMessageDialog(roomsEditFrame, "Pokój został pomyślnie zapisany.", "Pokój zapisany", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(roomsEditFrame, "Błąd w trakcie zapisywania pokoju: " + ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wypełnij wszystkie pola!");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
    }

    public AddRoomDialog(RoomsEditFrame roomsEditFrame, Connector connector) {
        this(roomsEditFrame,connector,null,false);
    }

    private void populateGui(Room tmpRoom) {

        typeOfRoomTextField.setText(String.valueOf(tmpRoom.getTypeOfRoom()));
        numberOfRoomTextField.setText(String.valueOf(tmpRoom.getNumberOfRoom()));
        numberOfRoomTextField.setEditable(false);
        if(tmpRoom.isIfBalcony())
            balkonyCheckBox.setSelected(true);
        if(tmpRoom.isIfSeaView())
            seaViewCheckBox.setSelected(true);
        if(tmpRoom.isIfSwimmingPooView())
            swimmingPoolViewCheckBox.setSelected(true);

        addButton.setText("Edytuj");
    }

}
