package Imagenes;

public class prueba {
	
	public static void main(String[] args)
	{
		Imagenes.Singleton().cargaCarpeta("Imagenes");
		while(true)
		{
			MenuInicio.Singleton().repaint();
		}
	}

}
