package prueba;

public abstract class Vehiculo {


	private String matricula;
	private int numBastidor;
	private String color;
	private int numAsientos;
	private double precio;
	private Serie serie;
	
	private boolean pintado;
	
	public Vehiculo(String matricula, int numBastidor, String color, int numAsientos, double precio, Serie serie) {

		this.matricula = matricula;
		this.numBastidor = numBastidor;
		this.color = color;
		this.numAsientos = numAsientos;
		this.precio = precio;
		this.serie = serie;
		this.pintado = false;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getNumBastidor() {
		return numBastidor;
	}

	public void setNumBastidor(int numBastidor) {
		this.numBastidor = numBastidor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
		this.pintado = true;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public boolean isPintado() {
		return pintado;
	}


	
	
	
}
