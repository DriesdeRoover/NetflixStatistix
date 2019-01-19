package nl.avans.UserInterfacePanels;

import nl.avans.Connection.DatabaseConnection;
import nl.avans.Repository.DatabaseRepository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
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

                DatabaseConnection.connect();
                String name = getComboboxValue();

                try {
                    model = new DefaultTableModel();
                    model = new DefaultTableModel();
                    model.addColumn("Titel");
                    model.addColumn("Tijdsduur");
                    model.addColumn("Leeftijdsindicatie");
                    model.addColumn("Gesproken Taal");
                    model.addColumn("Genre");
                    model.addColumn("Lijkt op");
                    ResultSet rs = DatabaseConnection.getData( "SELECT * " +
                            "FROM Aflevering " +
                            "JOIN Serie ON Serie.SerieNaam = Aflevering.SerieNaam " +
                            "WHERE Serie.SerieNaam = '" + name + "';");

                    while (rs.next()) {
                        model.addRow(new Object[]{rs.getString("Titel"), rs.getString("Tijdsduur"),
                                rs.getString("LeeftijdsIndicatie"), rs.getString("Taal"), rs.getString("Genre"),
                                rs.getString("LijktOp")});
                    }
                } catch (Exception ex) {
                    System.out.println("An Error Occurred: " + ex.getMessage());
                }

               // model = (DefaultTableModel) jtbl.getModel();
                //
                //                //String[] cols = new String[]{"Titel","Tijdsduur", "Leeftijdsindicatie", "Gesproken Taal", "Genre", "Lijkt Op"};
                //                Object c =  databaseRepository.getAllEpisodeData(getComboboxValue()).toArray();
                //
                //                //ArrayList<Episode> list = new ArrayList();
                //                Object[][] rowData = new Object[6][6];
                //
                //                for (int i = 0; i < databaseRepository.getAllEpisodeData(getComboboxValue()).size(); i++){
                //
                //                    rowData[0][0] = databaseRepository.getAllEpisodeData(getComboboxValue()).get(i);
                //                    rowData[1][1] = databaseRepository.getAllEpisodeData(getComboboxValue()).get(i);
                //                    rowData[2][2] = databaseRepository.getAllEpisodeData(getComboboxValue()).get(i);
                //                    rowData[3][3] = databaseRepository.getAllEpisodeData(getComboboxValue()).get(i);
                //                    rowData[4][4] = databaseRepository.getAllEpisodeData(getComboboxValue()).get(i);
                //                    rowData[5][5] = databaseRepository.getAllEpisodeData(getComboboxValue()).get(i);
                //
                //                    model.addRow(rowData);
                //                }
                //
                //
                //                //Object[][] data = c[5][6];
                //                //Object[][] data = new Object[][]{databaseRepository.getAllEpisodeData(getComboboxValue()).toArray()};
                //                    System.out.println(databaseRepository.getAllEpisodeData(getComboboxValue()).toString());

                jtbl.setModel(model);
                DatabaseConnection.disconnect();

            }
        });
        return seriePanel;
    }

    //This method returns the selected item of the combo box.
    public String getComboboxValue(){
        return contentBox.getSelectedItem().toString();
    }
}
