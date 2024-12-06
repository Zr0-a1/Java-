import javax.swing.*; 
import java.awt.event.*; 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.Date;

public class AdminPanel extends JFrame {
    private JTextField txtFirstName, txtLastName, txtPhoneNumber, txtEmail, txtAddress, txtDob; 
    private JRadioButton rdbMale, rdbFemale; 
    private ButtonGroup genderGroup; 
    private JButton btnInsert;

    public AdminPanel() { 
        setTitle("Admin Panel"); 
        setSize(500, 500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);

        // First Name Label and Field
        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(10, 20, 100, 25);
        add(lblFirstName);

        txtFirstName = new JTextField(); 
        txtFirstName.setBounds(120, 20, 250, 25);
        add(txtFirstName);

        // Last Name Label and Field
        JLabel lblLastName = new JLabel("Last Name:"); 
        lblLastName.setBounds(10, 60, 100, 25);
        add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(120, 60, 250, 25);
        add(txtLastName);

        // Date of Birth Label and Field
        JLabel lblDob = new JLabel("Date of Birth:"); 
        lblDob.setBounds(10, 100, 150, 25);
        add(lblDob);

        txtDob = new JTextField("yyyy-mm-dd"); 
        txtDob.setBounds(120, 100, 200, 25); 
        txtDob.addFocusListener(new FocusAdapter() { 
            @Override 
            public void focusGained(FocusEvent e) {
                if (txtDob.getText().equals("yyyy-mm-dd")) {
                    txtDob.setText("");
                }
            }
            @Override 
            public void focusLost(FocusEvent e) {
                if (txtDob.getText().isEmpty()) { 
                    txtDob.setText("yyyy-mm-dd"); 
                } 
            } 
        });
        add(txtDob);

        // Phone Number Label and Field
        JLabel lblPhoneNumber = new JLabel("Phone Number:"); 
        lblPhoneNumber.setBounds(10, 140, 100, 25);
        add(lblPhoneNumber);

        txtPhoneNumber = new JTextField(); 
        txtPhoneNumber.setBounds(120, 140, 250, 25);
        add(txtPhoneNumber);

        // Gender Label and Radio Buttons
        JLabel lblGender = new JLabel("Gender:"); 
        lblGender.setBounds(10, 180, 100, 25);
        add(lblGender);

        rdbMale = new JRadioButton("Male"); 
        rdbMale.setBounds(120, 180, 60, 25);
        add(rdbMale);

        rdbFemale = new JRadioButton("Female");
        rdbFemale.setBounds(190, 180, 80, 25);
        add(rdbFemale);

        // Group the radio buttons
        genderGroup = new ButtonGroup(); 
        genderGroup.add(rdbMale); 
        genderGroup.add(rdbFemale);

        // Email Label and Field
        JLabel lblEmail = new JLabel("Email:"); 
        lblEmail.setBounds(10, 220, 100, 25);
        add(lblEmail);

        txtEmail = new JTextField(); 
        txtEmail.setBounds(120, 220, 250, 25);
        add(txtEmail);

        // Address Label and Field
        JLabel lblAddress = new JLabel("Address:"); 
        lblAddress.setBounds(10, 260, 100, 25);
        add(lblAddress);

        txtAddress = new JTextField(); 
        txtAddress.setBounds(120, 260, 250, 25);
        add(txtAddress);

        // Insert button
        btnInsert = new JButton("Insert"); 
        btnInsert.setBounds(150, 300, 100, 25); 
        add(btnInsert);

        // Action listener for the Insert button 
        btnInsert.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                String firstName = txtFirstName.getText(); 
                String lastName = txtLastName.getText(); 
                String dobStr = txtDob.getText(); 
                String phoneNumber = txtPhoneNumber.getText(); 
                String gender = rdbMale.isSelected() ? "Male" : rdbFemale.isSelected() ? "Female" : null; 
                String email = txtEmail.getText(); 
                String address = txtAddress.getText();

                // Date parsing
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
                Date dob = null; 
                try {
                    dob = dateFormat.parse(dobStr);
                } catch (ParseException ex) { 
                    JOptionPane.showMessageDialog(null, "Please enter a valid date in yyyy-MM-dd format.");
                    return; 
                }

                // Create a Student object and set its properties 
                Student student = new Student(); 
                student.setFirstName(firstName); 
                student.setLastName(lastName); 
                student.setDob(dob); 
                student.setPhoneNumber(phoneNumber); 
                student.setGender(gender); 
                student.setEmail(email); 
                student.setAddress(address);

                // Save the student information to the database 
                student.saveToDatabase(); 
                JOptionPane.showMessageDialog(null, "Student information saved to the database.");

                // Reset all fields 
                txtFirstName.setText(""); 
                txtLastName.setText(""); 
                txtDob.setText("yyyy-mm-dd"); 
                txtPhoneNumber.setText("");
                genderGroup.clearSelection(); 
                txtEmail.setText(""); 
                txtAddress.setText(""); 
            } 
        });
    }

    public static void main(String[] args) {
        AdminPanel admin = new AdminPanel();
        admin.setVisible(true); 
    }
}
