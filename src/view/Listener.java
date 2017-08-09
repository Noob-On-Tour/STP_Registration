package view;

import actions.*;
import model.FixFile;
import model.Record;
import model.Validate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static controller.Controller.updateDataTable;

/*
 * Created by Ahmed on 13-Aug-16.
 */
public class Listener implements ActionListener {
    public static Record searchResult;
    public static boolean saveFlag = false;
    private final MyFrame stpFrame;
    public String currentDir = null;
    public String selectedFile = null;
    public String selectedFileAfterFix = null;
    public FixFile loadFile;

    public Listener(MyFrame stp_frame) {
        this.stpFrame = stp_frame;
        addActionListener();
    }

    private void addActionListener() {
//Buttons
        stpFrame.addButton.addActionListener(this);
        stpFrame.searchButton.addActionListener(this);
        stpFrame.confirmButton.addActionListener(this);
        stpFrame.saveButton.addActionListener(this);
        stpFrame.updateTableButton.addActionListener(this);
        stpFrame.EXITButton.addActionListener(this);
        stpFrame.editButton.addActionListener(this);
        stpFrame.createAttendeesFileButton.addActionListener(this);
        stpFrame.deleteButton.addActionListener(this);
        stpFrame.selectFileButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Panels Actions
        TextFieldsVisibility visibility = new TextFieldsVisibility();
        NewPanelAction newPanel = new NewPanelAction(stpFrame, visibility);
        DataPanelAction dataPanelAction = new DataPanelAction();
        SearchPanelAction searchPanelAction = new SearchPanelAction(visibility, dataPanelAction);
        StatisticsPanelAction statisticsPanelAction = new StatisticsPanelAction();
        //
        Object source = e.getSource();
        Validate validate = new Validate();
        boolean isChanged = false;

        //New Panel
        if (source == stpFrame.addButton) {
            isChanged = newPanel.addButtonAction(validate);
        }

        //Search Panel
        else if (source == stpFrame.searchButton) {
            searchPanelAction.searchButtonAction(validate);
        } else if (source == stpFrame.confirmButton) {
            if (stpFrame.attendedRadioButton.isSelected())
                isChanged = searchPanelAction.confirmButtonAction();
            else {
                JOptionPane.showMessageDialog(null, "You have to click attend first", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (source == stpFrame.editButton) {
            isChanged = searchPanelAction.editButtonAction();
        } else if (source == stpFrame.deleteButton) {
            isChanged = searchPanelAction.deleteButtonAction();
        }

        //Data Panel
        else if (source == stpFrame.saveButton) {
            String writeFile = JOptionPane.showInputDialog(null, "Please enter the file name", "");
            dataPanelAction.saveFileAction(currentDir + "/" + writeFile + ".csv");
            saveFlag = false;
        } else if (source == stpFrame.updateTableButton) {
            dataPanelAction.updateTableButtonAction();
        } else if (source == stpFrame.EXITButton) {
            dataPanelAction.exitButtonAction();
        } else if (source == stpFrame.selectFileButton) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(stpFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile().getAbsolutePath();
                currentDir = fileChooser.getSelectedFile().getParentFile().getAbsolutePath();
                 selectedFileAfterFix = currentDir + "/created.csv";
                 loadFile = new FixFile(selectedFile, selectedFileAfterFix);
                dataPanelAction.selectFileButtonAction(selectedFileAfterFix);
            }
        }

        //StatisticsPanelAction panel
        else if (source == stpFrame.createAttendeesFileButton) {
            statisticsPanelAction.createAttendeesFileButtonAction();
            statisticsPanelAction.createSelectedAttendeesFileButtonAction(currentDir + "/Attendees.csv");
        }

        if (isChanged) {
            updateDataTable();
            saveFlag = true;
        }
    }
//
//    private boolean deleteButtonAction() {
//        if (searchResult != null) {
//            for (int i = 0; i < dataRecords.size(); i++) {
//                if (dataRecords.get(i).getId().equals(searchResult.getId())) {
//                    dataRecords.remove(i);
//                    JOptionPane.showMessageDialog(stpFrame, "Deleted Successfully !", "Deleted", JOptionPane.INFORMATION_MESSAGE);
//                    return true;
//                }
//            }
//            return false;
//        } else {
//            JOptionPane.showMessageDialog(stpFrame, "Please Make a valid search first !", "Error", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//    }
//
//
//    private boolean editButtonAction() {
//        String name = stpFrame.nameSearchResult.getText();
//        String phone = stpFrame.phoneSearchResult.getText();
//        String email = stpFrame.emailSearchResult.getText();
//        String attendance = Boolean.toString(stpFrame.attendedRadioButton.isSelected());
//        Validate validate = new Validate();
//        if (validate.Email(email) && validate.ID(searchResult.getId()) && validate.Phone(phone) && validate.Name(name)) {
//            Record modifiedRecord = new Record(name, email, phone, searchResult.getId(), attendance);
//            for (int i = 0; i < dataRecords.size(); i++) {
//                if (dataRecords.get(i).getId().equals(searchResult.getId())) {
//                    dataRecords.set(i, modifiedRecord);
//                    updateTableButtonAction();
//                    JOptionPane.showMessageDialog(stpFrame, "Record Modified", "Done", JOptionPane.INFORMATION_MESSAGE);
//                    clearSearchPanel();
//                    return true;
//                }
//            }
//        } else {
//            JOptionPane.showMessageDialog(stpFrame, "Invalid Data Entered !\nPlease Check and fix it", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        return false;
//    }
//
//    private void exitButtonAction() {
//        int toSave;
//        if (saveFlag) {
//            toSave = JOptionPane.showConfirmDialog(stpFrame, "Unsaved work !\n" +
//                    "Do you want to save it ?", "Warning", JOptionPane.OK_CANCEL_OPTION);
//            if (toSave == 0) saveButtonAction();
//        }
//        System.exit(0);
//    }
//
//
//    private boolean addButtonAction(Validate validate) {
//        String name = stpFrame.nameTextField.getText();
//        String email = stpFrame.emailTextField.getText();
//        String phone = stpFrame.phoneTextField.getText();
//        boolean state = false;
//        if (validate.Name(name) && validate.Email(email) && validate.Phone(phone)) {
//            if (JOptionPane.showConfirmDialog(stpFrame, "Add New Record ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
//                dataRecords.add(new Record(name, email, phone, Integer.toString(dataRecords.size() + 1), "1"));
//                JOptionPane.showMessageDialog(stpFrame, "New Entry ID : " + dataRecords.size(), "ID", JOptionPane.INFORMATION_MESSAGE);
//                state = true;
//            }
//        } else {
//            JOptionPane.showMessageDialog(stpFrame, "Invalid entry.", "Error", JOptionPane.ERROR_MESSAGE);
//            state = false;
//        }
//        clearNewPanel();
//        return state;
//    }
//
//    private void searchButtonAction(Validate validate) {
//        String searchBy = stpFrame.searchByComboBox.getSelectedItem().toString();
//        String searchValue = stpFrame.searchTextField.getText();
//        Search search = new Search(searchValue, stpFrame);
//        searchResult = null;
//        switch (searchBy) {
//            case "ID":
//                if (validate.ID(searchValue)) searchResult = search.ByID();
//                else
//                    JOptionPane.showMessageDialog(stpFrame, "Invalid Search Value !", "Error", JOptionPane.ERROR_MESSAGE);
//                break;
//            case "Email":
//                if (validate.Email(searchValue)) searchResult = search.ByEmail();
//                else
//                    JOptionPane.showMessageDialog(stpFrame, "Invalid Search Value !", "Error", JOptionPane.ERROR_MESSAGE);
//                break;
//            case "Phone":
//                if (validate.Phone(searchValue)) searchResult = search.ByPhone();
//                else
//                    JOptionPane.showMessageDialog(stpFrame, "Invalid Search Value !", "Error", JOptionPane.ERROR_MESSAGE);
//                break;
//        }
//
//        if (searchResult != null) {
//            setSearchPanel(searchResult);
//        }
//
//    }
//
//    private boolean confirmButtonAction() {
//        if (searchResult != null) {
//            String id = stpFrame.idSearchResult.getText();
//            String attendance = Boolean.toString(stpFrame.attendedRadioButton.isSelected());
//            for (Record record : dataRecords) {
//                if (record.getId().equals(id)) {
//                    record.setAttendance(attendance);
//                    break;
//                }
//            }
//            JOptionPane.showMessageDialog(stpFrame, "Confirmed !", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
//            return true;
//        } else {
//            JOptionPane.showMessageDialog(stpFrame, "Please make a valid search first !", "Error", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//    }
//
//    private void saveButtonAction() {
//        setFileName(CREATED_CSV);
//        saveToFile(dataRecords);
//        JOptionPane.showMessageDialog(stpFrame, "Saved !", "Saved", JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    private void createAttendeesFileButtonAction() {
//        setFileName(ATTENDEES_CSV);
//        saveToFile(attendeesRecords);
//        JOptionPane.showMessageDialog(stpFrame, "File Created !", "", JOptionPane.INFORMATION_MESSAGE);
//        setFileName(CREATED_CSV);
//    }
//
//    private void clearSearchPanel() {
//        stpFrame.nameSearchResult.setText(null);
//        stpFrame.idSearchResult.setText(null);
//        stpFrame.phoneSearchResult.setText(null);
//        stpFrame.emailSearchResult.setText(null);
//        stpFrame.attendedRadioButton.setSelected(false);
//    }
//
//    private void setSearchPanel(Record searchResult) {
//        stpFrame.nameSearchResult.setText(searchResult.getName());
//        stpFrame.idSearchResult.setText(searchResult.getId());
//        stpFrame.phoneSearchResult.setText(searchResult.getPhone());
//        stpFrame.emailSearchResult.setText(searchResult.getEmail());
//        stpFrame.attendedRadioButton.setSelected(Boolean.parseBoolean(searchResult.getAttendance()));
//    }
//
//    private void clearNewPanel() {
//        stpFrame.nameTextField.setText(null);
//        stpFrame.emailTextField.setText(null);
//        stpFrame.phoneTextField.setText(null);
//    }
//
//    private void updateTableButtonAction() {
//        updateDataTable();
//    }
}
