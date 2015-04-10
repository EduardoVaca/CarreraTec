/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class Item {
    
    Image imagen;
    int x = 0, y = 90, vx = 10;
    int maxvel = 10;
    int alto, ancho;
    Colisionador col;
    String nombre;
    boolean afecta;
    
    public Item(int ancho, int alto){ 
        Random r = new Random();
        if(MenuInicio.Singleton().getEstadon()==MenuInicio.Singleton().estadon.n1){
            nombre = "item" + (r.nextInt(3) + 1) + ".png";
            y = 215;
        }            
        else if (MenuInicio.Singleton().getEstadon()==MenuInicio.Singleton().estadon.n2){
            nombre = "item" + (r.nextInt(3) + 4) + ".png";
            y = 90;   
        }
        this.x = VentanaJuego.Singleton().getWidth();
        this.vx = Fondo.Singleton().getAceleracion();
        imagen = Imagenes.Singleton().imagen(nombre);
        this.alto = alto;
        this.ancho = ancho;
        afecta = true;         
        col = new Colisionador(x, y, alto, ancho);       
    }

    public Colisionador getCol() {
        return col;
    }

    public boolean isAfecta() {
        return afecta;
    }

    public void setAfecta(boolean afecta) {
        this.afecta = afecta;
    }
    
    
    
    public void dibuja(Graphics g)
    {
      g.drawImage(imagen, x, y, null);
      x -= Fondo.Singleton().getAceleracion();
      col.setxInferior(x + ancho);
      col.setxSuperior(x);
      col.draw(g);
    }

    public int getX() {
        return x;
    }
    
    
}