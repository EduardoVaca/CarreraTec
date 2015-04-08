/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Graphics;

public class Personaje {
    enum Estados {jump, run, colision}
    Estados estado = Estados.run;
    Cronometro duracion = new Cronometro(4,400);
    int x, y;
    int contS1 = 1;

    int numeroImagenes;
    String nombreImagen;
    double contador = 4; 
    static Personaje instancia = null;
    
    int alto, ancho;
    Colisionador col;
    int tiempoColision = 0;
   
    static Personaje Singleton()
    {
        if(instancia==null)
        {
            instancia=new Personaje();
        }
        return instancia;
    }

    public Personaje()
    {
      this.numeroImagenes = 7;
      this.nombreImagen = "E3";
    }
    
    void setTamano(int alto, int ancho)
    {
        this.alto = alto;
        this.ancho = ancho;
        col = new Colisionador(x, y, alto, ancho);
    }
    
    void setPosicion(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public Colisionador getCol() {
        return col;
    }

    
    void setEstado(Estados nuevoEstado)
    {
        estado = nuevoEstado;
    }

    public Estados getEstado() {
        return estado;
    }
    
    void dibuja(Graphics g)
    {
        
      //VOLVER A PISO
       if(MenuInicio.Singleton().getEstadon()==MenuInicio.Singleton().estadon.n1)
        {
            while(y <= 175 && Teclado.Singleton().space == false) //50 es la posicion actual de piso
            { 
             y++;
            }
        }
        else
        {
            while(y <= 50 && Teclado.Singleton().space == false) //50 es la posicion actual de piso
            { 
             y++;
            }
        }
      
      //EN CASO DE SER SALTO
      if(Teclado.Singleton().space)
      {
        contador = contador + 0.1;
        
        y = y + (int)((Math.sin(contador) + Math.cos(contador)) * 5); //Gravedad
        //x= x + 5; //Avance en x
        
        Teclado.Singleton().comandoDeshabilitado();
      }
      
      //CAMBIO DE ESTADO
        switch(estado)
        {
             case run:
             g.drawImage(Imagenes.Singleton().imagen(nombreImagen+"run.gif"), x, y, null);
             break;
             
             case jump:
             g.drawImage(Imagenes.Singleton().imagen(nombreImagen+"jump"+contS1+".png"), x, y, null);
             this.animacionSalto(numeroImagenes);
             break;

             case colision:
             g.drawImage(Imagenes.Singleton().imagen(nombreImagen+"colision.png"), x, y, null);                          
             if(duracion.esTiempo())
               {                              
                tiempoColision++; 
                Fondo.Singleton().setAceleracion(0); //aceleracion nula
                if(tiempoColision > 17)
                {
                  estado = estado.run;
                  Fondo.Singleton().setAceleracion(4); // aceleracion default
                  tiempoColision = 0;
                }                                              
              }
             break;     
        }
    }


    public void animacionSalto(int numeroImagenes)
    {
      if(duracion.esTiempo())
      {
         contS1++;
             
             if(contS1 > numeroImagenes)
             {
             contS1 = 1;
             Teclado.Singleton().space = false;
              estado = estado.run;
             }
      }
    }
    
    public String getNombreImagen() {
    return nombreImagen;
  }

  public void setNombreImagen(String nombreImagen) {
    this.nombreImagen = nombreImagen;
  }
 
}