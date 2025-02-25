package chap8.degreeworks;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap8.courses.Course;
import chap8.courses.Section;
import chap8.courses.Term;
import chap8.users.User;

public class CoursesActionPanel extends ActionPanel {
    protected JTextField deptField;
    protected JTextField numField;
    protected JTextField titleField;
    protected JTextField creditsField;
    
    public CoursesActionPanel(Main main, ArrayList<User> allusers, ArrayList<Course> allcourses, ArrayList<Section> allsections, ArrayList<Term> allterms) {
        super(main, allusers, allcourses, allsections, allterms);
    }

    public void loadCourse(Course c) {
    }

    @Override
    protected String getTitle() {
        return "COURSES ACTION PANEL";
    }

    @Override
    protected JLabel[] getLabels() {
        return new JLabel[] {};
    }

    @Override
    protected JTextField[] getTextFields() {
        return new JTextField[] {};
    }

    @Override
    protected JButton[] getButtons() {
        addButton = new JButton("Add New Term");
        submitButton = new JButton("Add");
        cancelButton = new JButton("Cancel");
        updateButton = new JButton("Update Selected Term");        
        deleteButton = new JButton("Delete Selected Term");
        deleteButton.setForeground(Color.RED); // Sets text color to red
        updateButton.setVisible(false);
        deleteButton.setVisible(false);

        // now add all the listeners for the buttons
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameField.setText("");
                yearField.setText("");
                addButton.setVisible(false);
                updateButton.setVisible(false);
                deleteButton.setVisible(false);
                submitButton.setVisible(true);
                cancelButton.setVisible(true);
            }
        });
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = nameField.getText();
                String year = yearField.getText();
                Term t = new Term(name, year);
                allterms.add(t);
                main.catalogPanel.setSelectedTerm(t);
                main.catalogPanel.updateAllLists();
            }
        });
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Term t = main.catalogPanel.getSelectedTerm();
                if (t != null) {
                    loadTerm(main.catalogPanel.getSelectedTerm());
                } else if (allterms.size() > 0) {
                    main.catalogPanel.setSelectedTerm(allterms.get(0));
                    loadTerm(allterms.get(0));
                } else {
                    addButton.setVisible(true);
                    submitButton.setVisible(false);
                    cancelButton.setVisible(false);
                    updateButton.setVisible(false);
                    deleteButton.setVisible(false);
                }
            }
        });
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Term t = main.catalogPanel.getSelectedTerm();
                t.setName(nameField.getText());
                t.setYear(yearField.getText());
                main.catalogPanel.updateAllLists();
                loadTerm(t);
            }
        });
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Term t = main.catalogPanel.getSelectedTerm();
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this term?" + t, "Confirmation", JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    allterms.remove(t);
                    main.catalogPanel.updateAllLists();
                    nameField.setText("");
                    yearField.setText("");
                    addButton.setVisible(false);
                    submitButton.setVisible(true);
                    cancelButton.setVisible(true);
                    updateButton.setVisible(false);
                    deleteButton.setVisible(false);
                }
            }
        });
        return new JButton[] {addButton, submitButton, cancelButton, updateButton, deleteButton};
    }


}
