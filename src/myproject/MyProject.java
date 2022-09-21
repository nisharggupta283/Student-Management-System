package myproject;

import java.awt.EventQueue;
import static java.awt.EventQueue.invokeLater;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.Statement;
import javax.swing.UIManager;

//////////////////////////////////////////////////////////////////////// Faculty Class Change Phone Number /////////////////////////////////////////////////////////////////////////////////////
class changePhone extends JFrame {

    static int fid;

    public changePhone(int i) {
        initComponents();
        fid = i;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Update");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel1.setText("                            ");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(144, 144, 144)
                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                                .addGap(65, 65, 65)
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(215, 215, 215)
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(278, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addGap(67, 67, 67)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(232, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm1 = con1.prepareStatement("update faculty set mobileNo=? where fid = ? ;");
            stm1.setString(1, jTextField1.getText());
            stm1.setInt(2, fid);
            stm1.executeUpdate();
            jLabel1.setText("successfully");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(changePhone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private JButton jButton1;
    private JLabel jLabel1;
    private JTextField jTextField1;

}

///////////////////////////////////////////////////////////////////////Faculty Class Change Address ////////////////////////////////////////////////////////////////////////////////////
class changeOnlyAddr extends JFrame {

    static int fid;

    public changeOnlyAddr(int f) {
        initComponents();
        fid = f;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        statelist = new JComboBox<>();
        city = new JTextField();
        addr = new JTextField();
        jButton1 = new JButton();
        result = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("State");
        jLabel2.setText("City");
        jLabel3.setText("Address");
        statelist.setForeground(new java.awt.Color(93, 183, 183));
        statelist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Jharkhand", "Karnataka", "Kerala", "Maharastra", "Madhya Pradesh", "Manipur", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan"}));
        jButton1.setText("Submit");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(city, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(statelist, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(result, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addr, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
                                                .addGap(67, 67, 67)
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(statelist, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(addr, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addGap(58, 58, 58)
                                .addComponent(result, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(178, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update faculty set fcity=?,fstate=?,fAddr=? where fid = ? ;");
            stm.setString(1, city.getText());
            stm.setString(2, statelist.getSelectedItem().toString());
            stm.setString(3, addr.getText());
            stm.setInt(4, fid);
            stm.executeUpdate();
            result.setText("Successful");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(changeOnlyAddr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private JTextField addr;
    private JTextField city;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField result;
    private JComboBox<String> statelist;
}

//////////////////////////////////////////////////////// Faculty Class Change Password and Address/////////////////////////////////////////////
class changeContactDetail extends JFrame {

    static int fid;

    public changeContactDetail(int f) {
        initComponents();
        fid = f;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        statelist = new JComboBox<>();
        city = new JTextField();
        addr = new JTextField();
        phone = new JTextField();
        jLabel4 = new JLabel();
        jButton1 = new JButton();
        result = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("State");
        jLabel2.setText("City");
        jLabel3.setText("Address");
        statelist.setForeground(new java.awt.Color(93, 183, 183));
        statelist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Jharkhand", "Karnataka", "Kerala", "Maharastra", "Madhya Pradesh", "Manipur", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan"}));
        jLabel4.setText("Phone");
        jButton1.setText("Submit");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(city, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(addr, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(statelist, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(100, 100, 100)
                                                                .addComponent(phone, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(262, 262, 262)
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(174, 174, 174)
                                                .addComponent(result, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(247, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(statelist, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(addr, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(phone, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addComponent(jButton1)
                                .addGap(34, 34, 34)
                                .addComponent(result, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
        );
        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update faculty set mobileNo = ?,fcity=?,fstate=?,fAddr=? where fid = ? ;");
            if (phone.getText().matches("[0-9]{10,10}")) {
                stm.setLong(1, Long.parseLong(phone.getText()));
                stm.setString(2, city.getText());
                stm.setString(3, statelist.getSelectedItem().toString());
                stm.setString(4, addr.getText());
                stm.setInt(5, fid);
                stm.executeUpdate();
                result.setText("successfully");
            } else {
                result.setText("Unsuccessfully");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(changeContactDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private JTextField addr;
    private JTextField city;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField phone;
    private JTextField result;
    private JComboBox<String> statelist;
}

///////////////////////////////////////////////// Faculty Class which Call Above class /////////////////////////////////////////////////////////////////
class FacultyContact extends JFrame {

    static int fid;

    public FacultyContact(int id) {
        initComponents();
        fid = id;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        update = new JButton();
        result = new JTextField();
        jLabel1 = new JLabel();
        addrCheckBox = new JCheckBox();
        phoneCheckBox = new JCheckBox();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        update.setText("Update");
        update.addActionListener(this::updateActionPerformed);
        jLabel1.setText("Change Password...");
        jLabel1.setOpaque(true);
        addrCheckBox.setFont(new Font("Segoe UI", 1, 11));
        addrCheckBox.setText("Address");
        phoneCheckBox.setFont(new Font("Segoe UI", 1, 11));
        phoneCheckBox.setText("Phone");

        jLabel2.setFont(new Font("Times New Roman", 1, 14));
        jLabel2.setText("Select option to Update");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(236, 236, 236)
                                                .addComponent(update, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                .addGap(78, 78, 78))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(addrCheckBox, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                                .addGap(80, 80, 80)
                                                .addComponent(phoneCheckBox, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(174, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(result, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
                                .addGap(141, 141, 141))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addrCheckBox)
                                        .addComponent(phoneCheckBox))
                                .addGap(48, 48, 48)
                                .addComponent(update)
                                .addGap(38, 38, 38)
                                .addComponent(result, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(142, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleDescription("");
        pack();
    }

    private void updateActionPerformed(ActionEvent evt) {
        if (addrCheckBox.isSelected() && phoneCheckBox.isSelected()) {
            result.setText("Continue to change Address & Phone");
            MyProject.contactDetail(fid);
        } else if (phoneCheckBox.isSelected()) {
            result.setText("Continue to change Phone");
            MyProject.phoneUpdate(fid);
        } else if (addrCheckBox.isSelected()) {
            result.setText("Continue to change Address");
            MyProject.changeonlyAddr(fid);
        }
    }
    private JCheckBox addrCheckBox;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JCheckBox phoneCheckBox;
    private JTextField result;
    private JButton update;
}

/////////////////////////////////////////////////////// Faculty Class Change Password ////////////////////////////////////////////////////////////////////
class passChange extends JFrame {

    static int id;

    public passChange(int i) {
        initComponents();
        id = i;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        oldlabel = new JLabel();
        newlabel = new JLabel();
        update = new JButton();
        result = new JTextField("                                       ");
        jPasswordField1 = new JPasswordField();
        jPasswordField2 = new JPasswordField();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        oldlabel.setFont(new Font("Nirmala UI", 1, 14));
        oldlabel.setText("Old Password");
        newlabel.setFont(new Font("Nirmala UI", 1, 14));
        newlabel.setText("New Password");
        update.setText("Update");
        update.addActionListener(this::updateActionPerformed);
        jPasswordField1.setText("jPasswordField1");
        jPasswordField2.setText("jPasswordField2");
        jLabel1.setText("Change Password...");
        jLabel1.setOpaque(true);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(145, 145, 145)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(oldlabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(newlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)).addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jPasswordField2, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE).addComponent(jPasswordField1)))
                .addGroup(layout.createSequentialGroup().addGap(236, 236, 236).addComponent(update, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup().addGap(190, 190, 190).addComponent(result, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE)).addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(oldlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(newlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29).addComponent(update).addGap(35, 35, 35).addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        pack();
    }

    private void updateActionPerformed(ActionEvent evt) {

        try {
            String n = new String(jPasswordField1.getPassword());
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("select fpassword from faculty where fid = ? ;");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (rs.getString("fpassword").equals(n)) {

                    String str = new String(jPasswordField2.getPassword());
                    if (str.length() > 8) {
                        Class.forName("org.postgresql.Driver");

                        Connection con23 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");

                        PreparedStatement stm23 = con23.prepareStatement("update faculty set fpassword=? where fid=?;");

                        stm23.setString(1, str);
                        stm23.setInt(2, id);
                        stm23.executeUpdate();
                        result.setText("Successfull");
                    } else {
                        result.setText("password length should be greater than 8");
                    }
                } else {
                    result.setText("Try Again");
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AfterFacultylogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private JLabel jLabel1;
    private JPasswordField jPasswordField1;
    private JPasswordField jPasswordField2;
    private JLabel newlabel;
    private JLabel oldlabel;
    private JTextField result;
    private JButton update;
}

////////////////////////////////////////////////////Faculty After Login Interface Class ///////////////////////////////////////////////////////
class AfterFacultylogin extends JFrame {

    static String Pass, Type;
    int userID, mostimpFID;

    public AfterFacultylogin(int userid, String password, String type) {
        initComponents();
        userID = userid;
        Pass = password;
        Type = type;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        fid = new JButton();
        fDetails = new JButton();
        salary = new JButton();
        fpassword = new JButton();
        addr = new JButton();
        contactDetail = new JButton();
        attendance = new JButton();
        salaryPaidUnpiad = new JButton();
        complain = new JButton();
        about_us = new JButton();
        feedback = new JButton();
        updateByFaculty = new JButton();
        post = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jScrollPane2 = new JScrollPane();
        jTextArea2 = new JTextArea();
        title = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        fid.setText("Faculty ID");
        fid.addActionListener(this::fidActionPerformed);

        fDetails.setText("Faculty Detail");
        fDetails.addActionListener(this::fDetailsActionPerformed);

        salary.setText("Salary");
        salary.addActionListener(this::salaryActionPerformed);

        fpassword.setText("Password");
        fpassword.addActionListener(this::fpasswordActionPerformed);

        addr.setText("Address");

        contactDetail.setText("Contact Detail");
        contactDetail.addActionListener(this::contactDetailActionPerformed);

        attendance.setText("Attendance");
        attendance.addActionListener(this::attendanceActionPerformed);

        salaryPaidUnpiad.setText("Salary Status");
        salaryPaidUnpiad.addActionListener(this::salaryPaidUnpiadActionPerformed);

        complain.setText("Complain");

        about_us.setText("About University");

        feedback.setText("Feedback");

        updateByFaculty.setText("Updation");
        updateByFaculty.addActionListener(this::updateByFacultyActionPerformed);

        post.setText("Post");
        post.addActionListener(this::postActionPerformed);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        title.setText("WELCOME TO FACULTY SECTION....");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(post, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(updateByFaculty, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(feedback, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(about_us, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                        .addComponent(complain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(salaryPaidUnpiad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(attendance, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(contactDetail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addr, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fpassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(salary, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fDetails, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fid, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
                        .addComponent(title)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(fid)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fDetails)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(salary)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fpassword)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addr)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(contactDetail)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(attendance)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(salaryPaidUnpiad)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(complain)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(about_us)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(feedback)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(updateByFaculty)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(post)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))))
        );

        pack();
    }

    private void fidActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("select fname,fid from faculty where fpassword= ? and fid=?;");
            stm.setString(1, Pass);
            stm.setInt(2, userID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                jTextArea2.setText("\nWelcome back!! " + rs.getString("fname") + "  Your user ID is : " + rs.getInt("fid") + "\n");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AfterFacultylogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fDetailsActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("select * from faculty where fpassword= ? and fid=?;");
            stm.setString(1, Pass);
            stm.setInt(2, userID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                jTextArea2.append("\nFaculty ID " + rs.getInt("fid"));
                jTextArea2.append("\nFaculty Name " + rs.getString("fName"));
                jTextArea2.append("\nDOB " + rs.getString("fDOB"));
                jTextArea2.append("\nJoin Date in University " + rs.getString("joinDate"));
                jTextArea2.append("\nPay Scale " + rs.getInt("fSalary"));
                jTextArea2.append("\nAddress " + rs.getString("fcity"));
                jTextArea2.append(" " + rs.getString("fstate"));
                jTextArea2.append(" " + rs.getString("fAddr"));
                jTextArea2.append("\nExperience " + rs.getByte("fExperience"));
                jTextArea2.append("\nContact Info " + rs.getString("mobileNo"));
                jTextArea2.append("\nCurrent Post " + rs.getString("post"));
                jTextArea2.append("\nGender " + rs.getString("gender"));
                jTextArea2.append("\nSalary Status " + rs.getString("salarystatus"));
                mostimpFID = rs.getInt("fid");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AfterFacultylogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void salaryActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("select post,fsalary from faculty where fid=? ;");
            stm.setInt(1, mostimpFID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                jTextArea2.setText("Salary for " + rs.getString("post") + " is " + rs.getInt("fSalary") + " INR");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AfterFacultylogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fpasswordActionPerformed(ActionEvent evt) {
        MyProject.FacultyPssChange(mostimpFID);
    }

    private void contactDetailActionPerformed(ActionEvent evt) {
        MyProject.FacultyContact(mostimpFID);
    }

    private void attendanceActionPerformed(ActionEvent evt) {

    }

    private void salaryPaidUnpiadActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("select salarystatus from faculty where fid=? ;");
            stm.setInt(1, mostimpFID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (rs.getString("salarystatus").equals("unpaid")) {
                    jTextArea2.setText("you are unpaid till now...\ncontact Management to go through complain section");
                    jTextArea1.setText("UnPaid");
                } else {
                    jTextArea2.setText("Paid");
                    jTextArea1.setText("Paid");

                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AfterFacultylogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateByFacultyActionPerformed(ActionEvent evt) {
        MyProject.newMethod();
    }

    private void postActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm2 = con2.prepareStatement("select post from faculty where fid=?;");
            stm2.setInt(1, mostimpFID);
            ResultSet rs = stm2.executeQuery();
            while (rs.next()) {
                jTextArea2.setText(rs.getString("post"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AfterFacultylogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private JButton about_us;
    private JButton addr;
    private JButton attendance;
    private JButton complain;
    private JButton contactDetail;
    private JButton fDetails;
    private JButton feedback;
    private JButton fid;
    private JButton fpassword;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;
    private JButton post;
    private JButton salary;
    private JButton salaryPaidUnpiad;
    private JTextField title;
    private JButton updateByFaculty;
}
//////////////////////////////////////////////////////////////////Faculty Update itself and Student //////////////////////////////////////////////////////////////////////

class FacultyUpdate extends JFrame {

    public FacultyUpdate() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        jDesktopPane1 = new JDesktopPane();
        selfRadiobt = new JRadioButton();
        stdtRadioBt = new JRadioButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
                jDesktopPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 862, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
                jDesktopPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        buttonGroup1.add(selfRadiobt);
        selfRadiobt.setText("Self Update");
        selfRadiobt.addActionListener(this::selfRadiobtActionPerformed);

        buttonGroup1.add(stdtRadioBt);
        stdtRadioBt.setText("Student Update");
        stdtRadioBt.addActionListener(this::stdtRadioBtActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(stdtRadioBt, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                        .addComponent(selfRadiobt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDesktopPane1))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jDesktopPane1)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(selfRadiobt)
                                .addGap(99, 99, 99)
                                .addComponent(stdtRadioBt)
                                .addContainerGap(373, Short.MAX_VALUE))
        );

        pack();
    }

    private void stdtRadioBtActionPerformed(ActionEvent evt) {
        jDesktopPane1.removeAll();
        stdtUpdate st = new stdtUpdate();
        jDesktopPane1.add(st).setVisible(true);
    }

    private void selfRadiobtActionPerformed(ActionEvent evt) {
        jDesktopPane1.removeAll();
        selfupd st = new selfupd();
        jDesktopPane1.add(st).setVisible(true);
    }

    private ButtonGroup buttonGroup1;
    private JDesktopPane jDesktopPane1;
    private JRadioButton selfRadiobt;
    private JRadioButton stdtRadioBt;
}

class selfupd extends JInternalFrame {

    static String str;

    public selfupd() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        logUserID = new JTextField();
        logPAss = new JPasswordField();
        loginBt = new JButton();
        loginLabel = new JLabel();
        jPanel2 = new JPanel();
        NameLabel = new JLabel();
        newName = new JTextField();
        NameBt = new JButton();
        jPanel3 = new JPanel();
        day = new JComboBox<>();
        month = new JComboBox<>();
        year = new JComboBox<>();
        Dobbt = new JButton();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        doblabel = new JLabel();
        jPanel4 = new JPanel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        statename = new JComboBox<>();
        city = new JTextField();
        addrSubmitbt = new JButton();
        AddrLabel = new JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Self Update");

        jLabel1.setText("UserId");

        jLabel2.setText("Password");

        loginBt.setText("Ok");
        loginBt.addActionListener(this::loginBtActionPerformed);

        loginLabel.setText(".........................");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(149, 149, 149)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(logUserID)
                                                        .addComponent(logPAss, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(195, 195, 195)
                                                .addComponent(loginBt))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(loginLabel)))
                                .addContainerGap(301, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(logUserID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(logPAss, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addComponent(loginBt)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                                .addComponent(loginLabel)
                                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Login", jPanel1);

        NameLabel.setText("...........................");

        NameBt.setText("ok");
        NameBt.addActionListener(this::NameBtActionPerformed);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(NameLabel))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(newName, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50)
                                                .addComponent(NameBt)))
                                .addContainerGap(272, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NameBt))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                                .addComponent(NameLabel)
                                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Name", jPanel2);

        day.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

        month.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

        year.setModel(new DefaultComboBoxModel<>(new String[]{"1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "20001"}));

        Dobbt.setText("ok");
        Dobbt.addActionListener(this::DobbtActionPerformed);

        jLabel3.setText("Day");

        jLabel4.setText("Month");

        jLabel5.setText("Year");

        doblabel.setText("...............................");

        javax.swing.GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(137, 137, 137)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Dobbt)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4))
                                                                .addGap(52, 52, 52)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(doblabel)))
                                .addContainerGap(267, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addComponent(Dobbt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addComponent(doblabel)
                                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("DOB", jPanel3);

        jLabel6.setText("State");

        jLabel7.setText("City");

        jLabel8.setText("Address");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        statename.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Andhra Pradesh", "Arunchal Pradesh", "Assam", "Bihar", "Chattisgarh", "Goa", "Gujrat", "Haryana", "Himachal Pardesh", "Jharkahand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghayala", "Nagaland", "Orrisa", "Punjab", "Rajsathan", "Sikkim", "Tamil Nadu"}));

        addrSubmitbt.setText("ok");
        addrSubmitbt.addActionListener(this::addrSubmitbtActionPerformed);

        AddrLabel.setText("..................................");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(119, 119, 119)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7))
                                                .addGap(45, 45, 45)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(addrSubmitbt)
                                                        .addComponent(statename, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(AddrLabel)))
                                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(statename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addComponent(addrSubmitbt)
                                .addGap(18, 18, 18)
                                .addComponent(AddrLabel)
                                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Address", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );

        pack();
    }

    private void addrSubmitbtActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement(" update faculty set fcity=?,fstate=?,faddr=? where fid=?;");
            stm.setString(1, city.getText());
            stm.setString(2, statename.getSelectedItem().toString());
            stm.setString(3, jTextArea1.getText());
            stm.setInt(4, Integer.parseInt(logUserID.getText()));
            stm.executeUpdate();
            AddrLabel.setText("Sucessful");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(selfupd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void DobbtActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement(" update faculty set fDOB =? where fid=?;");
            stm.setObject(1, LocalDate.of(Integer.parseInt(year.getSelectedItem().toString()), Integer.parseInt(month.getSelectedItem().toString()), Integer.parseInt(day.getSelectedItem().toString())));
            stm.setInt(2, Integer.parseInt(logUserID.getText()));
            stm.executeUpdate();
            doblabel.setText("Sucessful");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(selfupd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void NameBtActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement(" update faculty set fName=? where fid=?;");
            if (newName.getText() == null) {
                NameLabel.setText("UnSucessful");
            } else {
                stm.setString(1, newName.getName());
                stm.setInt(2, Integer.parseInt(logUserID.getText()));
                stm.executeUpdate();
                NameLabel.setText("Sucessful");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(selfupd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loginBtActionPerformed(ActionEvent evt) {
        str = new String(logPAss.getPassword());
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement(" select * from faculty where fid=? and fPassword =?;");
            stm.setInt(1, Integer.parseInt(logUserID.getText()));
            stm.setString(2, str);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                loginLabel.setText("Sucessful");
            } else {
                loginLabel.setText("Sucessful");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(selfupd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private JLabel AddrLabel;
    private JButton Dobbt;
    private JButton NameBt;
    private JLabel NameLabel;
    private JButton addrSubmitbt;
    private JTextField city;
    private JComboBox<String> day;
    private JLabel doblabel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JTextArea jTextArea1;
    private JPasswordField logPAss;
    private JTextField logUserID;
    private JButton loginBt;
    private JLabel loginLabel;
    private JComboBox<String> month;
    private JTextField newName;
    private JComboBox<String> statename;
    private JComboBox<String> year;
}

class stdtUpdate extends JInternalFrame {

    public stdtUpdate() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jComboBox1 = new JComboBox<>();
        jComboBox2 = new JComboBox<>();
        jComboBox3 = new JComboBox<>();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        day = new JComboBox<>();
        jComboBox5 = new JComboBox<>();
        year = new JComboBox<>();
        jLabel4 = new JLabel();
        month = new JLabel();
        jLabel6 = new JLabel();
        eventhandler = new JButton();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        okbt = new JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Student Update");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}));

        jComboBox2.setModel(new DefaultComboBoxModel<>(new String[]{"CS", "ME", "CSE", "EC"}));

        jComboBox3.setModel(new DefaultComboBoxModel<>(new String[]{"First", "Second", "Third", "Fourth"}));

        jLabel1.setText("Semester");

        jLabel2.setText("Branch");

        jLabel3.setText("Year");

        day.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

        jComboBox5.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

        year.setModel(new DefaultComboBoxModel<>(new String[]{"2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028"}));

        jLabel4.setText("Day");

        month.setText("Month");

        jLabel6.setText("Year");

        eventhandler.setText("ok");
        eventhandler.addActionListener(this::eventhandlerActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(month)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(eventhandler)))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(month)
                                        .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)
                                .addComponent(eventhandler)
                                .addContainerGap(120, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Selection", jPanel1);

        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "ATTENDANCE"
                }
        ) {
            Class[] types = new Class[]{
                Integer.class, Boolean.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        okbt.setText("ok");
        okbt.addActionListener(this::okbtActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(okbt)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(okbt))
        );

        jTabbedPane1.addTab("Attendance", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );

        pack();
    }

    private void okbtActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement(" insert into Sattendance (sid,DateP,Attendance) values(?,?,?);");
            int index[] = jTable1.getSelectedRows();
            TableModel tbl = jTable1.getModel();
            for (int i = 0; i < index.length; i++) {
                stm.setInt(1, (int) tbl.getValueAt(index[i], 0));
                stm.setObject(2, LocalDate.of(Integer.parseInt(year.getSelectedItem().toString()), Integer.parseInt(jComboBox5.getSelectedItem().toString()), Integer.parseInt(day.getSelectedItem().toString())));
                stm.setBoolean(3, (boolean) tbl.getValueAt(index[i], 1));
            }

            stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(selfupd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eventhandlerActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement(" select sid,attendance from students where semester=? and SYear=? and sBranch  =?;");
            stm.setInt(1, Integer.parseInt(jComboBox1.getSelectedItem().toString()));
            stm.setString(2, jComboBox3.getSelectedItem().toString());
            stm.setString(3, jComboBox2.getSelectedItem().toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int i = rs.getInt("sid");
                boolean bl = rs.getBoolean("attendance");
                Object ob[] = {i, bl};
                DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
                tbl.addRow(ob);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private JComboBox<String> day;
    private JButton eventhandler;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JComboBox<String> jComboBox3;
    private JComboBox<String> jComboBox5;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JTable jTable1;
    private JLabel month;
    private JButton okbt;
    private JComboBox<String> year;
}

///////////////////////////////////////////////////////////////////////////Student   Class //////////////////////////////////////////////////////////////////////////////////////
class AfterStudentlogin extends JFrame {

    static String Pass, Type, year;
    static int mostimpSID, userID;
    static String gender, cast, branch;

    public AfterStudentlogin(int U, String P, String T) {
        initComponents();
        userID = U;
        Pass = P;
        Type = T;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        sidButton = new JButton();
        sDetails = new JButton();
        scholarship = new JButton();
        spassword = new JButton();
        addr = new JButton();
        contactDetail = new JButton();
        attendance = new JButton();
        fee = new JButton();
        complain = new JButton();
        about_us = new JButton();
        feedback = new JButton();
        updateByStudent = new JButton();
        Result = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jScrollPane2 = new JScrollPane();
        jTextArea2 = new JTextArea();
        title = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        sidButton.setText("Student ID");
        sidButton.addActionListener(this::sidButtonActionPerformed);

        sDetails.setText("Student Detail");
        sDetails.addActionListener(this::sDetailsActionPerformed);

        scholarship.setText("Scholarship");
        scholarship.addActionListener(this::scholarshipActionPerformed);

        spassword.setText("Password");
        spassword.addActionListener(this::spasswordActionPerformed);

        addr.setText("Address");
        contactDetail.setText("Contact Detail");
        contactDetail.addActionListener(this::contactDetailActionPerformed);

        attendance.setText("Attendance");
        attendance.addActionListener(this::attendanceActionPerformed);

        fee.setText("Fees Status");
        fee.addActionListener(this::feeActionPerformed);

        complain.setText("Complain");

        about_us.setText("About University");

        feedback.setText("Feedback");

        updateByStudent.setText("Updation");
        updateByStudent.addActionListener(this::updateByStudentActionPerformed);
        Result.setText("Result");
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        title.setText("WELCOME TO STUDENT SECTION....");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(Result, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(updateByStudent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(feedback, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(about_us, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                        .addComponent(complain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fee, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(attendance, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(contactDetail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(spassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(scholarship, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sDetails, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sidButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
                        .addComponent(title)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(sidButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sDetails)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(scholarship)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spassword)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addr)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(contactDetail)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(attendance)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fee)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(complain)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(about_us)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(feedback)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(updateByStudent)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Result)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))))
        );
        pack();
    }

    private void sidButtonActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("select sName,sid from Students where spassword= ? and sid=?;");
            stm.setString(1, Pass);
            stm.setInt(2, userID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                jTextArea2.setText("\nWelcome back!! " + rs.getString("sname") + "  Your user ID is : " + rs.getInt("sid") + "\n");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AfterFacultylogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sDetailsActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("select * from Students where spassword= ? and sid=?;");
            stm.setString(1, Pass);
            stm.setInt(2, userID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                jTextArea2.append("\nStudent ID " + rs.getInt("sId"));
                jTextArea2.append("\nStudent Name " + rs.getString("sName"));
                jTextArea2.append("\nBranch " + rs.getString("sBranch"));
                jTextArea2.append("\nDOB " + rs.getString("sDOB"));
                jTextArea2.append("\nJoin Date in University " + rs.getString("joinDate"));
                jTextArea2.append("\nCast " + rs.getString("castype"));
                jTextArea2.append("\nAddress " + rs.getString("scity"));
                jTextArea2.append(" " + rs.getString("sstate"));
                jTextArea2.append(" " + rs.getString("sAddr"));
                jTextArea2.append("\nSemester " + rs.getByte("semester"));
                jTextArea2.append("\nContact Info " + rs.getString("mobileNo"));
                jTextArea2.append("\nGender " + rs.getString("gender"));
                mostimpSID = rs.getInt("sId");
                if (rs.getBoolean("scholarship") == true) {
                    jTextArea2.append("\nScholarship based Admission ");
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AfterFacultylogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void scholarshipActionPerformed(ActionEvent evt) {
        try {

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("select castype,gender,sBranch,syear from Students where sid= ?;");
            stm.setInt(1, userID);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                cast = rs.getString("castype");
                gender = rs.getString("gender");
                branch = rs.getString("sBranch");
                year = rs.getString("syear");
            }
            System.out.println(cast + " " + gender + " " + branch + " " + year);
            Class.forName("org.postgresql.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            Statement ptm = con1.createStatement();
            ResultSet rs1;
            switch (branch) {
                case "CS" -> {
                    switch (year) {
                        case "First" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='First' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;

                                        }
                                        case "female" -> {

                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='First' and branch='CS';");

                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='First' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");

                                                break;
                                            }
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='First' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='First' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='First' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");

                                            }
                                            break;
                                        }
                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("18No ScholarShip");
                                            break;
                                        }
                                        case "female" -> {
                                            jTextArea2.setText("18No ScholarShip");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        case "Second" -> {
                            //CS Second Year
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Second' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Second' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Second' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Second' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Second' and branch='CS';");
                                            while (rs1.next()) {
                                                String str = rs1.getInt("obc_boy") + "";
                                                jTextArea2.setText(str);
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Second' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("17No ScholarShip");
                                            break;
                                        }
                                        case "female" -> {
                                            jTextArea2.setText("17No ScholarShip");
                                            break;
                                        }
                                    }
                                }

                            }
                        }

                        case "Third" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Third' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Third' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Third' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Third' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Third' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Third' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("16No ScholarShip");
                                            break;
                                        }
                                        case "female" -> {
                                            jTextArea2.setText("16No ScholarShip");
                                            break;
                                        }
                                    }
                                }

                            }
                        }

                        case "Fourth" -> {
                            //CS fourth year
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Fourth' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Fourth' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Fourth' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Fourth' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Fourth' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Fourth' and branch='CS';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("15No ScholarShip");
                                            break;
                                        }
                                        case "female" -> {
                                            jTextArea2.setText("15No ScholarShip");
                                            break;
                                        }
                                    }
                                }

                            }
                        }

                    }
                }
                case "ME" -> {
                    switch (year) {
                        case "First" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='First' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                            }
                                            break;

                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='First' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;

                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='First' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='First' and branch='ME';");
                                            jTextArea2.setText(rs1.getInt("st_girl") + "");
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='First' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='First' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("13No ScholarShip");
                                            break;
                                        }
                                        case "female" -> {
                                            jTextArea2.setText("13No ScholarShip");
                                            break;
                                        }
                                    }
                                }

                            }
                        }

                        case "Second" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Second' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Second' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Second' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Second' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Second' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Second' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("11No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            jTextArea2.setText("12No ScholarShip");
                                            break;
                                        }

                                    }
                                }

                            }
                        }
                        case "Third" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Third' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Third' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Third' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Third' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Third' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Third' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("10No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            jTextArea2.setText("10No ScholarShip");
                                            break;
                                        }

                                    }
                                }

                            }
                        }

                        case "Fourth" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Fourth' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Fourth' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Fourth' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Fourth' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Fourth' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Fourth' and branch='ME';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("9No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            jTextArea2.setText("9No ScholarShip");
                                            break;
                                        }

                                    }
                                }

                            }
                        }

                    }
                }

                case "EC" -> {
                    switch (year) {
                        case "First" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='First' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='First' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='First' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='First' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='First' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='First' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("8No ScholarShip");
                                        }

                                        case "female" -> {
                                            jTextArea2.setText("8No ScholarShip");
                                        }

                                    }
                                }

                            }
                        }

                        case "Second" -> {
                            //EC second
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Second' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Second' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Second' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Second' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Second' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Second' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("7No ScholarShip");
                                        }

                                        case "female" -> {
                                            jTextArea2.setText("7No ScholarShi");
                                        }

                                    }
                                }

                            }
                        }

                        case "Third" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Third' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Third' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Third' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Third' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Third' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Third' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("6No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            jTextArea2.setText("6No ScholarShip");
                                        }

                                    }
                                }

                            }
                        }

                        case "Fourth" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Fourth' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Fourth' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Fourth' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Fourth' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Fourth' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Fourth' and branch='EC';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("5No ScholarShip");
                                        }

                                        case "female" -> {
                                            jTextArea2.setText("5No ScholarShip");
                                        }

                                    }
                                }

                            }
                        }

                    }
                }

                case "CSE" -> {
                    switch (year) {
                        case "First" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='First' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='First' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='First' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='First' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='First' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='First' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("4No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            jTextArea2.setText("4No ScholarShip");
                                        }

                                    }
                                }

                            }
                        }
                        case "Second" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Second' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Second' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Second' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Second' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");

                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Second' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Second' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("3No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            jTextArea2.setText("3No ScholarShip");
                                        }

                                    }
                                }

                            }
                        }

                        case "Third" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Third' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Third' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Third' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Third' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Third' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Third' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("2No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            jTextArea2.setText("2No ScholarShip");
                                            break;
                                        }

                                    }
                                }

                            }
                        }

                        case "Fourth" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Fourth' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_boy") + "");
                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Fourth' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("sc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Fourth' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_boy") + "");
                                                break;
                                            }
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Fourth' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("st_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Fourth' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_boy") + "");
                                                break;

                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Fourth' and branch='CSE';");
                                            while (rs1.next()) {
                                                jTextArea2.setText(rs1.getInt("obc_girl") + "");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            jTextArea2.setText("1No ScholarShip");
                                            break;
                                        }
                                        case "female" -> {
                                            jTextArea2.setText("1No ScholarShip");
                                            break;
                                        }

                                    }
                                }
                            }
                        }

                    }
                }

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AfterStudentlogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void spasswordActionPerformed(ActionEvent evt) {
        MyProject.studentpasschange(mostimpSID);
    }

    private void contactDetailActionPerformed(ActionEvent evt) {
        // conatact info check and update
    }

    private void attendanceActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void feeActionPerformed(ActionEvent evt) {
        MyProject.feesSat(userID, true);
    }

    private void updateByStudentActionPerformed(ActionEvent evt) {
        MyProject.UpdateByStdt();
    }
    private JButton Result;
    private JButton about_us;
    private JButton addr;
    private JButton attendance;
    private JButton complain;
    private JButton contactDetail;
    private JButton fee;
    private JButton feedback;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;
    private JButton sDetails;
    private JButton scholarship;
    private JButton sidButton;
    private JButton spassword;
    private JTextField title;
    private JButton updateByStudent;

}

