package actions;

import javax.swing.*;

import static controller.Main.ATTENDEES_CSV;
import static controller.Main.CREATED_CSV;
import static controller.Main.attendeesRecords;
import static model.Operations.saveToFile;
import static model.Operations.setFileName;
import static view.MyFrame.stpFrame;

/*
 * Created by Ahmed on 14-Aug-16.
 */
public class StatisticsPanelAction {

    public void createAttendeesFileButtonAction() {
        setFileName(ATTENDEES_CSV);
        saveToFile(attendeesRecords);
        JOptionPane.showMessageDialog(stpFrame, "File Created !", "", JOptionPane.INFORMATION_MESSAGE);
        setFileName(CREATED_CSV);
    }
    public void createSelectedAttendeesFileButtonAction(String selectedFileName)
    {
        setFileName(selectedFileName);
        saveToFile(attendeesRecords);
        setFileName(CREATED_CSV);
    }
}
