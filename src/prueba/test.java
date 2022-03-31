package prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class test {
	public static ArrayList<String> vehiculosStock(Connection c) throws SQLException {
		
		Statement stm = null;
		ResultSet rs = null;
		ArrayList <String> vehic = new ArrayList<String>();
		
		stm = c.createStatement();
		rs = stm.executeQuery("select * from vehiculo");
		while(rs.next()) {
			String datos = "matricula: " + rs.getString(1)+", "+
					"numBastidor: " +rs.getString(2)+", "+
					"color: " +rs.getString(3)+", "+
					"tipo:" +rs.getString(4)+", "+
					"serie: " +rs.getString(5)+", "+
					"precio:" +rs.getString(6)+", "+
					"numAsientos: " +rs.getString(7);
			vehic.add(datos);
		}
		return vehic;
	}
	public static void main(String[] args) {
	
		Conexion conexion = new Conexion(); 
		Connection cn = conexion.conectar();
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
					try {
						System.out.println();
						resultado = vehiculosStock(cn);
						for(String i : resultado) {
							System.out.println(i);
							System.out.println("---------------");
						}
					}catch(SQLException e) {
						e.printStackTrace();
					}
		
					
					break;
				case 2:
					try {
						System.out.println("quieres añadir un coche o un camion?");
						String respuesta = Console.readString();
						
						if (respuesta.equalsIgnoreCase("coche") || respuesta.equalsIgnoreCase("camion")) {
							inportarVehiculo(cn, respuesta);
							System.out.println("Añadido OK");
						}else {
							throw new VehiculoException("No se ha establecido bien el tipo de vehiculo");
						}
					}catch(VehiculoException e){
						System.out.println(e.getMessage());
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					
					
					
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
	
	private static void inportarVehiculo(Connection cn, String respuesta) throws SQLException {
		
		Statement stm = null;



		stm = cn.createStatement();
		
		
		stm.executeUpdate("INSERT INTO Vehiculo (matricula, numBastidor, color, tipo, numSerie, precio, numAsientos)" + 
					"VALUES('123sa5a',12,'rojo','coche',1,5000,2)");
		
			

		
	} 
	
	



}

