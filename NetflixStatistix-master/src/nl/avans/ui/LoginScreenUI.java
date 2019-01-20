package nl.avans.ui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import javafx.scene.layout.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginScreenUI extends JFrame {



    public JPanel createdialogPane(){

        JPanel dialogPane = new JPanel(new GridBagLayout());
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());

        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

        dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
        dialogPane.setLayout(new BorderLayout());
        return dialogPane;
    }
    public JPanel createcontentPanel(){
             //<contentPanel>
        JPanel contentPanel = new JPanel();
        JLabel UsernameLabel = new JLabel();
        JTextField UsernameString = new JTextField();
        JLabel PasswordLabel = new JLabel();
        JPasswordField PasswordString = new JPasswordField();
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
        //dialogPane.add(contentPanel, BorderLayout.CENTER);
        new GridConstraints();
            return contentPanel;
    }

    public JPanel createButtonBar() {
        JPanel buttonBar = new JPanel();
        JButton LoginOkButtton = new JButton();
        JButton LoginCancelButton = new JButton();
        JButton RegisterButton = new JButton();

        buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
        buttonBar.setLayout(new GridBagLayout());
        ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
        ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};

        //LoginOkButtton
        LoginOkButtton.setText("OK");
        buttonBar.add(LoginOkButtton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 10), 0, 0));

        //LoginCancelButton
        LoginCancelButton.setText("Cancel");
        buttonBar.add(LoginCancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

        //RegisterButton
        RegisterButton.setText("Register account");
        buttonBar.add(RegisterButton, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        return buttonBar;
        //dialogPane.add(buttonBar, BorderLayout.SOUTH);
    }



    public JLabel LoginLabel(){
        JLabel LoginLabel = new JLabel();
        LoginLabel.setText("Netflix Statistix");
        LoginLabel.setForeground(new Color(255, 51, 51));
        LoginLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
        LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //  dialogPane.add(LoginLabel, BorderLayout.NORTH);
        //contentPane.add(dialogPane, new GridBagConstraints(
        // 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        return LoginLabel;
    }
}
