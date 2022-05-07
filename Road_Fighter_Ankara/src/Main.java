
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args) {
		//Defino las formas de los autos posibles y su posicion (se puede hacer directamente al momento de crear el auto)
		Rectangle2D.Double auto1= new Rectangle2D.Double(0.5,0,2,3); 
		Rectangle2D.Double auto2= new Rectangle2D.Double(0,5,2,3);
		
		//creo los autos
		AutomovilJugador jugador1= new AutomovilJugador(1,2.5,auto1,2);
		AutomovilBot bot1= new AutomovilBot(1,2.5,auto2);
		
		//creo el mapa
		Mapa mapa= new Mapa(1,-5,5,100,30,2);

		//defino las listas de autos de jugadores y autos bot
		ArrayList<AutomovilJugador> jugadores = new ArrayList<AutomovilJugador>();
		ArrayList<AutomovilBot> bots = new ArrayList<AutomovilBot>();
		jugadores.add(jugador1);
		bots.add(bot1);
		
		Partida partida = new Partida(mapa, bots,jugadores);
		
		
		//prueba de logica de juego
		while(partida.partidaEnCurso()) {
			jugador1.avanzar();
			jugador1.acelerar();
			jugador1.moverse(0.5);
			
			
			partida.validarChoque(jugador1);
			partida.validarExplosion();
		}
		System.out.println("Finalizo la partida");
	}
}
