
package datos.interfaces;

import java.util.List;


public interface CrudSimpleInterface <T> { //T SIGINIFICA UN OBJETO QUE SE LE VA A ESTAR PASANDO
    //metodos obligarorios, metodo para listar 
    public List<T> listar(String texto);
    //metodo para insertar un nuevo objeto
    public boolean insertar(T obj);
    //metodo para actualizar un objero del sistema
    public boolean actualizar(T obj);
    
    //metod para desactivar el objeto existente
    public boolean desactivar(int id);
    
    public boolean activar(int id);
    //metdo para contar el total de elementos registrados
    public int total();
    
    //metodo de verificacion si la categoria existe o no
    public boolean existe(String texto);
    
}
