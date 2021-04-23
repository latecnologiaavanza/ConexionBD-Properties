package com.christian.tecnologia.conexion;

import com.christian.tecnologia.utilerias.Propiedades;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Conexion {

    private Conexion() {

    }

    private static Conexion instancia = null;
    Propiedades properties = new Propiedades();

    //Creamos el método para conectarnos a la BD
    public void conectar() throws SQLException{
        Connection conexion = null;
        try {
            Properties propiedades = properties.cargarArchivoProperties();

            String user = propiedades.getProperty("conexion.user");
            String password = propiedades.getProperty("conexion.password");
            String url = propiedades.getProperty("conexion.url");
            
            conexion = DriverManager.getConnection(url, user, password);

            if (conexion != null) {
                JOptionPane.showMessageDialog(null, "Conexion exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexion");
            }
            
            conexion.close();
        } catch (IOException | SQLException error) {
            System.out.println(error);
        }finally{
            conexion.close();
        }
    }

    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
}
