import java.rmi.*; 
import java.util.Scanner;

public class CalculationClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object by its name in the RMI registry
            CalculationRemote calstub = (CalculationRemote) Naming.lookup("rmi://localhost/JmcCal");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose an operation: "); 
            System.out.println("1) Add "); 
            System.out.println("2) Subtract "); 
            System.out.println("3) Multiply "); 
            System.out.println("4) Divide"); 
            
            int choice = scanner.nextInt();
            System.out.println("Enter first number:");
            float num1 = scanner.nextFloat();
            System.out.println("Enter second number:");
            float num2 = scanner.nextFloat();

            float result = 0;
            switch (choice) {
                case 1: result = calstub.add(num1, num2);
                 break;
                case 2: result = calstub.sub(num1, num2);
                 break;
                case 3: result = calstub.mul(num1, num2);
                 break;
                case 4: result = calstub.div(num1, num2);
                 break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }

            System.out.println("Result: " + result);
        } catch (RemoteException e) {
            System.err.println("RemoteException: " + e.toString());
        } catch (NotBoundException e) {
            System.err.println("NotBoundException: " + e.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
