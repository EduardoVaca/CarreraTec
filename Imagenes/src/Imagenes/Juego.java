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
    static int numBotones;
    boolean barraDesbloqueada, teclasDibujadas;
    ArrayList <Tecla> teclas = new ArrayList <Tecla>();
    char teclaPresionada;
    Tecla barraEspaciadora; // Tecla de barra espaciadora unica
    
    public static Juego Singleton()
    {
         if(instancia==null)
         {
            instancia=new Juego();
            for(int i=0; i<numItems; i++)
            {
             items[i] = new Item("pokeball.png", 60, 60);
            }

            
         }
         return instancia;
    }
   
    public void actualiza(Graphics g)
    {
        if(MenuInicio.Singleton().getEstadon()==MenuInicio.Singleton().estadon.n1)
        {
            Nivel1.Singleton().dibuja(g);
            for(int i=0;i<numItems;i++)
                 {
                     items[i].dibujan1(g);
                     if(verificaColision(Personaje.Singleton(), items[i])){
                         Personaje.Singleton().setEstado(Personaje.Singleton().estado.colision);
                     }
                 }
        }
        else
        {
            Nivel2.Singleton().dibuja(g);
            for(int i=0;i<numItems;i++)
                 {
                     items[i].dibujan2(g);
                     if(verificaColision(Personaje.Singleton(), items[i])){
                         Personaje.Singleton().setEstado(Personaje.Singleton().estado.colision);
                     }
                 }
        }
                            
                 Personaje.Singleton().dibuja(g);  
                 
                 /* Condicion que generara teclas unicamente si estan no estan dibujadas*/
                 if(barraDesbloqueada){
                     barraEspaciadora.draw(g);                     
                 }  
                 /*Si no hay teclas dibujadas y el personaje esta en estado  CORRIENDO, se generan las teclas a presionar*/
                 
                 if(teclas.size() > 0){
                    verificaTeclaPresionada();                 
                    for(Tecla i: teclas)
                        i.draw(g);
                 }             
    }
   
   /*Metodo que genera las telcas y las agrega al ArrayList, 
   regresando el arrayList lleno con numero de teclas aleatorias
   */
    ArrayList<Tecla> generaTeclas(int y){
        Random rand = new Random();
        int numero_de_teclas = rand.nextInt(3) + 1;
        for(int i = 1; i <= numero_de_teclas; i++){
            Tecla t = new Tecla(500 + (70 * i), y);
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
            if( barraDesbloqueada) //Validacion de comando
            {
              barraDesbloqueada = false;
              Personaje.Singleton().setEstado(Personaje.Estados.jump);
              Teclado.Singleton().space = true;
              Personaje.Singleton().contador = 4; 
              teclasDibujadas = false;
            }
            break;
       }
        teclaPresionada = e.getKeyChar();
        if(teclaPresionada >= 97)
            teclaPresionada -= 32;        
      }      
    }
    /*Metodo que verifica si la tecla presionada corresponde al primer botonTecla mostrado, si coincide lo elimina*/  
     void verificaTeclaPresionada(){
         if(teclaPresionada == teclas.get(0).getLetra()){
             teclas.remove(0);
         }
         teclaPresionada = '*';
         if(teclas.size() == 0)
             barraDesbloqueada = true;
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
