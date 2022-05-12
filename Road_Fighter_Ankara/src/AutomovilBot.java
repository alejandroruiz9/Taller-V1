import java.awt.geom.Rectangle2D;

public class AutomovilBot extends Automovil {

	
	public AutomovilBot(int color,double x, double y) {
		super();
		this.x=x;//posicion inicial en x
		this.y=y;//posicion inicial en y
		this.color= color;
		this.velocidad=30;//Los automóvil Bot tienen una velocidad constante
	}

	@Override
	public void explotar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perderControl(int sentido) {
		this.x+=sentido;
				
	}

}
