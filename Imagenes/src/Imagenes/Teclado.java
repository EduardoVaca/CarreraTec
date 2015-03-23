/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.event.KeyEvent;

public class Teclado {
    
    static Teclado instancia=null;
    
    boolean derecha;
    boolean izquierda;
    boolean arriba;
    boolean abajo;
    boolean space;
    
 public Teclado()
 {
    this.derecha=false;
    this.izquierda=false;
    this.arriba=false;
    this.abajo=false;
    this.space=false;   
 }
      
   public static Teclado Singleton()
   {
        if(instancia==null)
        {
           instancia=new Teclado();
        }
        return instancia;
   }

  public void comandoDeshabilitado()
   {
    Teclado.Singleton().abajo =false;
    Teclado.Singleton().arriba =false;
    Teclado.Singleton().izquierda =false;
    Teclado.Singleton().derecha =false;
   }
   
}
