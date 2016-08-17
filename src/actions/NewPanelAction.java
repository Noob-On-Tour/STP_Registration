package actions;

import model.Record;
import model.Validate;
import view.MyFrame;

import javax.swing.*;

import static controller.Main.dataRecords;

/*
 * Created by Ahmed on 14-Aug-16.
 */
public class NewPanelAction {
    private final MyFrame stpFrame;
    private final TextFieldsVisibility visibility;

    public NewPanelAction(MyFrame stpFrame, TextFieldsVisibility visibility) {
        this.stpFrame = stpFrame;
        this.visibility = visibility;
    }

    public boolean addButtonAction(Validate validate) {
        String name = stpFrame.nameTextField.getText();
        String email = stpFrame.emailTextField.getText();
        String phone = stpFrame.phoneTextField.getText();
        boolean state = false;
        if (validate.Name(name) && validate.Email(email) && validate.Phone(phone)) {
            if (JOptionPane.showConfirmDialog(stpFrame, "Add New Record ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
                dataRecords.add(new Record(name, email, phone, Integer.toString(dataRecords.size() + 1), "1"));
                JOptionPane.showMessageDialog(stpFrame, "New Entry ID : " + dataRecords.size(), "ID", JOptionPane.INFORMATION_MESSAGE);
                state = true;
            }
        } else {
            JOptionPane.showMessageDialog(stpFrame, "Invalid entry.", "Error", JOptionPane.ERROR_MESSAGE);
            state = false;
        }
        visibility.clearNewPanel();
        return state;
    }
}
