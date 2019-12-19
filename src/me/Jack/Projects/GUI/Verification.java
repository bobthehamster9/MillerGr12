package me.Jack.Projects.GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Verification {
    private JTextField upcField;
    private JTextField sinField;
    private JButton verifyUPCButton;
    private JButton verifySINButton;
    private JLabel sinLabel;
    private JLabel upcLabel;
    private JLabel ccLabel;
    private JLabel birthLabel;
    private JButton verifyCCButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton verifyBirthDateButton;
    private JPanel MyPanel;
    private JTextField ccField;

    int upcOdd, upcEven, upcResult;
    ArrayList<Integer> sinNum = new ArrayList<>();
    boolean switch12 = true;

    public Verification() {
        verifyUPCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String upc = upcField.getText();
                upcOdd = 0;
                upcEven = 0;
                upcResult = 0;
                for (int i = 1; i < upc.length(); i++) {
                    if (!(i % 2 == 0)) {
                        upcOdd += Integer.parseInt(upc.charAt(i - 1) + "");
                    } else if (i % 2 == 0) {
                        upcEven += Integer.parseInt(upc.charAt(i - 1) + "");
                    }
                }
                upcOdd *= 3;
                upcResult = 10 - ((upcOdd + upcEven) % 10);
                System.out.println(upcResult);
            }
        });
        verifySINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sinNum.clear();
                String sin = sinField.getText();
                for (int i = 0; i < sin.length(); i++) {
                    int num = Integer.parseInt(sin.charAt(i) + "");
                    if (switch12) {
                        sinNum.add(num);
                        switch12 = false;
                    } else if (!switch12) {
                        if (num * 2 >= 10) {
                            int numDoubled = num * 2;
                            int sum;
                            for (sum = 0; numDoubled > 0; sum += numDoubled % 10,
                                    numDoubled /= 10)
                                ;
                            sinNum.add(sum);
                        } else {
                            sinNum.add(num * 2);
                        }
                        switch12 = true;
                    }
                }

                int total = 0;
                for (int i = 0; i < sinNum.size(); i++) {
                    total += sinNum.get(i);
                }
                if (total % 10 == 0)
                    System.out.println("Valid sin");
                else
                    System.out.println("Invalid Sin");
            }
        });
        verifyCCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public void run() {
        JFrame frame = new JFrame("Verification");
        frame.setContentPane(new Verification().MyPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        MyPanel = new JPanel();
        MyPanel.setLayout(new GridLayoutManager(6, 6, new Insets(0, 0, 0, 0), -1, -1));
        upcLabel = new JLabel();
        upcLabel.setText("UPC Code: ");
        MyPanel.add(upcLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ccLabel = new JLabel();
        ccLabel.setText("Credit Card:");
        MyPanel.add(ccLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sinLabel = new JLabel();
        sinLabel.setText("S.I.N. :");
        MyPanel.add(sinLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        birthLabel = new JLabel();
        birthLabel.setText("Birth Date:");
        MyPanel.add(birthLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        upcField = new JTextField();
        upcField.setText("");
        MyPanel.add(upcField, new GridConstraints(0, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        sinField = new JTextField();
        MyPanel.add(sinField, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        ccField = new JTextField();
        MyPanel.add(ccField, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        verifyUPCButton = new JButton();
        verifyUPCButton.setText("Verify UPC");
        MyPanel.add(verifyUPCButton, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        MyPanel.add(spacer1, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        MyPanel.add(spacer2, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        verifySINButton = new JButton();
        verifySINButton.setText("Verify SIN");
        MyPanel.add(verifySINButton, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        verifyCCButton = new JButton();
        verifyCCButton.setText("Verify CC");
        MyPanel.add(verifyCCButton, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Year");
        MyPanel.add(label1, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Month");
        MyPanel.add(label2, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Day");
        MyPanel.add(label3, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox1 = new JComboBox();
        MyPanel.add(comboBox1, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox2 = new JComboBox();
        MyPanel.add(comboBox2, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox3 = new JComboBox();
        MyPanel.add(comboBox3, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        MyPanel.add(spacer3, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        verifyBirthDateButton = new JButton();
        verifyBirthDateButton.setText("Verify Birth Date");
        MyPanel.add(verifyBirthDateButton, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MyPanel;
    }
}