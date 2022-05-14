
public class AutomovilBot extends Automovil {

	private final int VELOCIDAD_CONSTANTE = 30;

	public AutomovilBot(int color, Punto posicion) {
		super(color, posicion);
		this.posicion = posicion;
		this.velocidad = VELOCIDAD_CONSTANTE;// Los automóvil Bot tienen una velocidad constante (30)
	}

	@Override
	public void explotar() {
		// TODO Auto-generated method stub
		// Eliminar auto
	}

	@Override
	public void serChocado(Automovil chocador) {

		if (!chocador.isModoFantasma()) {
			// verifico de donde proviene el choque (del lado izquierdo o derecho)
			// para determinar hacia que sentido hacer el efecto.
			int sentidoChoque = -1;
			if (this.posicion.getX() > chocador.posicion.getX()) {
				sentidoChoque = 1;
			}
			this.perderControl(sentidoChoque);
			this.acelerar();
			chocador.frenar();
			chocador.perderControl(sentidoChoque * -1);
		}

	}

	@Override
	public void perderControl(int sentido) {
		this.posicion.sumarX(sentido);

	}

}
