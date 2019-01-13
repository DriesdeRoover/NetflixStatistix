package nl.avans.Repository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        menuBar.setBackground(Color.red);
        menuBar.setForeground(Color.white);

        JComboBox contentBox = new JComboBox();
        DefaultComboBoxModel contentModel = new DefaultComboBoxModel();
        //This content list is loaded from the database
        contentModel.addElement("Fargo");
        contentModel.addElement("House of Cards");
        contentModel.addElement("Sherlock");
        contentBox.setModel(contentModel);
        contentBox.setBackground(Color.white);

        JLabel seasonLabel = new JLabel("Seizoen: ");
        seasonLabel.setForeground(Color.white);

       // JComboBox seasonContentBox = new JComboBox();
        //        DefaultComboBoxModel seasonContentModel = new DefaultComboBoxModel();
        //        seasonContentModel.addElement("1");
        //        seasonContentModel.addElement("2");
        //        seasonContentModel.addElement("3");
        //        seasonContentBox.setModel(seasonContentModel);
        //        seasonContentBox.setBackground(Color.white);

        JButton searchButton = new JButton("Zoek");
        searchButton.setBackground(Color.white);
        searchButton.setForeground(Color.red);

        menuBar.add(selectContent, BorderLayout.WEST);
        menuBar.add(contentBox, BorderLayout.CENTER);
        menuBar.add(seasonLabel, BorderLayout.CENTER);
        //menuBar.add(seasonContentBox, BorderLayout.CENTER);
        menuBar.add(searchButton, BorderLayout.EAST);


        JLabel titleLabel = new JLabel(" ");
        JLabel durationLabel = new JLabel(" ");
        JLabel ageLabel = new JLabel(" ");
        JLabel languageLabel = new JLabel(" ");
        JLabel genreLabel = new JLabel(" ");

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
                    String SQL = "SELECT * FROM Aflevering WHERE SerieNaam = ?";

                    //stmt = con.createStatement();
                    stmt = con.prepareStatement(SQL);
                    stmt.setString(1, (String) contentBox.getSelectedItem());
                    // Execute the SQL statement
                    rs = stmt.executeQuery();
                    //rs = stmt.executeQuery();


                    // Adding the results to the labels.
                    while (rs.next()) {

                        int contentId = rs.getInt("ContentId");
                        String Titel = rs.getString("Titel");
                        String tijdsDuur = rs.getString("Tijdsduur");
                        String season = rs.getString("SeizoenId");
                        //String leeftijdsIndicatie = rs.getString("LeeftijdsIndicatie");
                        //tring taal = rs.getString("Taal");
                        //String genre = rs.getString("Genre");

                        //int progress = rs.getInt("BekekenContent_PercentageBekeken");


                        titleLabel.setText("<html><p>" + contentBox.getSelectedItem() + ": Seizoen: " +  season + ": </p>" + "<p>" + Titel + "</p></html>");
                        durationLabel.setText("Speelduur:  " + tijdsDuur + " min");
                        //ageLabel.setText("Leeftijdsindicatie:  " + leeftijdsIndicatie);
                        //languageLabel.setText("Gesproken taal:  " + taal);
                        //genreLabel.setText("Genre:  " + genre);
                        //movieProgress.setValue(progress);

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
                }


            }
        });

        // filmContainer.add(menuBar, new GridBagConstraints( 0, 0, 1, 1, 0.3, 0.0,
        //                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets( 0, 0, 0, 0 ), 0, 0 ) );
        serieContainer.add(titleLabel, new GridBagConstraints(2, 0, 0, 1, 0.3, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));
        serieContainer.add(durationLabel, new GridBagConstraints(0, 1, 0, 1, 0.3, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));
        serieContainer.add(ageLabel, new GridBagConstraints(0, 2, 0, 1, 0.3, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));
        serieContainer.add(languageLabel, new GridBagConstraints(0, 3, 0, 1, 0.3, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));
        serieContainer.add(genreLabel, new GridBagConstraints(0, 4, 0, 1, 0.3, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));

        seriePanel.add(menuBar, BorderLayout.NORTH);
        seriePanel.add(serieContainer, BorderLayout.CENTER);

        return seriePanel;
    }
}
