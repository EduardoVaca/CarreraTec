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
    char letra;
    
    public Tecla(int posX, int posY){
        Random rand = new Random();
        int numero = rand.nextInt(4);
        if(numero == 0){
            nombre = "TeclaA.png";
            letra = 'A';
        }            
        if(numero == 1){
            nombre = "TeclaW.png";
            letra = 'W';
        }            
        if(numero == 2){
            nombre = "TeclaS.png";
            letra = 'S';
        }            
        if(numero == 3){
            nombre = "TeclaD.png";
            letra = 'D';
        }            
        imagen = Imagenes.Singleton().imagen(nombre);
        this.posX = posX;
        this.posY = posY;
    }
    
    public Tecla(String nombre, int posX, int posY){
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        imagen = Imagenes.Singleton().imagen(nombre);
    }

    public char getLetra() {
        return letra;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
        
    
    void draw(Graphics g){
        g.drawImage(imagen, posX, posY, null);
    }
    
}
