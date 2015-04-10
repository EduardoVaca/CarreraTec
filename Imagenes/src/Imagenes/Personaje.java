/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Graphics;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Personaje {
    enum Estados {jump, run, colision, perder, ganar}
    Estados estado = Estados.run;
    Cronometro duracion = new Cronometro(4,400);
    int x, y;
    int contS1 = 1;

    int numeroImagenes;
    String nombreImagen;
    double contador = 4; 
    static Personaje instancia = null;
    int tiempoDelay = 0;  //tiempo que retarda una imagen
    boolean delay = false; //para retardar una imagen
    int alto, ancho;
    Colisionador col;
    int tiempoColision = 0;
    Clip clip;
    AudioInputStream musica;
    boolean sonido;
   
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
        while(y <= 175 && Teclado.Singleton().space == false) //50 es la posicion actual de piso
        { 
           y++;
        }
        
       
      
      //EN CASO DE SER SALTO
      if(Teclado.Singleton().space)
      {
        contador = contador + 0.1;
        
        y = y + (int)((Math.sin(contador) + Math.cos(contador)) * 13); //Gravedad
        //x= x + 5; //Avance en x
        
        Teclado.Singleton().comandoDeshabilitado();
      }
      col.setyInferior(y + alto);
      col.setySuperior(y);
      
      //CAMBIO DE ESTADO
        switch(estado)
        {
             case run:
             g.drawImage(Imagenes.Singleton().imagen(nombreImagen+"run.gif"), x, y, null);
             sonido = false;
             break;
             
             case jump:
             g.drawImage(Imagenes.Singleton().imagen(nombreImagen+"jump"+contS1+".png"), x, y, null);
             this.animacionSalto(numeroImagenes);
              try
            {
                musica = AudioSystem.getAudioInputStream(getClass().getResource("Salto1.wav"));
                clip = AudioSystem.getClip();
                clip.open(musica);
                if(!sonido){
                    clip.start();
                    sonido = true;
                }                
            }catch(Exception ex){

            }
             break;

             case colision:
             g.drawImage(Imagenes.Singleton().imagen(nombreImagen+"colision.png"), x, y, null);  
             Teclado.Singleton().space=false;                        
             if(duracion.esTiempo())
               {                              
                tiempoColision++; 
                Fondo.Singleton().setAceleracion(0); //aceleracion nula
                if(tiempoColision > 17)
                {
                  estado = estado.run;                  
                  Fondo.Singleton().setAceleracion(8); // aceleracion default
                  tiempoColision = 0;
                }                                              
              }
             break;

             case perder:
             Fondo.Singleton().setAceleracion(0);
             g.drawImage(Imagenes.Singleton().imagen(nombreImagen+"perder"+contS1+".png"), x, y, null);
             this.animacionRetardo(4, ControlVentanas.Singleton().estadoJuego.perder);
             break;
             
             case ganar:
             Fondo.Singleton().setAceleracion(0);
             g.drawImage(Imagenes.Singleton().imagen(nombreImagen+"ganar"+contS1+".png"), x, y, null);
             this.animacionRetardo(8, ControlVentanas.Singleton().estadoJuego.ganar);
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
               contS1 = 7;
               if(y>=175)
               {
                  contS1=1;
                  Teclado.Singleton().space = false;
                  estado = estado.run;
               }
             }
      }
    }
    
    public String getNombreImagen() {
    return nombreImagen;
  }

   /* Permite visualizar un periodo más largo una imagen en una animación (utilizado para ganar y perder) */
    void animacionRetardo(int numeroImagenes, ControlVentanas.EstadoJuego estado)
    {
      if(duracion.esTiempo())
        {
        if(delay == false)
        {
               contS1++;
        }else
        {
          tiempoDelay++;
        }
      
           if(contS1 > numeroImagenes)
           {
              delay = true;
           }
           
           if(tiempoDelay == 15)
           {
             ControlVentanas.Singleton().setEstadoJuego(estado);
             contS1=1;
           }
        }
    }

  public void setNombreImagen(String nombreImagen) {
    this.nombreImagen = nombreImagen;
  }
 
}