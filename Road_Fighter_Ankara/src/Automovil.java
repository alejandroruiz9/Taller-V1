
public abstract class Automovil extends ComponenteDeMapa {
	protected double velocidad;
	protected Punto posicion;
	private final int VELOCIDAD_MAXIMA = 50;
	private boolean modoFantasma;

	public Automovil(int color, Punto posicion) {
		super(color, posicion);
		this.posicion = posicion;
		this.modoFantasma = false;
	}

	// public abstract void chocar(Automovil otroAuto);
	public abstract void explotar();

	public abstract void perderControl(int sentido);

	public void avanzar() {
		this.posicion.incY(this.velocidad);
	}

	public void acelerar() {

		for (int i = 0; i < 5; i++) {
			if (this.velocidad + 1 <= VELOCIDAD_MAXIMA) {
				this.velocidad++;
			}
		}
		this.avanzar();
	}

	public void frenar() {

		for (int i = 0; i < 10; i++) {
			if (this.velocidad - 1 >= 0) {
				this.velocidad--;
			}
		}
	}

	public void chocar(ComponenteDeMapa chocado) {
		chocado.serChocado(this);
	}

	public double getVelocidad() {
		return velocidad;
	}

	public boolean isModoFantasma() {
		return this.modoFantasma;
	}

	public void setModoFantasma(boolean modoFantasma) {
		this.modoFantasma = modoFantasma;
	}

}
