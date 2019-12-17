package me.Jack.Projects;

import javax.swing.JRadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Survey extends JFrame implements ActionListener {

    int activityCount = 0;

    JFrame frame = new JFrame("Survey");

    String[] grades = {"Grade 9", "Grade 10", "Grade 11", "Grade 12"};
    JComboBox gradesBox = new JComboBox<>(grades);

    String [] genders = {"Male", "Female"};
    JComboBox gendersBox = new JComboBox<>(genders);

    SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1);
    JSpinner age = new JSpinner(model);

    SpinnerModel firstSemModel = new SpinnerNumberModel(1, 1, 5, 1);
    JSpinner classesFirstSem = new JSpinner(firstSemModel);

    SpinnerModel secondSemModel = new SpinnerNumberModel(1, 1, 5, 1);
    JSpinner classesSecondSem = new JSpinner(secondSemModel);

    SpinnerModel averageModel = new SpinnerNumberModel(1, 1, 100, 1);
    JSpinner average = new JSpinner(averageModel);

    SpinnerModel anticipatedAverageModel = new SpinnerNumberModel(1, 1, 100, 1);
    JSpinner anticipatedAverage = new JSpinner(anticipatedAverageModel);

    JRadioButton basketball = new JRadioButton("Basketball");
    JRadioButton football = new JRadioButton("Football");
    JRadioButton baseball = new JRadioButton("Baseball");
    JRadioButton robotics = new JRadioButton("Robotics");
    JRadioButton dramaClub = new JRadioButton("Drama Club");

    JTextField otherActivities = new JTextField(10);

    JLabel activitiesSelected = new JLabel();

    String [] options = {"Yes", "No"};
    JComboBox busOptions = new JComboBox<>(options);

    JSlider schoolRating = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);

    JSlider GDHSRating = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);

    JButton save = new JButton("Save");

    GridLayout gridLayout = new GridLayout(16,2, 30, 20);

    public void run(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gradesBox.setActionCommand("grade");
        gradesBox.setSelectedIndex(0);
        gradesBox.addActionListener(this);

        gendersBox.setActionCommand("gender");
        gendersBox.setSelectedIndex(0);
        gendersBox.addActionListener(this);

        basketball.addActionListener(this);
        football.addActionListener(this);
        baseball.addActionListener(this);
        robotics.addActionListener(this);
        dramaClub.addActionListener(this);

        schoolRating.setMajorTickSpacing(1);
        schoolRating.setPaintLabels(true);
        schoolRating.setPaintTicks(true);

        GDHSRating.setMajorTickSpacing(1);
        GDHSRating.setPaintLabels(true);
        GDHSRating.setPaintTicks(true);

        busOptions.setSelectedIndex(1);

        save.addActionListener(this);

        frame.setLayout(gridLayout);

        frame.add(new JLabel("Grade"));
        frame.add(gradesBox);

        frame.add(new JLabel("Gender"));
        frame.add(gendersBox);

        frame.add(new JLabel("Age"));
        frame.add(age);

        frame.add(new JLabel("Classes First Semester"));
        frame.add(classesFirstSem);

        frame.add(new JLabel("Classes Second Semester"));
        frame.add(classesSecondSem);

        frame.add(new JLabel("Your Average"));
        frame.add(average);

        frame.add(new JLabel("Anticipated Average"));
        frame.add(anticipatedAverage);

        frame.add(new JLabel("Activities"));
        frame.add(baseball);
        frame.add(basketball);
        frame.add(football);
        frame.add(robotics);
        frame.add(dramaClub);

        frame.add(new JLabel("Other Activites"));
        frame.add(otherActivities);

        frame.add(new JLabel("Activities Selected: "));
        frame.add(activitiesSelected);

        frame.add(new JLabel("Do you take the bus"));
        frame.add(busOptions);

        frame.add(new JLabel("Do you like School"));
        frame.add(schoolRating);

        frame.add(new JLabel("Do you like GDHS"));
        frame.add(GDHSRating);

        frame.add(save);

        changeFont(frame, new Font("Arial", Font.PLAIN, 12));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(basketball)) {
            activityCount = basketball.isSelected() ? activityCount+1 : activityCount-1;
        } else if (e.getSource().equals(football)){
            activityCount = football.isSelected() ? activityCount+1 : activityCount-1;
        } else if (e.getSource().equals(baseball)){
            activityCount = baseball.isSelected() ? activityCount+1 : activityCount-1;
        } else if (e.getSource().equals(robotics)){
            activityCount = robotics.isSelected() ? activityCount+1 : activityCount-1;
        } else if (e.getSource().equals(dramaClub)){
            activityCount = dramaClub.isSelected() ? activityCount+1 : activityCount-1;
        } else if (e.getSource().equals(save)){
            try{
                PrintWriter printWriter = new PrintWriter("SurveyResults");
                printWriter.println("Grade: " + gradesBox.getSelectedItem());
                printWriter.println("Gender: " + gendersBox.getSelectedItem());
                printWriter.println("Age: " + age.getValue());
                printWriter.println("# of classes sem1: " + classesFirstSem.getValue());
                printWriter.println("# of classes sem2: " + secondSemModel.getValue());
                printWriter.println("Average: " + average.getValue());
                printWriter.println("Anticipated average: " + anticipatedAverage.getValue());
                printWriter.println("basketball: " + basketball.isSelected());
                printWriter.println("football: " + football.isSelected());
                printWriter.println("baseball: " + baseball.isSelected());
                printWriter.println("robotics: " + robotics.isSelected());
                printWriter.println("drama club: " + dramaClub.isSelected());
                printWriter.println("unlisted activities: " + otherActivities.getText());
                printWriter.println("bus: "  + busOptions.getSelectedItem());
                printWriter.println("school rating: " + schoolRating.getValue());
                printWriter.println("GDHS rating: " + GDHSRating.getValue());
                printWriter.close();
            } catch (FileNotFoundException exception){
                exception.printStackTrace();
            }
        }
        activitiesSelected.setText(activityCount + "");
        frame.repaint();
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
