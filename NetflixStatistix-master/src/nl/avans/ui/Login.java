package nl.avans.ui;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import com.intellij.uiDesigner.core.*;
import javax.swing.JFrame;
import sun.rmi.runtime.Log;

public class Login extends JFrame {
    //the mainframe creates all the components and controls them.

    private UIComponents footer;
    private LoginScreenUI LoginScreenPane;
    private JFrame frame;


    public Login() {

        frame = new JFrame("Welcome to Netflix");
        LoginScreenPane = new LoginScreenUI();
        footer = new UIComponents();

        frame.add(footer.createFooter(), BorderLayout.SOUTH);
        frame.add(LoginScreenPane.LoginLabel(), BorderLayout.NORTH);
        frame.add(LoginScreenPane.createdialogPane());
        frame.add(LoginScreenPane.createcontentPanel(), BorderLayout.CENTER);

        frame.add(LoginScreenPane.createButtonBar(), BorderLayout.SOUTH);

        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());


    }

    private void thisInputMethodTextChanged(InputMethodEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Wesley de Jonge
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        UsernameLabel = new JLabel();
        UsernameString = new JTextField();
        PasswordLabel = new JLabel();
        PasswordString = new JPasswordField();
        buttonBar = new JPanel();
        LoginOkButtton = new JButton();
        LoginCancelButton = new JButton();
        LoginLabel = new JLabel();

        //======== this ========
        addInputMethodListener(new InputMethodListener() {
            @Override
            public void caretPositionChanged(InputMethodEvent e) {}
            @Override
            public void inputMethodTextChanged(InputMethodEvent e) {
                thisInputMethodTextChanged(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));

                //---- UsernameLabel ----
                UsernameLabel.setText("Username:");
                contentPanel.add(UsernameLabel, new GridConstraints(1, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

                //---- UsernameString ----
                UsernameString.setPreferredSize(new Dimension(150, 30));
                contentPanel.add(UsernameString, new GridConstraints(1, 1, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

                //---- PasswordLabel ----
                PasswordLabel.setText("Password:");
                contentPanel.add(PasswordLabel, new GridConstraints(2, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

                //---- PasswordString ----
                PasswordString.setPreferredSize(new Dimension(150, 30));
                contentPanel.add(PasswordString, new GridConstraints(2, 1, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- LoginOkButtton ----
                LoginOkButtton.setText("OK");
                buttonBar.add(LoginOkButtton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- LoginCancelButton ----
                LoginCancelButton.setText("Cancel");
                buttonBar.add(LoginCancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //---- LoginLabel ----
            LoginLabel.setText("Netflix Statistix");
            LoginLabel.setForeground(new Color(255, 51, 51));
            LoginLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
            LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
            dialogPane.add(LoginLabel, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Wesley de Jonge
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel UsernameLabel;
    private JTextField UsernameString;
    private JLabel PasswordLabel;
    private JPasswordField PasswordString;
    private JPanel buttonBar;
    private JButton LoginOkButtton;
    private JButton LoginCancelButton;
    private JLabel LoginLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}