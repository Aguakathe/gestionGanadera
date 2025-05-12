package database;

import java.sql.Connection; //Importamos la clase Connection para manejar conexiones a la base de datos
import java.sql.DriverManager; //Importamos la clase DriverManager para gestionar la conexión
import java.sql.SQLException; //Importamos la clase SQLException para manejar errores de sql
import javax.swing.JOptionPane;

public class Conexion {
    
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //URL de conexión al servidor MySQL en el puerto 3306 (puerto por defecto)
    private final String URL = "jdbc:mysql://localhost:3306/";
    //Nombre de la base de datos a la que nos conectaremos
    private final String DB = "gestion_ganadera";
    //Usuario para conectarse a la base de datos (por defecto es: "root")
    private final String USER = "root";
    //Contraseña para el usuario; en este caso la dejaremos vacía
    private final String PASSWORD = "";
    
    //Crear un objeto que almacene la conexión establecidad a la base de datos
    public Connection cadena;
    //Creamos instancia de la clase Conexion para implementar el patrón Singleton
    public static Conexion instancia;
    
    //Constructor privado para evitar instanciación externa
    private Conexion(){
        this.cadena = null;
    }
    
    //Método para establecer la conexión en la base de datos
    public Connection conectar(){
        try{
            //Cargar la clase dle driver JDBC de MySQL
            Class.forName(DRIVER);
            //Instancia para establecer la conexión combinando la URL y el nombre de la base de datos
            //y presetnamos el usuario y contraseña
            //this.cadena = DriverManager.getConnection(URL + DB + USER + PASSWORD);
            this.cadena = DriverManager.getConnection(URL + DB, USER, PASSWORD);

            
        }catch(ClassNotFoundException | SQLException e){
            //Si ocurre una exepción (no se encuentra el driver o falla la conexión)
            //se muestra un mensaje de error en un cuadro de dialogo y se termina el programa
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return this.cadena;
    }
    
    //Método para cerrar la conexión a la base de datos
    public void desconectar(){
        try{
            //Intetamos cerrar la conexión almacenada en "cadena"
            this.cadena.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //Método para obtener la instancia única de la clase
    public synchronized static Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }
        
        return instancia;
    }
    
    
    
}