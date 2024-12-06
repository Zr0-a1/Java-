import java.rmi.*;

public class CalculationImp implements CalculationRemote {
   
    public CalculationImp() throws RemoteException { 
        super(); 
    }

    @Override 
    public float add(float x, float y) throws RemoteException { 
            return x+y; 
    }

    @Override 
    public float sub(float x, float y) throws RemoteException {
         return x-y; 
    }

    @Override 
    public float mul(float x, float y) throws RemoteException { 
        return x*y; 
    }

    @Override 
    public float div(float x, float y) throws RemoteException { 
        if (y != 0) { 
            return x / y; }
         else {
        throw new RemoteException("Division by zero is not allowed."); }
     }

    
}
