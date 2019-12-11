package me.Jack.Projects;

import javax.swing.*;

public class FramePlay {

    public void run(){
        JFrame frame = new JFrame();
        JPanel contents = new JPanel();
        JLabel heading = new JLabel("Please enter a short story");
        JButton saveButton = new JButton("Save it");
        JLabel headingName = new JLabel("And your name is?");
        JTextArea name = new JTextArea(10, 20);
        JTextField textField = new JTextField(10);

        contents.add(heading);
        contents.add(name);
        contents.add(headingName);
        contents.add(textField);
        contents.add(saveButton);

        frame.setContentPane(contents);

        frame.setTitle("Frame Play");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(200, 100);
        frame.setSize(250, 350);
        frame.setVisible(true);
    }
}
