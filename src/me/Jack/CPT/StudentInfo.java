package me.Jack.CPT;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentInfo {

    /*
    TODO
    Fix search by age (miller doesn't care atm)
     */

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField postalField;
    private JTextField course7Field;
    private JTextField course4Field;
    private JTextField course8Field;
    private JTextField course3Field;
    private JTextField course6Field;
    private JTextField phoneField;
    private JTextField ageField;
    private JTextField studentNumField;
    private JTextField avgField;
    private JTextField course2Field;
    private JLabel avgLabel;
    private JLabel firstNameLabel;
    private JLabel streetAddressLabel;
    private JLabel provinceLabel;
    private JLabel lastNameLabel;
    private JLabel cityLabel;
    private JLabel postalCodeLabel;
    private JLabel studentNumberLabel;
    private JLabel homePhoneNumberLabel;
    private JLabel dateOfBirthLabel;
    private JLabel genderLabel;
    private JLabel gradeLabel;
    private JLabel ageLabel;
    private JPanel panel;
    private JComboBox courseBox6;
    private JComboBox courseBox7;
    private JComboBox courseBox8;
    private JComboBox courseBox2;
    private JComboBox courseBox3;
    private JComboBox courseBox4;
    private JList studentList;
    private JButton SEARCHButton;
    private JButton EDITButton;
    private JButton SAVEButton;
    private JButton ADDButton;
    private JTextField searchField;
    private JButton PREVButton;
    private JButton NEXTButton;
    private JRadioButton ALPHABETICALLYRadioButton;
    private JComboBox courseListBox;
    private JRadioButton AGERadioButton;
    private JComboBox gradeListBox;
    private JTextField course5Field;
    private JTextField course1Field;
    private JComboBox courseBox5;
    private JComboBox courseBox1;
    private JRadioButton GRADESRadioButton;
    private JComboBox yearBox;
    private JComboBox gradeBox;
    private JComboBox provBox;
    private JComboBox genderBox;
    private JTextField maxField;
    private JTextField minField;
    private JComboBox dayBox;
    private JComboBox monthBox;
    private JRadioButton grade9RadioButton;
    private JRadioButton grade11RadioButton;
    private JRadioButton grade10RadioButton;
    private JRadioButton grade12RadioButton;
    private JButton DELETESTUDENTButton;
    private JTextField CourseIDField;
    private JComboBox CourseTypeBox;
    private JComboBox CourseGradeBox;
    private JTextArea CourseDescArea;
    private JButton ADDCOURSEButton;

    DefaultListModel listModel = new DefaultListModel();

    DefaultComboBoxModel course1 = new DefaultComboBoxModel();
    DefaultComboBoxModel course2 = new DefaultComboBoxModel();
    DefaultComboBoxModel course3 = new DefaultComboBoxModel();
    DefaultComboBoxModel course4 = new DefaultComboBoxModel();
    DefaultComboBoxModel course5 = new DefaultComboBoxModel();
    DefaultComboBoxModel course6 = new DefaultComboBoxModel();
    DefaultComboBoxModel course7 = new DefaultComboBoxModel();
    DefaultComboBoxModel course8 = new DefaultComboBoxModel();
    DefaultComboBoxModel courseSearch = new DefaultComboBoxModel();

    ArrayList<DefaultComboBoxModel> courseArray = new ArrayList<>();

    Data data = new Data();

    ArrayList<String> tmpStudentList = new ArrayList<>();

    int[] coursesInt = new int[16];
    int grade, selectedIndex, max = 100, min = 0;

    public void setEditable(boolean editable) {
        //Perma disabled
        lastNameField.setEditable(false);
        studentNumField.setEditable(false);
        avgField.setEditable(false);
        ageField.setEditable(false);

        firstNameField.setEditable(editable);
        addressField.setEditable(editable);
        cityField.setEditable(editable);
        provBox.setEnabled(editable);
        postalField.setEditable(editable);
        phoneField.setEditable(editable);
        yearBox.setEnabled(editable);
        dayBox.setEnabled(editable);
        monthBox.setEnabled(editable);
        genderBox.setEnabled(editable);
        gradeBox.setEnabled(editable);
        courseBox1.setEnabled(editable);
        course1Field.setEditable(editable);
        courseBox2.setEnabled(editable);
        course2Field.setEditable(editable);
        courseBox3.setEnabled(editable);
        course3Field.setEditable(editable);
        courseBox4.setEnabled(editable);
        course4Field.setEditable(editable);
        courseBox5.setEnabled(editable);
        course5Field.setEditable(editable);
        courseBox6.setEnabled(editable);
        course6Field.setEditable(editable);
        courseBox7.setEnabled(editable);
        course7Field.setEditable(editable);
        courseBox8.setEnabled(editable);
        course8Field.setEditable(editable);
    }

    public void clearFields() {
        grade = 1;
        setCourseBox();
        firstNameField.setText("");
        lastNameField.setText("");
        addressField.setText("");
        cityField.setText("");
        provBox.setSelectedIndex(0);
        postalField.setText("");
        studentNumField.setText("");
        phoneField.setText("");
        yearBox.setSelectedIndex(0);
        dayBox.setSelectedIndex(0);
        monthBox.setSelectedIndex(0);
        genderBox.setSelectedIndex(0);
        gradeBox.setSelectedIndex(0);
        ageField.setText("");
        course1Field.setText("0");
        course2Field.setText("0");
        course3Field.setText("0");
        course4Field.setText("0");
        course5Field.setText("0");
        course6Field.setText("0");
        course7Field.setText("0");
        course8Field.setText("0");
    }

    public void setCourseBoxContents(ArrayList arrayList) {
        for (int i = 0; i < courseArray.size(); i++) {
            courseArray.get(i).addAll(arrayList);
        }
    }

    public void setCourseBox() {
        for (int i = 0; i < courseArray.size(); i++) {
            courseArray.get(i).removeAllElements();
        }
        switch (gradeBox.getSelectedIndex()) {
            case 1:
                setCourseBoxContents(data.course9Keys);
                break;
            case 2:
                setCourseBoxContents(data.course10Keys);
                break;
            case 3:
                setCourseBoxContents(data.course11Keys);
                break;
            case 4:
                setCourseBoxContents(data.course12Keys);
                break;
        }
        courseBox1.setModel(course1);
        courseBox2.setModel(course2);
        courseBox3.setModel(course3);
        courseBox4.setModel(course4);
        courseBox5.setModel(course5);
        courseBox6.setModel(course6);
        courseBox7.setModel(course7);
        courseBox8.setModel(course8);
    }

    public void setCourseBoxesToIndex() {
        courseBox1.setSelectedIndex(coursesInt[0]);
        course1Field.setText(coursesInt[1] + "");
        courseBox2.setSelectedIndex(coursesInt[2]);
        course2Field.setText(coursesInt[3] + "");
        courseBox3.setSelectedIndex(coursesInt[4]);
        course3Field.setText(coursesInt[5] + "");
        courseBox4.setSelectedIndex(coursesInt[6]);
        course4Field.setText(coursesInt[7] + "");
        courseBox5.setSelectedIndex(coursesInt[8]);
        course5Field.setText(coursesInt[9] + "");
        courseBox6.setSelectedIndex(coursesInt[10]);
        course6Field.setText(coursesInt[11] + "");
        courseBox7.setSelectedIndex(coursesInt[12]);
        course7Field.setText(coursesInt[13] + "");
        courseBox8.setSelectedIndex(coursesInt[14]);
        course8Field.setText(coursesInt[15] + "");
    }

    public boolean checkFields() {
        System.out.println(phoneField.getText().length());
        if (firstNameField.getText() != "" && lastNameField.getText() != "" && addressField.getText() != "" &&
                cityField.getText() != "" && postalField.getText().replaceAll(" ", "").length() == 6 && studentNumField.getText().length() == 9
                && phoneField.getText().replaceAll(" ", "").length() == 10) {
            return true;
        } else {
            return false;
        }
    }

    public void setStudent(Object selected_row) {
        String id[] = selected_row.toString().toUpperCase().split(", ");
        firstNameField.setText(data.firstName.get(selected_row).toUpperCase());
        lastNameField.setText(id[0]);
        addressField.setText(data.address.get(selected_row).toUpperCase());
        cityField.setText(data.city.get(selected_row).toUpperCase());
        provBox.setSelectedIndex(data.province.get(selected_row));
        postalField.setText(data.postalCode.get(selected_row));
        studentNumField.setText(id[1]);
        phoneField.setText(data.phoneNum.get(selected_row));
        yearBox.setSelectedIndex(data.DOByear.get(selected_row));
        dayBox.setSelectedIndex(data.DOBday.get(selected_row));
        monthBox.setSelectedIndex(data.DOBmonth.get(selected_row));
        genderBox.setSelectedIndex(data.gender.get(selected_row));
        gradeBox.setSelectedIndex(data.grade.get(selected_row));
        LocalDate birthdate = LocalDate.of(data.DOByear.get(selected_row) + 1999, data.DOBmonth.get(selected_row), data.DOBday.get(selected_row));
        ageField.setText(data.calculateAge(birthdate) + "");
        setCourseBox();
        String[] courses = data.courses.get(selected_row).split("/");
        for (int i = 0; i < courses.length; i++) {
            coursesInt[i] = Integer.parseInt(courses[i]);
        }
        setCourseBoxesToIndex();
        avgField.setText(calculateAverage() + "");
        setEditable(false);
    }

    public StudentInfo() {
        studentList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    Object selected_row = ((JList) e.getSource()).getSelectedValue();
                    setStudent(selected_row);
                    selectedIndex = ((JList) e.getSource()).getSelectedIndex();
                }
            }
        });
        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkFields()) {
                    try {
                        LocalDate birthdate = LocalDate.of(yearBox.getSelectedIndex() + 1999, monthBox.getSelectedIndex(), dayBox.getSelectedIndex());
                        ageField.setText(data.calculateAge(birthdate) + "");
                        String courses[] = {courseBox1.getSelectedIndex() + "", course1Field.getText(), courseBox2.getSelectedIndex() + "", course2Field.getText(), courseBox3.getSelectedIndex() + "", course3Field.getText(), courseBox4.getSelectedIndex() + "", course4Field.getText(),
                                courseBox5.getSelectedIndex() + "", course5Field.getText(), courseBox6.getSelectedIndex() + "", course6Field.getText(), courseBox7.getSelectedIndex() + "", course7Field.getText(), courseBox8.getSelectedIndex() + "", course8Field.getText()};
                        for (int i = 0; i < courses.length; i++) {
                            coursesInt[i] = Integer.parseInt(courses[i]);
                        }
                        avgField.setText(calculateAverage() + "");
                        //studentNum, firstName, lastName, address, city, province, postal code, phone#, year, day, month, gender, grade, course1, avg, course2, avg, course3, avg....
                        String student = studentNumField.getText() + "," + firstNameField.getText().toUpperCase() + "," + lastNameField.getText().toUpperCase() + "," + addressField.getText().toUpperCase() + "," + cityField.getText().toUpperCase() + "," +
                                provBox.getSelectedIndex() + "," + postalField.getText().replaceAll(" ", "") + "," + phoneField.getText().replaceAll(" ", "") + "," + yearBox.getSelectedIndex() + "," + dayBox.getSelectedIndex() + "," + monthBox.getSelectedIndex() + "," + genderBox.getSelectedIndex()
                                + "," + gradeBox.getSelectedIndex() + "," + courseBox1.getSelectedIndex() + "/" + course1Field.getText() + "/" + courseBox2.getSelectedIndex() + "/" + course2Field.getText() + "/" + courseBox3.getSelectedIndex()
                                + "/" + course3Field.getText() + "/" + courseBox4.getSelectedIndex() + "/" + course4Field.getText() + "/" + courseBox5.getSelectedIndex() + "/" + course5Field.getText() + "/" + courseBox6.getSelectedIndex()
                                + "/" + course6Field.getText() + "/" + courseBox7.getSelectedIndex() + "/" + course7Field.getText() + "/" + courseBox8.getSelectedIndex() + "/" + course8Field.getText() + "," + avgField.getText() + "," + ageField.getText();
                        data.writeToFile(student, lastNameField.getText().toUpperCase() + ", " + studentNumField.getText());
                        data.initData();
                        initStudentList();
                        studentList.repaint();
                        setEditable(false);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "OOga", "Booga", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
                setEditable(true);
                lastNameField.setEditable(true);
                studentNumField.setEditable(true);
                avgField.setEditable(true);
                ageField.setEditable(true);
                studentList.setSelectedIndex(0);
                selectedIndex = 0;
            }
        });
        EDITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditable(true);
            }
        });
        gradeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gradeBox.getSelectedIndex() != 0)
                    grade = gradeBox.getSelectedIndex();
                else
                    grade = -1;

                setCourseBox();
            }
        });
        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //0,72 student classes/marks
                tmpStudentList.clear();
                String search = searchField.getText();
                listModel.removeAllElements();
                for (int i = 0; i < data.keys.size(); i++) {
                    if (data.keys.get(i).contains(search.toUpperCase())) {
                        String key = data.keys.get(i);
                        String courses[] = data.courses.get(key).split("/");
                        String totalCourses = "";
                        for (int j = 0; j < courses.length; j += 2) {
                            int course = Integer.parseInt(courses[j]);
                            if (course >= 1) {
                                switch (data.grade.get(key)) {
                                    case 1:
                                        totalCourses += data.course9Keys.get(course);
                                        break;
                                    case 2:
                                        totalCourses += data.course10Keys.get(course);
                                        break;
                                    case 3:
                                        totalCourses += data.course11Keys.get(course);
                                        break;
                                    case 4:
                                        totalCourses += data.course12Keys.get(course);
                                        break;
                                }
                                String courseMark = String.format("%03d", Integer.parseInt(courses[j + 1]));
                                totalCourses += courseMark;
                            } else {
                                if (j % 2 == 0) {
                                    totalCourses += "         ";
                                }
                            }
                        }
                        if (courseListBox.getSelectedIndex() > 0) {
                            String filteredCourse = courseListBox.getSelectedItem().toString();
                            if (totalCourses.contains(filteredCourse)) {
                                int mark = Integer.parseInt(totalCourses.substring(totalCourses.indexOf(filteredCourse) + 7, totalCourses.indexOf(filteredCourse) + 9));
                                try {
                                    max = Integer.parseInt(maxField.getText());
                                } catch (NumberFormatException numberException) {
                                    max = 100;
                                    maxField.setText(max + "");
                                }

                                try {
                                    min = Integer.parseInt(minField.getText());
                                } catch (NumberFormatException numberException) {
                                    min = 0;
                                    minField.setText(min + "");
                                }

                                if (max < 0 || max > 100) {
                                    max = 100;
                                }
                                if (min < 0 || min > 100) {
                                    min = 0;
                                }
                                if (totalCourses.contains(filteredCourse)) {
                                    if (mark <= max && mark >= min)
                                        tmpStudentList.add(totalCourses + data.age.get(key) + "" + data.grade.get(key) + key);
                                }
                            }
                        } else {
                            tmpStudentList.add(totalCourses + data.age.get(key) + "" + data.grade.get(key) + key);
                        }
                    }
                }

                if (ALPHABETICALLYRadioButton.isSelected()) {
                    Collections.sort(tmpStudentList, Comparator.comparing(s -> s.substring(75)));
                }

                if (GRADESRadioButton.isSelected()) {
                    Collections.sort(tmpStudentList, Comparator.comparing(s -> s.substring(74, 75)));
                }

                if (AGERadioButton.isSelected() && !GRADESRadioButton.isSelected() && !ALPHABETICALLYRadioButton.isSelected()) {
                    Collections.sort(tmpStudentList, Comparator.comparing(s -> s.substring(72, 74)));
                }

                for (int i = 0; i < tmpStudentList.size(); i++) {
                    if (!grade9RadioButton.isSelected() && !grade10RadioButton.isSelected() && !grade11RadioButton.isSelected() && !grade12RadioButton.isSelected())
                        listModel.addElement(tmpStudentList.get(i).substring(75));
                    else {
                        char grade = tmpStudentList.get(i).charAt(74);
                        if (grade9RadioButton.isSelected() && grade == '1')
                            listModel.addElement(tmpStudentList.get(i).substring(75));

                        if (grade10RadioButton.isSelected() && grade == '2')
                            listModel.addElement(tmpStudentList.get(i).substring(75));

                        if (grade11RadioButton.isSelected() && grade == '3')
                            listModel.addElement(tmpStudentList.get(i).substring(75));

                        if (grade12RadioButton.isSelected() && grade == '4')
                            listModel.addElement(tmpStudentList.get(i).substring(75));
                    }
                }
                studentList.repaint();
            }
        });
        NEXTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((selectedIndex + 1) <= tmpStudentList.size() - 1) {
                    setStudent(tmpStudentList.get(++selectedIndex).substring(75));
                    studentList.setSelectedIndex(selectedIndex);
                }
            }
        });
        PREVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((selectedIndex - 1) >= 0) {
                    setStudent(tmpStudentList.get(--selectedIndex).substring(75));
                    studentList.setSelectedIndex(selectedIndex);
                }
            }
        });
        gradeListBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selection = gradeListBox.getSelectedIndex();
                courseSearch.removeAllElements();
                switch (selection) {
                    case 1:
                        courseSearch.addAll(data.course9Keys);
                        break;
                    case 2:
                        courseSearch.addAll(data.course10Keys);
                        break;
                    case 3:
                        courseSearch.addAll(data.course11Keys);
                        break;
                    case 4:
                        courseSearch.addAll(data.course12Keys);
                        break;
                }
                courseListBox.setModel(courseSearch);
            }
        });
        DELETESTUDENTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = studentNumField.getText() + "," + firstNameField.getText().toUpperCase() + "," + lastNameField.getText().toUpperCase();
                for (int i = 0; i < data.tmpFile.size(); i++) {
                    if (data.tmpFile.get(i).contains(key)) {
                        System.out.println(key);
                        data.tmpFile.remove(i);
                    }
                }
            }
        });
        ADDCOURSEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseType = "";
                if (CourseTypeBox.getSelectedIndex() == 0) {
                    courseType = "U";
                } else if (CourseTypeBox.getSelectedIndex() == 1) {
                    courseType = "M";
                } else if (CourseTypeBox.getSelectedIndex() == 2) {
                    courseType = "O";
                }

                String course = CourseIDField.getText().toUpperCase() + "" + CourseGradeBox.getSelectedIndex() + courseType + "1";
                try {
                    data.writeCourseData(course, CourseGradeBox.getSelectedIndex());
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public void removeBorders() {
        firstNameField.setBorder(null);
        lastNameField.setBorder(null);
        addressField.setBorder(null);
        cityField.setBorder(null);
        studentNumField.setBorder(null);
        postalField.setBorder(null);
        course1Field.setBorder(null);
        course2Field.setBorder(null);
        course3Field.setBorder(null);
        course4Field.setBorder(null);
        course5Field.setBorder(null);
        course6Field.setBorder(null);
        course7Field.setBorder(null);
        course8Field.setBorder(null);
        avgField.setBorder(null);
        ageField.setBorder(null);
        phoneField.setBorder(null);
        searchField.setBorder(null);
        minField.setBorder(null);
        maxField.setBorder(null);
        CourseIDField.setBorder(null);
    }

    public void initStudentList() {
        listModel.removeAllElements();
        for (int i = 0; i < data.keys.size(); i++) {
            listModel.addElement(data.keys.get(i));
        }
        studentList.setModel(listModel);
    }

    public void init() throws IOException {
        provBox.setModel(new DefaultComboBoxModel<>(data.provinces));
        gradeListBox.setModel(new DefaultComboBoxModel<>(data.grades));
        genderBox.setModel(new DefaultComboBoxModel<>(data.genders));
        gradeBox.setModel(new DefaultComboBoxModel<>(data.grades));
        yearBox.setModel(new DefaultComboBoxModel<>(data.year));
        monthBox.setModel(new DefaultComboBoxModel<>(data.month));
        dayBox.setModel(new DefaultComboBoxModel<>(data.day));

        courseArray.add(course1);
        courseArray.add(course2);
        courseArray.add(course3);
        courseArray.add(course4);
        courseArray.add(course5);
        courseArray.add(course6);
        courseArray.add(course7);
        courseArray.add(course8);

        setEditable(false);

        data.initData();

        initStudentList();

        for (int i = 0; i < data.keys.size(); i++) {
            String key = data.keys.get(i);
            String courses[] = data.courses.get(key).split("/");
            String totalCourses = "";
            for (int j = 0; j < courses.length; j += 2) {
                int course = Integer.parseInt(courses[j]);
                if (course >= 1) {
                    switch (data.grade.get(key)) {
                        case 1:
                            totalCourses += data.course9Keys.get(course);
                            break;
                        case 2:
                            totalCourses += data.course10Keys.get(course);
                            break;
                        case 3:
                            totalCourses += data.course11Keys.get(course);
                            break;
                        case 4:
                            totalCourses += data.course12Keys.get(course);
                            break;
                    }
                    String courseMark = String.format("%03d", Integer.parseInt(courses[j + 1]));
                    totalCourses += courseMark;
                } else {
                    if (j % 2 == 0) {
                        totalCourses += "         ";
                    }
                }
            }

            tmpStudentList.add(totalCourses + data.age.get(key) + "" + data.grade.get(key) + key);
            System.out.println();
        }

        clearFields();
    }

    public int calculateAverage() {
        int total = 0;
        int numClasses = 0;
        for (int i = 0; i < coursesInt.length; i += 2) {
            if (coursesInt[i] != 0) {
                numClasses++;
                total += coursesInt[i + 1];
            }
        }

        if (numClasses > 0)
            return ((total + numClasses - 1) / numClasses);
        else
            return 0;
    }

    public void run() throws IOException {
        init();
        removeBorders();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("STUDENT REPORT");
        ImageIcon icon = new ImageIcon("src\\me\\Jack\\CPT\\northpic.jpg");
        frame.setIconImage(icon.getImage());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
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
        panel = new JPanel();
        panel.setLayout(new GridLayoutManager(12, 13, new Insets(0, 0, 0, 0), -1, -1));
        panel.setBackground(new Color(-16763815));
        panel.setForeground(new Color(-16763815));
        firstNameLabel = new JLabel();
        firstNameLabel.setBackground(new Color(-1));
        Font firstNameLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, firstNameLabel.getFont());
        if (firstNameLabelFont != null) firstNameLabel.setFont(firstNameLabelFont);
        firstNameLabel.setForeground(new Color(-1));
        firstNameLabel.setHorizontalAlignment(10);
        firstNameLabel.setHorizontalTextPosition(11);
        firstNameLabel.setText("FIRST NAME");
        panel.add(firstNameLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        firstNameField = new JTextField();
        firstNameField.setBackground(new Color(-16744793));
        Font firstNameFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, firstNameField.getFont());
        if (firstNameFieldFont != null) firstNameField.setFont(firstNameFieldFont);
        firstNameField.setForeground(new Color(-1));
        firstNameField.setInheritsPopupMenu(false);
        firstNameField.setMargin(new Insets(2, 5, 2, 5));
        firstNameField.setText("");
        panel.add(firstNameField, new GridConstraints(0, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lastNameLabel = new JLabel();
        lastNameLabel.setBackground(new Color(-1));
        Font lastNameLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, lastNameLabel.getFont());
        if (lastNameLabelFont != null) lastNameLabel.setFont(lastNameLabelFont);
        lastNameLabel.setForeground(new Color(-1));
        lastNameLabel.setText("LAST NAME");
        panel.add(lastNameLabel, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lastNameField = new JTextField();
        lastNameField.setBackground(new Color(-16744793));
        Font lastNameFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, lastNameField.getFont());
        if (lastNameFieldFont != null) lastNameField.setFont(lastNameFieldFont);
        lastNameField.setForeground(new Color(-1));
        panel.add(lastNameField, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        streetAddressLabel = new JLabel();
        streetAddressLabel.setBackground(new Color(-1));
        streetAddressLabel.setEnabled(true);
        Font streetAddressLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, streetAddressLabel.getFont());
        if (streetAddressLabelFont != null) streetAddressLabel.setFont(streetAddressLabelFont);
        streetAddressLabel.setForeground(new Color(-1));
        streetAddressLabel.setText("STREET ADDRESS");
        panel.add(streetAddressLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cityLabel = new JLabel();
        cityLabel.setBackground(new Color(-1));
        Font cityLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, cityLabel.getFont());
        if (cityLabelFont != null) cityLabel.setFont(cityLabelFont);
        cityLabel.setForeground(new Color(-1));
        cityLabel.setText("CITY");
        panel.add(cityLabel, new GridConstraints(1, 5, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addressField = new JTextField();
        addressField.setBackground(new Color(-16744793));
        Font addressFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, addressField.getFont());
        if (addressFieldFont != null) addressField.setFont(addressFieldFont);
        addressField.setForeground(new Color(-1));
        panel.add(addressField, new GridConstraints(1, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        cityField = new JTextField();
        cityField.setBackground(new Color(-16744793));
        Font cityFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, cityField.getFont());
        if (cityFieldFont != null) cityField.setFont(cityFieldFont);
        cityField.setForeground(new Color(-1));
        panel.add(cityField, new GridConstraints(1, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        provinceLabel = new JLabel();
        provinceLabel.setBackground(new Color(-1));
        provinceLabel.setEnabled(true);
        Font provinceLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, provinceLabel.getFont());
        if (provinceLabelFont != null) provinceLabel.setFont(provinceLabelFont);
        provinceLabel.setForeground(new Color(-1));
        provinceLabel.setText("PROVINCE");
        panel.add(provinceLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        postalCodeLabel = new JLabel();
        postalCodeLabel.setBackground(new Color(-1));
        Font postalCodeLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, postalCodeLabel.getFont());
        if (postalCodeLabelFont != null) postalCodeLabel.setFont(postalCodeLabelFont);
        postalCodeLabel.setForeground(new Color(-1));
        postalCodeLabel.setText("POSTAL CODE");
        panel.add(postalCodeLabel, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        postalField = new JTextField();
        postalField.setBackground(new Color(-16744793));
        Font postalFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, postalField.getFont());
        if (postalFieldFont != null) postalField.setFont(postalFieldFont);
        postalField.setForeground(new Color(-1));
        panel.add(postalField, new GridConstraints(2, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        studentNumberLabel = new JLabel();
        studentNumberLabel.setBackground(new Color(-1));
        studentNumberLabel.setEnabled(true);
        Font studentNumberLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, studentNumberLabel.getFont());
        if (studentNumberLabelFont != null) studentNumberLabel.setFont(studentNumberLabelFont);
        studentNumberLabel.setForeground(new Color(-1));
        studentNumberLabel.setText("STUDENT NUMBER");
        panel.add(studentNumberLabel, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        homePhoneNumberLabel = new JLabel();
        homePhoneNumberLabel.setBackground(new Color(-1));
        Font homePhoneNumberLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, homePhoneNumberLabel.getFont());
        if (homePhoneNumberLabelFont != null) homePhoneNumberLabel.setFont(homePhoneNumberLabelFont);
        homePhoneNumberLabel.setForeground(new Color(-1));
        homePhoneNumberLabel.setText("        HOME PHONE #");
        panel.add(homePhoneNumberLabel, new GridConstraints(3, 5, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dateOfBirthLabel = new JLabel();
        dateOfBirthLabel.setBackground(new Color(-1));
        dateOfBirthLabel.setEnabled(true);
        Font dateOfBirthLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, dateOfBirthLabel.getFont());
        if (dateOfBirthLabelFont != null) dateOfBirthLabel.setFont(dateOfBirthLabelFont);
        dateOfBirthLabel.setForeground(new Color(-1));
        dateOfBirthLabel.setText("DATE OF BIRTH");
        panel.add(dateOfBirthLabel, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genderLabel = new JLabel();
        genderLabel.setBackground(new Color(-1));
        genderLabel.setEnabled(true);
        Font genderLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, genderLabel.getFont());
        if (genderLabelFont != null) genderLabel.setFont(genderLabelFont);
        genderLabel.setForeground(new Color(-1));
        genderLabel.setText("GENDER");
        panel.add(genderLabel, new GridConstraints(4, 5, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gradeLabel = new JLabel();
        gradeLabel.setBackground(new Color(-1));
        Font gradeLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, gradeLabel.getFont());
        if (gradeLabelFont != null) gradeLabel.setFont(gradeLabelFont);
        gradeLabel.setForeground(new Color(-1));
        gradeLabel.setText("GRADE");
        panel.add(gradeLabel, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(36, 25), null, 0, false));
        ageLabel = new JLabel();
        ageLabel.setBackground(new Color(-1));
        Font ageLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, ageLabel.getFont());
        if (ageLabelFont != null) ageLabel.setFont(ageLabelFont);
        ageLabel.setForeground(new Color(-1));
        ageLabel.setText("AGE");
        panel.add(ageLabel, new GridConstraints(5, 5, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(21, 25), null, 0, false));
        phoneField = new JTextField();
        phoneField.setBackground(new Color(-16744793));
        Font phoneFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, phoneField.getFont());
        if (phoneFieldFont != null) phoneField.setFont(phoneFieldFont);
        phoneField.setForeground(new Color(-1));
        panel.add(phoneField, new GridConstraints(3, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        ageField = new JTextField();
        ageField.setBackground(new Color(-16744793));
        Font ageFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, ageField.getFont());
        if (ageFieldFont != null) ageField.setFont(ageFieldFont);
        ageField.setForeground(new Color(-1));
        panel.add(ageField, new GridConstraints(5, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 25), null, 0, false));
        studentNumField = new JTextField();
        studentNumField.setBackground(new Color(-16744793));
        Font studentNumFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, studentNumField.getFont());
        if (studentNumFieldFont != null) studentNumField.setFont(studentNumFieldFont);
        studentNumField.setForeground(new Color(-1));
        studentNumField.setSelectionEnd(0);
        panel.add(studentNumField, new GridConstraints(3, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        courseBox2 = new JComboBox();
        courseBox2.setBackground(new Color(-16733976));
        Font courseBox2Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, courseBox2.getFont());
        if (courseBox2Font != null) courseBox2.setFont(courseBox2Font);
        courseBox2.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("COURSE");
        courseBox2.setModel(defaultComboBoxModel1);
        courseBox2.setRequestFocusEnabled(true);
        panel.add(courseBox2, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseBox6 = new JComboBox();
        courseBox6.setBackground(new Color(-16733976));
        Font courseBox6Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, courseBox6.getFont());
        if (courseBox6Font != null) courseBox6.setFont(courseBox6Font);
        courseBox6.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("COURSE");
        courseBox6.setModel(defaultComboBoxModel2);
        courseBox6.setRequestFocusEnabled(true);
        panel.add(courseBox6, new GridConstraints(7, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        course6Field = new JTextField();
        course6Field.setBackground(new Color(-16744793));
        Font course6FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course6Field.getFont());
        if (course6FieldFont != null) course6Field.setFont(course6FieldFont);
        course6Field.setForeground(new Color(-1));
        panel.add(course6Field, new GridConstraints(7, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        course7Field = new JTextField();
        course7Field.setBackground(new Color(-16744793));
        Font course7FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course7Field.getFont());
        if (course7FieldFont != null) course7Field.setFont(course7FieldFont);
        course7Field.setForeground(new Color(-1));
        panel.add(course7Field, new GridConstraints(8, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        course8Field = new JTextField();
        course8Field.setBackground(new Color(-16744793));
        Font course8FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course8Field.getFont());
        if (course8FieldFont != null) course8Field.setFont(course8FieldFont);
        course8Field.setForeground(new Color(-1));
        panel.add(course8Field, new GridConstraints(9, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        SAVEButton = new JButton();
        SAVEButton.setBackground(new Color(-16733976));
        Font SAVEButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, SAVEButton.getFont());
        if (SAVEButtonFont != null) SAVEButton.setFont(SAVEButtonFont);
        SAVEButton.setForeground(new Color(-1));
        SAVEButton.setRequestFocusEnabled(false);
        SAVEButton.setText("SAVE");
        panel.add(SAVEButton, new GridConstraints(10, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        NEXTButton = new JButton();
        NEXTButton.setBackground(new Color(-16733976));
        NEXTButton.setEnabled(true);
        Font NEXTButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, NEXTButton.getFont());
        if (NEXTButtonFont != null) NEXTButton.setFont(NEXTButtonFont);
        NEXTButton.setForeground(new Color(-1));
        NEXTButton.setRequestFocusEnabled(false);
        NEXTButton.setText("NEXT");
        panel.add(NEXTButton, new GridConstraints(11, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseBox8 = new JComboBox();
        courseBox8.setBackground(new Color(-16733976));
        Font courseBox8Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, courseBox8.getFont());
        if (courseBox8Font != null) courseBox8.setFont(courseBox8Font);
        courseBox8.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("COURSE");
        courseBox8.setModel(defaultComboBoxModel3);
        courseBox8.setRequestFocusEnabled(true);
        panel.add(courseBox8, new GridConstraints(9, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        EDITButton = new JButton();
        EDITButton.setBackground(new Color(-16733976));
        Font EDITButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, EDITButton.getFont());
        if (EDITButtonFont != null) EDITButton.setFont(EDITButtonFont);
        EDITButton.setForeground(new Color(-1));
        EDITButton.setRequestFocusEnabled(false);
        EDITButton.setText("EDIT");
        panel.add(EDITButton, new GridConstraints(10, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        course3Field = new JTextField();
        course3Field.setBackground(new Color(-16744793));
        Font course3FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course3Field.getFont());
        if (course3FieldFont != null) course3Field.setFont(course3FieldFont);
        course3Field.setForeground(new Color(-1));
        panel.add(course3Field, new GridConstraints(8, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        courseBox3 = new JComboBox();
        courseBox3.setBackground(new Color(-16733976));
        Font courseBox3Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, courseBox3.getFont());
        if (courseBox3Font != null) courseBox3.setFont(courseBox3Font);
        courseBox3.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("COURSE");
        courseBox3.setModel(defaultComboBoxModel4);
        courseBox3.setRequestFocusEnabled(true);
        panel.add(courseBox3, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseBox4 = new JComboBox();
        courseBox4.setBackground(new Color(-16733976));
        Font courseBox4Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, courseBox4.getFont());
        if (courseBox4Font != null) courseBox4.setFont(courseBox4Font);
        courseBox4.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel5 = new DefaultComboBoxModel();
        defaultComboBoxModel5.addElement("COURSE");
        courseBox4.setModel(defaultComboBoxModel5);
        courseBox4.setRequestFocusEnabled(true);
        panel.add(courseBox4, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        course4Field = new JTextField();
        course4Field.setBackground(new Color(-16744793));
        Font course4FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course4Field.getFont());
        if (course4FieldFont != null) course4Field.setFont(course4FieldFont);
        course4Field.setForeground(new Color(-1));
        panel.add(course4Field, new GridConstraints(9, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        avgLabel = new JLabel();
        avgLabel.setBackground(new Color(-1));
        Font avgLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, avgLabel.getFont());
        if (avgLabelFont != null) avgLabel.setFont(avgLabelFont);
        avgLabel.setForeground(new Color(-1));
        avgLabel.setText("AVERAGE");
        panel.add(avgLabel, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        course5Field = new JTextField();
        course5Field.setBackground(new Color(-16744793));
        Font course5FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course5Field.getFont());
        if (course5FieldFont != null) course5Field.setFont(course5FieldFont);
        course5Field.setForeground(new Color(-1));
        panel.add(course5Field, new GridConstraints(6, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        course1Field = new JTextField();
        course1Field.setBackground(new Color(-16744793));
        Font course1FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course1Field.getFont());
        if (course1FieldFont != null) course1Field.setFont(course1FieldFont);
        course1Field.setForeground(new Color(-1));
        panel.add(course1Field, new GridConstraints(6, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        courseBox5 = new JComboBox();
        courseBox5.setBackground(new Color(-16733976));
        Font courseBox5Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, courseBox5.getFont());
        if (courseBox5Font != null) courseBox5.setFont(courseBox5Font);
        courseBox5.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel6 = new DefaultComboBoxModel();
        defaultComboBoxModel6.addElement("COURSE");
        courseBox5.setModel(defaultComboBoxModel6);
        courseBox5.setRequestFocusEnabled(true);
        panel.add(courseBox5, new GridConstraints(6, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseBox1 = new JComboBox();
        courseBox1.setBackground(new Color(-16733976));
        Font courseBox1Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, courseBox1.getFont());
        if (courseBox1Font != null) courseBox1.setFont(courseBox1Font);
        courseBox1.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel7 = new DefaultComboBoxModel();
        defaultComboBoxModel7.addElement("COURSE");
        courseBox1.setModel(defaultComboBoxModel7);
        courseBox1.setRequestFocusEnabled(true);
        panel.add(courseBox1, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        course2Field = new JTextField();
        course2Field.setBackground(new Color(-16744793));
        Font course2FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course2Field.getFont());
        if (course2FieldFont != null) course2Field.setFont(course2FieldFont);
        course2Field.setForeground(new Color(-1));
        panel.add(course2Field, new GridConstraints(7, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        PREVButton = new JButton();
        PREVButton.setBackground(new Color(-16733976));
        PREVButton.setEnabled(true);
        Font PREVButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, PREVButton.getFont());
        if (PREVButtonFont != null) PREVButton.setFont(PREVButtonFont);
        PREVButton.setForeground(new Color(-1));
        PREVButton.setOpaque(true);
        PREVButton.setRequestFocusEnabled(false);
        PREVButton.setText("PREV");
        panel.add(PREVButton, new GridConstraints(11, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseBox7 = new JComboBox();
        courseBox7.setBackground(new Color(-16733976));
        Font courseBox7Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, courseBox7.getFont());
        if (courseBox7Font != null) courseBox7.setFont(courseBox7Font);
        courseBox7.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel8 = new DefaultComboBoxModel();
        defaultComboBoxModel8.addElement("COURSE");
        courseBox7.setModel(defaultComboBoxModel8);
        courseBox7.setRequestFocusEnabled(true);
        panel.add(courseBox7, new GridConstraints(8, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        yearBox = new JComboBox();
        yearBox.setBackground(new Color(-16744793));
        yearBox.setFocusable(false);
        Font yearBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, yearBox.getFont());
        if (yearBoxFont != null) yearBox.setFont(yearBoxFont);
        yearBox.setForeground(new Color(-1));
        yearBox.setRequestFocusEnabled(true);
        panel.add(yearBox, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, 25), new Dimension(80, 25), new Dimension(80, 25), 0, false));
        gradeBox = new JComboBox();
        gradeBox.setBackground(new Color(-16744793));
        gradeBox.setEnabled(true);
        gradeBox.setFocusable(false);
        Font gradeBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, gradeBox.getFont());
        if (gradeBoxFont != null) gradeBox.setFont(gradeBoxFont);
        gradeBox.setForeground(new Color(-1));
        gradeBox.setRequestFocusEnabled(true);
        panel.add(gradeBox, new GridConstraints(5, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(91, 25), null, 0, false));
        provBox = new JComboBox();
        provBox.setBackground(new Color(-16744793));
        provBox.setEditable(false);
        provBox.setEnabled(true);
        provBox.setFocusable(false);
        Font provBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, provBox.getFont());
        if (provBoxFont != null) provBox.setFont(provBoxFont);
        provBox.setForeground(new Color(-1));
        provBox.setRequestFocusEnabled(true);
        panel.add(provBox, new GridConstraints(2, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genderBox = new JComboBox();
        genderBox.setBackground(new Color(-16744793));
        genderBox.setFocusable(false);
        Font genderBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, genderBox.getFont());
        if (genderBoxFont != null) genderBox.setFont(genderBoxFont);
        genderBox.setForeground(new Color(-1));
        genderBox.setRequestFocusEnabled(true);
        panel.add(genderBox, new GridConstraints(4, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel.add(spacer1, new GridConstraints(0, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, new Dimension(50, 4), new Dimension(4, 4), new Dimension(50, 4), 0, false));
        searchField = new JTextField();
        searchField.setBackground(new Color(-16744793));
        Font searchFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, searchField.getFont());
        if (searchFieldFont != null) searchField.setFont(searchFieldFont);
        searchField.setForeground(new Color(-1));
        panel.add(searchField, new GridConstraints(1, 8, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-1));
        Font label1Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-1));
        label1.setText("SURNAME OR STUDENT #");
        panel.add(label1, new GridConstraints(0, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dayBox = new JComboBox();
        dayBox.setBackground(new Color(-16744793));
        dayBox.setFocusable(false);
        Font dayBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, dayBox.getFont());
        if (dayBoxFont != null) dayBox.setFont(dayBoxFont);
        dayBox.setForeground(new Color(-1));
        dayBox.setRequestFocusEnabled(true);
        panel.add(dayBox, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(60, 25), new Dimension(60, 25), new Dimension(60, 25), 0, false));
        monthBox = new JComboBox();
        monthBox.setBackground(new Color(-16744793));
        monthBox.setFocusable(false);
        Font monthBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, monthBox.getFont());
        if (monthBoxFont != null) monthBox.setFont(monthBoxFont);
        monthBox.setForeground(new Color(-1));
        monthBox.setRequestFocusEnabled(true);
        panel.add(monthBox, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(60, 25), new Dimension(50, 25), new Dimension(60, 25), 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        Font scrollPane1Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, scrollPane1.getFont());
        if (scrollPane1Font != null) scrollPane1.setFont(scrollPane1Font);
        scrollPane1.setForeground(new Color(-1));
        panel.add(scrollPane1, new GridConstraints(2, 8, 10, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(200, 300), null, null, 0, false));
        studentList = new JList();
        studentList.setBackground(new Color(-16744793));
        studentList.setEnabled(true);
        Font studentListFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, studentList.getFont());
        if (studentListFont != null) studentList.setFont(studentListFont);
        studentList.setForeground(new Color(-1));
        studentList.setSelectionBackground(new Color(-16733976));
        scrollPane1.setViewportView(studentList);
        ADDButton = new JButton();
        ADDButton.setBackground(new Color(-16733976));
        Font ADDButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, ADDButton.getFont());
        if (ADDButtonFont != null) ADDButton.setFont(ADDButtonFont);
        ADDButton.setForeground(new Color(-1));
        ADDButton.setRequestFocusEnabled(false);
        ADDButton.setText("ADD");
        panel.add(ADDButton, new GridConstraints(11, 9, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseListBox = new JComboBox();
        courseListBox.setBackground(new Color(-16733976));
        courseListBox.setFocusable(false);
        Font courseListBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, courseListBox.getFont());
        if (courseListBoxFont != null) courseListBox.setFont(courseListBoxFont);
        courseListBox.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel9 = new DefaultComboBoxModel();
        defaultComboBoxModel9.addElement("COURSE");
        courseListBox.setModel(defaultComboBoxModel9);
        panel.add(courseListBox, new GridConstraints(6, 9, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(98, 25), null, 0, false));
        gradeListBox = new JComboBox();
        gradeListBox.setBackground(new Color(-16733976));
        gradeListBox.setFocusable(false);
        Font gradeListBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, gradeListBox.getFont());
        if (gradeListBoxFont != null) gradeListBox.setFont(gradeListBoxFont);
        gradeListBox.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel10 = new DefaultComboBoxModel();
        defaultComboBoxModel10.addElement("Grade");
        gradeListBox.setModel(defaultComboBoxModel10);
        panel.add(gradeListBox, new GridConstraints(5, 9, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        AGERadioButton = new JRadioButton();
        AGERadioButton.setBackground(new Color(-16763815));
        AGERadioButton.setFocusable(false);
        Font AGERadioButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, AGERadioButton.getFont());
        if (AGERadioButtonFont != null) AGERadioButton.setFont(AGERadioButtonFont);
        AGERadioButton.setForeground(new Color(-1));
        AGERadioButton.setRequestFocusEnabled(false);
        AGERadioButton.setText("AGE");
        panel.add(AGERadioButton, new GridConstraints(4, 9, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        GRADESRadioButton = new JRadioButton();
        GRADESRadioButton.setBackground(new Color(-16763815));
        Font GRADESRadioButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, GRADESRadioButton.getFont());
        if (GRADESRadioButtonFont != null) GRADESRadioButton.setFont(GRADESRadioButtonFont);
        GRADESRadioButton.setForeground(new Color(-1));
        GRADESRadioButton.setRequestFocusEnabled(false);
        GRADESRadioButton.setText("GRADES");
        panel.add(GRADESRadioButton, new GridConstraints(3, 9, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ALPHABETICALLYRadioButton = new JRadioButton();
        ALPHABETICALLYRadioButton.setBackground(new Color(-16763815));
        ALPHABETICALLYRadioButton.setFocusable(false);
        Font ALPHABETICALLYRadioButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, ALPHABETICALLYRadioButton.getFont());
        if (ALPHABETICALLYRadioButtonFont != null) ALPHABETICALLYRadioButton.setFont(ALPHABETICALLYRadioButtonFont);
        ALPHABETICALLYRadioButton.setForeground(new Color(-1));
        ALPHABETICALLYRadioButton.setRequestFocusEnabled(false);
        ALPHABETICALLYRadioButton.setText("ALPHABETICALLY");
        panel.add(ALPHABETICALLYRadioButton, new GridConstraints(2, 9, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SEARCHButton = new JButton();
        SEARCHButton.setBackground(new Color(-16733976));
        Font SEARCHButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, SEARCHButton.getFont());
        if (SEARCHButtonFont != null) SEARCHButton.setFont(SEARCHButtonFont);
        SEARCHButton.setForeground(new Color(-1));
        SEARCHButton.setRequestFocusEnabled(false);
        SEARCHButton.setText("SEARCH");
        panel.add(SEARCHButton, new GridConstraints(1, 9, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setBackground(new Color(-1));
        Font label2Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-1));
        label2.setText("MAX GRADE");
        panel.add(label2, new GridConstraints(7, 9, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        maxField = new JTextField();
        maxField.setBackground(new Color(-16744793));
        maxField.setFocusCycleRoot(true);
        Font maxFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, maxField.getFont());
        if (maxFieldFont != null) maxField.setFont(maxFieldFont);
        maxField.setForeground(new Color(-1));
        panel.add(maxField, new GridConstraints(7, 10, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setBackground(new Color(-1));
        Font label3Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-1));
        label3.setText("MIN GRADE");
        panel.add(label3, new GridConstraints(8, 9, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        minField = new JTextField();
        minField.setBackground(new Color(-16744793));
        Font minFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, minField.getFont());
        if (minFieldFont != null) minField.setFont(minFieldFont);
        minField.setForeground(new Color(-1));
        panel.add(minField, new GridConstraints(8, 10, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        grade9RadioButton = new JRadioButton();
        grade9RadioButton.setBackground(new Color(-16763815));
        Font grade9RadioButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, grade9RadioButton.getFont());
        if (grade9RadioButtonFont != null) grade9RadioButton.setFont(grade9RadioButtonFont);
        grade9RadioButton.setForeground(new Color(-1));
        grade9RadioButton.setText("Grade 9");
        panel.add(grade9RadioButton, new GridConstraints(9, 9, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        grade11RadioButton = new JRadioButton();
        grade11RadioButton.setBackground(new Color(-16763815));
        Font grade11RadioButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, grade11RadioButton.getFont());
        if (grade11RadioButtonFont != null) grade11RadioButton.setFont(grade11RadioButtonFont);
        grade11RadioButton.setForeground(new Color(-1));
        grade11RadioButton.setText("Grade 11");
        panel.add(grade11RadioButton, new GridConstraints(9, 10, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        grade10RadioButton = new JRadioButton();
        grade10RadioButton.setBackground(new Color(-16763815));
        Font grade10RadioButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, grade10RadioButton.getFont());
        if (grade10RadioButtonFont != null) grade10RadioButton.setFont(grade10RadioButtonFont);
        grade10RadioButton.setForeground(new Color(-1));
        grade10RadioButton.setText("Grade 10");
        panel.add(grade10RadioButton, new GridConstraints(10, 9, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        grade12RadioButton = new JRadioButton();
        grade12RadioButton.setBackground(new Color(-16763815));
        Font grade12RadioButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, grade12RadioButton.getFont());
        if (grade12RadioButtonFont != null) grade12RadioButton.setFont(grade12RadioButtonFont);
        grade12RadioButton.setForeground(new Color(-1));
        grade12RadioButton.setText("Grade 12");
        panel.add(grade12RadioButton, new GridConstraints(10, 10, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DELETESTUDENTButton = new JButton();
        DELETESTUDENTButton.setBackground(new Color(-16733976));
        Font DELETESTUDENTButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, DELETESTUDENTButton.getFont());
        if (DELETESTUDENTButtonFont != null) DELETESTUDENTButton.setFont(DELETESTUDENTButtonFont);
        DELETESTUDENTButton.setForeground(new Color(-1));
        DELETESTUDENTButton.setText("DELETE STUDENT");
        panel.add(DELETESTUDENTButton, new GridConstraints(11, 2, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, 18, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-1));
        label4.setText("COURSE CREATOR");
        panel.add(label4, new GridConstraints(0, 12, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setEnabled(true);
        Font label5Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setForeground(new Color(-1));
        label5.setText("3 LETTER IDENTIFIER");
        panel.add(label5, new GridConstraints(1, 12, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        CourseIDField = new JTextField();
        CourseIDField.setBackground(new Color(-16744793));
        CourseIDField.setEnabled(true);
        Font CourseIDFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, CourseIDField.getFont());
        if (CourseIDFieldFont != null) CourseIDField.setFont(CourseIDFieldFont);
        CourseIDField.setForeground(new Color(-1));
        panel.add(CourseIDField, new GridConstraints(2, 12, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        CourseTypeBox = new JComboBox();
        CourseTypeBox.setBackground(new Color(-11358776));
        CourseTypeBox.setEnabled(true);
        Font CourseTypeBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, CourseTypeBox.getFont());
        if (CourseTypeBoxFont != null) CourseTypeBox.setFont(CourseTypeBoxFont);
        CourseTypeBox.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel11 = new DefaultComboBoxModel();
        defaultComboBoxModel11.addElement("UNIVERSITY");
        defaultComboBoxModel11.addElement("MIXED");
        defaultComboBoxModel11.addElement("OPEN");
        CourseTypeBox.setModel(defaultComboBoxModel11);
        CourseTypeBox.setRequestFocusEnabled(false);
        panel.add(CourseTypeBox, new GridConstraints(4, 12, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setForeground(new Color(-1));
        label6.setText("LEVEL OF COURSE");
        panel.add(label6, new GridConstraints(3, 12, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setEnabled(true);
        Font label7Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, label7.getFont());
        if (label7Font != null) label7.setFont(label7Font);
        label7.setForeground(new Color(-1));
        label7.setText("GRADE");
        panel.add(label7, new GridConstraints(5, 12, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        CourseGradeBox = new JComboBox();
        CourseGradeBox.setAutoscrolls(false);
        CourseGradeBox.setBackground(new Color(-11358776));
        CourseGradeBox.setEnabled(true);
        Font CourseGradeBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, CourseGradeBox.getFont());
        if (CourseGradeBoxFont != null) CourseGradeBox.setFont(CourseGradeBoxFont);
        CourseGradeBox.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel12 = new DefaultComboBoxModel();
        defaultComboBoxModel12.addElement("GRADE 9");
        defaultComboBoxModel12.addElement("GRADE 10");
        defaultComboBoxModel12.addElement("GRADE 11");
        defaultComboBoxModel12.addElement("GRADE 12");
        CourseGradeBox.setModel(defaultComboBoxModel12);
        panel.add(CourseGradeBox, new GridConstraints(6, 12, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        Font label8Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, label8.getFont());
        if (label8Font != null) label8.setFont(label8Font);
        label8.setForeground(new Color(-1));
        label8.setText("COURSE DESCRIPTION");
        panel.add(label8, new GridConstraints(7, 12, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        CourseDescArea = new JTextArea();
        CourseDescArea.setBackground(new Color(-16744793));
        CourseDescArea.setForeground(new Color(-1));
        CourseDescArea.setLineWrap(true);
        panel.add(CourseDescArea, new GridConstraints(8, 12, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        avgField = new JTextField();
        avgField.setBackground(new Color(-16744793));
        Font avgFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, avgField.getFont());
        if (avgFieldFont != null) avgField.setFont(avgFieldFont);
        avgField.setForeground(new Color(-1));
        panel.add(avgField, new GridConstraints(10, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        ADDCOURSEButton = new JButton();
        ADDCOURSEButton.setBackground(new Color(-16733976));
        Font ADDCOURSEButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, ADDCOURSEButton.getFont());
        if (ADDCOURSEButtonFont != null) ADDCOURSEButton.setFont(ADDCOURSEButtonFont);
        ADDCOURSEButton.setForeground(new Color(-1));
        ADDCOURSEButton.setText("ADD COURSE");
        panel.add(ADDCOURSEButton, new GridConstraints(11, 12, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel.add(spacer2, new GridConstraints(0, 11, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, new Dimension(50, 1), null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}
