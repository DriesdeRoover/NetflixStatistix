package nl.avans.ui;

import nl.avans.Repository.FilmPanel;
import nl.avans.Repository.SeriePanel;
import nl.avans.Repository.WatchedContentPanel;

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
        SeriePanel seriePanel = new SeriePanel();
        return seriePanel.createSeriePanel();
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
        WatchedContentPanel watched = new WatchedContentPanel();
        return watched.createWatchPanel();
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
