/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Graphics;

public class Personaje {
    enum Estados {jump,run}
    Estados estado=Estados.run;
    Cronometro duracion= new Cronometro(7,400);
    int x,y;
    int contS1=1;
    String nombreImagen="";
    static Personaje instancia = null;
   
    static Personaje Singleton(){
        if(instancia==null){
            instancia=new Personaje();
        }
        return instancia;
    }
    
    void setPosicion(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    void setEstado(Estados nuevoEstado)
    {
        estado = nuevoEstado;
    }
    
    void dibuja(Graphics g){
        switch(estado)
        {
            case run:
             nombreImagen="run1";
             g.drawImage(Imagenes.Singleton().imagen(nombreImagen+".gif"), x, y, null);
             break;
            case jump:
                 nombreImagen="jump";
                 g.drawImage(Imagenes.Singleton().imagen(nombreImagen+contS1+".png"), x, y, null);
                if(duracion.esTiempo())
                {
                    contS1++;
                    if(contS1>7){
                    estado=estado.run;
                    contS1=1;
                    }
                    x=x+3;
                }                
                break;
        }
    }
} 