package nl.avans;

import nl.avans.ui.Login;
import nl.avans.ui.MainFrame;

import javax.swing.*;

/**
 * Netflix Statistix \\ Programmeren II & Databases II \\ Dries de Roover & Wesley de Jonge \\
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();

            }
        });

    }
}