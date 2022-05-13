

import java.util.Timer;
import java.util.TimerTask;

public class AutomovilJugador extends Automovil {
	private boolean modoFantasma;
	private double coolDown;
	private double duracionSkill;
	

	
	public AutomovilJugador(int color,Punto posicion) {
		super();
		this.posicion=posicion;
		this.modoFantasma = false;
		this.coolDown=25;
		this.duracionSkill=7;
		this.velocidad=0;
		this.color=color;
	}



	@Override
	public void explotar() {
		System.out.println(this.getClass().toString() + ": Explote");
		this.velocidad=0;

	}

	@Override
	public void perderControl(int sentido) {
		this.posicion.sumarX(sentido);
		
	}
	
	public void moverse(double sentido) {
		
		this.posicion.sumarX(sentido);
		
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
