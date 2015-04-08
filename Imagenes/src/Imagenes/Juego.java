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
    static int numItems = 7;
    static Item [] items = new Item[numItems];
    static int numBotones;
    boolean barraDesbloqueada, teclasDibujadas, poderEspecial;
    ArrayList <Tecla> teclas = new ArrayList <Tecla>();
    char teclaPresionada;
    Tecla barraEspaciadora; // Tecla de barra espaciadora unica
    Estrella estrellas [] = new Estrella [7];
    int numero_de_estrellas_reales = 5; // variable para contar las estrellas dibujadas
    int numero_de_estrellas_posibles = 0; // variable para contar las estrellas que se acomulan o ganan en cada salto
    int piso;
    Temporizador t = new Temporizador();
    
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
         }
         return instancia;
    }
   
    public void actualiza(Graphics g)
    {
         if(MenuInicio.Singleton().getEstadon()==MenuInicio.Singleton().estadon.n1){
             piso = 175;
             Nivel1.Singleton().dibuja(g);
         }else{
             piso = 100;
              Nivel2.Singleton().dibuja(g);
         }                                              
        Personaje.Singleton().dibuja(g); 
        Personaje.Singleton().getCol().draw(g);
        dibujaEstrellas(g);

        for(int i=0;i<numItems;i++)
        {
            items[i].dibuja(g);
            if(verificaColision(Personaje.Singleton(), items[i]) && poderEspecial == false){
                Personaje.Singleton().setEstado(Personaje.Singleton().estado.colision);
                numero_de_estrellas_posibles = 0;
            }
        }
        /* Condicion que generara teclas unicamente si estan no estan dibujadas*/
        if(barraDesbloqueada){
            barraEspaciadora.draw(g); 

        }  
        /*Si no hay teclas dibujadas y el personaje esta en estado  CORRIENDO, se generan las teclas a presionar*/
        if(!teclasDibujadas && Personaje.Singleton().getEstado() == Personaje.Estados.run){
            teclas = generaTeclas(piso); 
            numero_de_estrellas_reales += numero_de_estrellas_posibles;
            numero_de_estrellas_posibles = 0;
            if(numero_de_estrellas_reales >= 7){
                numero_de_estrellas_reales = 0;
                //AQUI SE DESACTIVA LA COLISION                
                t.setSegundos(5);
                t.execute();
                poderEspecial = true;
            }
            teclasDibujadas = true;
        }
        if(teclas.size() > 0){
           verificaTeclaPresionada();                 
           for(Tecla i: teclas)
               i.draw(g);
        }
        if(poderEspecial)
            desactivarColision(t);
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
             numero_de_estrellas_posibles ++;
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
      /*Metodo que dibuja las estrellas en el JFrame*/
      public void dibujaEstrellas(Graphics g){
          for(int i = 0; i < numero_de_estrellas_reales; i++){
              estrellas[i] = new Estrella(10 + (50 * i), 50);
              estrellas[i].draw(g);
          }
      }
      
      public void desactivarColision(Temporizador t){         
          System.out.println(t.toString());
          if(t.toString().equals("00:00"))
              poderEspecial = false;
      }
}
