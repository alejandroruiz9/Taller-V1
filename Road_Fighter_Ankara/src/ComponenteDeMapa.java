
public abstract class ComponenteDeMapa {
	protected int color;
	protected Punto posicion;

	public ComponenteDeMapa(int color, Punto posicion) {
		this.color = color;
		this.posicion = posicion;
	}

	public abstract void serChocado(Automovil chocador);

	public double getX() {
		return posicion.getX();
	}

	public double getY() {
		return posicion.getY();
	}

}
