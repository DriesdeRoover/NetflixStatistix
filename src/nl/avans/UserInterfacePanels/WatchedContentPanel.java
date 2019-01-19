package nl.avans.UserInterfacePanels;

import nl.avans.Connection.DatabaseConnection;
import nl.avans.Repository.DatabaseRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class WatchedContentPanel extends JPanel {
    private DatabaseRepository databaseRepository;
    private DefaultTableModel model;

    public JPanel createWatchPanel() {
        JPanel watchPanel = new JPanel(new BorderLayout());
        JLabel selectContent = new JLabel("Selecteer een profiel");
        selectContent.setForeground(Color.white);

        JPanel menuBar = new JPanel();
        menuBar.setBackground(new Color(229, 9, 20));
        menuBar.setForeground(Color.white);


        JComboBox contentBox = new JComboBox();
        contentBox.setBackground(Color.white);
        //This content list is loaded from the database
        databaseRepository = new DatabaseRepository();

        contentBox.setModel(new DefaultComboBoxModel(databaseRepository.getProfileName().toArray()));


        JButton searchButton = new JButton("Zoek");
        searchButton.setBackground(Color.white);
        searchButton.setForeground(new Color(229, 9, 20));

        menuBar.add(selectContent, BorderLayout.WEST);
        menuBar.add(contentBox, BorderLayout.CENTER);
        menuBar.add(searchButton, BorderLayout.EAST);

        //Creating the table to display data from the database
        model = new DefaultTableModel();
        JTable jtbl = new JTable(model);
        model.addColumn("Titel");
        model.addColumn("PercentageBekeken");
        model.addColumn("LaatstBekeken");
        model.addColumn("ProfielNaam");

        jtbl.setGridColor(Color.white);

        JScrollPane pg = new JScrollPane(jtbl);
        watchPanel.add(pg);

        JTableHeader header = jtbl.getTableHeader();
        header.setBackground(Color.white);
        header.setForeground(new Color(229, 9, 20));
        jtbl.setEnabled(false);

        //Show the results
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    model = new DefaultTableModel();
                    model.addColumn("Titel");
                    model.addColumn("PercentageBekeken");
                    model.addColumn("LaatstBekeken");
                    model.addColumn("ProfielNaam");

                    ResultSet rs = DatabaseConnection.getData("SELECT * " +
                            "FROM BekekenContent " +
                            "JOIN Content ON Content.ContentId = BekekenContent.ContentId " +
                            "WHERE BekekenContent.ProfielNaam = " + contentBox.getSelectedItem());


                    while (rs.next()) {
                        model.addRow(new Object[]{rs.getString("Titel"), rs.getString("PercentageBekeken"),
                                rs.getString("LaatstBekeken"), rs.getString("ProfielNaam")});
                    }
                    // Handle any errors that may have occurred.
                } catch (Exception ex) {
                    System.out.println("An Error Occurred: " + ex.getMessage());
                }


                    JScrollPane pg = new JScrollPane(jtbl);
                    watchPanel.add(pg);
            }
        });


        watchPanel.add(menuBar, BorderLayout.NORTH);

        return watchPanel;
    }

}
