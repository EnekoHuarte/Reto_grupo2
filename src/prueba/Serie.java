package prueba;

public class Serie {

	private int numSerie;
	private String marca;
	private String modelo;
	private int anioFabric;

	public Serie( String marca, String modelo, int anioFabric) {
		this.marca = marca;
		this.modelo = modelo;
		this.anioFabric = anioFabric;
	}

	public int getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnioFabric() {
		return anioFabric;
	}

	public void setAnioFabric(int anioFabric) {
		this.anioFabric = anioFabric;
	}
	
}
