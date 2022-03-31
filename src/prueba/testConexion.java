package prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testConexion {
	public static void main(String[] args) {
		Conexion conexion = new Conexion(); 
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("select * from serie"); 
			
			while (rs.next()) {
				int numSerie = rs.getInt(1);
				String marca = rs.getString(2);
				String modelo = rs.getString(3);
				int a�oFabric = rs.getInt(4);
				System.out.println(numSerie + "/" + marca + "/" + modelo + "/" + a�oFabric);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
