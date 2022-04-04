package prueba;

public class Coche extends Vehiculo {

	private int numPuertas;
	private int capMaletero;
	
	
	public Coche(String matricula, String numBastidor, String color, double precio,int numAsientos, int numPuertas, int capMaletero,String marca, String modelo, int anioFab,int numSerie) {
		super(matricula, numBastidor, color, numAsientos, precio, modelo, modelo, anioFab,numSerie);
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

	@Override
	public String toString() {
		return "Coche "+super.toString() +", numPuertas=" + numPuertas + ", capMaletero=" + capMaletero + "]";
	}
	
	

}
