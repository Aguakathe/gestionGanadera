
package datos.interfaces;

import java.util.List;


public interface CrudSimpleInterface <T> { //T SIGINIFICA UN OBJETO QUE SE LE VA A ESTAR PASANDO
    //Metodos obligatorios
    
    //Metodo para listar 
    public List<T> listar(String texto);
    //Metodo para insertar un nuevo objeto
    public boolean insertar(T obj);
    //Metodo para actualizar un objero del sistema
    public boolean actualizar(T obj);
    //Metodo para eliminar por ID
    public boolean eliminar(int id);
    //Método para contar el total de elementos registrados
    public int total();
    
    
    
}
