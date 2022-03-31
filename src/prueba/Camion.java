package prueba;

public class Camion extends Vehiculo {

	private int carga;
	private tipo_mercancia tipoMercancia;
	
	public Camion(String matricula, int numBastidor, String color, int numAsientos, double precio, Serie serie,
			int carga, tipo_mercancia tipoMercancia) {
		super(matricula, numBastidor, color, numAsientos, precio, serie);
		this.carga = carga;
		this.tipoMercancia = tipoMercancia;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public tipo_mercancia getTipoMercancia() {
		return tipoMercancia;
	}

	public void setTipoMercancia(tipo_mercancia tipoMercancia) {
		this.tipoMercancia = tipoMercancia;
	}
	
}