class feespaid extends JFrame {

    static int str;
    static boolean bl;
    static String cast, gender, branch, year;

    public feespaid(int stat, boolean boo) {
        str = stat;
        bl = boo;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        fees = new JLabel();
        scholrBase = new JLabel();
        scholarArr = new JLabel();
        result = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Fees");

        jLabel2.setText("                                                         ");

        jLabel3.setText("                                                          ");

        result.setText(".......................");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fees, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(scholarArr, javax.swing.GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(scholrBase, javax.swing.GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(207, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(fees))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(scholrBase))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(scholarArr))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                                .addComponent(result)
                                .addContainerGap())
        );

        pack();
        fun();
    }

    void fun() {
        try {

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("select castype,gender,sBranch,syear from Students where sid= ?;");
            stm.setInt(1, str);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                cast = rs.getString("castype");
                gender = rs.getString("gender");
                branch = rs.getString("sBranch");
                year = rs.getString("syear");
            }
            System.out.println(str + " " + cast + " " + gender + " " + branch + " " + year + " " + bl);
            Class.forName("org.postgresql.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            Statement ptm = con1.createStatement();
            ResultSet rs1;
            switch (branch) {
                case "CS" -> {
                    switch (year) {
                        case "First" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='First' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;

                                        }
                                        case "female" -> {

                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='First' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='First' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='First' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='First' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='First' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }

                                            }
                                            break;
                                        }
                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("18No ScholarShip");
                                            break;
                                        }
                                        case "female" -> {
                                            fees.setText("18No ScholarShip");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        case "Second" -> {
                            //CS Second Year
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Second' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Second' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Second' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Second' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Second' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Second' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("17No ScholarShip");
                                            break;
                                        }
                                        case "female" -> {
                                            fees.setText("17No ScholarShip");
                                            break;
                                        }
                                    }
                                }

                            }
                        }

                        case "Third" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Third' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Third' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Third' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Third' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Third' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Third' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("16No ScholarShip");
                                            break;
                                        }
                                        case "female" -> {
                                            fees.setText("16No ScholarShip");
                                            break;
                                        }
                                    }
                                }

                            }
                        }

                        case "Fourth" -> {
                            //CS fourth year
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Fourth' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Fourth' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Fourth' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Fourth' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Fourth' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Fourth' and branch='CS';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("15No ScholarShip");
                                            break;
                                        }
                                        case "female" -> {
                                            fees.setText("15No ScholarShip");
                                            break;
                                        }
                                    }
                                }

                            }
                        }

                    }
                }
                case "ME" -> {
                    switch (year) {
                        case "First" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='First' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;

                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='First' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;

                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='First' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='First' and branch='ME';");
                                            fees.setText(rs1.getInt("st_girl") + "");
                                            scholrBase.setText("Scholrship Based");
                                            if (bl == true) {
                                                result.setText("Please Pay Fees");
                                                scholarArr.setText("Scholarship Not arrived");
                                            } else {
                                                result.setText("Fees Paid");
                                                scholarArr.setText("Scholarship  arrived");
                                            }
                                            jLabel3.setText("Arrival status");
                                            jLabel2.setText("Admission");

                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='First' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='First' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("13No ScholarShip");
                                            break;
                                        }
                                        case "female" -> {
                                            fees.setText("13No ScholarShip");
                                            break;
                                        }
                                    }
                                }

                            }
                        }

                        case "Second" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Second' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Second' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Second' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Second' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Second' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Second' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("11No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            fees.setText("12No ScholarShip");
                                            break;
                                        }

                                    }
                                }

                            }
                        }
                        case "Third" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Third' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Third' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Third' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Third' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Third' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Third' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("10No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            fees.setText("10No ScholarShip");
                                            break;
                                        }

                                    }
                                }

                            }
                        }

                        case "Fourth" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Fourth' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Fourth' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Fourth' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Fourth' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Fourth' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Fourth' and branch='ME';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("9No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            fees.setText("9No ScholarShip");
                                            break;
                                        }

                                    }
                                }

                            }
                        }

                    }
                }

                case "EC" -> {
                    switch (year) {
                        case "First" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='First' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='First' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='First' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='First' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='First' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='First' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("8No ScholarShip");
                                        }

                                        case "female" -> {
                                            fees.setText("8No ScholarShip");
                                        }

                                    }
                                }

                            }
                        }

                        case "Second" -> {
                            //EC second
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Second' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Second' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Second' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Second' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Second' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Second' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("7No ScholarShip");
                                        }

                                        case "female" -> {
                                            fees.setText("7No ScholarShi");
                                        }

                                    }
                                }

                            }
                        }

                        case "Third" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Third' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Third' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Third' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Third' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Third' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Third' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("6No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            fees.setText("6No ScholarShip");
                                        }

                                    }
                                }

                            }
                        }

                        case "Fourth" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Fourth' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Fourth' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Fourth' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Fourth' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Fourth' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Fourth' and branch='EC';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("5No ScholarShip");
                                        }

                                        case "female" -> {
                                            fees.setText("5No ScholarShip");
                                        }

                                    }
                                }

                            }
                        }

                    }
                }

                case "CSE" -> {
                    switch (year) {
                        case "First" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='First' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='First' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='First' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='First' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='First' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='First' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("4No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            fees.setText("4No ScholarShip");
                                        }

                                    }
                                }

                            }
                        }
                        case "Second" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Second' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Second' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Second' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Second' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Second' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Second' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("3No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            fees.setText("3No ScholarShip");
                                        }

                                    }
                                }

                            }
                        }

                        case "Third" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Third' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Third' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Third' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Third' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Third' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Third' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("2No ScholarShip");
                                            break;
                                        }

                                        case "female" -> {
                                            fees.setText("2No ScholarShip");
                                            break;
                                        }

                                    }
                                }

                            }
                        }

                        case "Fourth" -> {
                            switch (cast) {
                                case "SC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select sc_boy from feesstructure where yearly='Fourth' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select sc_girl from feesstructure where yearly='Fourth' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("sc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "ST" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select st_boy from feesstructure where yearly='Fourth' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                        }
                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select st_girl from feesstructure where yearly='Fourth' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("st_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "OBC" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            rs1 = ptm.executeQuery("select obc_boy from feesstructure where yearly='Fourth' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_boy") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;

                                            }
                                            break;
                                        }

                                        case "female" -> {
                                            rs1 = ptm.executeQuery("select obc_girl from feesstructure where yearly='Fourth' and branch='CSE';");
                                            while (rs1.next()) {
                                                fees.setText(rs1.getInt("obc_girl") + "");
                                                scholrBase.setText("Scholrship Based");
                                                if (bl == true) {
                                                    result.setText("Please Pay Fees");
                                                    scholarArr.setText("Scholarship Not arrived");
                                                } else {
                                                    result.setText("Fees Paid");
                                                    scholarArr.setText("Scholarship  arrived");
                                                }
                                                jLabel3.setText("Arrival status");
                                                jLabel2.setText("Admission");

                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }

                                case "UR" -> {
                                    switch (gender) {
                                        case "male" -> {
                                            fees.setText("1No ScholarShip");
                                            break;
                                        }
                                        case "female" -> {
                                            fees.setText("1No ScholarShip");
                                            break;
                                        }

                                    }
                                }
                            }
                        }

                    }
                }

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AfterStudentlogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private JLabel fees;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel result;
    private JLabel scholarArr;
    private JLabel scholrBase;
}

