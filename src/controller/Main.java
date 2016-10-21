package controller;

import model.FixFile;
import model.Operations;
import model.Record;

import java.io.File;
import java.util.ArrayList;

import static controller.Controller.setUIFlavour;

/*
 * Created by Ahmed on 08-Aug-16.
 */


public class Main {
    public static ArrayList<Record> dataRecords = new ArrayList<>();
    public static final ArrayList<Record> attendeesRecords = new ArrayList<>();
    public static final String CREATED_CSV = "created.csv";
    public static final String ATTENDEES_CSV = "attendees.csv";
    private static final String SOURCE_CSV = "source.csv";

    public static void main(String[] args) {
        if (new File(CREATED_CSV).isFile()) Operations.setFileName(CREATED_CSV);
        else if (new File(SOURCE_CSV).isFile())
            new FixFile(SOURCE_CSV, CREATED_CSV);
        Operations.setFileName(CREATED_CSV);
        setUIFlavour();
        new Controller();
        Operations.countUnique();
    }
}
