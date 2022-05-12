
import java.awt.geom.Rectangle2D;

public abstract class Automovil {
	protected int color;
	protected double velocidad;
	private final int VELOCIDAD_MINIMA = 2;
	private final int VELOCIDAD_MAXIMA = 50;
	protected double x;
	protected double y;

	//public abstract void chocar(Automovil otroAuto);
	public abstract void explotar();
	public abstract void perderControl(int sentido);

//	public void avanzar() {
//		auto.y+=velocidad;
//		
//		System.out.println(this.getClass().toString() + ": Avance y ahora estoy en la posicion X:"+ auto.x +" Y: " + auto.y );
//	}
	
	public void acelerar() {
		
		for(int i=0;i<5;i++) {
			if(this.velocidad+1 <= VELOCIDAD_MAXIMA ) {
				this.velocidad++;
			}
		}
	}
	
	public void frenar() {
		
		for(int i=0;i<10;i++) {
			if(this.velocidad-1 >= 0) {
				this.velocidad--;
			}
		}
	}
	
	public double getVelocidad() {
		return velocidad;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

}
