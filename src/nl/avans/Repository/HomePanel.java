package nl.avans.Repository;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {


    public JPanel createHomePanel(){
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
