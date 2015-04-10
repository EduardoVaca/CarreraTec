package Imagenes;

import java.awt.*;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Perder extends JFrame implements MouseListener{

    Botonesfinal b = new Botonesfinal("Volver al menu");
    Botonesfinal s = new Botonesfinal("Salir");
		public static Perder instancia = null;

		public static Perder Singleton()
		{
		    if(instancia == null)
		    {
		       instancia= new Perder();
                     instancia.setBounds(100, 100, 997, 280);
                     instancia.agregaElementos();
	            instancia.setContentPane(fondoPerder.Singleton());
	           instancia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	           instancia.setUndecorated(true);
	          
	           instancia.setVisible(true);
	           instancia.setResizable(false);
	           instancia.createBufferStrategy(2);
	           instancia.addMouseListener(instancia);
                  
		    }
		    return instancia;
		}
                public void agregaElementos()
                {
                    fondoPerder.Singleton().add(b, BorderLayout.EAST);
                    fondoPerder.Singleton().add(s, BorderLayout.EAST);
                }


		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

}