package me.Jack.Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstSwing extends JFrame{

    JLabel age = new JLabel();
    JLabel firstName = new JLabel("First Name");
    JTextField firstNameField = new JTextField(30);
    JLabel lastName = new JLabel("Last Name");
    JTextField lastNameField = new JTextField(30);
    JLabel year = new JLabel("Year of birth");
    JTextField yearField = new JTextField(4);
    JLabel month = new JLabel("Month of birth");
    JTextField monthField = new JTextField(2);
    JLabel day = new JLabel("Day of birth");
    JTextField dayField = new JTextField(10);
    JButton calculateAge = new JButton("Calculate Age");

    public void run(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setName("Information");
        frame.setSize(800, 1200);
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        calculateAge.addActionListener(new ClickListener());
        GridLayout gridLayout = new GridLayout(6, 2);
        panel.setLayout(gridLayout);
        panel.add(firstName);
        panel.add(firstNameField);
        panel.add(lastName);
        panel.add(lastNameField);
        panel.add(year);
        panel.add(yearField);
        panel.add(month);
        panel.add(monthField);
        panel.add(day);
        panel.add(dayField);
        panel.add(calculateAge);
        panel.add(age);
        changeFont(panel, new Font("Arial", Font.PLAIN, 250));
        frame.setContentPane(panel);
        frame.setVisible(true);

    }

    private class ClickListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if(e.getSource() == calculateAge){
                int calcAge = 2019 - Integer.parseInt(yearField.getText());
                System.out.println(calcAge);
                age.setText(calcAge + "");
                age.repaint();
            }
        }
    }

    public static void changeFont ( Component component, Font font )
    {
        component.setFont ( font );
        if ( component instanceof Container )
        {
            for ( Component child : ( ( Container ) component ).getComponents () )
            {
                changeFont ( child, font );
            }
        }
    }

}
