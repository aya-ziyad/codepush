package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB{
    private static final String USER = "root";  // Assurez-vous que c'est l'utilisateur correct
    private static final String PASSWORD = "";  
    private static final String URL = "jdbc:mysql://localhost:3307/onousc?useSSL=false&serverTimezone=UTC";
    
    // Connexion privée et statique pour éviter de créer plusieurs instances
    private static Connection connection = null;

    // Méthode statique pour obtenir la connexion
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully.");
            } catch (SQLException e) {
                System.err.println("Failed to connect: " + e.getMessage());
            }
        }
        return connection;
    }

    // Méthode pour fermer la connexion
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to close connection: " + e.getMessage());
        }
    }
}
