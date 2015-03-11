/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Juego{
    static Juego instancia=null;
    static int numItems = 2;
    static Item [] items = new Item[numItems];
    private Fondo fondo;
   public static Juego Singleton()
   {
        if(instancia==null)
        {
           instancia=new Juego();
           for(int i=0; i<numItems; i++)
           {
            items[i] = new Item();
           }
           Personaje.Singleton().setPosicion(30, 50);
           Personaje.Singleton().setTamano(96, 96);
           //Personaje.Singleton().setPosicion(VentanaJuego.Singleton().getWidth() /2, VentanaJuego.Singleton().getHeight()/2);
           //Personaje.Singleton().setEstado(Personaje.Estados.run);
               instancia.fondo=new Fondo();
        }
        return instancia;
   }
   
   public void actualiza(Graphics g)
   {
                fondo.dibujaImagen(g);
                //g.drawImage(Imagenes.Singleton().imagen("Nivel2.png"),0,0,null);
                Personaje.Singleton().dibuja(g);  
                for(int i=0;i<numItems;i++)
                {
                    items[i].dibuja(g);
                }
   }
   
      public void comando(KeyEvent e )
    {
      switch(e.getKeyCode())
       {
          case KeyEvent.VK_RIGHT:
              Teclado.Singleton().derecha=true;
              break;
          case KeyEvent.VK_LEFT:
              Teclado.Singleton().izquierda=true;
              break;
          case KeyEvent.VK_UP:
              Teclado.Singleton().arriba=true;
              break;
          case KeyEvent.VK_DOWN:
              Teclado.Singleton().abajo=true;
              break;
          case KeyEvent.VK_SPACE:
             // Teclado.Singleton().space=true;
              Personaje.Singleton().setEstado(Personaje.Estados.jump);
              break;
      }
   }
}
