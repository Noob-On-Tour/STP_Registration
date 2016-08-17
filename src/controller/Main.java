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
    public static final String LIGHT_CSV = "Light.csv";
    public static final String ATTENDEES_CSV = "Attendees.csv";
    private static final String NAWART_16_RESPONSES_FORM_RESPONSES_1_CSV = "NAWART '16 (Responses) - Form Responses 1.csv";

    public static void main(String[] args) {
        if (new File(LIGHT_CSV).isFile()) Operations.setFileName(LIGHT_CSV);
        else if (new File(NAWART_16_RESPONSES_FORM_RESPONSES_1_CSV).isFile())
            new FixFile(NAWART_16_RESPONSES_FORM_RESPONSES_1_CSV, LIGHT_CSV);

        Operations.setFileName(LIGHT_CSV);
        setUIFlavour();
        new Controller();
    }

}
