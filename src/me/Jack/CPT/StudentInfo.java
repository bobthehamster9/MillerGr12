package me.Jack.CPT;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;

public class StudentInfo {

    int count;

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
    private JButton SELECTButton;
    private JRadioButton GRADESRadioButton;
    private JComboBox yearBox;
    private JComboBox gradeBox;
    private JComboBox provBox;
    private JComboBox genderBox;
    private JTextField maxField;
    private JTextField minField;
    private JComboBox dayBox;
    private JComboBox monthBox;

    String line;

    DefaultListModel listModel = new DefaultListModel();
    Data data = new Data();

    public void setEditable(boolean editable) {
        firstNameField.setEditable(editable);
        lastNameField.setEditable(editable);
        addressField.setEditable(editable);
        cityField.setEditable(editable);
        provBox.setEnabled(editable);
        postalField.setEditable(editable);
        studentNumField.setEditable(editable);
        phoneField.setEditable(editable);
        yearBox.setEnabled(editable);
        dayBox.setEnabled(editable);
        monthBox.setEnabled(editable);
        genderBox.setEnabled(editable);
        gradeBox.setEnabled(editable);
        ageField.setEditable(editable);
    }

    public StudentInfo() {
        studentList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    Object selected_row = ((JList) e.getSource()).getSelectedValue();
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
                    setEditable(false);
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
    }

    public void initStudentList() throws IOException {
        data.initData();
        for (int i = 0; i < data.keys.size(); i++) {
            listModel.addElement(data.keys.get(i));
        }
    }

