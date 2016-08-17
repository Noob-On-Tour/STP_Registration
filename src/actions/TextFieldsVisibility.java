package actions;

import model.Record;

import static view.MyFrame.stpFrame;

/*
 * Created by Ahmed on 14-Aug-16.
 */
public class TextFieldsVisibility {

    void clearSearchPanel() {
        stpFrame.nameSearchResult.setText(null);
        stpFrame.idSearchResult.setText(null);
        stpFrame.phoneSearchResult.setText(null);
        stpFrame.emailSearchResult.setText(null);
        stpFrame.attendedRadioButton.setSelected(false);
    }

    void setSearchPanel(Record searchResult) {
        stpFrame.nameSearchResult.setText(searchResult.getName());
        stpFrame.idSearchResult.setText(searchResult.getId());
        stpFrame.phoneSearchResult.setText(searchResult.getPhone());
        stpFrame.emailSearchResult.setText(searchResult.getEmail());
        stpFrame.attendedRadioButton.setSelected(Boolean.parseBoolean(searchResult.getAttendance()));
    }

    void clearNewPanel() {
        stpFrame.nameTextField.setText(null);
        stpFrame.emailTextField.setText(null);
        stpFrame.phoneTextField.setText(null);
    }
}
