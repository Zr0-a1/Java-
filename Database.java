import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Database {

    // Database connection
    final String DB_URL = "jdbc:mariadb://localhost/BCA";
       final String USERNAME = "root";
       final String PASSWORD = "4567";
    

       Connection con;
        // Connection to initialize The Gui and database

        public Database(){
            
            // Establish database connection 
            try{
                con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            JFrame frame = new JFrame("Database");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,700);
            frame.setLayout(null);


            JLabel RollLabel = new JLabel("Rollno:");
            RollLabel.setBounds(50, 50, 100, 30);
            frame.add(RollLabel);

            JTextField RollField =new JTextField();
            RollField.setBounds(150,50,200,30);
            frame.add(RollField);

            JLabel NameLabel = new JLabel("Name:");
            NameLabel.setBounds(50, 100, 100, 30);
            frame.add(NameLabel);

            JTextField NameField = new JTextField();
            NameField.setBounds(150, 100, 200, 30);
            frame.add(NameField);

            JLabel AgeLabel = new JLabel("Age");
            AgeLabel.setBounds(50, 150, 100, 30);
            frame.add(AgeLabel);

            JTextField AgeField = new JTextField();
            AgeField.setBounds(150, 150, 200, 30);
            frame.add(AgeField);

            JButton ClearButton = new JButton("Clear");
            ClearButton.setBounds(50, 200, 80, 30);
            frame.add(ClearButton);
            
            JButton SaveButton = new JButton("Save");
            SaveButton.setBounds(140, 200, 80,30);
            frame.add(SaveButton);

            JButton EditButton = new JButton("Edit");
            EditButton.setBounds(230, 200, 80, 30);
            frame.add(EditButton);

            JButton DeleteButton = new JButton("Delete");
            DeleteButton.setBounds(320, 200, 80, 30);
            frame.add(DeleteButton);
            
            JButton FindButton = new JButton("Find");
            FindButton.setBounds(230, 50, 80, 30);
            frame.add(FindButton);
            
            ClearButton.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e){
                    RollField.setText("");
                    NameField.setText("");
                    AgeField.setText("");
                }
            });

            SaveButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String rollno = RollField.getText();
                    String name = NameField.getText();
                    String age = AgeField.getText();

                    try(
                        con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                        PreparedStatement pstmt = con.prepareStatement(age)
                    )
                }
            });
        }
}
