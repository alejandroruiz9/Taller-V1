
import java.awt.geom.Rectangle2D;

public class AutomovilJugador extends Automovil {
	private boolean modoFantasma;
	private double coolDown;
	private int velocidadMinima=2;
	
	public AutomovilJugador(/*int forma,*/int color,double velocidad,Punto posicion,double tamanioX, double tamanioY, double coolDown) {
		super();
		this.forma= new Rectangle2D.Double(posicion.getX(), posicion.getY(),tamanioX, tamanioY );
		this.color= color;
		this.velocidad= velocidad;
		this.posicion= posicion;
		this.tamanioX= tamanioX;
		this.tamanioY=tamanioY;
		this.modoFantasma=false;
		this.coolDown=coolDown;
	}

	
	@Override
	public void chocar() {
		System.out.println("Choque");
		frenar(3);
		moverse(-1);
	}

	@Override
	public void explotar() {
		
		
	}

	@Override
	public void perderControl() {
		
		
	}
	
	public void moverse(int sentido) {
		posicion.setX(sentido);
		
		System.out.println("Me movi y ahora estoy en la posicion X: " + posicion.getX());
	}

	public void acelerar() {
		
		
	}

	public void frenar(int fuerzaFrenado) {
		if(velocidad - fuerzaFrenado >= velocidadMinima)
			velocidad-=fuerzaFrenado;
		else
			return;
		
		System.out.println("Frene y mi velocidad ahora es " + velocidad);
	}
	public void iniciarHabilidad() {
		
		
	}

	public boolean interseccion(Automovil otroAuto) {
		if(this.forma.getBounds2D().intersects(otroAuto.getForma().getBounds2D()))
			return true;
		else
			return false;
	}
	


}
