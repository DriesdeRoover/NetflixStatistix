package nl.avans.ui;


import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    //the mainframe creates all the components and controls them.

    private UIComponents footer;
    private UIComponents content;
    private JFrame frame;


    public MainFrame() {

        frame = new JFrame("Netflix Statistix - 2019");
        footer = new UIComponents();
        content = new UIComponents();

        frame.setLayout(new BorderLayout());
        frame.add(content.createTabs(), BorderLayout.CENTER);
        frame.add(footer.createFooter(), BorderLayout.SOUTH);

        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


