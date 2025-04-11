package control;

import java.io.IOException;
import java.net.InetAddress;
public class Pingcheck {
    
    // Method to check IP address and return the result as a string
    public String checkIpAddress(String ipAddress) {
        if (ipAddress == null || ipAddress.trim().isEmpty()) {
            return "Veuillez entrer une adresse IP.";
        }

        // Validate IP address
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            
            // Try to ping the address
            boolean isReachable = inetAddress.isReachable(2000); // Timeout of 2 seconds
            if (isReachable) {
                return "Le périphérique à l'adresse " + ipAddress + " est connecté.";
            } else {
                return "Le périphérique à l'adresse " + ipAddress + " n'est pas connecté.";
            }
        } catch (IOException e) {
            return "Erreur lors de la vérification de la connectivité.";
        }
    }

    // Example usage
    //public static void main(String[] args) {
        //Pingcheck pk = new Pingcheck();
        // Replace with the IP address to test
        //System.out.println(pk.checkIpAddress("192.168.1.2"));
    //}
}
