/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;
import javax.swing.SwingUtilities;

/**
 *
 * @author USER
 */
public class MainProyect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FrmLogin ventana = new FrmLogin();
            ventana.setVisible(true);
        });
    }
    
}
