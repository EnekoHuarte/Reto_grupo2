package prueba;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruevaVisualizar {
	public static void main(String[] args) {
		Conexion conexion = new Conexion(); 
		Connection cn = null;
		Statement stm = null;
		ResultSet vehiculos = null;
		
			
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			vehiculos = stm.executeQuery("select * from vehiculos"); 
				
			while (vehiculos.next()) {
				int numSerie = vehiculos.getInt(1);
				String marca = vehiculos.getString(2);
				String estado = vehiculos.getString(3);
				int añoFabric = vehiculos.getInt(4);
				
				if(estado == "vendido")
				System.out.println(numSerie + "/" + marca + "/"  + "/" + añoFabric);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}


