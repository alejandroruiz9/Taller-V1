
import java.awt.geom.Rectangle2D;

public abstract class Automovil extends ComponenteDeMapa {
	protected int color;
	protected double velocidad;
	private final int VELOCIDAD_MINIMA = 2;
	private final int VELOCIDAD_MAXIMA = 50;

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
	public void chocar(ComponenteDeMapa chocado) {
		System.out.println(this.getClass().toString() + ": Choque");
		chocado.serChocado(this);
	}
	@Override
	public void serChocado(Automovil chocador) {
		//verifico de donde proviene el choque (del lado izquierdo o derecho)
		//para determinar hacia que sentido hacer el efecto.
		int sentidoChoque=1;
		if(this.posicion.getX() > chocador.posicion.getX()) {
			sentidoChoque=-1;
			}
		this.perderControl(sentidoChoque);
		this.acelerar();
		chocador.frenar();
		chocador.perderControl(sentidoChoque * -1);
		}
	
	public double getVelocidad() {
		return velocidad;
	}
	

}
