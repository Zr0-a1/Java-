import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.Date; 

public class Student implements java.io.Serializable { 
    private String firstName; 
    private String lastName; 
    private Date dob; 
    private String phoneNumber; 
    private String gender; 
    private String email; 
    private String address; 
    public ArrayList<MessageListener> listeners = new ArrayList<>();
    public String getFirstName() {
         return firstName; 
        }
    public void setFirstName(String firstName) {
         this.firstName = firstName; 
        }
    public String getLastName() {
         return lastName; 
    }
    public void setLastName(String lastName) {
         this.lastName = lastName; 
        }
    public Date getDob() { 
        return dob; 
    }
    public void setDob(Date dob) {
         this.dob = dob; 
    }
    public String getPhoneNumber() {
         return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
         this.phoneNumber = phoneNumber; 
    }
    public String getGender() {
         return gender; 
    }
    public void setGender(String gender) {
         this.gender = gender; 
    }
    public String getEmail() {
         return email; 
    }
    public void setEmail(String email) {
         this.email = email; 
    }
    public String getAddress() { 
        return address; 
    }
    public void setAddress(String address) {
         this.address = address; 
    }
    public void saveToDatabase() {
         String url = "jdbc:mariadb://localhost:3306/StudentsDB";
          String user = "root";
           String password = "4567";
            try {Class.forName("org.mariadb.jdbc.Driver");
             try (Connection conn = DriverManager.getConnection(url, user, password);
              PreparedStatement stmt = conn.prepareStatement("INSERT INTO Students (first_name, last_name, dob, phone_number, gender, email, address) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setDate(3, new java.sql.Date(dob.getTime())); 
                stmt.setString(4, phoneNumber);
                stmt.setString(5, gender);
                stmt.setString(6, email); 
                stmt.setString(7, address); 
                stmt.executeUpdate(); System.out.println("Student information saved to database.");
            } catch (SQLException e) {
                 e.printStackTrace(); }
                 } catch (ClassNotFoundException e) {
                     e.printStackTrace(); }
                     }
                     public void addMessageListener(MessageListener messageListener) {
                         listeners.add(messageListener);
                         }
                    public void removeMessageListener(MessageListener messageListener) {
                         listeners.remove(messageListener); 
                        }
                    public void messageDelivered(String message) {
                         if (!listeners.isEmpty()) {
                             MessageListener listener = listeners.get(0);
                              listener.onMessage(new MessageEvent(this), message);
                             } }
                    @Override 
                    public String toString() { return "This is a Student Bean"; }public Student() { } 
                }