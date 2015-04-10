package Imagenes;

public class ControlVentanas {
			
	public enum EstadoJuego {ganar,perder,juego}
	EstadoJuego estadoJuego = EstadoJuego.juego;
	static ControlVentanas instancia=null;

	static ControlVentanas Singleton()
	{
	    if(instancia==null)
	    {
	       instancia=new ControlVentanas();
	    }
	    return instancia;
	}

		public void setEstadoJuego(EstadoJuego estadoJuego) {
	    switch(estadoJuego)
	    {
	        case ganar : VentanaJuego.Singleton().setVisible(false);
	                     Ganar.Singleton().repaint();                             
	                    break;
                    
	        case perder :Perder.Singleton().repaint();
                    VentanaJuego.Singleton().setVisible(false);
	        			 
	        			 break;
	        case juego : Ganar.Singleton().setVisible(false);
	        			 Perder.Singleton().setVisible(false);
	        			 VentanaJuego.Singleton().setVisible(true);                                         
	        			 break;
	    }
	    this.estadoJuego = estadoJuego;
	   }

		public EstadoJuego getEstadoJuego() {
			return estadoJuego;
		}

}