class updateByStudent extends JFrame {

    public updateByStudent() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        logname = new JTextField();
        loginBt = new JButton();
        loginLa = new JLabel();
        logpass = new JPasswordField();
        jPanel2 = new JPanel();
        jLabel4 = new JLabel();
        newName = new JTextField();
        newNamebt = new JButton();
        nameLa = new JLabel();
        jPanel3 = new JPanel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        day = new JComboBox<>();
        month = new JComboBox<>();
        year = new JComboBox<>();
        DobBt = new JButton();
        dobLA = new JLabel();
        jPanel4 = new JPanel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        city = new JTextField();
        jScrollPane1 = new JScrollPane();
        addr = new JTextArea();
        state = new JComboBox<>();
        AddrBt = new JButton();
        addrLa = new JLabel();
        jPanel5 = new JPanel();
        jLabel11 = new JLabel();
        mob = new JTextField();
        mobBt = new JButton();
        mobLa = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Password");

        loginBt.setText("Ok");
        loginBt.addActionListener(this::loginBtActionPerformed);

        loginLa.setText(".....................");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(logname, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(75, 75, 75)
                                                                .addComponent(loginBt, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(logpass, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(loginLa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(logname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                                .addComponent(loginLa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(loginBt)
                                .addGap(4, 4, 4)
                                .addComponent(logpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Login", jPanel1);

        jLabel4.setText("New Name");

        newNamebt.setText("ok");
        newNamebt.addActionListener(this::newNamebtActionPerformed);

        nameLa.setText("...............................");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(101, 101, 101)
                                                .addComponent(jLabel4)
                                                .addGap(33, 33, 33)
                                                .addComponent(newName, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(newNamebt, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(nameLa)))
                                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(newName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newNamebt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                                .addComponent(nameLa)
                                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Name", jPanel2);

        jLabel5.setText("Day");

        jLabel6.setText("Month");

        jLabel7.setText("Year");

        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014"}));

        DobBt.setText("ok");
        DobBt.addActionListener(this::DobBtActionPerformed);

        dobLA.setText("...................");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(161, 161, 161)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7))
                                                .addGap(42, 42, 42)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(198, 198, 198)
                                                .addComponent(DobBt))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(dobLA)))
                                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addComponent(DobBt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(dobLA)
                                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("DOB", jPanel3);

        jLabel8.setText("City");

        jLabel9.setText("State");

        jLabel10.setText("Address");

        addr.setColumns(20);
        addr.setRows(5);
        jScrollPane1.setViewportView(addr);

        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Andhra Pradesh", "Arunchal Pradesh", "Assam", "Bihar", "Chattisgarh", "Goa", "Gujrat", "Haryana", "Himachal Pardesh", "Jharkahand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghayala", "Nagaland", "Orrisa", "Punjab", "Rajsathan", "Sikkim", "Tamil Nadu"}));

        AddrBt.setText("ok");
        AddrBt.addActionListener(this::AddrBtActionPerformed);

        addrLa.setText("...............");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(111, 111, 111)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9))
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(163, 163, 163)
                                                .addComponent(AddrBt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(149, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addrLa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addComponent(AddrBt)
                                .addGap(18, 18, 18)
                                .addComponent(addrLa, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Address", jPanel4);

        jLabel11.setText("New Mobile");

        mobBt.setText("ok");
        mobBt.addActionListener(this::mobBtActionPerformed);

        mobLa.setText(".....................");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(112, 112, 112)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(mob, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(mobBt))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(mobLa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(mob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mobBt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                                .addComponent(mobLa)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Mobile", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>                        

    private void mobBtActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AddrBtActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void DobBtActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void newNamebtActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void loginBtActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }
    private JButton AddrBt;
    private JButton DobBt;
    private JTextArea addr;
    private JLabel addrLa;
    private JTextField city;
    private JComboBox<String> day;
    private JLabel dobLA;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JButton loginBt;
    private JLabel loginLa;
    private JTextField logname;
    private JPasswordField logpass;
    private JTextField mob;
    private JButton mobBt;
    private JLabel mobLa;
    private JComboBox<String> month;
    private JLabel nameLa;
    private JTextField newName;
    private JButton newNamebt;
    private JComboBox<String> state;
    private JComboBox<String> year;
}

/////////////////////////////////////////////////////////////////////////////Student Class//////////////////////////////////////////////////////////////////////////////
class changeStudentDetail extends JFrame {

    static int sid;

    public changeStudentDetail(int i) {
        initComponents();
        sid = i;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton1 = new JButton();
        Result = new JTextField();
        jPasswordField1 = new JPasswordField();
        jPasswordField2 = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("old password");
        jLabel3.setText("new password");
        jButton1.setText("Update");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(228, 228, 228)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2))
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(282, 282, 282)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(242, 242, 242)
                                                .addComponent(Result, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(262, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(jButton1)
                                .addGap(34, 34, 34)
                                .addComponent(Result, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(174, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        try {
            String n = new String(jPasswordField1.getPassword());
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("select spassword from students where sid = ? ;");
            stm.setInt(1, sid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (rs.getString("spassword").equals(n)) {

                    String str = new String(jPasswordField2.getPassword());
                    if (str.length() > 8) {
                        Class.forName("org.postgresql.Driver");

                        Connection con23 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");

                        PreparedStatement stm23 = con23.prepareStatement("update students set spassword=? where sid=?;");

                        stm23.setString(1, str);
                        stm23.setInt(2, sid);
                        stm23.executeUpdate();
                        Result.setText("Successfull");
                    } else {
                        Result.setText("password length should be greater than 8");
                    }
                } else {
                    Result.setText("Try Again");
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AfterFacultylogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private JTextField Result;
    private JButton jButton1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPasswordField jPasswordField1;
    private JPasswordField jPasswordField2;
}

///////////////////////////////////////////////////////////////////// Login Page////////////////////////////////////////////////////////
class NewJFrame extends JFrame {

    private ButtonGroup buttonGroup1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JTextField jTextField2;
    private JTextField jTextField3;

    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        buttonGroup1 = new ButtonGroup();
        jLabel1 = new JLabel();
        jTextField2 = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextField3 = new JTextField();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Vikash Prajapati & Nisharg Gupta ");
        jLabel2.setText("USERID");
        jLabel3.setText("PASSWORD");
        jRadioButton1.setText("STUDENT");
        jRadioButton2.setText("FACULTY");
        jRadioButton3.setText("MANAGEMENT");
        jButton2.setText("LOGIN");
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        jButton2.addActionListener((ActionEvent evt)
                -> {
            jButton2ActionPerformed(evt);
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(327, 327, 327)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                        .addComponent(jTextField3))
                                .addGap(273, 273, 273))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jRadioButton1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(jRadioButton2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addComponent(jRadioButton3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton3))
                                .addGap(52, 52, 52)
                                .addComponent(jButton2)
                                .addContainerGap(220, Short.MAX_VALUE))
        );
        pack();
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        jRadioButton1.setActionCommand("students");
        jRadioButton2.setActionCommand("faculty");
        jRadioButton3.setActionCommand("management");
        int userid = Integer.parseInt(jTextField2.getText());
        String password = jTextField3.getText();
        String type = buttonGroup1.getSelection().getActionCommand();

        System.out.println(userid + " " + password + " " + type);
        switch (type) {
            case "students" -> {
                try {

                    dispose();

                    Class.forName("org.postgresql.Driver");

                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");

                    PreparedStatement stm = con.prepareStatement("select * from students where sid=? and spassword=?;");
                    stm.setInt(1, userid);
                    stm.setString(2, password);
                    ResultSet rs = stm.executeQuery();
                    if (rs.next()) {
                        MyProject.afterStudentLogin(userid, password, type);
                    } else {
                        MyProject.attemptFail();
                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Hello");
                }

            }

            case "faculty" -> {
                dispose();
                MyProject.facultyMeth(userid, password, type);

            }
            case "management" -> {
                dispose();
                MyProject.managementMeth(userid, password, type);
            }
        }
    }
}

class LoginFail extends JFrame {

    public LoginFail() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Attempt Fail");

        jLabel1.setText("Login Fail , Please Try Again....");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(170, Short.MAX_VALUE))
        );

        pack();
    }

    private javax.swing.JLabel jLabel1;
}

///////////////////////////////////////////////////////////////////// Main Class////////////////////////////////////////////////////////
public class MyProject {

    public static void attemptFail() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFail().setVisible(true);
        });
    }

    public static void newMethod() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacultyUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new FacultyUpdate().setVisible(true);
        });
    }

    public static void feesSat(int stri, boolean bll) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(feespaid.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(() -> {
            new feespaid(stri, bll).setVisible(true);
        });
    }

    public static void UpdateByStdt() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateByStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new updateByStudent().setVisible(true);
        });
    }

    public static void updatebyManage() {
        try {
            for (LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updatebyManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        invokeLater(() -> {
            new updatebyManagement().setVisible(true);
        });
    }

    public static void studentpasschange(int i) {
        try {
            for (LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changeStudentDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        invokeLater(() -> {
            new changeStudentDetail(i).setVisible(true);
        });
    }

    public static void phoneUpdate(int i) {
        try {
            for (LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changeContactDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        invokeLater(() -> {
            new changePhone(i).setVisible(true);
        });
    }

    public static void changeonlyAddr(int id) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changeOnlyAddr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        invokeLater(() -> {
            new changeOnlyAddr(id).setVisible(true);
        });
    }

    public static void contactDetail(int f) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changeContactDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        invokeLater(() -> {
            new changeContactDetail(f).setVisible(true);
        });
    }

    public static void FacultyContact(int fid) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacultyContact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(()
                -> {
            new FacultyContact(fid).setVisible(true);
        });
    }

    public static void FacultyPssChange(int i) {
        try {
            for (LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(passChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        invokeLater(()
                -> {
            new passChange(i).setVisible(true);
        });
    }

    public static void facultyMeth(int userid, String password, String type) {
        try {
            for (LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfterFacultylogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        invokeLater(() -> {
            new AfterFacultylogin(userid, password, type).setVisible(true);
        });
    }

    public static void afterStudentLogin(int userid, String password, String type) {
        try {
            for (LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfterStudentlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        invokeLater(()
                -> {
            new AfterStudentlogin(userid, password, type).setVisible(true);
        });
    }

//////////////////////////////////////////////////////// Management  method///////////////////////////////////////////////////////////
    public static void managementMeth(int userid, String password, String type) {
        try {
            for (LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfterManagementlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        invokeLater(()
                -> {
            new AfterManagementlogin(userid, password, type).setVisible(true);
        });
    }

/////////////////////////////////////////////////////////////////////// Login Method/////////////////////////////////////////////////////////
    static void loginpage() {
        try {
            for (LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        invokeLater(() -> {
            new NewJFrame().setVisible(true);
        });
    }

    public static void FacultyUpdateByManage() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacultyClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new FacultyClass().setVisible(true);
        });
    }

/////////////////////////////////////////////////////////////////////// Main Method////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        loginpage();
    }
}

///////////////////////////////////////////////////////////////////Update Existing Student///////////////////////////////////////////////////
class updateexiststdt extends JInternalFrame {

    static boolean scholar;
    static String fees;

    public updateexiststdt() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jRadioButton1 = new JRadioButton();
        buttonGroup1 = new ButtonGroup();
        buttonGroup2 = new ButtonGroup();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList<>();
        buttonGroup3 = new ButtonGroup();
        jScrollPane3 = new JScrollPane();
        jList2 = new JList<>();
        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jTextField3 = new JTextField();
        responseName = new JButton();
        nameLAbel = new JLabel();
        jLabel17 = new JLabel();
        jPanel2 = new JPanel();
        jLabel13 = new JLabel();
        jComboBox4 = new JComboBox<>();
        jLabel14 = new JLabel();
        jComboBox5 = new JComboBox<>();
        jLabel15 = new JLabel();
        jComboBox6 = new JComboBox<>();
        submitDOB = new JButton();
        jPanel4 = new JPanel();
        jComboBox3 = new JComboBox<>();
        jLabel12 = new JLabel();
        branchSubmit = new JButton();
        jPanel5 = new JPanel();
        jRadioButton6 = new JRadioButton();
        jRadioButton7 = new JRadioButton();
        scholrbutton = new JButton();
        jPanel6 = new JPanel();
        jComboBox2 = new JComboBox<>();
        Semsubmit = new JButton();
        jPanel7 = new JPanel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jScrollPane2 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jFormattedTextField3 = new JFormattedTextField();
        jTextField2 = new JTextField();
        submitaddr = new JButton();
        addressLabel = new JLabel();
        jPanel8 = new JPanel();
        jComboBox1 = new JComboBox<>();
        submityear = new JButton();
        jPanel9 = new JPanel();
        jRadioButton4 = new JRadioButton();
        jRadioButton5 = new JRadioButton();
        submitattendance = new JButton();
        AttendanceLabel = new JLabel();
        jPanel10 = new JPanel();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        feessubmit = new JButton();
        feesLabel = new JLabel();
        jPanel11 = new JPanel();
        jFormattedTextField1 = new JFormattedTextField();
        jFormattedTextField2 = new JFormattedTextField();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        submitMobile = new JButton();
        MobileLable = new JLabel();
        studentlogin = new JPanel();
        jTextField1 = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        StudentLoginByMang = new JButton();
        LoginLabel = new JLabel();
        jFormattedTextField4 = new JFormattedTextField();

        jRadioButton1.setText("jRadioButton1");

        jList1.setModel(new AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(jList1);
        jList2.setModel(new AbstractListModel<String>() {
            String[] strings;

            {
                this.strings = new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
            }

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane3.setViewportView(jList2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        responseName.setText("Response");
        responseName.addActionListener(this::responseNameActionPerformed);

        nameLAbel.setText("..............");

        jLabel17.setText("New Name");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addComponent(jLabel17)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(responseName))
                                        .addComponent(nameLAbel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17)
                                        .addComponent(responseName))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                                .addComponent(nameLAbel)
                                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Name", jPanel1);

        jLabel13.setText("Date");

        jComboBox4.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

        jLabel14.setText("Month");

        jComboBox5.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

        jLabel15.setText("Year");

        jComboBox6.setModel(new DefaultComboBoxModel<>(new String[]{"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2021"}));

        submitDOB.setText("Submit");
        submitDOB.addActionListener(this::submitDOBActionPerformed);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(111, 111, 111)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(jLabel13))
                                                .addGap(62, 62, 62)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(140, 140, 140)
                                                .addComponent(submitDOB)))
                                .addContainerGap(287, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(submitDOB)
                                .addContainerGap(166, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DOB", jPanel2);

        jComboBox3.setModel(new DefaultComboBoxModel<>(new String[]{"CS", "ME", "CSE", "EC"}));

        jLabel12.setText("Branch");

        branchSubmit.setText("Submit");
        branchSubmit.addActionListener(this::branchSubmitActionPerformed);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel12)
                                .addGap(34, 34, 34)
                                .addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(branchSubmit)
                                .addContainerGap(254, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(branchSubmit))
                                .addContainerGap(273, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Branch", jPanel4);

        buttonGroup3.add(jRadioButton6);
        jRadioButton6.setText("Yes");

        buttonGroup3.add(jRadioButton7);
        jRadioButton7.setText("No");

        scholrbutton.setText("Response");
        scholrbutton.addActionListener(this::scholrbuttonActionPerformed);

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addComponent(jRadioButton6)
                                                .addGap(62, 62, 62)
                                                .addComponent(jRadioButton7))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(165, 165, 165)
                                                .addComponent(scholrbutton)))
                                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton6)
                                        .addComponent(jRadioButton7))
                                .addGap(30, 30, 30)
                                .addComponent(scholrbutton)
                                .addContainerGap(217, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Scholarship", jPanel5);

        jComboBox2.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}));

        Semsubmit.setText("Submit");
        Semsubmit.addActionListener(this::SemsubmitActionPerformed);

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Semsubmit)
                                .addContainerGap(325, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Semsubmit))
                                .addContainerGap(264, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Semester", jPanel6);

        jLabel8.setText("City");

        jLabel9.setText("State");

        jLabel10.setText("Address");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        submitaddr.setText("submit");
        submitaddr.addActionListener(this::submitaddrActionPerformed);

        addressLabel.setText("................");

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addGap(45, 45, 45)
                                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel9)
                                                                        .addComponent(jLabel8))
                                                                .addGap(58, 58, 58)
                                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jFormattedTextField3, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                                                        .addComponent(jTextField2)))))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(116, 116, 116)
                                                .addComponent(submitaddr))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jFormattedTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(submitaddr)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                .addComponent(addressLabel)
                                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Address", jPanel7);

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"First", "Second", "Third", "Fourth"}));

        submityear.setText("submit");
        submityear.addActionListener(this::submityearActionPerformed);

        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(submityear)
                                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(submityear))
                                .addContainerGap(260, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Year", jPanel8);

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Absent");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Present");

        submitattendance.setText("submit");
        submitattendance.addActionListener(this::submitattendanceActionPerformed);

        AttendanceLabel.setText("..................");

        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(146, 146, 146)
                                                .addComponent(jRadioButton5)
                                                .addGap(59, 59, 59)
                                                .addComponent(jRadioButton4)
                                                .addGap(38, 38, 38)
                                                .addComponent(submitattendance))
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(AttendanceLabel)))
                                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton5)
                                        .addComponent(jRadioButton4)
                                        .addComponent(submitattendance))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                                .addComponent(AttendanceLabel)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Attendance", jPanel9);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Paid");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Unpaid");

        feessubmit.setText("submit");
        feessubmit.addActionListener(this::feessubmitActionPerformed);

        feesLabel.setText("................");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(139, 139, 139)
                                                .addComponent(jRadioButton2)
                                                .addGap(35, 35, 35)
                                                .addComponent(jRadioButton3)
                                                .addGap(28, 28, 28)
                                                .addComponent(feessubmit))
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(feesLabel)))
                                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton3)
                                        .addComponent(feessubmit))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                                .addComponent(feesLabel)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Fees ", jPanel10);

        jLabel4.setText("Old");

        jLabel5.setText("New Mobile");

        submitMobile.setText("Submit");
        submitMobile.addActionListener(this::submitMobileActionPerformed);

        MobileLable.setText("...............");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                        .addComponent(jFormattedTextField2))
                                .addGap(144, 144, 144))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(225, 225, 225)
                                                .addComponent(submitMobile))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(MobileLable)))
                                .addContainerGap(259, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addComponent(submitMobile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                                .addComponent(MobileLable)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Mobile", jPanel11);

        jLabel1.setText("Student ID");

        jLabel2.setText("Name");

        StudentLoginByMang.setText("Login");
        StudentLoginByMang.addActionListener(this::StudentLoginByMangActionPerformed);

        LoginLabel.setText(".............");

        javax.swing.GroupLayout studentloginLayout = new javax.swing.GroupLayout(studentlogin);
        studentlogin.setLayout(studentloginLayout);
        studentloginLayout.setHorizontalGroup(
                studentloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(studentloginLayout.createSequentialGroup()
                                .addGroup(studentloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(studentloginLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(LoginLabel))
                                        .addGroup(studentloginLayout.createSequentialGroup()
                                                .addGap(220, 220, 220)
                                                .addComponent(StudentLoginByMang)))
                                .addContainerGap(272, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentloginLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(studentloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addGap(58, 58, 58)
                                .addGroup(studentloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                        .addComponent(jFormattedTextField4))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        studentloginLayout.setVerticalGroup(
                studentloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(studentloginLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(studentloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(studentloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(StudentLoginByMang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                                .addComponent(LoginLabel)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Login", studentlogin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );

        pack();
    }

    private void submitDOBActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update from students set sdob=? where sid=?");
            stm.setObject(1, LocalDate.of(Integer.parseInt(jComboBox6.getSelectedItem().toString()), Integer.parseInt(jComboBox5.getSelectedItem().toString()), Integer.parseInt(jComboBox4.getSelectedItem().toString())));
            stm.setInt(2, Integer.parseInt(jTextField1.getText()));
            stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(updateexiststdt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void responseNameActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update from students set sname=? where sid=?");
            stm.setString(1, jTextField3.getText());
            stm.setInt(2, Integer.parseInt(jTextField1.getText()));
            stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(updateexiststdt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void branchSubmitActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update from students set sbranch=? where sid=?");
            stm.setByte(1, Byte.parseByte(jComboBox2.getSelectedItem().toString()));
            stm.setInt(2, Integer.parseInt(jTextField1.getText()));
            stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(updateexiststdt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void scholrbuttonActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update from students set scholarship where sid=?");
            if (jRadioButton6.isSelected()) {
                scholar = true;
            } else if (jRadioButton7.isSelected()) {
                scholar = false;
            }
            stm.setBoolean(1, scholar);
            stm.setInt(2, Integer.parseInt(jTextField1.getText()));
            stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(updateexiststdt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void SemsubmitActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update from students set semester=? where sid=?");
            stm.setByte(1, Byte.parseByte(jComboBox2.getSelectedItem().toString()));
            stm.setInt(2, Integer.parseInt(jTextField1.getText()));
            stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(updateexiststdt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void feessubmitActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update from students where sid=? and password=?");
            if (jRadioButton2.isSelected()) {
                fees = "paid";
            } else {
                fees = "unpaid";
            }
            stm.setString(1, fees);
            stm.setInt(2, Integer.parseInt(jTextField1.getText()));
            stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(updateexiststdt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void submitaddrActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update from students set scity=?,sstate=?,saddr=?  where sid=?");
            stm.setString(1, jFormattedTextField3.getText());
            stm.setString(2, jTextField2.getText());
            stm.setString(3, jTextArea1.getText());
            stm.setInt(2, Integer.parseInt(jTextField1.getText()));
            stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(updateexiststdt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void submityearActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update  students set syear=?  where sid=?");
            stm.setString(1, jComboBox1.getSelectedItem().toString());
            stm.setInt(2, Integer.parseInt(jTextField1.getText()));
            stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(updateexiststdt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void submitattendanceActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update from students set attendance=? where sid=?");
            if (jRadioButton4.isSelected()) {
                stm.setBoolean(1, false);
                stm.setInt(2, Integer.parseInt(jTextField1.getText()));
                stm.executeUpdate();
            } else {
                stm.setBoolean(1, true);
                stm.setInt(2, Integer.parseInt(jTextField1.getText()));
                stm.executeUpdate();
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(updateexiststdt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void submitMobileActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update students set mobileno=? where sid=?;");
            stm.setLong(1, Long.parseLong(jFormattedTextField2.getText()));
            stm.setInt(2, Integer.parseInt(jTextField1.getText()));
            stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(updateexiststdt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void StudentLoginByMangActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("select sid,sname from students where sid=? and sname=?;");
            stm.setInt(1, Integer.parseInt(jTextField1.getText()));
            stm.setString(2, jFormattedTextField4.getText());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                LoginLabel.setText("Login Succesful");
                break;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(updateexiststdt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private JLabel AttendanceLabel;
    private JLabel LoginLabel;
    private JLabel MobileLable;
    private JButton Semsubmit;
    private JButton StudentLoginByMang;
    private JLabel addressLabel;
    private JButton branchSubmit;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private JLabel feesLabel;
    private JButton feessubmit;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JComboBox<String> jComboBox3;
    private JComboBox<String> jComboBox4;
    private JComboBox<String> jComboBox5;
    private JComboBox<String> jComboBox6;
    private JFormattedTextField jFormattedTextField1;
    private JFormattedTextField jFormattedTextField2;
    private JFormattedTextField jFormattedTextField3;
    private JFormattedTextField jFormattedTextField4;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel17;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JList<String> jList1;
    private JList<String> jList2;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel2;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private JRadioButton jRadioButton5;
    private JRadioButton jRadioButton6;
    private JRadioButton jRadioButton7;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JLabel nameLAbel;
    private JButton responseName;
    private JButton scholrbutton;
    private JPanel studentlogin;
    private JButton submitDOB;
    private JButton submitMobile;
    private JButton submitaddr;
    private JButton submitattendance;
    private JButton submityear;
}

////////////////////////////////////////////////////// Enroll new student/////////////////////////////////////////////////
class enrollNewStudent extends javax.swing.JInternalFrame {

    static String gender, yearlt;
    static boolean sc;

    public enrollNewStudent() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addr = new javax.swing.JTextArea();
        name = new javax.swing.JTextField();
        day = new javax.swing.JComboBox<>();
        month = new javax.swing.JComboBox<>();
        year = new javax.swing.JComboBox<>();
        city = new javax.swing.JTextField();
        state = new javax.swing.JComboBox<>();
        semester = new javax.swing.JComboBox<>();
        cast = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        branch = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        mobile = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        changes = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Enrollnment");

        jLabel1.setText("Name");

        jLabel2.setText("DOB");

        jLabel3.setText("State");

        jLabel4.setText("Gender");

        jLabel5.setText("Cast");

        jLabel6.setText("Password");

        jLabel7.setText("Scholarship");

        jLabel9.setText("City");

        jLabel10.setText("Branch");

        jLabel11.setText("Semester");

        addr.setColumns(20);
        addr.setRows(5);
        addr.setText("Complete Addresss");
        jScrollPane1.setViewportView(addr);

        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "29", "30", "31"}));

        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1999", "2001", "2000", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"}));

        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Andhra Pradesh", "Arunchal Pradesh", "Assam", "Bihar", "Chattisgarh", "Goa", "Gujrat", "Haryana", "Himachal Pardesh", "Jharkahand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghayala", "Nagaland", "Orrisa", "Punjab", "Rajsathan", "Sikkim", "Tamil Nadu"}));

        semester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}));

        cast.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"SC", "ST", "OBC", "UR"}));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Yes");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("No");

        branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"CS", "EC", "ME", "CE"}));

        mobile.setText("Mobile Number");

        jButton1.setText("Submit");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        changes.setColumns(20);
        changes.setRows(5);
        jScrollPane2.setViewportView(changes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel3)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel2))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(119, 119, 119)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel10))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(112, 112, 112)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel5))
                                                                .addGap(43, 43, 43)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jRadioButton1)
                                                                                        .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jRadioButton3))
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(cast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addComponent(jPasswordField1)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(413, 413, 413)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jRadioButton2)
                                                                .addComponent(jRadioButton4))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButton1))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel2)
                                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel3)
                                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jRadioButton4))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel9)
                                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addGap(47, 47, 47))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jRadioButton1)
                                                                        .addComponent(jRadioButton2))
                                                                .addGap(25, 25, 25)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(cast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 99, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Calendar cl = Calendar.getInstance(TimeZone.getDefault());
            if (jRadioButton3.isSelected()) {
                sc = true;
            } else if (jRadioButton4.isSelected()) {
                sc = false;
            }
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement(" insert into Students "
                    + "("
                    + "	sName,"
                    + "	sDOB,"
                    + "	sBranch,"
                    + "	scholarship,"
                    + "	gender,"
                    + "	castype,"
                    + "	spassword,"
                    + "	scity,"
                    + "	sstate,"
                    + "	sAddr,"
                    + "	joinDate,"
                    + "	currentDate,"
                    + "	semester,"
                    + "	mobileNo,"
                    + "	Attendance,"
                    + "	feestatus,"
                    + "           syear       "
                    + ")values"
                    + "("
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "	?,"
                    + "            ? "
                    + ");"
            );
            if (jRadioButton1.isSelected()) {
                gender = "male";
            } else if (jRadioButton2.isSelected()) {
                gender = "female";
            }

            stm.setString(1, name.getText());
            stm.setObject(2, LocalDate.of(Integer.parseInt(year.getSelectedItem().toString()), Integer.parseInt(month.getSelectedItem().toString()), Integer.parseInt(day.getSelectedItem().toString())));
            stm.setString(3, branch.getSelectedItem().toString());
            stm.setBoolean(4, sc);
            stm.setString(5, gender);
            stm.setString(6, cast.getSelectedItem().toString());
            stm.setString(7, new String(jPasswordField1.getPassword()));
            stm.setString(8, state.getSelectedItem().toString());
            stm.setString(9, city.getText());
            stm.setString(10, addr.getText());
            stm.setObject(11, LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH), cl.get(Calendar.DATE)));
            stm.setObject(12, LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH), cl.get(Calendar.DATE)));
            stm.setByte(13, Byte.parseByte(semester.getSelectedItem().toString()));
            stm.setLong(14, Long.parseLong(mobile.getText()));
            stm.setBoolean(15, false);
            stm.setString(16, "unpaid");

            yearlt = switch (Byte.parseByte(semester.getSelectedItem().toString())) {
                case 1, 2 ->
                    "First";
                case 3, 4 ->
                    "Second";
                case 5, 6 ->
                    "Third";
                default ->
                    "Fourth";
            };

            stm.setString(17, yearlt);
            stm.executeUpdate();
            Class.forName("org.postgresql.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm1 = con1.prepareStatement("select sid from students where spassword=? and sName=? and mobileNo=?;"); //change logic
            stm1.setString(1, String.valueOf(jPasswordField1.getPassword()));
            stm1.setString(2, name.getText());
            stm1.setLong(3, Long.parseLong(mobile.getText()));
            ResultSet rs1 = stm1.executeQuery();
            if (rs1.next()) {
                changes.setText("Succesfully Registered \n");
                changes.append("UserID \"" + rs1.getInt("sid") + "\"\n");
            }
            changes.append("Password  \"" + String.valueOf(jPasswordField1.getPassword()) + "\"");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnrollNewFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private javax.swing.JTextArea addr;
    private javax.swing.JComboBox<String> branch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cast;
    private javax.swing.JTextArea changes;
    private javax.swing.JTextField city;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mobile;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> semester;
    private javax.swing.JComboBox<String> state;
    private javax.swing.JComboBox<String> year;
}

