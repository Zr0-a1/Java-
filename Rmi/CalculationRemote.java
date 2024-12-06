import java.rmi.*;

public interface CalculationRemote extends Remote{ 
    public float add(float x, float y) throws RemoteException; 
    public float sub(float x, float y) throws RemoteException; 
    public float mul(float x, float y) throws RemoteException; 
    public float div(float x, float y) throws RemoteException; 
}