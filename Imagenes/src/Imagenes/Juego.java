/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Juego{
    static Juego instancia=null;
    static int numItems = 2;
    static Item [] items = new Item[numItems];
    private Fondo fondo;
    static int numBotones;
    boolean barraDesbloqueada, teclasDibujadas;
    ArrayList <Tecla> teclas = new ArrayList <Tecla>();
    char teclaPresionada;
    
    public static Juego Singleton()
    {
         if(instancia==null)
         {
            instancia=new Juego();
            for(int i=0; i<numItems; i++)
            {
             items[i] = new Item("pokeball.png", 60, 60);
            }
            Personaje.Singleton().setPosicion(30, 50);
            Personaje.Singleton().setTamano(96, 96);
                instancia.fondo=new Fondo();
         }
         return instancia;
    }
   
    public void actualiza(Graphics g)
    {
                 fondo.dibujaImagen(g);                
                 Personaje.Singleton().dibuja(g);  
                 for(int i=0;i<numItems;i++)
                 {
                     items[i].dibuja(g);
                     if(verificaColision(Personaje.Singleton(), items[i])){
                         Personaje.Singleton().setEstado(Personaje.Singleton().estado.colision);
                     }
                 }
                 /* Condicion que generara teclas unicamente si estan no estan dibujadas*/
                 if(!teclasDibujadas){
                     teclas = generaTeclas();                    
                     teclasDibujadas = true;
                 }
                 if(teclas.size() > 0){
                    verificaTeclaPresionada();                 
                    for(Tecla i: teclas)
                        i.draw(g);
                 }             
    }
   
   /*Metodo que genera las telcas y las agrega al ArrayList, 
   regresando el arrayList lleno con numero de teclas aleatorias
   */
    ArrayList<Tecla> generaTeclas(){
        Random rand = new Random();
        int numero_de_teclas = rand.nextInt(3) + 1;
        for(int i = 1; i <= numero_de_teclas; i++){
            Tecla t = new Tecla(500 + (70 * i), 100);
            teclas.add(t);
        }  
        return teclas;
    }
   
      public void comando(KeyEvent e )
    {
      if(Personaje.Singleton().getEstado() != Personaje.Singleton().estado.colision)
      {
         switch(e.getKeyCode())
        {
           case KeyEvent.VK_RIGHT:
               Teclado.Singleton().derecha = true;
               break;
           case KeyEvent.VK_LEFT:
               Teclado.Singleton().izquierda = true;
               break;
           case KeyEvent.VK_UP:
               Teclado.Singleton().arriba = true;
               break;
           case KeyEvent.VK_DOWN:
               Teclado.Singleton().abajo = true;
               break;
           case KeyEvent.VK_SPACE:
            if( Teclado.Singleton().arriba ) //Validacion de comando (ejemplo 1 tecla) provisional
            {
              Personaje.Singleton().setEstado(Personaje.Estados.jump);
              Teclado.Singleton().space = true;
              Personaje.Singleton().contador = 4; 
            }
            break;
       }
        teclaPresionada = e.getKeyChar();
        if(teclaPresionada >= 97)
            teclaPresionada -= 32;
        System.out.println("CHAR: " + teclaPresionada);
      }      
    }
      
     void verificaTeclaPresionada(){
         if(teclaPresionada == teclas.get(0).getLetra()){
             teclas.remove(0);
         }
         teclaPresionada = '*';
     }
      
      /*Metodo que verifica si ha existido colision del Personaje con los items en movimiento
      Regresa un booleano indicando si choco o no
      */
      public boolean verificaColision(Personaje p, Item o){
        if((p.getCol().getxInferior() >= o.getCol().getxSuperior() && p.getCol().getxInferior() <= o.getCol().getxInferior()) 
                && (p.getCol().getyInferior() >= o.getCol().getySuperior() && p.getCol().getyInferior() <= o.getCol().getyInferior())){
            return true;
        }else{
            return false;
        }
     }
}
