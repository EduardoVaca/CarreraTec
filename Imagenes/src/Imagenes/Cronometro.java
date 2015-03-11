package Imagenes;

public class Cronometro {
	long retardo;
	long arranque;
	
	public Cronometro(int frames, int n)
	{
		retardo=(n/30)*frames;
		arranque=System.currentTimeMillis();
	}
	
	public boolean esTiempo()
	{
		long ahora=System.currentTimeMillis();
		if((ahora-arranque) >retardo) //conviene con mayor
		{
			arranque=ahora;
			return true;
		}
		return false;
	}

}
