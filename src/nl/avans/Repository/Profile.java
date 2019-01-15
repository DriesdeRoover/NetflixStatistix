package nl.avans.Repository;

import nl.avans.Connection.DatabaseConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends JPanel {

    public JPanel createProfilePanel() {
        JPanel profilePanel = new JPanel(new BorderLayout());
        JPanel profileContainer = new JPanel(new GridBagLayout());
        profileContainer.setBorder(new EmptyBorder(3, 10, 3, 10));
        profileContainer.setBackground(Color.white);
        JLabel selectContent = new JLabel("Voeg een profiel toe");
        selectContent.setForeground(Color.white);

        JPanel menuBar = new JPanel();
        menuBar.setBackground(new Color(229, 9, 20));
        menuBar.setForeground(Color.white);


        JButton addButton = new JButton("Toevoegen");
        addButton.setBackground(Color.white);
        addButton.setForeground(new Color(229, 9, 20));

        menuBar.add(selectContent, BorderLayout.WEST);
        menuBar.add(addButton, BorderLayout.EAST);


        JProgressBar movieProgress = new JProgressBar();
        movieProgress.setStringPainted(true);


        //Show the results
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseConnection.connect();

            }

        });


        profilePanel.add(menuBar, BorderLayout.NORTH);

        return profilePanel;


    }
}
