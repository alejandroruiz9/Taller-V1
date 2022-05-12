
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

public class AutomovilJugador extends Automovil {
	private boolean modoFantasma;
	private double coolDown;
	private double duracionSkill;
	

	
	public AutomovilJugador(int color,double x, double y) {
		super();
		this.x=x;//posicion inicial en x
		this.y=y;//posicion inicial en y
		this.modoFantasma = false;
		this.coolDown=25;
		this.duracionSkill=7;
		this.velocidad=0;
		this.color=color;
	}

	public void chocar(Automovil otroAuto) {
		System.out.println(this.getClass().toString() + ": Choque");
		int sentidoChoque=1;
		
		//verifico de donde proviene el choque (del lado izquierdo o derecho)
		//para determinar hacia que sentido hacer el efecto.
		if(this.x > otroAuto.x) {
			sentidoChoque=-1;
		}
		otroAuto.perderControl(sentidoChoque);
		this.perderControl(sentidoChoque * -1);
		
		//Verifico si el choque es trasero o delantero.
		if(this.y > otroAuto.y) {
			this.acelerar();
			otroAuto.frenar();
		}
		else {
			otroAuto.acelerar();
			this.frenar();
		}	
	}

	@Override
	public void explotar() {
		System.out.println(this.getClass().toString() + ": Explote");
		this.x-=2;
	}

	@Override
	public void perderControl(int sentido) {
		this.x+=sentido;
		
	}
	
	public void moverse(double sentido) {
		
		this.x+=sentido;
		
	}




	public void iniciarHabilidad() {
		modoFantasma=true;
		
		System.out.println("Start skill");
		
		Timer timer = new Timer();

		TimerTask tarea = new TimerTask() {
			
			@Override
			public void run() {
				duracionSkill--;
				System.out.println("Duracion Skill:" + duracionSkill);
				
				if(duracionSkill==0) {
					timer.cancel();
				}
				
			}
		};
		
		timer.scheduleAtFixedRate(tarea, 0, 1000);
		
		Timer timerCooldown = new Timer();
		
		
		System.out.println("Start Cooldown");
			
		TimerTask tarea2 = new TimerTask() {
				
			@Override
			public void run() {
				coolDown--;
				System.out.println("Cooldown: "+coolDown);
					
				if(coolDown==0) {
					timerCooldown.cancel();
				}
					
			}
		};
			
			timerCooldown.scheduleAtFixedRate(tarea2,0,1000);

		

		
	}

//	public boolean interseccion(Automovil otroAuto) {
//		
//		if(modoFantasma = true) {
//			return false;
//		}
//		
//		if(this.auto.getBounds2D().intersects(otroAuto.getAuto().getBounds2D()))
//			return true;
//		else
//			return false;
//	}
	
//	@Override
//	public String toString() {
//		return ("Posicion: "+this.auto.y);
//	}

}