class updatebyManagement extends JFrame {

    public updatebyManagement() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        update = new javax.swing.JRadioButton();
        enroll = new javax.swing.JRadioButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(update);
        update.setText("Update Existing Student ");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        buttonGroup1.add(enroll);
        enroll.setText("Enroll New Student");
        enroll.addActionListener(this::enrollActionPerformed);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 835, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(enroll)
                                        .addComponent(update))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(update)
                                .addGap(11, 11, 11)
                                .addComponent(enroll)
                                .addContainerGap(545, Short.MAX_VALUE))
                        .addComponent(jDesktopPane1)
        );

        pack();
    }

    private void enrollActionPerformed(ActionEvent evt) {

        enrollNewStudent enroll = new enrollNewStudent();
        jDesktopPane1.add(enroll);
        enroll.setVisible(true);
    }

    private void updateMouseClicked(MouseEvent evt) {
        updateexiststdt usd = new updateexiststdt();
        jDesktopPane1.add(usd);
        usd.setVisible(true);
    }
    private ButtonGroup buttonGroup1;
    private JRadioButton enroll;
    private JDesktopPane jDesktopPane1;
    private JRadioButton update;
}

class AfterManagementlogin extends JFrame {

    static String pass, name;
    static int userid;

    public AfterManagementlogin(int Userid, String Password, String Type) {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        title = new JTextField();
        student = new JButton();
        faculty = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        title.setText("WELCOME TO MANAGEMENT SECTION....");

        student.setText("STUDENT");
        student.addActionListener(this::studentActionPerformed);

        faculty.setText("FACULTY");
        faculty.addActionListener(this::facultyActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(student, GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                                .addComponent(faculty, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGap(320, 320, 320))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addGap(244, 244, 244)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(student)
                                        .addComponent(faculty))
                                .addContainerGap(247, Short.MAX_VALUE))
        );

