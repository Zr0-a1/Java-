import javax.swing.*; 
import javax.swing.table.DefaultTableModel; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.Date;

public class StudentPanel extends JFrame { 
    private JTextField txtPhoneNumber, txtDob; 
    private JButton btnCheck; 
    private JTable tableStudentDetails;
    
    public StudentPanel() {
    setTitle("Student Panel"); 
    setSize(600, 400); 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setLayout(new BorderLayout());
    
    JPanel inputPanel = new JPanel(); 
    inputPanel.setLayout(new GridLayout(3, 2, 10, 10));

    JLabel lblPhoneNumber = new JLabel("Phone Number:"); 
    inputPanel.add(lblPhoneNumber);

    txtPhoneNumber = new JTextField(); 
    inputPanel.add(txtPhoneNumber);

    JLabel lblDob = new JLabel("Date of Birth (yyyy-MM-dd):"); 
    inputPanel.add(lblDob);

    txtDob = new JTextField(); 
    inputPanel.add(txtDob);

    btnCheck = new JButton("Check Registration"); 
    inputPanel.add(btnCheck);

    JPanel tablePanel = new JPanel(); 
    tablePanel.setLayout(new BorderLayout());

    tableStudentDetails = new JTable(); 
    tablePanel.add(new JScrollPane(tableStudentDetails), BorderLayout.CENTER);

    add(inputPanel, BorderLayout.NORTH); 
    add(tablePanel, BorderLayout.CENTER);

    btnCheck.addActionListener(new ActionListener() {
         @Override 
         public void actionPerformed(ActionEvent e) {
             String phoneNumber = txtPhoneNumber.getText().trim(); 
             String dobStr = txtDob.getText().trim();

             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
             Date dob = null;
             try {
                dob = sdf.parse(dobStr); 
            } catch (ParseException parseException) {
                JOptionPane.showMessageDialog(null, "Invalid Date format. Please use yyyy- MM-dd."); 
                return; 
            }

            String url = "jdbc:mariadb://localhost:3306/StudentsDB"; 
            String user = "root"; 
            String password = "4567";

            try {Class.forName("org.mariadb.jdbc.Driver"); 
            try (Connection conn = DriverManager.getConnection(url, user, password); 
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Students WHERE phone_number = ? AND dob = ?")) {

                stmt.setString(1, phoneNumber); 
                stmt.setDate(2, new java.sql.Date(dob.getTime()));

                ResultSet rs = stmt.executeQuery();

                DefaultTableModel model = new DefaultTableModel(); 
                model.addColumn("Field"); 
                model.addColumn("Value");


            if (rs.next()) { 
                model.addRow(new Object[]{"First Name", rs.getString("first_name")}); 
                model.addRow(new Object[]{"Last Name", rs.getString("last_name")}); 
                model.addRow(new Object[]{"Date of Birth", rs.getDate("dob")}); 
                model.addRow(new Object[]{"Phone Number", rs.getString("phone_number")});
                model.addRow(new Object[]{"Gender", rs.getString("gender")}); 
                model.addRow(new Object[]{"Email", rs.getString("email")}); 
                model.addRow(new Object[]{"Address", rs.getString("address")});
            } else {
                 JOptionPane.showMessageDialog(null, "No student found with the provided phone number and date of birth.");
                }
            tableStudentDetails.setModel(model);
        } catch (Exception ex) { 
            ex.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "Error retrieving data from the database."); 
        }} catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "MariaDB JDBC Driver not found.");
        }
    } 
}
); 
}public static void main(String[] args) { 
    SwingUtilities.invokeLater(() -> { 
        StudentPanel studentPanel = new StudentPanel(); 
        studentPanel.setVisible(true); }); 
    } 
}


