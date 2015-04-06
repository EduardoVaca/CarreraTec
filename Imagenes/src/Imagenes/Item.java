/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Graphics;
import java.awt.Image;

public class Item {
    
    Image imagen;
    int x = 0, y = 90, vx = 10;
    int maxvel = 10;
    int alto, ancho;
    Colisionador col;
    
    public Item(String nombre, int ancho, int alto){
        this.x = VentanaJuego.Singleton().getWidth();
        this.vx = (int)(Math.random() * maxvel);
        imagen=Imagenes.Singleton().imagen(nombre);
        this.alto = alto;
        this.ancho = ancho;
        if(MenuInicio.Singleton().getEstadon()==MenuInicio.Singleton().estadon.n1)
        {
            col = new Colisionador(x, y+125, alto, ancho);
        }
        else
        {
            col = new Colisionador(x, y, alto, ancho);
        }
    }

    public Colisionador getCol() {
        return col;
    }
    
    public void dibujan1(Graphics g)
    {
      g.drawImage(imagen, x, y+125, null);
      x-=vx;
      col.setxInferior(x + ancho);
      col.setxSuperior(x);
      //col.draw(g);
    }
    
    public void dibujan2(Graphics g)
    {
      g.drawImage(imagen, x, y, null);
      x-=vx;
      col.setxInferior(x + ancho);
      col.setxSuperior(x);
      //col.draw(g);
    }
}