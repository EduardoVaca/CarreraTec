/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imagenes;

import java.awt.Graphics;

public class Fondo {

    private int x=0,y=0; 
    int aceleracion = 8; //velocidad a la que se mueve el background
    int incrementoMax=100; // duracion de los lapsos para incrementar velocidad
    int contadorIncremento=0; //inicio de un lapso
    boolean desarrollo, fin = false;
    boolean inicio=true;
    int contn2=0;
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
            if(inicio)
            {
                g.drawImage(Imagenes.Singleton().imagen("Nivel1inicio.png"), getX(), 25, null);
            }
            else if(desarrollo)
            {
                g.drawImage(Imagenes.Singleton().imagen("Nivel1.png"), getX(), 25, null);
            }
            else if(fin)
            {
                g.drawImage(Imagenes.Singleton().imagen("Nivel1final.png"), getX(), 25, null);
            }
                        if(!fin || getX()>-1988)
                        {
                        setX(getX() - aceleracion);
                        }
                            if(inicio && getX()<-994)
                            {
                                setX(0);
                                inicio=false;
                                desarrollo=true;
                            }
                            if(getX()<-1988)
                            {
                                setX(0);
                                if(desarrollo)
                                {
                                    desarrollo=false;
                                    fin=true;
                                }
                                else if(fin)
                                {

                                    Personaje.Singleton().setEstado(Personaje.Singleton().estado.ganar);
                                }
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
		if(inicio)
                {
                    g.drawImage(Imagenes.Singleton().imagen("Nivel2.jpg"), getX(), 25, null);
                }
                else if(fin)
                {
                    g.drawImage(Imagenes.Singleton().imagen("Nivel2final.png"), getX(), 25, null);
                }    
                
                if(!fin || getX()>-955)
                {
                setX(getX() - aceleracion);
                }
                if(getX()<-955)
                {
                    contn2++;
                    if(!fin)
                    {
                        setX(0);
                    }
                    if(contn2==2)
                    {
                        inicio=false;
                        fin=true;
                    }
                    else if(fin)
                    {
                    }
                }
    }


 public int getX() {
        return x;
    }

    public void setX(int x) 
    {
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


