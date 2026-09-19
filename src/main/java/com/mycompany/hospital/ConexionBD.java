package com.mycompany.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Juan Eraso
 */
public class ConexionBD {
    //Atributos
    private static String url = "jdbc:mysql://localhost:3306/Hospital";
    private static String user = "root";
    private static String password = "";
    
    //Métodos
    //Método para conectar la BD
    public static Connection conectar() throws SQLException
    {
      try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        }
        return DriverManager.getConnection(url, user, password);
    }
}
