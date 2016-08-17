package view;

import javax.swing.*;

/*
 * Created by Ahmed on 08-Aug-16.
 */

public class MyFrame extends JPanel {
    public JPanel mainPanel;
    public JTabbedPane tabbedPane;
    public JButton addButton;
    public JTextField nameTextField;
    public JTextField phoneTextField;
    public JTextField emailTextField;
    public JButton searchButton;
    public JComboBox searchByComboBox;
    public JTextField searchTextField;
    public JRadioButton attendedRadioButton;
    public JButton confirmButton;
    public JTable dataTable;
    public JScrollPane scrollPane;
    public JButton saveButton;
    public JButton updateTableButton;
    public JTextField idSearchResult;
    public JTextField nameSearchResult;
    public JTextField phoneSearchResult;
    public JTextField emailSearchResult;
    public JButton editButton;
    public JButton EXITButton;
    public JLabel attendanceCountLabel;
    public JButton createAttendeesFileButton;
    public JLabel totalCountLabel;
    public JScrollPane attendeesScrollPane;
    public JTable attendeesTable;
    public JButton deleteButton;

    private MyFrame() {
    }

    public static final MyFrame stpFrame = new MyFrame();

    public static MyFrame getInstance() {
        return stpFrame;
    }

}
