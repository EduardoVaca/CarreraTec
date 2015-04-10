package Imagenes;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.*;
public class Ganar extends JFrame implements MouseListener{
    Botonesfinal b = new Botonesfinal("Volver al menu");
    Botonesfinal s = new Botonesfinal("Salir");
    public static Ganar instancia = null;	    
		public static Ganar Singleton()
		{
		    if(instancia==null)
		    {
		    instancia=new Ganar();
	           instancia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	           instancia.setUndecorated(true);
	           instancia.Singleton().setBounds(100, 100, 997, 280);
                   instancia.agregaElementos();
	           instancia.setContentPane(fondoGanar.Singleton());
	           instancia.setVisible(true);
	           instancia.setResizable(false);
	           instancia.createBufferStrategy(2);
	           instancia.addMouseListener(instancia);
                   
		    }
		    return instancia;
		}
		
            public void agregaElementos()
                {
                    fondoGanar.Singleton().add(b, BorderLayout.EAST);
                    fondoGanar.Singleton().add(s, BorderLayout.EAST);
                }

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
                
                
                  
                
	
	
}