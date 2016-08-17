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
        for (Record r : dataRecords) {
            if (r.getId().equals(searchValue)) return r;
        }
        JOptionPane.showMessageDialog(stpFrame, "Value Not Found !", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public Record ByEmail() {
        for (Record r : dataRecords) {
            if (r.getEmail().equals(searchValue)) return r;
        }
        JOptionPane.showMessageDialog(stpFrame, "Value Not Found !", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public Record ByPhone() {
        for (Record r : dataRecords) {
            if (r.getPhone().equals(searchValue)) return r;
        }
        JOptionPane.showMessageDialog(stpFrame, "Value Not Found !", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

}
