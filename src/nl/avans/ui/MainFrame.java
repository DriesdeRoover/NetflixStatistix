package nl.avans.ui;


import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    //the mainframe creates all the components and controls them.

    private UIComponents footer;
    private UIComponents menu;
    private UIComponents test;
    private UIComponents content;
    private JFrame frame;


    public MainFrame() {

        frame = new JFrame("Netflix Statistix - 2019");
        footer = new UIComponents();
        menu = new UIComponents();
        test = new UIComponents();
        content = new UIComponents();

        frame.setLayout(new BorderLayout());
        //frame.add(menu.createMenu(), BorderLayout.WEST);
        frame.add(content.createWatchedSeriePanel(), BorderLayout.CENTER);
        frame.add(footer.createFooter(), BorderLayout.SOUTH);

        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.repaint();
    }
}


