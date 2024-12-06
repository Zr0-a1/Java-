public class Student implements java.io.Serializable {

    private String firstName;
    private String lastName;
    private int age;
    private java.util.Date Dob;
    public ArrayList <MessageListener> listeners = new ArrayList<MessageListener>();
    private Object MessageListener;
    
    public void addMessageListener(MessageListener message){
        listeners.add(MessageListener);
    } 

    public void removeMessageListener(MessageListener message){
        listeners.remove(MessageListener);
    }

    public void messageDeliver(MessageEvent e, String message) {
        MessageListener listener = (MessageListener)listeners.get(0);
        listener.onMessage(e,message);
    }
        
    

     public Student(
        public String getfirstName(){
            return firstName;
         }
    
        public String getlastName(){
            return lastName;
        }
    
        public int getage(){
            return age;
        }
    
        public java.util.Date getDob(){
            return Dob;
        }
    
        public void  setfirstName(String firstName){
            this.firstName = firstName;
        }
        
        public void  setlastName(String lastName){
            this.lastName = lastName;
        }
        
        public void  setage(int age){
            this.age = age;
        }
    
         public void  setDob(java.util.Date Dob){
            this.Dob = Dob;
        }
     )
    
}
