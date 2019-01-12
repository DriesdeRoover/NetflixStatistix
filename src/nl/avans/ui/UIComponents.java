package nl.avans.ui;

import nl.avans.Repository.FilmPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class UIComponents extends JPanel {

    public UIComponents() {
    }

    public JPanel createFooter() {
        JPanel footerContainer = new JPanel(new BorderLayout());
        footerContainer.setBorder(new EmptyBorder(3, 10, 3, 10));
        JLabel footerTitle = new JLabel("Netflix Statistix versie 0.1", JLabel.LEFT);
        JLabel contributors = new JLabel("Informatica 2019 - Klas E - Dries de Roover | Wesley de Jonge", JLabel.RIGHT);
        footerContainer.add(footerTitle, BorderLayout.WEST);
        footerContainer.add(contributors, BorderLayout.EAST);

        footerContainer.validate();
        footerContainer.repaint();
        return footerContainer;
    }

    public JTabbedPane createWatchedSeriePanel() {
        JTabbedPane tabbedPane = new JTabbedPane();
        //tabbedPane(new GridLayout(1,1));
        ImageIcon icon = new ImageIcon();

        JComponent homePanel = makeTextPanel("Home");
        tabbedPane.addTab("Netflix Statistix - Home", icon, homePanel);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        tabbedPane.addTab("Films", icon, createFilms());
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        tabbedPane.addTab("Series", icon, createSeries());
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        tabbedPane.addTab("Profiel", icon, createProfile());
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        tabbedPane.addTab("Bekeken Content", icon, createWatchedContent());
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_5);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        return tabbedPane;
    }

    public JPanel createFilms() {
        FilmPanel filmPanel = new FilmPanel();
        return filmPanel.createFilmPanel();
    }

    public JPanel createSeries() {
        JPanel serieContainer = new JPanel(new GridBagLayout());
        serieContainer.setBorder(new EmptyBorder(3, 10, 3, 10));
        serieContainer.setBackground(Color.red);
        JLabel selectContent = new JLabel("Selecteer een serie", JLabel.LEFT);

        serieContainer.add(selectContent);

        return serieContainer;
    }

    public JTabbedPane createProfile() {

        JTabbedPane tabbedPane = new JTabbedPane();
        //tabbedPane(new GridLayout(1,1));
        ImageIcon icon = new ImageIcon();

        JComponent seriePanel = new JPanel();
        tabbedPane.addTab("Series", icon, seriePanel);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent filmPanel = new JPanel();
        tabbedPane.addTab("Films", icon, filmPanel);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JPanel profileMovieContainer = new JPanel(new GridBagLayout());
        profileMovieContainer.setBorder(new EmptyBorder(3, 10, 3, 10));
        profileMovieContainer.setBackground(Color.white);
        JLabel selectContent = new JLabel("Selecteer een profiel ");

        JPanel profileSerieContainer = new JPanel(new GridBagLayout());
        profileSerieContainer.setBorder(new EmptyBorder(3, 10, 3, 10));
        profileSerieContainer.setBackground(Color.white);

        JComboBox contentBox = new JComboBox();
        DefaultComboBoxModel contentModel = new DefaultComboBoxModel();
        //This content list is loaded from the database
        contentModel.addElement("Hendrik");
        contentModel.addElement("Jan");
        contentModel.addElement("Kinderen");
        contentBox.setModel(contentModel);

        profileMovieContainer.add(selectContent, new GridBagConstraints(0, 0, 1, 1, 0.3, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));
        profileMovieContainer.add(contentBox, new GridBagConstraints(1, 0, 1, 1, 0.3, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));


        //profileContainer.add(selectContent);
        //profileContainer.add(contentBox);
        filmPanel.add(profileMovieContainer);
        seriePanel.add(profileMovieContainer);

        tabbedPane.addTab("Films", icon, filmPanel);
        tabbedPane.addTab("Series", icon, seriePanel);

        return tabbedPane;
    }

    public JPanel createWatchedContent() {
        JPanel contentContainer = new JPanel(new GridBagLayout());
        contentContainer.setBorder(new EmptyBorder(3, 10, 3, 10));
        contentContainer.setBackground(Color.white);
        JLabel selectContent = new JLabel("Selecteer serie", JLabel.LEFT);

        JComboBox contentBox = new JComboBox();
        DefaultComboBoxModel contentModel = new DefaultComboBoxModel();
        //This content list is loaded from the database
        contentModel.addElement("House of Cards");
        contentModel.addElement("Sherlock");
        contentModel.addElement("Fargo");
        contentBox.setModel(contentModel);

        JButton okButton = new JButton("OK");
        //select.add(contentBox, BorderLayout.WEST);

        //Watch progress of the overall serie
        int perc = 10;
        JLabel averageWatched = new JLabel("Gemiddeld bekeken per aflevering:");
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(perc);
        progressBar.setStringPainted(true);

        //Watch progress of watched episodes
        int episodePerc = 67;
        JLabel watchedEpisodeLabel = new JLabel("Selecteer een serie en druk op 'OK'");
        System.out.println(contentModel.getSelectedItem());


        JPanel contentPanel = new JPanel();
        JLabel watchedEpisodeTitle = new JLabel("Seizoen 1, aflevering 1: Er was eens een Swing");
        JProgressBar episodeProgress = new JProgressBar();
        episodeProgress.setValue(episodePerc);
        episodeProgress.setStringPainted(true);
        contentPanel.add(watchedEpisodeLabel);
        contentPanel.add(episodeProgress);
        contentPanel.add(episodeProgress);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                watchedEpisodeLabel.setText("Bekeken aflevering van " + contentModel.getSelectedItem() + ":");

            }
        });

        //Adding the components
        contentContainer.add(selectContent, new GridBagConstraints(0, 0, 1, 1, 0.3, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));
        contentContainer.add(contentBox, new GridBagConstraints(1, 0, 1, 1, 0.3, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));

        //add the OK button
        contentContainer.add(okButton, new GridBagConstraints(1, 1, 1, 1, 0.3, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 50), 0, 0));
        contentContainer.add(averageWatched, new GridBagConstraints(0, 1, 1, 1, 0.3, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(15, 0, 0, 50), 0, 0));
        contentContainer.add(progressBar, new GridBagConstraints(0, 2, 1, 1, 0.3, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 0, 0));

        //adding an empty line
        contentContainer.add(line(), new GridBagConstraints(0, 3, 1, 1, 0.3, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 0, 0));

        //adding the watched episode content
        contentContainer.add(watchedEpisodeLabel, new GridBagConstraints(0, 4, 1, 1, 0.3, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 0, 0));
        contentContainer.add(watchedEpisodeTitle, new GridBagConstraints(0, 5, 1, 1, 0.3, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 0, 0));
        contentContainer.add(episodeProgress, new GridBagConstraints(0, 6, 1, 1, 0.3, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 0, 0));

        //adding an empty line
        contentContainer.add(line(), new GridBagConstraints(0, 7, 1, 1, 0.3, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 0, 0));

        contentContainer.add(new JScrollPane());
        return contentContainer;
    }


    public JLabel line() {
        JLabel line = new JLabel("                                               ");
        return line;
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

}
