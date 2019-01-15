package nl.avans.ui;

import nl.avans.Repository.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

public class UIComponents extends JPanel {

    public UIComponents() {
    }

    public JPanel createFooter() {
        JPanel footerContainer = new JPanel(new BorderLayout());
        footerContainer.setBorder(new EmptyBorder(3, 10, 3, 10));
        JLabel footerTitle = new JLabel("Netflix Statistix versie 1.0", JLabel.LEFT);
        JLabel contributors = new JLabel("Informatica 2019 - Klas E - Dries de Roover | Wesley de Jonge", JLabel.RIGHT);
        footerTitle.setForeground(Color.white);
        contributors.setForeground(Color.white);
        footerContainer.add(footerTitle, BorderLayout.WEST);
        footerContainer.add(contributors, BorderLayout.EAST);
        footerContainer.setBackground(new Color(229, 9, 20));

        return footerContainer;
    }

    public JTabbedPane createTabs() {
        //This method creates a tabbed layout
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = new ImageIcon();

        tabbedPane.addTab("Netflix Statistix - Home", icon, createHome());
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        tabbedPane.addTab("Films", icon, createFilms());
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        tabbedPane.addTab("Series", icon, createSeries());
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        tabbedPane.addTab("Profiel", icon, createProfile());
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        tabbedPane.addTab("Bekeken Content", icon, createWatchedContent());
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_5);

        //Setting the background color of the tabs to red and the foreground to white.
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            tabbedPane.setBackgroundAt(i, Color.white);
            tabbedPane.setForegroundAt(i, new Color(229, 9, 20));
        }

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        return tabbedPane;
    }

    public JPanel createHome() {
        HomePanel homePanel = new HomePanel();
        return homePanel.createHomePanel();
    }

    public JPanel createFilms() {
        FilmPanel filmPanel = new FilmPanel();
        return filmPanel.createFilmPanel();
    }

    public JPanel createSeries() {
        SeriePanel seriePanel = new SeriePanel();
        return seriePanel.createSeriePanel();
    }

    public JPanel createProfile() {
        Profile profilePanel = new Profile();
        return profilePanel.createProfilePanel();
    }

    public JPanel createWatchedContent() {
        WatchedContentPanel watched = new WatchedContentPanel();
        return watched.createWatchPanel();
    }

}
