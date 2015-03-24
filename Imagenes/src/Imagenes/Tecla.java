/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

/**
 *
 * @author Eduardo Vaca
 */
public class Tecla {
    String nombre;
    boolean presionada;
    boolean EsBarraEspaciadora;
    int posX;
    int posY;
    Image imagen;
    
    public Tecla(int posX, int posY){
        Random rand = new Random();
        int numero = rand.nextInt(4);
        if(numero == 0)
            nombre = "TeclaA.png";
        if(numero == 1)
            nombre = "TeclaW.png";
        if(numero == 2)
            nombre = "TeclaS.png";
        if(numero == 3)
            nombre = "TeclaD.png";
        imagen = Imagenes.Singleton().imagen(nombre);
        this.posX = posX;
        this.posY = posY;
    }
    
    void draw(Graphics g){
        g.drawImage(imagen, posX, posY, null);
    }
    
}
