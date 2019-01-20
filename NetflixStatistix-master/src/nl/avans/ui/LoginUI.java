package nl.avans.ui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginUI  extends JFrame {

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


    public JPanel LoginUI(){

        dialogPane = new JPanel();
        contentPanel = new JPanel();
        buttonBar = new JPanel();

        UsernameLabel = new JLabel();
        UsernameString = new JTextField();
        PasswordLabel = new JLabel();
        PasswordString = new JPasswordField();

        LoginLabel = new JLabel();
        LoginOkButtton = new JButton();
        LoginCancelButton = new JButton();


        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        {

            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), dialogPane.getBorder()));

            dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });

            dialogPane.setLayout(new BorderLayout());

            //<contentPanel>
            {
                contentPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));

                //<UsernameLabel>
                UsernameLabel.setText("Username:");
                contentPanel.add(UsernameLabel, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //<UsernameString>
                UsernameString.setPreferredSize(new Dimension(150, 30));
                contentPanel.add(UsernameString, new GridConstraints(1, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //<PasswordLabel>
                PasswordLabel.setText("Password:");
                contentPanel.add(PasswordLabel, new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //<PasswordString>
                PasswordString.setPreferredSize(new Dimension(150, 30));
                contentPanel.add(PasswordString, new GridConstraints(2, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }

            dialogPane.add(contentPanel, BorderLayout.CENTER);
            {
                //<Buttons>
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
                ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};

                //<LoginOkButtton>
                LoginOkButtton.setText("OK");
                buttonBar.add(LoginOkButtton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //<LoginCancelButton>
                LoginCancelButton.setText("Cancel");
                buttonBar.add(LoginCancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //<LoginLabel>
            LoginLabel.setText("Netflix Statistix");
            LoginLabel.setForeground(new Color(255, 51, 51));
            LoginLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
            LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
            dialogPane.add(LoginLabel, BorderLayout.NORTH);
        }
            contentPane.add(dialogPane, BorderLayout.CENTER);
            return contentPanel;
    }
}