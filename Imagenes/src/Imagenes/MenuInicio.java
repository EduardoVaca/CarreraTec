/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import static Imagenes.VentanaJuego.Singleton;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
/**
 *
 * @author Edu
 */
public class MenuInicio extends JFrame implements KeyListener
{
    enum Estados {iniciar, salir};
    enum Estadosn {n1, n2};
    Estados estado = Estados.iniciar;
    Estadosn estadon = null;
    public static MenuInicio instancia = null;
    static JPanel bgimagen;
    boolean juegoiniciado=false;
    
    //Es estatico para que no sea necesario crear un objeto para acceder a esta instancia 
    public static MenuInicio Singleton()
    {
        if(instancia == null)
        {
            instancia = new MenuInicio();
            instancia.setBounds(100, 100, 800, 600);
            instancia.agregaElementos();
            instancia.setContentPane(bgimagen);
            instancia.setDefaultCloseOperation(EXIT_ON_CLOSE);  
            instancia.setVisible(true);
            instancia.addKeyListener(instancia);
            instancia.setResizable(false);
        }
        return instancia;
        
    }

    public void agregaElementos()
    {
        bgimagen = new bgImagen();
        bgimagen.setLayout(new BorderLayout());
        
        JPanel titulo = new JPanel();
        JLabel titu = new JLabel("Carrera Tec");
        titu.setFont(new Font("Arial", Font.PLAIN, 36));
        titu.setForeground(Color.yellow);
        titulo.add(titu);
        titulo.setOpaque(false);
        
        JPanel pruebaes = new JPanel();
        JLabel pru = new JLabel("hhhhhhhhhhhhhhhh");
        pru.setFont(new Font("Arial", Font.PLAIN, 36));
        pru.setForeground(Color.BLACK);
        pruebaes.add(pru);
        pruebaes.setOpaque(false);
        
        Opciones.Singleton().inicio.setForeground(Color.RED);
        
        bgimagen.add(pruebaes, BorderLayout.WEST);
        bgimagen.add(titulo, BorderLayout.NORTH);
        bgimagen.add(Opciones.Singleton(), BorderLayout.CENTER);
        
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Estadosn getEstadon() {
        return estadon;
    }

    public void setEstadon(Estadosn estadon) {
        this.estadon = estadon;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
         
    }

    @Override
    public void keyPressed(KeyEvent ke) {

                    
        switch(ke.getKeyCode())
         {
            
           case KeyEvent.VK_UP:
           case KeyEvent.VK_DOWN:
               if(estado==Estados.iniciar)
               {
                   this.setEstado(Estados.salir);
                   
                   Opciones.Singleton().salir.setForeground(Color.RED);
                   Opciones.Singleton().inicio.setForeground(Color.YELLOW);
                   //bgimagen.remove(Opciones.Singleton());
                  // bgimagen.add(Opciones.Singleton(), BorderLayout.CENTER);
                   if(estadon!=null)
                   {
                       this.setEstadon(Estadosn.n2);
                   }
               }
               else if(estado==Estados.salir)
               {
                   this.setEstado(Estados.iniciar);
                   Opciones.Singleton().inicio.setForeground(Color.RED);
                   Opciones.Singleton().salir.setForeground(Color.YELLOW);
                  // bgimagen.remove(Opciones.Singleton());
                  // bgimagen.add(Opciones.Singleton(), BorderLayout.CENTER);
                   if(estadon!=null)
                   {
                       this.setEstadon(Estadosn.n1);
                   }
               }
              
               break;
           case KeyEvent.VK_ENTER:
               if(estadon==null)
               {
                    if(estado==Estados.iniciar)
                    {
                        //VentanaJuego.Singleton().repaint();
                        Opciones.Singleton().inicio.setText("Nivel 1");
                        Opciones.Singleton().salir.setText("Nivel 2");
                         /*while(true)
                         {
                             VentanaJuego.Singleton().repaint();
                         }*/
                        //this.setVisible(false);
                        this.setEstadon(Estadosn.n1);
                    }
                    else if(estado==Estados.salir)
                    {
                        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                    }
               }
               else
               {
                   VentanaJuego.Singleton().repaint();
                   this.setVisible(false);
               }
               break;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}

