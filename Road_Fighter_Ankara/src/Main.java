import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		AutomovilJugador jugador1= new AutomovilJugador(1,2.5,new Punto(1,0),1,2, 20);
		Mapa mapa= new Mapa(1,-5,5,100,30,2);
		AutomovilBot bot1= new AutomovilBot(1,1,new Punto(1,5),2,3);
		
		ArrayList<AutomovilJugador> jugadores = new ArrayList<AutomovilJugador>();
		ArrayList<AutomovilBot> bots = new ArrayList<AutomovilBot>();
		jugadores.add(jugador1);
		bots.add(bot1);
		
		Partida partida = new Partida(mapa, bots,jugadores);
		while(partida.partidaEnCurso()) {
			jugador1.avanzar();
			
			if(partida.validarChoque(jugador1))
				jugador1.chocar();
			
			else if(partida.validarExplosion(jugador1))
				jugador1.explotar();
			
			
		}
		
	}
}
