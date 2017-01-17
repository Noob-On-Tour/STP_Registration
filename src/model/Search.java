package model;

import view.MyFrame;

import javax.swing.*;

import static controller.Main.dataRecords;

/*
 * Created by Ahmed on 13-Aug-16.
 */
public class Search {
    private final String searchValue;
    private final MyFrame stpFrame;

    public Search(String searchValue) {
        this.searchValue = searchValue;
        this.stpFrame = MyFrame.stpFrame;
    }

    public Record ByID() {
        for (Record record : dataRecords) {
            if (record.getId().equals(searchValue)) return record;
        }
        JOptionPane.showMessageDialog(stpFrame, "Value Not Found !", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public Record ByEmail() {
        for (Record record : dataRecords) {
            if (record.getEmail().equals(searchValue)) return record;
        }
        JOptionPane.showMessageDialog(stpFrame, "Value Not Found !", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public Record ByPhone() {
        for (Record record : dataRecords) {
            if (record.getPhone().equals(searchValue)) return record;
        }
        JOptionPane.showMessageDialog(stpFrame, "Value Not Found !", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

}
