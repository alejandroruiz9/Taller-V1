import java.awt.geom.Rectangle2D;

public class AutomovilBot extends Automovil {
	
	
	public AutomovilBot(int color,double velocidad,Punto posicion,double tamanioX, double tamanioY) {
		super();
		this.forma= new Rectangle2D.Double(posicion.getX(), posicion.getY(),tamanioX, tamanioY );
		this.color= color;
		this.velocidad= velocidad;
		this.posicion= posicion;
		this.tamanioX= tamanioX;
		this.tamanioY=tamanioY;
	}

	@Override
	public void chocar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void explotar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perderControl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avanzar() {
		// TODO Auto-generated method stub
		
	}

}
