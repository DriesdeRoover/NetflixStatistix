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

public class WatchedContentPanel extends JPanel {

    public JPanel createWatchPanel() {
        JPanel watchPanel = new JPanel(new BorderLayout());
        JLabel selectContent = new JLabel("Selecteer een profiel");
        selectContent.setForeground(Color.white);

        JPanel menuBar = new JPanel();
        menuBar.setBackground(new Color(229, 9, 20));
        menuBar.setForeground(Color.white);

        JComboBox contentBox = new JComboBox();
        DefaultComboBoxModel contentModel = new DefaultComboBoxModel();
        //This content list is loaded from the database
        contentModel.addElement("Greta");
        contentModel.addElement("Dries");
        contentModel.addElement("Wesley");
        contentBox.setModel(contentModel);
        contentBox.setBackground(Color.white);

        JButton searchButton = new JButton("Zoek");
        searchButton.setBackground(Color.white);
        searchButton.setForeground(new Color(229, 9, 20));

        menuBar.add(selectContent, BorderLayout.WEST);
        menuBar.add(contentBox, BorderLayout.CENTER);
        menuBar.add(searchButton, BorderLayout.EAST);

        DefaultTableModel model = new DefaultTableModel();
        JTable jtbl = new JTable(model);
        model.addColumn("Titel");
        model.addColumn("PercentageBekeken");
        model.addColumn("LaatstBekeken");
        model.addColumn("ProfielNaam");

        jtbl.setGridColor(Color.white);

        JTableHeader header = jtbl.getTableHeader();
        header.setBackground(Color.white);
        header.setForeground(new Color(229, 9, 20));

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
                            "FROM BekekenContent " +
                            "JOIN Content ON Content.ContentId = BekekenContent.ContentId " +
                            "WHERE BekekenContent.ProfielNaam = ?";

                    //stmt = con.createStatement();
                    stmt = con.prepareStatement(SQL);
                    stmt.setString(1, (String) contentBox.getSelectedItem());
                    // Execute the SQL statement
                    rs = stmt.executeQuery();


                    // Adding the results to the labels.
                        while(rs.next()){
                            model.addRow(new Object[]{rs.getString("Titel"),rs.getString("PercentageBekeken"),
                                    rs.getString("LaatstBekeken"), rs.getString("ProfielNaam")});
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
                    watchPanel.add(pg);
                }


            }
        });



        watchPanel.add(menuBar, BorderLayout.NORTH);
        watchPanel.add(jtbl, BorderLayout.CENTER);

        return watchPanel;
    }

}
