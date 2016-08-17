package model;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;

import static controller.Main.attendeesRecords;
import static controller.Main.dataRecords;


/*
 * Created by Ahmed on 11-Aug-16.
 */

public class Operations {
    private static String fileName;
    private static final String[] column = {"Name", "Email", "Phone", "ID", "Attendance"};


    public static DefaultTableModel makeDataTableModel() {
        DefaultTableModel model = new DefaultTableModel();
        for (String s : column) model.addColumn(s);
        for (Record dataRecord : dataRecords) model.addRow(dataRecord.toString().split(","));
        return model;
    }

    public static DefaultTableModel makeAttendeesTableModel() {
        DefaultTableModel model = new DefaultTableModel();
        for (String s : column) model.addColumn(s);
        attendeesRecords.clear();
        dataRecords.stream().filter(record -> record.getAttendance().equals("true")).forEachOrdered(record -> {
            model.addRow(record.toString().split(","));
            attendeesRecords.add(record);
        });
        return model;
    }

    public static void saveToFile(ArrayList<Record> dataRecords) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for (Record i : dataRecords) {
                String strLine = i.toString();
                bufferedWriter.write(strLine);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Record> loadFromFile() {
        dataRecords = null;
        try {
            dataRecords = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                String[] result = strLine.split(",");
                dataRecords.add(new Record(result[0], result[1], result[2], result[3], result[4]));
            }
        } catch (Exception e) {
            try {
                new FileWriter(fileName);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return dataRecords;
    }

    public static void setFileName(String fileName) {
        Operations.fileName = fileName;
    }
}
