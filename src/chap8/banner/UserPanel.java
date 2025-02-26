package chap8.banner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import chap8.users.User;
import chap8.users.Student;
import chap8.users.Staff;
import chap8.users.Admin;
import chap8.users.Faculty;

public class UserPanel extends JPanel {
    private JTextField nameBox;
    private JTextField idBox;
    private JTextField usernameBox;
    private JTextField passwordBox;
    private JComboBox<String> typeDropdown;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton sortButton;
    private UserListPanel userListPanel;
    private ArrayList<User> allusers;
    private User selectedUser; // the current user being edited if the user has selected a user from the users list
    private boolean reverseSort = false;

    public UserPanel(UserListPanel userListPanel, ArrayList<User> allusers) {
        this.userListPanel = userListPanel;
        this.allusers = allusers;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Name: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nameBox = new JTextField(15);
        add(nameBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("ID (9#): "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        idBox = new JTextField(15);
        add(idBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Username: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usernameBox = new JTextField(15);
        add(usernameBox, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Password: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        passwordBox = new JTextField(15);
        add(passwordBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Type: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        typeDropdown = new JComboBox<>(Main.userTypes);
        add(typeDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        sortButton = new JButton("Sort");
        add(sortButton, gbc);
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Collections.sort(allusers);
                if (reverseSort) {
                    java.util.Collections.reverse(allusers);
                }
                reverseSort = !reverseSort;
                userListPanel.updateUserList(allusers);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        addButton = new JButton("Add User");
        updateButton = new JButton("Update User");
        updateButton.setVisible(false);
        deleteButton = new JButton("Delete User");
        deleteButton.setVisible(false);
        saveButton = new JButton("Save Users");
        loadButton = new JButton("Load Users");
        buttonPanel.add(addButton, gbc);
        buttonPanel.add(updateButton, gbc);
        buttonPanel.add(deleteButton, gbc);
        buttonPanel.add(saveButton, gbc);
        buttonPanel.add(loadButton, gbc);
        add(buttonPanel, gbc);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                deleteUser(); 
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUsers();
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadUsers();
                userListPanel.updateUserList(allusers);
            }
        });
        
    }

    private void saveUsers() {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                FileOutputStream fo = new FileOutputStream(chooser.getSelectedFile());
                ObjectOutputStream so = new ObjectOutputStream(fo);
                so.writeObject(allusers);
                so.flush();
                so.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void loadUsers() {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream fi = new FileInputStream(chooser.getSelectedFile());
                ObjectInputStream si = new ObjectInputStream(fi);
                ArrayList<User> tmpusers = (ArrayList<User>) si.readObject();
                allusers.clear();
                for (User u : tmpusers) {
                    allusers.add(u);
                }
                si.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void addUser() {
        String name = nameBox.getText();
        String type = (String) typeDropdown.getSelectedItem();
        String username = usernameBox.getText();
        String password = passwordBox.getText();
        String id = idBox.getText();
        if (!name.isEmpty() && type != null) {
            if (type.equals("Student")) {
                allusers.add(new Student(name, id, username, password));
            } else if (type.equals("Faculty")) {
                allusers.add(new Faculty(name, id, username, password));
            } else if (type.equals("Staff")) {
                allusers.add(new Staff(name, id, username, password));
            } else if (type.equals("Admin")) {
                allusers.add(new Admin(name, id, username, password));
            }
            nameBox.setText("");
            idBox.setText("");
            usernameBox.setText("");
            passwordBox.setText("");
            userListPanel.updateUserList(allusers);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a name and select a type.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // b/c we have a reference to the User stored in our global allusers array, we can just update the User object directly instead of having to mess with some kind of index into the list
    // BUT that update doesn't happen until the user clicks the update button ... so we need to save a reference to the selected user so we can update it later in our updateUser method
    public void loadUser(User u) {
        this.selectedUser = u;
        addButton.setVisible(false);
        updateButton.setVisible(true);
        deleteButton.setVisible(true);
        nameBox.setText(u.getName());
        idBox.setText(u.getId());
        // finish loading the boxes        
        // add your code here
    }

    // b/c we have a reference to the User currently being edited, we can just update the User object directly instead of having to mess with some kind of index into the list
    public void updateUser() {
        this.selectedUser.setName(nameBox.getText());
        this.selectedUser.setId(idBox.getText());

        // finish updating the user below!
        // add your code here

        // now that we have updated the user, let's tell the userListPanel to update the list
        userListPanel.updateUserList(allusers);
        // restore the UI to prepare it for adding a new user
        addButton.setVisible(true);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);

        nameBox.setText("");
        idBox.setText("");
        usernameBox.setText("");
        passwordBox.setText("");
        
     }

    // Helper method to delete user
     public void deleteUser() {

        allusers.remove(selectedUser);

        userListPanel.updateUserList(allusers);
        addButton.setVisible(true);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);

        nameBox.setText("");
        idBox.setText("");
        usernameBox.setText("");
        passwordBox.setText("");
      }
}