/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imagenes;
import java.awt.*;
/**
 *
 * @author Edu
 */
public class Nivel1 {
    static Nivel1 instancia=null;
    
    public static Nivel1 Singleton()
    {
         if(instancia==null)
         {
            instancia=new Nivel1();
            Personaje.Singleton().setPosicion(30, 175);
            Personaje.Singleton().setTamano(96, 96);
            Juego.Singleton().barraEspaciadora = new Tecla("TeclaSPACE.png", 400, 175);
            Temporizador.Singleton().setMinutos(5);
            Temporizador.Singleton().setSegundos(0);
            Temporizador.Singleton().execute();
         }
         return instancia;
    }
    public void dibuja (Graphics g)
    {
        Fondo.Singleton().dibujaImagenn1(g);
        VentanaJuego.Singleton().setBounds(100, 100, 997, 317);
        if(!Juego.Singleton().teclasDibujadas && Personaje.Singleton().getEstado() == Personaje.Estados.run)
        {
                     Juego.Singleton().teclas = Juego.Singleton().generaTeclas(175);                    
                     Juego.Singleton().teclasDibujadas = true;
        }
    }
}


