package com.christian.tecnologia.utilerias;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propiedades{
    
    //Creamos el metodo para cargar el archivo properties
    public Properties cargarArchivoProperties() throws FileNotFoundException, IOException{
        Properties propiedades = new Properties(); //creamos el archivo properties
        InputStream archivo = new FileInputStream("C:\\Users\\Christian Ramirez\\Documents\\NetBeansProjects\\ConexionProperties\\src\\main\\resources\\conexionBD.properties");
        propiedades.load(archivo);
        return propiedades;
    }
}
