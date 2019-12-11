package me.Jack.Projects;

import javax.swing.JRadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Survey extends JFrame implements ActionListener {

    JLabel gradeLabel = new JLabel("Grade");
    String[] grades = {"Grade 9", "Grade 10", "Grade 11", "Grade 12"};
    JComboBox gradesBox = new JComboBox<>(grades);

    JLabel genderLabel = new JLabel("Gender");
    String [] genders = {"Male", "Female"};
    JComboBox gendersBox = new JComboBox<>(genders);

    JLabel ageLabel = new JLabel("Age");
    SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1);
    JSpinner age = new JSpinner(model);

    JLabel firstSemLabel = new JLabel("Classes First Semester");
    SpinnerModel firstSemModel = new SpinnerNumberModel(1, 1, 5, 1);
    JSpinner classesFirstSem = new JSpinner(firstSemModel);

    JLabel secondSemLabel = new JLabel("Classes First Semester");
    SpinnerModel secondSemModel = new SpinnerNumberModel(1, 1, 5, 1);
    JSpinner classesSecondSem = new JSpinner(secondSemModel);

    JLabel studentAverage = new JLabel("Your Average");
    SpinnerModel averageModel = new SpinnerNumberModel(1, 1, 100, 1);
    JSpinner average = new JSpinner(averageModel);

    JLabel anticipatedAverageLabel = new JLabel("Anticipated Average");
    SpinnerModel anticipatedAverageModel = new SpinnerNumberModel(1, 1, 100, 1);
    JSpinner anticipatedAverage = new JSpinner(anticipatedAverageModel);

    JRadioButton basketball = new JRadioButton("Basketball");
    JRadioButton football = new JRadioButton("Football");
    JRadioButton baseball = new JRadioButton("Baseball");
    JRadioButton robotics = new JRadioButton("Robotics");
    JRadioButton dramaClub = new JRadioButton("Drama Club");

    ButtonGroup activites = new ButtonGroup();

    String [] options = {"Yes", "No"};

    JSlider schoolRating = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);

    JSlider GDHSRating = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);

    GridLayout gridLayout = new GridLayout(14,2, 30, 20);

    public void run(){
        JFrame frame = new JFrame("Survey");
        frame.setSize(800, 1400);
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gradesBox.setActionCommand("grade");
        gradesBox.setSelectedIndex(0);
        gradesBox.addActionListener(this);

        gendersBox.setActionCommand("gender");
        gendersBox.setSelectedIndex(0);
        gendersBox.addActionListener(this);

        activites.add(basketball);
        activites.add(football);
        activites.add(baseball);
        activites.add(robotics);
        activites.add(dramaClub);

        schoolRating.setMajorTickSpacing(1);
        schoolRating.setPaintLabels(true);
        schoolRating.setPaintTicks(true);

        schoolRating.setMajorTickSpacing(1);
        schoolRating.setPaintLabels(true);
        schoolRating.setPaintTicks(true);

        frame.setLayout(gridLayout);

        frame.add(gradeLabel);
        frame.add(gradesBox);

        frame.add(genderLabel);
        frame.add(gendersBox);

        frame.add(ageLabel);
        frame.add(age);

        frame.add(firstSemLabel);
        frame.add(classesFirstSem);

        frame.add(secondSemLabel);
        frame.add(classesSecondSem);

        frame.add(studentAverage);
        frame.add(average);

        frame.add(anticipatedAverageLabel);
        frame.add(anticipatedAverage);

        frame.add(new JLabel("Activities"));
        frame.add(baseball);
        frame.add(basketball);
        frame.add(football);
        frame.add(robotics);
        frame.add(dramaClub);

        frame.add(new JLabel("Other Activites"));
        frame.add(new TextField());

        frame.add(new JLabel("BusGang"));
        frame.add(new JComboBox<>(options));

        frame.add(new JLabel("Do you like School"));
        frame.add(schoolRating);

        frame.add(new JLabel("Do you like GDHS"));
        frame.add(GDHSRating);

        changeFont(frame, new Font("Arial", Font.PLAIN, 30));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("grade")){
            System.out.println(gradesBox.getSelectedItem());
        }
    }

    public static void changeFont (Component component, Font font )
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
