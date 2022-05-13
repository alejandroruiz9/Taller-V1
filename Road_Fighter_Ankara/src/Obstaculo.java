
public class Obstaculo extends ComponenteDeMapa {


	public Obstaculo(Punto posicion) {
		super();
		this.posicion = posicion;
	}

	@Override
	public void serChocado(Automovil chocador) {
		chocador.explotar();
	}
	
	
}
