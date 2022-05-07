import java.awt.geom.Rectangle2D;

public class AutomovilBot extends Automovil {

	
	public AutomovilBot(int color,double velocidad,Rectangle2D.Double auto ) {
		super();
		this.auto= auto;
		this.color= color;
		this.velocidad= velocidad;
	}

	@Override
	public void explotar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void perderControl(int sentido) {
		auto.x+=sentido;
		
		System.out.println(this.getClass().toString() + ": Perdi el control por un choque y ahora estoy en la posicion X " + auto.x);
		
	}

}
