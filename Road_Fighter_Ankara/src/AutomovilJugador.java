
import java.util.Timer;
import java.util.TimerTask;

public class AutomovilJugador extends Automovil {
	private double coolDown;
	private double duracionSkill;

	public AutomovilJugador(int color, Punto posicion) {
		super(color, posicion);
		this.posicion = posicion;
		this.coolDown = 25;
		this.duracionSkill = 7;
		this.velocidad = 0;
	}

	@Override
	public void explotar() {
		if (this.isModoFantasma() == false) {
			this.velocidad = 0;
		}

	}

	@Override
	public void perderControl(int sentido) {
		if (this.isModoFantasma() == false) {
			this.posicion.sumarX(sentido);
		}
	}

	public void moverse(double sentido) {

		this.posicion.sumarX(sentido);

	}

	@Override
	public void serChocado(Automovil chocador) {

		if (!this.isModoFantasma()) {
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

	public void iniciarHabilidad() {
		this.setModoFantasma(true);

		Timer timer = new Timer();

		TimerTask tarea = new TimerTask() {

			@Override
			public void run() {
				duracionSkill--;

				if (duracionSkill == 0) {
					setModoFantasma(false);
					timer.cancel();
				}

			}
		};

		timer.scheduleAtFixedRate(tarea, 0, 1000);

		Timer timerCooldown = new Timer();

		TimerTask tarea2 = new TimerTask() {

			@Override
			public void run() {
				coolDown--;

				if (coolDown == 0) {
					timerCooldown.cancel();
				}

			}
		};

		timerCooldown.scheduleAtFixedRate(tarea2, 0, 1000);
	}
}
