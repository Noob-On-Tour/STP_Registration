package actions;

import model.Record;
import model.Search;
import model.Validate;

import javax.swing.*;

import static controller.Main.dataRecords;
import static view.Listener.searchResult;
import static view.MyFrame.stpFrame;

/*
 * Created by Ahmed on 14-Aug-16.
 */
public class SearchPanelAction {

    private final TextFieldsVisibility visibility;
    private final DataPanelAction dataPanel;

    public SearchPanelAction(TextFieldsVisibility visibility, DataPanelAction dataPanel) {
        this.visibility = visibility;
        this.dataPanel = dataPanel;
    }

    public boolean confirmButtonAction() {

        if (searchResult != null) {
            String id = stpFrame.idSearchResult.getText();
            String attendance = Boolean.toString(stpFrame.attendedRadioButton.isSelected());
            for (Record record : dataRecords) {
                if (record.getId().equals(id)) {
                    record.setAttendance(attendance);
                    break;
                }
            }
            JOptionPane.showMessageDialog(stpFrame, "Confirmed !", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(stpFrame, "Please make a valid search first !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    public void searchButtonAction(Validate validate) {
        String searchBy = stpFrame.searchByComboBox.getSelectedItem().toString();
        String searchValue = stpFrame.searchTextField.getText();
        Search search = new Search(searchValue);
        searchResult = null;
        switch (searchBy) {
            case "ID":
                if (validate.ID(searchValue)) searchResult = search.ByID();
                else
                    JOptionPane.showMessageDialog(stpFrame, "Invalid Search Value !", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case "Email":
                if (validate.Email(searchValue)) searchResult = search.ByEmail();
                else
                    JOptionPane.showMessageDialog(stpFrame, "Invalid Search Value !", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case "Phone":
                if (validate.Phone(searchValue)) searchResult = search.ByPhone();
                else
                    JOptionPane.showMessageDialog(stpFrame, "Invalid Search Value !", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }

        if (searchResult != null) {
            visibility.setSearchPanel(searchResult);
        }

    }


    public boolean deleteButtonAction() {
        if (searchResult != null) {
            for (int i = 0; i < dataRecords.size(); i++) {
                if (dataRecords.get(i).getId().equals(searchResult.getId())) {
                    dataRecords.remove(i);
                    JOptionPane.showMessageDialog(stpFrame, "Deleted Successfully !", "Deleted", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            }
            return false;
        } else {
            JOptionPane.showMessageDialog(stpFrame, "Please Make a valid search first !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    public boolean editButtonAction() {
        String name = stpFrame.nameSearchResult.getText();
        String phone = stpFrame.phoneSearchResult.getText();
        String email = stpFrame.emailSearchResult.getText();
        String attendance = Boolean.toString(stpFrame.attendedRadioButton.isSelected());
        Validate validate = new Validate();
        if (validate.Email(email) && validate.ID(searchResult.getId()) && validate.Phone(phone) && validate.Name(name)) {
            Record modifiedRecord = new Record(name, email, phone, searchResult.getId(), attendance);
            for (int i = 0; i < dataRecords.size(); i++) {
                if (dataRecords.get(i).getId().equals(searchResult.getId())) {
                    dataRecords.set(i, modifiedRecord);
                    dataPanel.updateTableButtonAction();
                    JOptionPane.showMessageDialog(stpFrame, "Record Modified", "Done", JOptionPane.INFORMATION_MESSAGE);
                    visibility.clearSearchPanel();
                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(stpFrame, "Invalid Data Entered !\nPlease Check and fix it", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
