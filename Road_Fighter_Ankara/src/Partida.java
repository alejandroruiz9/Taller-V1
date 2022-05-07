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

	public boolean validarChoque(AutomovilJugador jugador) {
		
		for (AutomovilJugador jugadores : listaJugadores) {
			if(jugador.interseccion(jugadores) && jugador != jugadores)
				return true;
		}

		for (AutomovilBot bot : listaBots) {
			if(jugador.interseccion(bot))
				return true;
		}
		
		return false;
	}
	
	public boolean validarExplosion(AutomovilJugador jugador) {
		
		double posicionJugador= jugador.getPosicion().getX();
		if(posicionJugador >= mapa.getLimiteDerecho() || posicionJugador<= mapa.getLimiteIzquierdo() )
			return true;
		
		return false;
	}

	public boolean partidaEnCurso() {
		for (AutomovilJugador jugadores : listaJugadores) {
			if(jugadores.getPosicion().getY() >= mapa.getLongitud())
				return false;
		}
		return true;
	}
}
