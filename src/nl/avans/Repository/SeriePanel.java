package nl.avans.Repository;

import nl.avans.Connection.DatabaseConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SeriePanel {
    private DefaultTableModel model;
    private DatabaseRepository databaseRepository;
    private JComboBox contentBox;


    public JPanel createSeriePanel() {
        JPanel seriePanel = new JPanel(new BorderLayout());
        JLabel selectContent = new JLabel("Selecteer een serie");
        selectContent.setForeground(Color.white);

        JPanel menuBar = new JPanel();
        menuBar.setBackground(new Color(229, 9, 20));
        menuBar.setForeground(Color.white);


        contentBox = new JComboBox();
        databaseRepository = new DatabaseRepository();

        contentBox.setModel(new DefaultComboBoxModel(databaseRepository.getSerieData().toArray()));

        contentBox.setBackground(Color.white);
        JButton searchButton = new JButton("Zoek");
        searchButton.setBackground(Color.white);
        searchButton.setForeground(new Color(229, 9, 20));

        menuBar.add(selectContent, BorderLayout.WEST);
        menuBar.add(contentBox, BorderLayout.CENTER);
        menuBar.add(searchButton, BorderLayout.EAST);

        //Creating the table to display data from the database
        model = new DefaultTableModel();
        JTable jtbl = new JTable(model);
        //model.addColumn("Seizoen");
        model.addColumn("Titel");
        model.addColumn("Tijdsduur");
        model.addColumn("Leeftijdsindicatie");
        model.addColumn("Gesproken Taal");
        model.addColumn("Genre");
        model.addColumn("Lijkt op");
        jtbl.setGridColor(Color.white);

        JScrollPane pg = new JScrollPane(jtbl);
        seriePanel.add(pg);

        JTableHeader header = jtbl.getTableHeader();
        header.setBackground(Color.white);
        header.setForeground(new Color(229, 9, 20));
        jtbl.setEnabled(false);

        seriePanel.add(menuBar, BorderLayout.NORTH);
        //seriePanel.add(jtbl, BorderLayout.CENTER);


        //Show the results
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] cols = new String[]{"Titel","Tijdsduur", "Leeftijdsindicatie", "Gesproken Taal", "Genre", "Lijkt Op"};
                Object[][] data = new Object[][]{databaseRepository.getAllEpisodeData(getComboboxValue()).toArray()};
                System.out.println(databaseRepository.getAllEpisodeData(getComboboxValue()).toString());



                jtbl.setModel(new DefaultTableModel(data, cols));
                //jtbl.setModel(model);
                DatabaseConnection.disconnect();

            }
        });
        return seriePanel;
    }

    public String getComboboxValue(){
        return contentBox.getSelectedItem().toString();
    }
}