        pack();
    }

    private void studentActionPerformed(ActionEvent evt) {
        MyProject.updatebyManage();
    }

    private void facultyActionPerformed(ActionEvent evt) {
        MyProject.FacultyUpdateByManage();
    }
    private javax.swing.JButton faculty;
    private javax.swing.JButton student;
    private javax.swing.JTextField title;
}

/********************************************************************Working*****************************************************/
class FacultyClass extends JFrame {

    public FacultyClass() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 519, Short.MAX_VALUE)
        );

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Update Existing Faculty");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Appoint New Faculty");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(503, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {
        UpdateExitingFaculty uef = new UpdateExitingFaculty();
        jDesktopPane1.add(uef);
        uef.setVisible(true);
    }

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {
        EnrollNewFaculty eF = new EnrollNewFaculty();
        jDesktopPane1.add(eF);
        eF.setVisible(true);
    }

    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
}

class EnrollNewFaculty extends JInternalFrame {

    static String gender;

    public EnrollNewFaculty() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Dob_Day = new javax.swing.JComboBox<>();
        Dob_month = new javax.swing.JComboBox<>();
        Dob_year = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        joinDay = new javax.swing.JComboBox<>();
        joinMonth = new javax.swing.JComboBox<>();
        joinYear = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        state = new javax.swing.JComboBox<>();
        city = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        salary = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        experience = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        post = new javax.swing.JComboBox<>();
        addr = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        mobilenumber = new javax.swing.JTextField();
        result = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTree1);

        jTextField3.setText("jTextField3");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Name");

        jLabel2.setText("DOB");

        Dob_Day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

        Dob_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

        Dob_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2021"}));

        jLabel3.setText("Address");

        jLabel4.setText("Join Date");

        joinDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

        joinMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

        joinYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2021"}));

        jLabel5.setText("State");

        jLabel6.setText("City");

        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Andhra Pradesh", "Arunchal Pradesh", "Assam", "Bihar", "Chattisgarh", "Goa", "Gujrat", "Haryana", "Himachal Pardesh", "Jharkahand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghayala", "Nagaland", "Orrisa", "Punjab", "Rajsathan", "Sikkim", "Tamil Nadu"}));

        jLabel7.setText("Password");

        jLabel8.setText("Salary");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");

        jLabel9.setText("Experience");

        jLabel10.setText("Post");

        post.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Asst. Prof", "Prof", "Normal", "Supporter", "Temporay"}));

        jLabel11.setText("Mobile Number");

        result.setText("Submit");
        result.addActionListener(this::resultActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(61, 61, 61)
                                                .addComponent(result)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(Dob_Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Dob_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Dob_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(joinDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(joinMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(joinYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(55, 55, 55)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel10)
                                                                                                .addGap(41, 41, 41)
                                                                                                .addComponent(post, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel11)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(mobilenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel3)
                                                                                                .addGap(44, 44, 44)
                                                                                                .addComponent(addr, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                                        .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(78, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(jLabel9))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jRadioButton1)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jRadioButton2)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addComponent(experience, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(89, 89, 89))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jRadioButton1)
                                                        .addComponent(jRadioButton2)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Dob_Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(Dob_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Dob_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(experience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(joinDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(joinYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(joinMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(addr, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11)
                                        .addComponent(mobilenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10)
                                        .addComponent(post, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(result)
                                .addGap(33, 33, 33))
        );

        pack();
    }

    private void resultActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement(" insert into faculty ("
                    + "	fname,"
                    + "	fdob,"
                    + "	fsalary,"
                    + "	fpassword,"
                    + "	fcity,"
                    + "	fstate,"
                    + "	faddr,"
                    + "	joindate,"
                    + "	currentDate,"
                    + "	fexperience,"
                    + "	mobileno,"
                    + "	post,"
                    + "	attendance,"
                    + "	gender,"
                    + "	salarystatus) "
                    + "	values"
                    + "	("
                    + "		?,"
                    + "		?,"
                    + "		?,"
                    + "		?,"
                    + "		?,"
                    + "		?,"
                    + "		?,"
                    + "		?,"
                    + "		current_date,"
                    + "		?,"
                    + "		?,"
                    + "		?,"
                    + "		?,"
                    + "		?,"
                    + "		?)"
            );
            if (jRadioButton1.isSelected()) {
                gender = "male";
            } else if (jRadioButton2.isSelected()) {
                gender = "female";
            }

            stm.setString(1, name.getText());
            stm.setObject(2, LocalDate.of(Integer.parseInt(Dob_year.getSelectedItem().toString()), Integer.parseInt(Dob_month.getSelectedItem().toString()), Integer.parseInt(Dob_Day.getSelectedItem().toString())));
            stm.setInt(3, Integer.parseInt(salary.getText()));
            stm.setString(4, new String(jPasswordField1.getPassword()));
            stm.setString(5, city.getText());
            stm.setString(6, state.getSelectedItem().toString());
            stm.setString(7, addr.getText());
            stm.setObject(8, LocalDate.of(Integer.parseInt(joinYear.getSelectedItem().toString()), Integer.parseInt(joinMonth.getSelectedItem().toString()), Integer.parseInt(joinDay.getSelectedItem().toString())));
            stm.setByte(9, Byte.parseByte(experience.getValue().toString()));
            stm.setLong(10, Long.parseLong(mobilenumber.getText()));
            stm.setString(11, post.getSelectedItem().toString());
            stm.setBoolean(12, false);
            stm.setString(13, gender);
            stm.setString(14, "unpaid");
            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnrollNewFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private javax.swing.JComboBox<String> Dob_Day;
    private javax.swing.JComboBox<String> Dob_month;
    private javax.swing.JComboBox<String> Dob_year;
    private javax.swing.JTextField addr;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField city;
    private javax.swing.JSpinner experience;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTree jTree1;
    private javax.swing.JComboBox<String> joinDay;
    private javax.swing.JComboBox<String> joinMonth;
    private javax.swing.JComboBox<String> joinYear;
    private javax.swing.JTextField mobilenumber;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> post;
    private javax.swing.JButton result;
    private javax.swing.JTextField salary;
    private javax.swing.JComboBox<String> state;
}

///////////////////////////////////////// Update Existing Faculty////////////////////////////////////////////////////////////
class UpdateExitingFaculty extends JInternalFrame {

    static boolean salSat;
    static String sal;

    public UpdateExitingFaculty() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTextField3 = new JTextField();
        buttonGroup1 = new ButtonGroup();
        jRadioButton3 = new JRadioButton();
        buttonGroup2 = new ButtonGroup();
        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        loginName = new JTextField();
        userIdLogin = new JTextField();
        SubmitLogin = new JButton();
        jPanel2 = new JPanel();
        jLabel3 = new JLabel();
        Newname = new JTextField();
        submitButton = new JButton();
        jLabel4 = new JLabel();
        jPanel3 = new JPanel();
        jComboBox1 = new JComboBox<>();
        jComboBox2 = new JComboBox<>();
        jComboBox3 = new JComboBox<>();
        okDOB = new JButton();
        jPanel4 = new JPanel();
        jLabel5 = new JLabel();
        jTextField1 = new JTextField();
        okSalary = new JButton();
        jPanel5 = new JPanel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jComboBox4 = new JComboBox<>();
        jTextField2 = new JTextField();
        jTextField4 = new JTextField();
        okAddress = new JButton();
        jPanel6 = new JPanel();
        jComboBox5 = new JComboBox<>();
        okPost = new JButton();
        jPanel7 = new JPanel();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        okAttendance = new JButton();
        jPanel8 = new JPanel();
        jRadioButton4 = new JRadioButton();
        jRadioButton5 = new JRadioButton();
        okSalaryStatus = new JButton();
        jPanel9 = new JPanel();
        jLabel9 = new JLabel();
        jTextField5 = new JTextField();
        mobileok = new JButton();

        jTextField3.setText("jTextField3");

        jRadioButton3.setText("jRadioButton3");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Name");

        jLabel2.setText("Userid");

        SubmitLogin.setText("Submit");
        SubmitLogin.addActionListener(this::SubmitLoginActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(167, 167, 167)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(userIdLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                                        .addComponent(loginName)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(192, 192, 192)
                                                .addComponent(SubmitLogin)))
                                .addContainerGap(297, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(loginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(userIdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(SubmitLogin)
                                .addContainerGap(213, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Login", jPanel1);

        jLabel3.setText("New Name");

        submitButton.setText("Submit");
        submitButton.addActionListener(this::submitButtonActionPerformed);

        jLabel4.setText("......................................");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addComponent(jLabel3)
                                                .addGap(36, 36, 36)
                                                .addComponent(Newname, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(submitButton))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel4)))
                                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(Newname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(submitButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Name", jPanel2);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000"}));

        okDOB.setText("ok");
        okDOB.addActionListener(this::okDOBActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(okDOB)
                                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(okDOB))
                                .addContainerGap(293, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DOB", jPanel3);

        jLabel5.setText("Update Salary");

        okSalary.setText("ok");
        okSalary.addActionListener(this::okSalaryActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jLabel5)
                                .addGap(37, 37, 37)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(okSalary)
                                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(okSalary))
                                .addContainerGap(267, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Salary", jPanel4);

        jLabel6.setText("city");

        jLabel7.setText("state");

        jLabel8.setText("Address");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Andhra Pradesh", "Arunchal Pradesh", "Assam", "Bihar", "Chhatisgarh", "Goa", "Gujrat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharastra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"}));

        okAddress.setText("ok");
        okAddress.addActionListener(this::okAddressActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(114, 114, 114)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jLabel6))
                                                                .addGap(32, 32, 32)
                                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jTextField2)))))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addComponent(okAddress)))
                                .addContainerGap(250, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(okAddress)
                                .addContainerGap(178, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Address", jPanel5);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Asst. Prof", "Prof", "Normal", "Supporter", "Temporay"}));

        okPost.setText("ok");
        okPost.addActionListener(this::okPostActionPerformed);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(okPost)
                                .addContainerGap(306, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(okPost))
                                .addContainerGap(294, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Post", jPanel6);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Present");
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Absent");

        okAttendance.setText("ok");
        okAttendance.addActionListener(this::okAttendanceActionPerformed);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(141, 141, 141)
                                                .addComponent(jRadioButton1)
                                                .addGap(43, 43, 43)
                                                .addComponent(jRadioButton2))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(202, 202, 202)
                                                .addComponent(okAttendance)))
                                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2))
                                .addGap(27, 27, 27)
                                .addComponent(okAttendance)
                                .addContainerGap(217, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Attendance", jPanel7);

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Paid");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Unpaid");

        okSalaryStatus.setText("ok");
        okSalaryStatus.addActionListener(this::okSalaryStatusActionPerformed);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addContainerGap(211, Short.MAX_VALUE)
                                .addComponent(jRadioButton4)
                                .addGap(39, 39, 39)
                                .addComponent(jRadioButton5)
                                .addGap(243, 243, 243))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(okSalaryStatus)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton5)
                                        .addComponent(jRadioButton4))
                                .addGap(26, 26, 26)
                                .addComponent(okSalaryStatus)
                                .addContainerGap(204, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Salary Status", jPanel8);

        jLabel9.setText("New Number");

        mobileok.setText("ok");
        mobileok.addActionListener(this::mobileokActionPerformed);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(151, 151, 151)
                                                .addComponent(jLabel9)
                                                .addGap(30, 30, 30)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(217, 217, 217)
                                                .addComponent(mobileok)))
                                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(mobileok)
                                .addContainerGap(234, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mobile", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );

        pack();
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update Faculty set fname=? where fid=?");
            stm.setString(1, Newname.getText());
            stm.setInt(2, Integer.parseInt(userIdLogin.getText()));
            stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateExitingFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void SubmitLoginActionPerformed(ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("select fid,fname from Faculty where fId=?");
            stm.setInt(1, Integer.parseInt(userIdLogin.getText()));
            ResultSet rs = stm.executeQuery();
            /* Not Complete yaha pe nayaclass banana padega or batana padega login succesful login fail
             */

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateExitingFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void okDOBActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update faculty set fdob=? where fid=?");
            stm.setObject(1, LocalDate.of(Integer.parseInt(jComboBox3.getSelectedItem().toString()), Integer.parseInt(jComboBox2.getSelectedItem().toString()), Integer.parseInt(jComboBox1.getSelectedItem().toString())));
            stm.setInt(2, Integer.parseInt(userIdLogin.getText()));
            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateExitingFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void okSalaryActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update  faculty set fsalary=? where fid=?");
            stm.setInt(1, Integer.parseInt(jTextField1.getText()));
            stm.setInt(2, Integer.parseInt(userIdLogin.getText()));
            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateExitingFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void okAddressActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update  faculty set fcity=?,fstate=?,faddr=? where fid=?");
            stm.setString(1, jTextField2.getText());
            stm.setString(2, jComboBox4.getSelectedItem().toString());
            stm.setString(3, jTextField4.getText());
            stm.setInt(4, Integer.parseInt(userIdLogin.getText()));
            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateExitingFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void okPostActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update  faculty set post=? where fid=?");
            stm.setString(1, jComboBox5.getSelectedItem().toString());
            stm.setInt(2, Integer.parseInt(userIdLogin.getText()));
            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateExitingFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void okAttendanceActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update  faculty set attendance=? where fid=?");

            if (jRadioButton1.isSelected()) {
                salSat = true;
            } else if (jRadioButton2.isSelected()) {
                salSat = false;
            }
            stm.setBoolean(1, salSat);
            stm.setInt(2, Integer.parseInt(userIdLogin.getText()));
            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateExitingFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void okSalaryStatusActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update  faculty set salarystatus=? where fid=?");

            if (jRadioButton4.isSelected()) {
                sal = "paid";
            } else {
                sal = "unpaid";
            }
            stm.setString(1, sal);
            stm.setInt(2, Integer.parseInt(userIdLogin.getText()));
            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateExitingFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mobileokActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adina", "postgres", "root");
            PreparedStatement stm = con.prepareStatement("update faculty set mobileno=? where fid=?");
            stm.setLong(1, Long.parseLong(jTextField5.getText()));
            stm.setInt(2, Integer.parseInt(userIdLogin.getText()));
            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateExitingFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private JTextField Newname;
    private JButton SubmitLogin;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JComboBox<String> jComboBox3;
    private JComboBox<String> jComboBox4;
    private JComboBox<String> jComboBox5;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private JRadioButton jRadioButton5;
    private JTabbedPane jTabbedPane1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField loginName;
    private javax.swing.JButton mobileok;
    private JButton okAddress;
    private JButton okAttendance;
    private JButton okDOB;
    private JButton okPost;
    private JButton okSalary;
    private JButton okSalaryStatus;
    private JButton submitButton;
    private JTextField userIdLogin;
}
