
public class Punto {
	
	private double x,y;

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	public void sumarY(double desY) {
		this.y+=desY;
	}
	
	public void setX(double desX) {
		this.x+=desX;
	}

}
