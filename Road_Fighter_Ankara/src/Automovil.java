
import java.awt.geom.Rectangle2D;

public abstract class Automovil {
	protected int color;
	protected double velocidad;
	private final int VELOCIDAD_MINIMA = 2;
	//protected Punto posicion;
	//protected double tamanioX;
	//protected double tamanioY;
	protected Rectangle2D.Double auto;

	//public abstract void chocar(Automovil otroAuto);
	public abstract void explotar();
	public abstract void perderControl(int sentido);

	public void avanzar() {
		auto.y+=velocidad;
		
		System.out.println(this.getClass().toString() + ": Avance y ahora estoy en la posicion X:"+ auto.x +" Y: " + auto.y );
	}
	public void acelerar() {
		this.velocidad+=1;
		System.out.println(this.getClass().toString() + ": Acelere y ahora mi velocidad es de " + velocidad);
	}
	
	public void frenar(int fuerzaFrenado) {
		if(velocidad - fuerzaFrenado >= VELOCIDAD_MINIMA)
			velocidad-=fuerzaFrenado;
		else
			velocidad= VELOCIDAD_MINIMA;
		
		System.out.println(this.getClass().toString() + ": Frene y mi velocidad ahora es " + velocidad);
	}
	
	public double getVelocidad() {
		return velocidad;
	}

	public Rectangle2D.Double getAuto() {
		return auto;
	}

}
