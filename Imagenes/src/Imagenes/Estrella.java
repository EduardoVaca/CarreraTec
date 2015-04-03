/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Eduardo Vaca
 */
public class Estrella {
    
    private int posX;
    private int posY;
    private String nombre;
    private Image imagen;
    
    public Estrella(int x, int y){
        nombre = "estrella.png";
        posX = x;
        posY = y;
        imagen = Imagenes.Singleton().imagen(nombre);
    }
    
    public void draw(Graphics g){
        g.drawImage(imagen, posX, posY, 50, 50, null);               
    }
}
