import java.util.ArrayList;

public class Mapa {
	private int disenio;
	private double limiteIzquierdo;
	private double limiteDerecho;
	private int puntosOtorgados;
	private double longitud;
	private int dificultad;
	private ArrayList<AutomovilBot> listaBots;
	private ArrayList<AutomovilJugador> listaJugadores;
	private ArrayList<Obstaculo> listaObstaculos;
	private int segmentos;
	private double longitudSegmento = 5 ;
	
	
	public Mapa(int disenio, double limiteIzquierdo, double limiteDerecho, int puntosOtorgados, double longitud,
			int dificultad,ArrayList<AutomovilBot> listaBots, ArrayList<AutomovilJugador> listaJugadores) {
		super();
		this.disenio = disenio;
		this.limiteIzquierdo = limiteIzquierdo;
		this.limiteDerecho = limiteDerecho;
		this.puntosOtorgados = puntosOtorgados;
		this.longitud = longitud;
		this.dificultad = dificultad;
		this.listaBots = listaBots;
		this.listaJugadores = listaJugadores;
		this.segmentos= (int) (longitud / longitudSegmento);
		
		setearObstaculos();
	}


	public double getLimiteIzquierdo() {
		return limiteIzquierdo;
	}


	public double getLimiteDerecho() {
		return limiteDerecho;
	}


	public int getDificultad() {
		return dificultad;
	}
	
	public double getLongitud() {
		return longitud;
	}


	public void setearObstaculos() {
		
	}
}
