/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imagenes;

import java.awt.Graphics;
/**
 *
 * @author Edu
 */
public class Fondo {

    private int x=0,y=0; 
    
    public Fondo()
    {
        
        

       //ventana.add(this);
    }
   
    public void dibujaImagen(Graphics g)
    {
        g.drawImage(Imagenes.Singleton().imagen("Nivel2.png"), getX(), getY(), null);
        setX(getX()-6);
        if(getX()<-955)
                    {setX(0);}
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}


