import java.util.ArrayList;


public class Partida {
	private Mapa mapa;
	private ArrayList<AutomovilBot> listaBots;
	private ArrayList<AutomovilJugador> listaJugadores;
	
	
	
	public Partida(Mapa mapa, ArrayList<AutomovilBot> listaBots, ArrayList<AutomovilJugador> listaJugadores) {
		super();
		this.mapa = mapa;
		this.listaBots = listaBots;
		this.listaJugadores = listaJugadores;
	}

	public void validarChoque(AutomovilJugador jugador) {
		
		for (AutomovilJugador jugadores : listaJugadores) {
			if(jugador.interseccion(jugadores) && jugador != jugadores)
				jugador.chocar(jugadores);
		}

		for (AutomovilBot bot : listaBots) {
			if(jugador.interseccion(bot))
				jugador.chocar(bot);
		}
		
	}
	
	public void validarExplosion() {
		for (AutomovilJugador jugadores : listaJugadores) {
			double posicionJugador= jugadores.auto.getX();
			if(posicionJugador >= mapa.getLimiteDerecho() || posicionJugador<= mapa.getLimiteIzquierdo() )
				jugadores.explotar();
		}
		
	}

	public boolean partidaEnCurso() {
		for (AutomovilJugador jugadores : listaJugadores) {
			if(jugadores.auto.getY() >= mapa.getLongitud()) {
				return false;
				//finalizarPartida();
			}
				
		}
		return true;
	}

	private void finalizarPartida() {
		
		
	}
}