    public void init() throws IOException {
        provBox.setModel(new DefaultComboBoxModel<String>(data.provinces));
        gradeListBox.setModel(new DefaultComboBoxModel<String>(data.grades));
        genderBox.setModel(new DefaultComboBoxModel<String>(data.genders));
        gradeBox.setModel(new DefaultComboBoxModel<String>(data.grades));
        yearBox.setModel(new DefaultComboBoxModel<String>(data.year));
        monthBox.setModel(new DefaultComboBoxModel<String>(data.month));
        dayBox.setModel(new DefaultComboBoxModel<String>(data.day));


        setEditable(false);

        initStudentList();

        studentList.setModel(listModel);
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
        panel.setLayout(new GridLayoutManager(12, 11, new Insets(0, 0, 0, 0), -1, -1));
        panel.setBackground(new Color(-6795155));
        panel.setForeground(new Color(-13075293));
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
        firstNameField.setBackground(new Color(-3121058));
        Font firstNameFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, firstNameField.getFont());
        if (firstNameFieldFont != null) firstNameField.setFont(firstNameFieldFont);
        firstNameField.setForeground(new Color(-1));
        firstNameField.setInheritsPopupMenu(false);
        firstNameField.setMargin(new Insets(2, 6, 2, 6));
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
        lastNameField.setBackground(new Color(-3121058));
        Font lastNameFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, lastNameField.getFont());
        if (lastNameFieldFont != null) lastNameField.setFont(lastNameFieldFont);
        lastNameField.setForeground(new Color(-1837313));
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
        addressField.setBackground(new Color(-3121058));
        Font addressFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, addressField.getFont());
        if (addressFieldFont != null) addressField.setFont(addressFieldFont);
        addressField.setForeground(new Color(-1));
        panel.add(addressField, new GridConstraints(1, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        cityField = new JTextField();
        cityField.setBackground(new Color(-3121058));
        Font cityFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, cityField.getFont());
        if (cityFieldFont != null) cityField.setFont(cityFieldFont);
        cityField.setForeground(new Color(-1837313));
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
        postalField.setBackground(new Color(-3121058));
        Font postalFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, postalField.getFont());
        if (postalFieldFont != null) postalField.setFont(postalFieldFont);
        postalField.setForeground(new Color(-1837313));
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
        phoneField.setBackground(new Color(-3121058));
        Font phoneFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, phoneField.getFont());
        if (phoneFieldFont != null) phoneField.setFont(phoneFieldFont);
        phoneField.setForeground(new Color(-1837313));
        panel.add(phoneField, new GridConstraints(3, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        ageField = new JTextField();
        ageField.setBackground(new Color(-3121058));
        Font ageFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, ageField.getFont());
        if (ageFieldFont != null) ageField.setFont(ageFieldFont);
        ageField.setForeground(new Color(-1837313));
        panel.add(ageField, new GridConstraints(5, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 25), null, 0, false));
        studentNumField = new JTextField();
        studentNumField.setBackground(new Color(-3121058));
        Font studentNumFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, studentNumField.getFont());
        if (studentNumFieldFont != null) studentNumField.setFont(studentNumFieldFont);
        studentNumField.setForeground(new Color(-1));
        studentNumField.setSelectionEnd(0);
        panel.add(studentNumField, new GridConstraints(3, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        studentList = new JList();
        studentList.setBackground(new Color(-3121058));
        studentList.setEnabled(true);
        Font studentListFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, studentList.getFont());
        if (studentListFont != null) studentList.setFont(studentListFont);
        studentList.setForeground(new Color(-1));
        studentList.setSelectionBackground(new Color(-26292));
        panel.add(studentList, new GridConstraints(2, 8, 10, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        SEARCHButton = new JButton();
        SEARCHButton.setBackground(new Color(-26292));
        Font SEARCHButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, SEARCHButton.getFont());
        if (SEARCHButtonFont != null) SEARCHButton.setFont(SEARCHButtonFont);
        SEARCHButton.setForeground(new Color(-1));
        SEARCHButton.setRequestFocusEnabled(false);
        SEARCHButton.setText("SEARCH");
        panel.add(SEARCHButton, new GridConstraints(0, 9, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ALPHABETICALLYRadioButton = new JRadioButton();
        ALPHABETICALLYRadioButton.setBackground(new Color(-6795155));
        ALPHABETICALLYRadioButton.setFocusable(false);
        Font ALPHABETICALLYRadioButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, ALPHABETICALLYRadioButton.getFont());
        if (ALPHABETICALLYRadioButtonFont != null) ALPHABETICALLYRadioButton.setFont(ALPHABETICALLYRadioButtonFont);
        ALPHABETICALLYRadioButton.setForeground(new Color(-1));
        ALPHABETICALLYRadioButton.setRequestFocusEnabled(false);
        ALPHABETICALLYRadioButton.setText("ALPHABETICALLY");
        panel.add(ALPHABETICALLYRadioButton, new GridConstraints(1, 9, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        AGERadioButton = new JRadioButton();
        AGERadioButton.setBackground(new Color(-6795155));
        AGERadioButton.setFocusable(false);
        Font AGERadioButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, AGERadioButton.getFont());
        if (AGERadioButtonFont != null) AGERadioButton.setFont(AGERadioButtonFont);
        AGERadioButton.setForeground(new Color(-1));
        AGERadioButton.setRequestFocusEnabled(false);
        AGERadioButton.setText("AGE");
        panel.add(AGERadioButton, new GridConstraints(3, 9, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseBox2 = new JComboBox();
        courseBox2.setBackground(new Color(-26292));
        courseBox2.setForeground(new Color(-1));
        courseBox2.setRequestFocusEnabled(false);
        panel.add(courseBox2, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseBox6 = new JComboBox();
        courseBox6.setBackground(new Color(-26292));
        courseBox6.setForeground(new Color(-1));
        courseBox6.setRequestFocusEnabled(false);
        panel.add(courseBox6, new GridConstraints(7, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        course6Field = new JTextField();
        course6Field.setBackground(new Color(-3121058));
        Font course6FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course6Field.getFont());
        if (course6FieldFont != null) course6Field.setFont(course6FieldFont);
        course6Field.setForeground(new Color(-1837313));
        panel.add(course6Field, new GridConstraints(7, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        ADDButton = new JButton();
        ADDButton.setBackground(new Color(-26292));
        Font ADDButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, ADDButton.getFont());
        if (ADDButtonFont != null) ADDButton.setFont(ADDButtonFont);
        ADDButton.setForeground(new Color(-1));
        ADDButton.setRequestFocusEnabled(false);
        ADDButton.setText("ADD");
        panel.add(ADDButton, new GridConstraints(10, 9, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        course7Field = new JTextField();
        course7Field.setBackground(new Color(-3121058));
        Font course7FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course7Field.getFont());
        if (course7FieldFont != null) course7Field.setFont(course7FieldFont);
        course7Field.setForeground(new Color(-1837313));
        panel.add(course7Field, new GridConstraints(8, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        course8Field = new JTextField();
        course8Field.setBackground(new Color(-3121058));
        Font course8FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course8Field.getFont());
        if (course8FieldFont != null) course8Field.setFont(course8FieldFont);
        course8Field.setForeground(new Color(-1837313));
        panel.add(course8Field, new GridConstraints(9, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        SAVEButton = new JButton();
        SAVEButton.setBackground(new Color(-26292));
        Font SAVEButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, SAVEButton.getFont());
        if (SAVEButtonFont != null) SAVEButton.setFont(SAVEButtonFont);
        SAVEButton.setForeground(new Color(-1));
        SAVEButton.setRequestFocusEnabled(false);
        SAVEButton.setText("SAVE");
        panel.add(SAVEButton, new GridConstraints(10, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        NEXTButton = new JButton();
        NEXTButton.setBackground(new Color(-26292));
        NEXTButton.setEnabled(true);
        Font NEXTButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, NEXTButton.getFont());
        if (NEXTButtonFont != null) NEXTButton.setFont(NEXTButtonFont);
        NEXTButton.setForeground(new Color(-1));
        NEXTButton.setRequestFocusEnabled(false);
        NEXTButton.setText("NEXT");
        panel.add(NEXTButton, new GridConstraints(11, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseBox8 = new JComboBox();
        courseBox8.setBackground(new Color(-26292));
        courseBox8.setForeground(new Color(-1));
        courseBox8.setRequestFocusEnabled(false);
        panel.add(courseBox8, new GridConstraints(9, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        EDITButton = new JButton();
        EDITButton.setBackground(new Color(-26292));
        Font EDITButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, EDITButton.getFont());
        if (EDITButtonFont != null) EDITButton.setFont(EDITButtonFont);
        EDITButton.setForeground(new Color(-1));
        EDITButton.setRequestFocusEnabled(false);
        EDITButton.setText("EDIT");
        panel.add(EDITButton, new GridConstraints(10, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        course3Field = new JTextField();
        course3Field.setBackground(new Color(-3121058));
        Font course3FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course3Field.getFont());
        if (course3FieldFont != null) course3Field.setFont(course3FieldFont);
        course3Field.setForeground(new Color(-1));
        panel.add(course3Field, new GridConstraints(8, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        courseBox3 = new JComboBox();
        courseBox3.setBackground(new Color(-26292));
        courseBox3.setForeground(new Color(-1));
        courseBox3.setRequestFocusEnabled(false);
        panel.add(courseBox3, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseBox4 = new JComboBox();
        courseBox4.setBackground(new Color(-26292));
        courseBox4.setForeground(new Color(-1));
        courseBox4.setRequestFocusEnabled(false);
        panel.add(courseBox4, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        course4Field = new JTextField();
        course4Field.setBackground(new Color(-3121058));
        Font course4FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course4Field.getFont());
        if (course4FieldFont != null) course4Field.setFont(course4FieldFont);
        course4Field.setForeground(new Color(-1));
        panel.add(course4Field, new GridConstraints(9, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        avgField = new JTextField();
        avgField.setBackground(new Color(-3121058));
        Font avgFieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, avgField.getFont());
        if (avgFieldFont != null) avgField.setFont(avgFieldFont);
        avgField.setForeground(new Color(-1));
        panel.add(avgField, new GridConstraints(10, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        avgLabel = new JLabel();
        avgLabel.setBackground(new Color(-1));
        Font avgLabelFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, avgLabel.getFont());
        if (avgLabelFont != null) avgLabel.setFont(avgLabelFont);
        avgLabel.setForeground(new Color(-1));
        avgLabel.setText("AVERAGE");
        panel.add(avgLabel, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        course5Field = new JTextField();
        course5Field.setBackground(new Color(-3121058));
        Font course5FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course5Field.getFont());
        if (course5FieldFont != null) course5Field.setFont(course5FieldFont);
        course5Field.setForeground(new Color(-1837313));
        panel.add(course5Field, new GridConstraints(6, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        course1Field = new JTextField();
        course1Field.setBackground(new Color(-3121058));
        Font course1FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course1Field.getFont());
        if (course1FieldFont != null) course1Field.setFont(course1FieldFont);
        course1Field.setForeground(new Color(-1));
        panel.add(course1Field, new GridConstraints(6, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        courseBox5 = new JComboBox();
        courseBox5.setBackground(new Color(-26292));
        Font courseBox5Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, courseBox5.getFont());
        if (courseBox5Font != null) courseBox5.setFont(courseBox5Font);
        courseBox5.setForeground(new Color(-1));
        courseBox5.setRequestFocusEnabled(false);
        panel.add(courseBox5, new GridConstraints(6, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseBox1 = new JComboBox();
        courseBox1.setBackground(new Color(-26292));
        courseBox1.setForeground(new Color(-1));
        courseBox1.setRequestFocusEnabled(false);
        panel.add(courseBox1, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        course2Field = new JTextField();
        course2Field.setBackground(new Color(-3121058));
        Font course2FieldFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, course2Field.getFont());
        if (course2FieldFont != null) course2Field.setFont(course2FieldFont);
        course2Field.setForeground(new Color(-1));
        panel.add(course2Field, new GridConstraints(7, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        PREVButton = new JButton();
        PREVButton.setBackground(new Color(-26292));
        PREVButton.setEnabled(true);
        Font PREVButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, PREVButton.getFont());
        if (PREVButtonFont != null) PREVButton.setFont(PREVButtonFont);
        PREVButton.setForeground(new Color(-1));
        PREVButton.setOpaque(true);
        PREVButton.setRequestFocusEnabled(false);
        PREVButton.setText("PREV");
        panel.add(PREVButton, new GridConstraints(11, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SELECTButton = new JButton();
        SELECTButton.setBackground(new Color(-26292));
        SELECTButton.setFocusable(false);
        Font SELECTButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, SELECTButton.getFont());
        if (SELECTButtonFont != null) SELECTButton.setFont(SELECTButtonFont);
        SELECTButton.setForeground(new Color(-1));
        SELECTButton.setText("SELECT");
        panel.add(SELECTButton, new GridConstraints(11, 9, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        GRADESRadioButton = new JRadioButton();
        GRADESRadioButton.setBackground(new Color(-6795155));
        Font GRADESRadioButtonFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, GRADESRadioButton.getFont());
        if (GRADESRadioButtonFont != null) GRADESRadioButton.setFont(GRADESRadioButtonFont);
        GRADESRadioButton.setForeground(new Color(-1));
        GRADESRadioButton.setRequestFocusEnabled(false);
        GRADESRadioButton.setText("GRADES");
        panel.add(GRADESRadioButton, new GridConstraints(2, 9, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseBox7 = new JComboBox();
        courseBox7.setBackground(new Color(-26292));
        Font courseBox7Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, courseBox7.getFont());
        if (courseBox7Font != null) courseBox7.setFont(courseBox7Font);
        courseBox7.setForeground(new Color(-1));
        courseBox7.setRequestFocusEnabled(false);
        panel.add(courseBox7, new GridConstraints(8, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        yearBox = new JComboBox();
        yearBox.setBackground(new Color(-3121058));
        yearBox.setFocusable(false);
        Font yearBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, yearBox.getFont());
        if (yearBoxFont != null) yearBox.setFont(yearBoxFont);
        yearBox.setForeground(new Color(-1));
        yearBox.setRequestFocusEnabled(false);
        panel.add(yearBox, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, 25), new Dimension(80, 25), new Dimension(80, 25), 0, false));
        gradeBox = new JComboBox();
        gradeBox.setBackground(new Color(-3121058));
        gradeBox.setEnabled(true);
        gradeBox.setFocusable(false);
        Font gradeBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, gradeBox.getFont());
        if (gradeBoxFont != null) gradeBox.setFont(gradeBoxFont);
        gradeBox.setForeground(new Color(-1));
        gradeBox.setRequestFocusEnabled(false);
        panel.add(gradeBox, new GridConstraints(5, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(91, 25), null, 0, false));
        provBox = new JComboBox();
        provBox.setBackground(new Color(-3121058));
        provBox.setEnabled(true);
        provBox.setFocusable(false);
        Font provBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, provBox.getFont());
        if (provBoxFont != null) provBox.setFont(provBoxFont);
        provBox.setForeground(new Color(-263173));
        provBox.setRequestFocusEnabled(false);
        panel.add(provBox, new GridConstraints(2, 2, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genderBox = new JComboBox();
        genderBox.setBackground(new Color(-3121058));
        genderBox.setFocusable(false);
        Font genderBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, genderBox.getFont());
        if (genderBoxFont != null) genderBox.setFont(genderBoxFont);
        genderBox.setForeground(new Color(-1837313));
        genderBox.setRequestFocusEnabled(false);
        panel.add(genderBox, new GridConstraints(4, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel.add(spacer1, new GridConstraints(0, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, new Dimension(50, 4), new Dimension(4, 4), new Dimension(50, 4), 0, false));
        searchField = new JTextField();
        searchField.setBackground(new Color(-3121058));
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
        gradeListBox = new JComboBox();
        gradeListBox.setBackground(new Color(-26292));
        gradeListBox.setFocusable(false);
        Font gradeListBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, gradeListBox.getFont());
        if (gradeListBoxFont != null) gradeListBox.setFont(gradeListBoxFont);
        gradeListBox.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Grade");
        gradeListBox.setModel(defaultComboBoxModel1);
        panel.add(gradeListBox, new GridConstraints(4, 9, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        courseListBox = new JComboBox();
        courseListBox.setBackground(new Color(-26292));
        courseListBox.setFocusable(false);
        Font courseListBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, courseListBox.getFont());
        if (courseListBoxFont != null) courseListBox.setFont(courseListBoxFont);
        courseListBox.setForeground(new Color(-1));
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Course");
        courseListBox.setModel(defaultComboBoxModel2);
        panel.add(courseListBox, new GridConstraints(5, 9, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(98, 25), null, 0, false));
        minField = new JTextField();
        minField.setBackground(new Color(-3121058));
        minField.setForeground(new Color(-1));
        panel.add(minField, new GridConstraints(9, 10, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        maxField = new JTextField();
        maxField.setBackground(new Color(-3121058));
        maxField.setForeground(new Color(-1));
        panel.add(maxField, new GridConstraints(8, 10, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setBackground(new Color(-1));
        Font label2Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-1));
        label2.setText("MAX GRADE");
        panel.add(label2, new GridConstraints(8, 9, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setBackground(new Color(-1));
        Font label3Font = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-1));
        label3.setText("MIN GRADE");
        panel.add(label3, new GridConstraints(9, 9, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dayBox = new JComboBox();
        dayBox.setBackground(new Color(-3121058));
        dayBox.setFocusable(false);
        Font dayBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, dayBox.getFont());
        if (dayBoxFont != null) dayBox.setFont(dayBoxFont);
        dayBox.setForeground(new Color(-1));
        dayBox.setRequestFocusEnabled(false);
        panel.add(dayBox, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(60, 25), new Dimension(60, 25), new Dimension(60, 25), 0, false));
        monthBox = new JComboBox();
        monthBox.setBackground(new Color(-3121058));
        monthBox.setFocusable(false);
        Font monthBoxFont = this.$$$getFont$$$("Microsoft YaHei UI", Font.BOLD, -1, monthBox.getFont());
        if (monthBoxFont != null) monthBox.setFont(monthBoxFont);
        monthBox.setForeground(new Color(-1));
        monthBox.setRequestFocusEnabled(false);
        panel.add(monthBox, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(60, 25), new Dimension(50, 25), new Dimension(60, 25), 0, false));
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
