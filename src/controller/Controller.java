package controller;

/*
 * Created by Ahmed on 12-Aug-16.
 */

import view.Listener;

import javax.swing.*;
import java.awt.*;

import static controller.Main.attendeesRecords;
import static controller.Main.dataRecords;
import static model.Operations.*;
import static view.MyFrame.getInstance;

public class Controller {

    Controller() {
        dataRecords = loadFromFile();
        updateDataTable();
        new Listener(getInstance());
        setUIFlavour();
        initializeFrame();
    }

    static void setUIFlavour() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateDataTable() {
        getInstance().dataTable.setModel(makeDataTableModel());
        getInstance().attendeesTable.setModel(makeAttendeesTableModel());
        getInstance().dataTable.moveColumn(3, 0);
        getInstance().attendeesTable.moveColumn(3, 0);
        getInstance().totalCountLabel.setText(Integer.toString(dataRecords.size()));
        getInstance().attendanceCountLabel.setText(Integer.toString(attendeesRecords.size()));
    }

    private void initializeFrame() {
        JFrame frame = new JFrame("STP Registration");
        frame.setContentPane(getInstance().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1300, 700));
        frame.pack();
        frame.setVisible(true);
    }

}
