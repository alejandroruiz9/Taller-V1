
import java.awt.geom.Rectangle2D;

public abstract class Automovil {
	//protected int forma;
	protected int color;
	protected double velocidad;
	protected Punto posicion;
	protected double tamanioX;
	protected double tamanioY;
	protected Rectangle2D.Double forma;

	public abstract void chocar();
	public abstract void explotar();
	public abstract void perderControl();
	
	
	public void avanzar() {
		posicion.sumarY(velocidad);
		forma.y+=velocidad;
		
		System.out.println("Avance y ahora estoy en la posicion Y:"+ posicion.getY() );
	}
	
	public double getVelocidad() {
		return velocidad;
	}

	public Punto getPosicion() {
		return posicion;
	}

	public double getTamanioX() {
		return tamanioX;
	}

	public double getTamanioY() {
		return tamanioY;
	}
	
	public Rectangle2D getForma() {
		return forma;
	}

}
