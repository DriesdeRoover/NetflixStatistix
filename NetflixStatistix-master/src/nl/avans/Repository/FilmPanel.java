package nl.avans.Repository;

import com.sun.corba.se.impl.orb.DataCollectorBase;
import nl.avans.Connection.DatabaseConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.xml.crypto.Data;
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
        menuBar.setBackground(new Color(229, 9, 20));
        menuBar.setForeground(Color.white);


        JButton searchButton = new JButton("Zoek");
        searchButton.setBackground(Color.white);
        searchButton.setForeground(new Color(229, 9, 20));

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
        header.setForeground(new Color(229, 9, 20));


        //Show the results
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseConnection.connect();
                try {
                    ResultSet rs = DatabaseConnection.getData("SELECT * FROM Film");
                    while(rs.next()){
                        model.addRow(new Object[]{rs.getString("Titel"),rs.getString("Tijdsduur"),
                                rs.getString("LeeftijdsIndicatie"), rs.getString("Taal"), rs.getString("Genre")});
                    }

                } catch (Exception x) {
                    System.out.println("An Error Occurred.. " + x.getMessage());
                }
                JScrollPane pg = new JScrollPane(jtbl);
                filmPanel.add(pg);
            }

        });


        filmPanel.add(menuBar, BorderLayout.NORTH);
        filmPanel.add(jtbl, BorderLayout.CENTER);

        return filmPanel;
    }
}
