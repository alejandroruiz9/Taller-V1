
public class Obstaculo extends ComponenteDeMapa {

	public Obstaculo(int color, Punto posicion) {
		super(color, posicion);
		this.posicion = posicion;
	}

	@Override
	public void serChocado(Automovil chocador) {
		chocador.explotar();
	}
}
