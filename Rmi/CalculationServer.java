import java.rmi.*; 
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class CalculationServer {
    public static void main(String[] args) {
        try {
            // Start RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Create the remote object and export it
            CalculationRemote calobj = (CalculationRemote) UnicastRemoteObject.exportObject(new CalculationImp(), 0);
            
            // Bind the object in the RMI registry
            Naming.rebind("rmi://localhost/JmcCal", calobj); 
            
            System.out.println("Calculation RMI Server is running...");
        } catch (Exception ex) {
            System.err.println("Server exception: " + ex.toString());
            ex.printStackTrace();
        }
    }
}
