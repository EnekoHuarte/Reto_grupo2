package prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class test2 {
	public static void main(String[] args) throws SQLException {
	
		String[] info = new String[7];
		Conexion conexion = new Conexion(); 
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("select * from vehiculo"); 
			
			while (rs.next()) {
				String matricula = rs.getString(1);
				int numBastidor = rs.getInt(2);
				String color = rs.getString(3);
				String tipo = rs.getString(4);
				int numSerie = rs.getInt(5);
				double precio = rs.getDouble(6);
				int numAsientos = rs.getInt(7);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Bienvenido");
		int elec = 1;
		ArrayList<String> resultado = new ArrayList<String>();
		
		do {
			try {
				System.out.println();
				System.out.println("Elija una opcion");
				System.out.println("1. Visualizar vehiculos");
				System.out.println("2. Adquirir vehiculo");
				System.out.println("3. Vender vehiculo");
				System.out.println("4. Modificar datos del vehiculo");
				System.out.println("5. Ver repintado");
				System.out.println("6. Consultar ventas");
				System.out.println("7. Salir");
				System.out.println();
				
				elec = Console.readInt();
				
				switch(elec) {
				case 1:
					System.out.println();
						System.out.println("matricula: ");
						System.out.println("---------------");
		
					
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				default:
					System.out.println("Elección no valida");
				}
			}catch(NumberFormatException e) {
				System.out.println("Eleccion no válida");
			}
			
		}while(elec!=7);
	}

}
