
import java.awt.geom.Rectangle2D;

public class AutomovilJugador extends Automovil {
	private boolean modoFantasma;
	private double coolDown;

	
	public AutomovilJugador(int color,double velocidad,Rectangle2D.Double auto , double coolDown) {
		super();
		this.auto= auto;
		this.color= color;
		this.velocidad= velocidad;
		this.modoFantasma=false;
		this.coolDown=coolDown;
	}

	public void chocar(Automovil otroAuto) {
		System.out.println(this.getClass().toString() + ": Choque");
		int setidoChoque=1;
		if(auto.x > otroAuto.getAuto().x) {
			setidoChoque=-1;
		}
		otroAuto.perderControl(setidoChoque);
		this.perderControl(setidoChoque * -1);
		
		if(auto.y > otroAuto.getAuto().y) {
			this.acelerar();
			otroAuto.frenar(3);
		}
		else {
			otroAuto.acelerar();
			this.frenar(3);
		}	
	}

	@Override
	public void explotar() {
		System.out.println(this.getClass().toString() + ": Explote");
		this.auto.x-=2;
	}

	@Override
	public void perderControl(int sentido) {
		auto.x+=sentido;
		
		System.out.println(this.getClass().toString() + ": Perdi el control por un choque y ahora estoy en la posicion X: " + auto.x);
	}
	
	public void moverse(double sentido) {
		auto.x+=sentido;
		
		System.out.println(this.getClass().toString() + ": Me movi y ahora estoy en la posicion X: " + auto.x);
	}




	public void iniciarHabilidad() {
		
		
	}

	public boolean interseccion(Automovil otroAuto) {
		if(this.auto.getBounds2D().intersects(otroAuto.getAuto().getBounds2D()))
			return true;
		else
			return false;
	}
	


}
