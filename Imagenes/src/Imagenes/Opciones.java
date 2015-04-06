/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imagenes;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Edu
 */
public class Opciones extends JPanel
{
    JLabel inicio;
    JLabel salir;
    
    public static Opciones instancia = null;
    public static Opciones Singleton()
    {
        
        if(instancia == null)
        {
            instancia = new Opciones();
            
        }
        return instancia;
        
    }
    public Opciones() 
    {
        
        setOpaque(false);
        setLayout(new GridLayout(3,1));
        inicio = new JLabel("Iniciar Juego");
        inicio.setForeground(Color.yellow);
        inicio.setFont(new Font("Arial", Font.PLAIN, 28));
        salir = new JLabel("Quitar Juego");
        salir.setForeground(Color.yellow);
        salir.setFont(new Font("Arial", Font.PLAIN, 28));
        add(inicio);
        add(salir);
    }

}
