package remote;
import java.rmi.Naming;
import java.rmi.Remote;
import java.util.Properties;

public class MyServer implements Remote{
    public static void main(String[] args) {
        Properties p = new Properties();
        p.setProperty("java.security.policy", "file:///home/jessy/Bureau/RMI/exempleCours/out/production/TP/server.policy");
        System.setProperties(p);
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {           
            Naming.rebind("rmi://localhost/calculate", new CalculateEngine());
            System.out.println("CalculateEngine bound");
            } 
        catch (Exception e) {
              System.err.println("CalculateEngine exception:");
               e.printStackTrace();
            }
     }
}
