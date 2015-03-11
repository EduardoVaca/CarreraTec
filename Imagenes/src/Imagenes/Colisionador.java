/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imagenes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Eduardo
 */
public class Colisionador {
    private int xSuperior;
    private int ySuperior;
    private int xInferior;
    private int yInferior;
    private int ancho, alto;
    
    public Colisionador(int xSup, int ySup, int alto, int ancho){
        xSuperior = xSup;
        ySuperior = ySup;
        xInferior = xSup + ancho;
        yInferior = ySup + alto;
        this.alto = alto;
        this.ancho = alto;
    }
    
    public void setxSuperior(int xSuperior) {
        this.xSuperior = xSuperior;
    }

    public void setySuperior(int ySuperior) {
        this.ySuperior = ySuperior;
    }

    public void setxInferior(int xInferior) {
        this.xInferior = xInferior;
    }

    public void setyInferior(int yInferior) {
        this.yInferior = yInferior;
    }

    public int getxSuperior() {
        return xSuperior;
    }

    public int getySuperior() {
        return ySuperior;
    }

    public int getxInferior() {
        return xInferior;
    }

    public int getyInferior() {
        return yInferior;
    }
    
    
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.drawRect(xSuperior, ySuperior, ancho, alto);   
    }
    
}
