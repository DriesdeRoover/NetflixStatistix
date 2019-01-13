package nl.avans.Repository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FilmPanel extends JPanel {

    public JPanel createFilmPanel() {
        JPanel filmPanel = new JPanel(new BorderLayout());
        JPanel filmContainer = new JPanel(new GridBagLayout());
        filmContainer.setBorder(new EmptyBorder(3, 10, 3, 10));
        filmContainer.setBackground(Color.white);
        JLabel selectContent = new JLabel("Hieronder staat de informatie over de bekende films weergegeven");
        selectContent.setForeground(Color.white);

        JPanel menuBar = new JPanel();
        menuBar.setBackground(Color.red);
        menuBar.setForeground(Color.white);


        JButton searchButton = new JButton("Zoek");
        searchButton.setBackground(Color.white);
        searchButton.setForeground(Color.red);

        menuBar.add(selectContent, BorderLayout.WEST);
        menuBar.add(searchButton, BorderLayout.EAST);


        JProgressBar movieProgress = new JProgressBar();
        movieProgress.setStringPainted(true);

        DefaultTableModel model = new DefaultTableModel();
        JTable jtbl = new JTable(model);
        model.addColumn("Titel");
        model.addColumn("Tijdsduur");
        model.addColumn("Leeftijdsindicatie");
        model.addColumn("Gesproken Taal");
        model.addColumn("Genre");
        jtbl.setGridColor(Color.white);

        JTableHeader header = jtbl.getTableHeader();
        header.setBackground(Color.white);
        header.setForeground(Color.red);


        //Show the results
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // The connection URL can be different
                String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=Netflix;integratedSecurity=true;";
                Connection con = null;
                Statement stmt = null;
                ResultSet rs = null;

                try {
                    // 'Import' the driver.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    // Maak de verbinding met de database.
                    con = DriverManager.getConnection(connectionUrl);

                    // SQL Statement.
                    String SQL = "SELECT * FROM Film";

                    stmt = con.createStatement();
                    //stmt = con.createStatement(SQL);
                    // Execute the SQL statement
                    rs = stmt.executeQuery(SQL);


                    // Adding the results to the labels.
                    while(rs.next()){
                        model.addRow(new Object[]{rs.getString("Titel"),rs.getString("Tijdsduur"),
                                rs.getString("LeeftijdsIndicatie"), rs.getString("Taal"), rs.getString("Genre")});
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
                    filmPanel.add(pg);
                }


            }
        });



        filmPanel.add(menuBar, BorderLayout.NORTH);
        filmPanel.add(jtbl, BorderLayout.CENTER);

        return filmPanel;
    }
}
