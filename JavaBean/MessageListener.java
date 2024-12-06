import java.util.EventListener;
 
public interface MessageListener extends EventListener {
     public void onMessage(MessageEvent e, String message);
}