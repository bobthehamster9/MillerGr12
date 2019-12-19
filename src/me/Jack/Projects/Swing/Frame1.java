package me.Jack.Projects.Swing;

import javax.swing.*;

public class Frame1 {

    JFrame jFrame = new JFrame();

    public void run(){
        jFrame.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        jFrame.setName("Nig nog");
        jFrame.setSize(400, 400);
        jFrame.setLocation(300, 300);
        jFrame.setVisible(true);
    }

}
