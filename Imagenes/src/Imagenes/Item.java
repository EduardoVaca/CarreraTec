/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Graphics;
import java.awt.Image;

public class Item {
    
    Image imagen=Imagenes.Singleton().imagen("pokeball.png");
    int x=0, y=90, vx=0;
    int maxvel=5;
    
    public Item(){
        this.x = VentanaJuego.Singleton().getWidth();
        this.vx = (int)(Math.random() * maxvel);
    }
    
    public void dibuja(Graphics g)
    {
      g.drawImage(imagen, x, y, null);
      x-=vx;
    }
}