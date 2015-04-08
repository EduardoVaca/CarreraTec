/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imagenes;

import java.awt.Graphics;

public class Fondo {

    private int x=0,y=0; 
	int aceleracion = 4; //velocidad a la que se mueve el background
    int incrementoMax=250; // duracion de los lapsos para incrementar velocidad
    int contadorIncremento=0; //inicio de un lapso
    
    static Fondo instancia = null;

    static Fondo Singleton()
    {
        if(instancia==null)
        {
            instancia=new Fondo();
        }
        return instancia;
    }
   
    public int getAceleracion() {
		return aceleracion;
	}

	public void setAceleracion(int aceleracion) {
		this.aceleracion = aceleracion;
	}

	 public void dibujaImagenn1(Graphics g)
        {
		/*Al cumplir con un lapso se incrementa la aceleracion siempre y cuando no haya una colision*/
		if(contadorIncremento == incrementoMax) 
		{
			aceleracion+=1;	
			contadorIncremento=0;
		}
		
		contadorIncremento++;
		
        g.drawImage(Imagenes.Singleton().imagen("Nivel1.jpg"), getX(), getY(), null);
        setX(getX() - aceleracion);
        if(getX()<-996)
        {
        	setX(0);
        }
    }
        
	public void dibujaImagenn2(Graphics g)
        {

    

		/*Al cumplir con un lapso se incrementa la aceleracion siempre y cuando no haya una colision*/
		if(contadorIncremento == incrementoMax) 
		{
			aceleracion+=1;	
			contadorIncremento=0;
		}
		
		contadorIncremento++;
		
        g.drawImage(Imagenes.Singleton().imagen("Nivel2.png"), getX(), getY(), null);
        setX(getX() - aceleracion);
        if(getX()<-955)
        {
        	setX(0);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getIncrementoMax() {
  		return incrementoMax;
  	}

  	public void setIncrementoMax(int incrementoMax) {
  		this.incrementoMax = incrementoMax;
  	}
    
}


