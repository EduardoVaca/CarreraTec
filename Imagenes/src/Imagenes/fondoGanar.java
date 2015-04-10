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
        g.setFont(new Font("Candara", Font.PLAIN, 28));
        g.drawString("Tu tiempo: " + generaScore() + " segundos...", 400, 170);
    }
    
    public String generaScore(){
        String minutos = Integer.toString(Temporizador.Singleton().getMinutos());
        String segundos = Integer.toString(-(Temporizador.Singleton().getSegundos() - 60));
        
        return segundos;
        
    }
    
}
