package prueba;

public class Coche extends Vehiculo {

	private int numPuertas;
	private int capMaletero;
	
	public Coche(String matricula, int numBastidor, String color, int numAsientos, double precio, Serie serie, int numPuertas, int capMaletero) {
		super(matricula, numBastidor, color, numAsientos, precio, serie);
		this.numPuertas = numPuertas;
		this.capMaletero = capMaletero;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public int getCapMaletero() {
		return capMaletero;
	}

	public void setCapMaletero(int capMaletero) {
		this.capMaletero = capMaletero;
	}
	
	

}
