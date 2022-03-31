package prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class test {
	public static int comprobarSerie(Serie s,Connection c) throws SQLException {

		Statement stm = null;
		ResultSet rs = null;
		
		stm = c.createStatement();
		rs = stm.executeQuery("select * from serie where marca like '"+s.getMarca()+"'&& modelo like '"+s.getModelo()+"', anioFabric like"+s.getAnioFabric());
			if(rs.getRow()==0) {
				stm.executeUpdate("INSERT INTO serie(marca,modelo,anioFabric) VALUES('"+s.getMarca()+"','"+s.getModelo()+"',"+s.getAnioFabric());
			}
		rs = stm.executeQuery("select numSerie from serie where marca like '"+s.getMarca()+"'&& modelo like '"+s.getModelo()+"', anioFabric like"+s.getAnioFabric());
		int numSerie = rs.getInt(1);
		return numSerie;
	}
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
	
	private static void inportarVehiculo(Connection cn, String respuesta) throws SQLException {
		
		Statement stm = null;
		ResultSet rs = null;
		Boolean existe = false;

	
			System.out.println("Introduce la matricula");
			String matricula = Console.readString();
			System.out.println("Introduce el número de Bastidor");
			int numBastidor = Console.readInt();
			System.out.println("Introduce el color");
			String color = Console.readString();
			System.out.println("Introduce la marca del vehiculo");
			String marca = Console.readString();
			System.out.println("Introduce el modelo");
			String modelo = Console.readString();
			System.out.println("Introduce el año de fabricación");
			int anioFab = Console.readInt();
			System.out.println("Introduce el precio");
			double precio = Console.readDouble();
			System.out.println("Introduce el número de asientos");
			int numAsientos = Console.readInt();
			System.out.println("NumPuertas");
			int numPuertas = Console.readInt();
			System.out.println("capMaletero");
			int capMaletero = Console.readInt();
			
			Serie serie = new Serie(marca,modelo,anioFab);
			Coche v =new Coche(matricula,numBastidor,color,numAsientos,precio,serie,numPuertas,capMaletero);
			int numSeire = comprobarSerie(serie,cn);
			serie.setNumSerie(numSeire);
			
			
			PreparedStatement ps = null;
			ps = cn.prepareStatement("INSERT INTO vehiculo values(?,?,?,?,?,?,?)");
			ps.setString(1, v.getMatricula());
			ps.setInt(2, v.getNumBastidor());
			ps.setString(3, v.getColor());
			ps.setInt(4, v.getNumAsientos());
			ps.setDouble(5, v.getPrecio());
			ps.setInt(6,v.getSerie().getNumSerie());
			ps.setInt(7, v.getCapMaletero());
			if(ps.executeUpdate()!=1) {
				throw new SQLException("Error");
			}

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

}

