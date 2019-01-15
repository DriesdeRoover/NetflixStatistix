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

public class SeriePanel {

    public JPanel createSeriePanel() {
        JPanel seriePanel = new JPanel(new BorderLayout());
        JPanel serieContainer = new JPanel(new GridBagLayout());
        serieContainer.setBorder(new EmptyBorder(3, 10, 3, 10));
        serieContainer.setBackground(Color.white);
        JLabel selectContent = new JLabel("Selecteer een serie");
        selectContent.setForeground(Color.white);

        JPanel menuBar = new JPanel();
        menuBar.setBackground(new Color(229, 9, 20));
        menuBar.setForeground(Color.white);


        JComboBox contentBox = new JComboBox();

        //This content list is loaded from the database
        DatabaseConnection.connect();
        try {
            ResultSet rs = DatabaseConnection.getData("SELECT * FROM Serie");
            while(rs.next()){
                contentBox.addItem(rs.getString("SerieNaam"));
            }

        } catch (Exception x) {
            System.out.println("An Error Occurred.. " + x.getMessage());
        }

        contentBox.setBackground(Color.white);
        JButton searchButton = new JButton("Zoek");
        searchButton.setBackground(Color.white);
        searchButton.setForeground(new Color(229, 9, 20));

        menuBar.add(selectContent, BorderLayout.WEST);
        menuBar.add(contentBox, BorderLayout.CENTER);
        menuBar.add(searchButton, BorderLayout.EAST);

        //Creating the table to display data from the database
        DefaultTableModel model = new DefaultTableModel();
        JTable jtbl = new JTable(model);
        model.addColumn("Seizoen");
        model.addColumn("Titel");
        model.addColumn("Tijdsduur");
        model.addColumn("Leeftijdsindicatie");
        model.addColumn("Gesproken Taal");
        model.addColumn("Genre");
        model.addColumn("Lijkt op");
        jtbl.setGridColor(Color.white);

        JTableHeader header = jtbl.getTableHeader();
        header.setBackground(Color.white);
        header.setForeground(new Color(229, 9, 20));
        jtbl.setEnabled(false);

        //Show the results
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // The connection URL can be different
                String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=Netflix;integratedSecurity=true;";
                Connection con = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;

                try {
                    // 'Import' the driver.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    // Maak de verbinding met de database.
                    con = DriverManager.getConnection(connectionUrl);

                    // SQL Statement.
                    String SQL = "SELECT * " +
                            "FROM Aflevering " +
                            "JOIN Serie ON Serie.SerieNaam = Aflevering.SerieNaam " +
                            "WHERE Serie.SerieNaam = ?";

                    //stmt = con.createStatement();
                    stmt = con.prepareStatement(SQL);
                    stmt.setString(1, (String)contentBox.getSelectedItem());
                    // Execute the SQL statement
                    rs = stmt.executeQuery();


                    // Adding the results to the labels.
                    while(rs.next()){
                        model.addRow(new Object[]{"Seizoen " + rs.getString("SeizoenNummer"),rs.getString("Titel"),
                                rs.getString("Tijdsduur"),
                                rs.getString("LeeftijdsIndicatie"), rs.getString("Taal"),
                                rs.getString("Genre"), rs.getString("LijktOp")});
                    }
                }

                // Handle any errors that may have occurred.
                catch (Exception ev) {
                    ev.printStackTrace();
                } finally {
                    if (rs != null) try {
                        rs.close();
                    } catch (Exception ev) {
                    }
                    if (stmt != null) try {
                        stmt.close();
                    } catch (Exception ev) {
                    }
                    if (con != null) try {
                        con.close();
                    } catch (Exception ev) {
                    }
                    JScrollPane pg = new JScrollPane(jtbl);
                    seriePanel.add(pg);
                }
            }
        });


        seriePanel.add(menuBar, BorderLayout.NORTH);
        seriePanel.add(jtbl, BorderLayout.CENTER);

        return seriePanel;
    }
}
