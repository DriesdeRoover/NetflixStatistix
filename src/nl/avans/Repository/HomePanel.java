package nl.avans.Repository;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {


    public JPanel createHomePanel() {
        //This methods creates a logo for the homepage from the netflix.png file
        JPanel homePanel = new JPanel(new BorderLayout());
        homePanel.setBackground(Color.white);

        try {
            JLabel wIcon = new JLabel(new ImageIcon("netflix.png"));
            homePanel.add(wIcon);
        } catch (Exception ex) {
            // handle exception...
        }

        return homePanel;
    }
}
