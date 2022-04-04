package prueba;

public class Camion extends Vehiculo {

	private int carga;
	private String tipoMercancia;
	
	public Camion(String matricula, String numBastidor, String color, double precio,int numAsientos, int carga, String tipoMercancia,
			String marca, String modelo, int anioFab, int numSerie) {
		super(matricula, numBastidor, color, numAsientos, precio, modelo, modelo, anioFab, numSerie);
		this.carga = carga;
		this.tipoMercancia = tipoMercancia;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public String getTipoMercancia() {
		return tipoMercancia;
	}

	public void setTipoMercancia(String tipoMercancia) {
		this.tipoMercancia = tipoMercancia;
	}

	@Override
	public String toString() {
		return "Camion"+ super.toString()+", carga=" + carga + ", tipoMercancia=" + tipoMercancia + "]";
	}
	
}
