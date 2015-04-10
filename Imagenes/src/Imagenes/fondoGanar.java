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
public class fondoGanar extends JPanel{
    public static fondoGanar instancia = null;	    
		public static fondoGanar Singleton()
		{
		    if(instancia==null)
		    {
		       instancia=new fondoGanar();
                   
		    }
		    return instancia;
		}
    @Override
    public void paintComponent(Graphics g)
    {
        g.drawImage(Imagenes.Singleton().imagen("ganaste.png"), 0, 0, null);
    }
    
}
