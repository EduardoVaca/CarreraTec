/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Graphics;
import java.awt.Image;

public class Item {
    
    Image imagen;
    int x = 0, y = 90, vx = 0;
    int maxvel = 5;
    int alto, ancho;
    Colisionador col;
    
    public Item(String nombre, int ancho, int alto){
        this.x = VentanaJuego.Singleton().getWidth();
        this.vx = (int)(Math.random() * maxvel);
        imagen=Imagenes.Singleton().imagen(nombre);
        this.alto = alto;
        this.ancho = ancho;
        col = new Colisionador(x, y, alto, ancho);
    }
    
    public void dibuja(Graphics g)
    {
      g.drawImage(imagen, x, y, null);
      x-=vx;
      col.setxInferior(x + ancho);
      col.setxSuperior(x);
      col.draw(g);
    }
}