/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imagenes;
import java.util.Scanner;
import javax.swing.SwingWorker;
/**
 *
 * @author Edu
 */
public class Temporizador extends SwingWorker<Boolean,Void>{
    
    int minutos, segundos;
    static Temporizador instancia = null;
    public static Temporizador Singleton()
    {
         if(instancia==null)
         {
            instancia=new Temporizador();

         }
         return instancia;
    }
        
    
    public String toString()
    {
        
        String tiempo = "";
        if( getMinutos() < 10)
        {
            tiempo += "0" + getMinutos() + ":";
        }
        else
        {
            tiempo += getMinutos() + ":";
        }
        
        if( getSegundos() < 10)
        {
            tiempo += "0" + getSegundos();
        }
        else
        {
            tiempo += getSegundos();
        }
        
        return tiempo;
    }
    
    public void decrementa()
    {
        if(getSegundos()==0)
        {
            setSegundos(59);
        }
        else
        {
            setSegundos(getSegundos()-1);
        }
        if(getSegundos()==59)
        {
            setMinutos(getMinutos()-1);
        }
        if(getMinutos()==-1)
        {
            setMinutos(59);
        }

    }
    

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    @Override
    protected Boolean doInBackground() throws Exception 
    {
        while(true)
        {
            try
            {
                System.out.println(toString());
                Thread.sleep(1000);
                decrementa();
            }
            catch(Exception e)
            {}
            
            if(this.toString().equals("00:00"))
                return false;
       }
        
   }
        
}
    

