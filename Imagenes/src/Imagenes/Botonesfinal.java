/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imagenes;

import static Imagenes.Ganar.instancia;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Edu
 */
public class Botonesfinal extends JButton{

    public Botonesfinal()
    {}
    public Botonesfinal(final String s)
    {
        this.setText(s);
        this.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
              if(s.equals("Volver al menu"))
              {   Nivel1.instancia=null;
                  Nivel2.instancia=null;
                  VentanaJuego.instancia=null;
                  Juego.instancia=null;
                  Personaje.instancia=null;
                  Fondo.instancia=null;
                  Temporizador.instancia=null;
                  Opciones.instancia=null;
                  ControlVentanas.instancia=null;
                  fondoPerder.instancia=null;                  
                  MenuInicio.Singleton().setEstadon(MenuInicio.Singleton().estadon.n1);
                  MenuInicio.Singleton().setVisible(true);
                  Perder.Singleton().setVisible(false);
                  Ganar.Singleton().setVisible(false);
                  
                  
              }
              else
              {
                  Perder.Singleton().dispatchEvent(new WindowEvent(Perder.Singleton(), WindowEvent.WINDOW_CLOSING));
              }
            }
        
        });
    }
    
    
}
