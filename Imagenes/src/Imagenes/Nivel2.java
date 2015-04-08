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
public class Nivel2 {
    
    static Nivel2 instancia=null;
    
    public static Nivel2 Singleton()
    {
         if(instancia==null)
         {
            instancia=new Nivel2();
            Personaje.Singleton().setPosicion(30, 50);
            Personaje.Singleton().setTamano(96, 96);
            Juego.Singleton().barraEspaciadora = new Tecla("TeclaSPACE.png", 400, 100);
            Temporizador.Singleton().setMinutos(3);
            Temporizador.Singleton().setSegundos(0);
            Temporizador.Singleton().execute();
         }
         return instancia;
    }
    public void dibuja (Graphics g)
    {
        Fondo.Singleton().dibujaImagenn2(g);
        VentanaJuego.Singleton().setBounds(100, 100, 956, 220);
        if(!Juego.Singleton().teclasDibujadas && Personaje.Singleton().getEstado() == Personaje.Estados.run)
        {
                     Juego.Singleton().teclas = Juego.Singleton().generaTeclas(100);                    
                     Juego.Singleton().teclasDibujadas = true;
        } 
    }
    
}
