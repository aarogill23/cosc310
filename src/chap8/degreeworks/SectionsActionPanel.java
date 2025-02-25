package chap8.degreeworks;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap8.courses.Course;
import chap8.courses.Section;
import chap8.courses.Term;
import chap8.users.User;

public class SectionsActionPanel extends ActionPanel {
    public SectionsActionPanel(Main main, ArrayList<User> allusers, ArrayList<Course> allcourses, ArrayList<Section> allsections, ArrayList<Term> allterms) {
        super(main, allusers, allcourses, allsections, allterms);
    }

    public void loadSection(Section s) {
    }

        @Override
    protected String getTitle() {
        // TODO Auto-generated method stub
        return "SECTIONS ACTION PANEL";
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
        return new JButton[] {};
    }

}
