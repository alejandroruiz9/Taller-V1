import java.awt.geom.Rectangle2D;

public class AutomovilBot extends Automovil {

	
	public AutomovilBot(int color,Punto posicion) {
		super();
		this.posicion=posicion;
		this.color= color;
		this.velocidad=30;//Los automóvil Bot tienen una velocidad constante
	}

	@Override
	public void explotar() {
		// TODO Auto-generated method stub
		//Eliminar auto
	}
	

	@Override
	public void perderControl(int sentido) {
		this.posicion.sumarX(sentido);
				
	}

}
