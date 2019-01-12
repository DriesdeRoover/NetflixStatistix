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

public class FilmPanel extends JPanel {

    public JPanel createFilmPanel() {
        JPanel filmPanel = new JPanel(new BorderLayout());
        JPanel filmContainer = new JPanel(new GridBagLayout());
        filmContainer.setBorder(new EmptyBorder(3, 10, 3, 10));
        filmContainer.setBackground(Color.white);
        JLabel selectContent = new JLabel("Selecteer een film");
        selectContent.setForeground(Color.white);

        JPanel menuBar = new JPanel();
        menuBar.setBackground(Color.red);
        menuBar.setForeground(Color.white);

        JComboBox contentBox = new JComboBox();
        DefaultComboBoxModel contentModel = new DefaultComboBoxModel();
        //This content list is loaded from the database
        contentModel.addElement("Avengers");
        contentModel.addElement("Harry Potter");
        contentModel.addElement("Mary Poppins");
        contentBox.setModel(contentModel);
        contentBox.setBackground(Color.white);

        JButton searchButton = new JButton("Zoek");
        searchButton.setBackground(Color.white);
        searchButton.setForeground(Color.red);

        menuBar.add(selectContent, BorderLayout.WEST);
        menuBar.add(contentBox, BorderLayout.CENTER);
        menuBar.add(searchButton, BorderLayout.EAST);

        //JPanel contentPanel = new JPanel();

        // JTextArea textArea = new JTextArea();
        JLabel titleLabel = new JLabel("-");
        JLabel durationLabel = new JLabel("-");
        JLabel ageLabel = new JLabel("-");
        JLabel languageLabel = new JLabel("-");
        JLabel genreLabel = new JLabel("-");
        JProgressBar movieProgress = new JProgressBar();
        movieProgress.setStringPainted(true);
        //contentPanel.add(new JScrollPane(titleLabel));

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
                    String SQL = "SELECT * FROM Film WHERE Titel = ?";

                    //stmt = con.createStatement();
                    stmt = con.prepareStatement(SQL);
                    stmt.setString(1, (String) contentBox.getSelectedItem());
                    // Execute the SQL statement
                    rs = stmt.executeQuery();


                    // Adding the results to the labels.
                    while (rs.next()) {

                        int contentId = rs.getInt("ContentId");
                        String Titel = rs.getString("Titel");
                        String tijdsDuur = rs.getString("Tijdsduur");
                        String leeftijdsIndicatie = rs.getString("LeeftijdsIndicatie");
                        String taal = rs.getString("Taal");
                        String genre = rs.getString("Genre");

                        //int progress = rs.getInt("BekekenContent_PercentageBekeken");


                        //titleLabel.setText(Titel + " | Speelduur: " + tijdsDuur + " min\nLeeftijdsindicatie: "
                        //                                + leeftijdsIndicatie + " | Gesproken taal: " + taal + " | Genre: " +
                        //                                genre + "\n");

                        titleLabel.setText(Titel);
                        durationLabel.setText("Speelduur:  " + tijdsDuur + " min");
                        ageLabel.setText("Leeftijdsindicatie:  " + leeftijdsIndicatie);
                        languageLabel.setText("Gesproken taal:  " + taal);
                        genreLabel.setText("Genre:  " + genre);
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
        filmContainer.add(titleLabel, new GridBagConstraints(2, 0, 0, 1, 0.3, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));
        filmContainer.add(durationLabel, new GridBagConstraints(0, 1, 0, 1, 0.3, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));
        filmContainer.add(ageLabel, new GridBagConstraints(0, 2, 0, 1, 0.3, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));
        filmContainer.add(languageLabel, new GridBagConstraints(0, 3, 0, 1, 0.3, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));
        filmContainer.add(genreLabel, new GridBagConstraints(0, 4, 0, 1, 0.3, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));
        filmContainer.add(movieProgress, new GridBagConstraints(0, 5, 0, 1, 0.3, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));

        filmPanel.add(menuBar, BorderLayout.NORTH);
        filmPanel.add(filmContainer, BorderLayout.CENTER);

        return filmPanel;
    }
}
