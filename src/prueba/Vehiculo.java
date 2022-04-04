package prueba;

public abstract class Vehiculo {


	private String matricula;
	private String numBastidor;
	private String color;
	private int numAsientos;
	private double precio;
	private Serie serie;
	
	private boolean pintado;
	
	public Vehiculo(String matricula, String numBastidor, String color, int numAsientos, double precio, String marca, String modelo, int anioFab, int numSerie) {

		this.matricula = matricula;
		this.numBastidor = numBastidor;
		this.color = color;
		this.numAsientos = numAsientos;
		this.precio = precio;
		this.serie = new Serie(marca,modelo,anioFab);
		this.serie.setNumSerie(numSerie);
		this.pintado = false;
	}

	@Override
	public String toString() {
		return "[matricula=" + matricula + ", numBastidor=" + numBastidor + ", color=" + color
				+ ", numAsientos=" + numAsientos + ", precio=" + precio + ", serie=" + serie.getNumSerie() + ", pintado=" + pintado;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNumBastidor() {
		return numBastidor;
	}

	public void setNumBastidor(String numBastidor) {
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
