
public class Mapa {
	private int disenio;
	private double limiteIzquierdo;
	private double limiteDerecho;
	private int puntosOtorgados;
	private double longitud;
	private int dificultad;
	
	
	public Mapa(int disenio, double limiteIzquierdo, double limiteDerecho, int puntosOtorgados, double longitud,
			int dificultad) {
		super();
		this.disenio = disenio;
		this.limiteIzquierdo = limiteIzquierdo;
		this.limiteDerecho = limiteDerecho;
		this.puntosOtorgados = puntosOtorgados;
		this.longitud = longitud;
		this.dificultad = dificultad;
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
