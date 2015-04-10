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
public class fondoPerder extends JPanel {
    public static fondoPerder instancia = null;
    public static fondoPerder Singleton()
		{
		    if(instancia == null)
		    {
		       instancia= new fondoPerder();
                     
                  
		    }
		    return instancia;
		}
    @Override
    public void paintComponent(Graphics g)
    {
        g.drawImage(Imagenes.Singleton().imagen("perdiste.jpg"), 0, 0, null);
    }
    
}
