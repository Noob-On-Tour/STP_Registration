package actions;

import javax.swing.*;

import static controller.Controller.updateDataTable;
import static controller.Main.*;
import static model.Operations.saveToFile;
import static model.Operations.setFileName;
import static view.Listener.saveFlag;
import static view.MyFrame.stpFrame;

/*
 * Created by Ahmed on 14-Aug-16.
 */
public class DataPanelAction {

    public void updateTableButtonAction() {
        updateDataTable();
    }

    public void exitButtonAction() {
        int toSave;
        if (saveFlag) {
            toSave = JOptionPane.showConfirmDialog(stpFrame, "Unsaved work !\n" +
                    "Do you want to save it ?", "Warning", JOptionPane.OK_CANCEL_OPTION);
            if (toSave == 0) saveButtonAction();
        }
        System.exit(0);
    }

    public void saveButtonAction() {
        setFileName(CREATED_CSV);
        saveToFile(dataRecords);
        JOptionPane.showMessageDialog(stpFrame, "Saved !", "Saved", JOptionPane.INFORMATION_MESSAGE);
    }

}
