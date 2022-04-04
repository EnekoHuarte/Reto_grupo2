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
	
	public static ArrayList<Coche> cochesStock(Connection c) throws SQLException {
		
		Statement stm = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList <Coche> vehic = new ArrayList<Coche>();
		Coche coche;
		
		stm = c.createStatement();
		
		rs = stm.executeQuery("select * from coche");
		while(rs.next()) {
			rs2 = stm.executeQuery("Select * from Serie where numSerie = "+rs.getInt(4));
			int numSerie = rs2.getInt(1);
			String marca = rs2.getString(2);
			String modelo = rs2.getString(3);
			int anioFab = rs2.getInt(4);
			coche = new Coche(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),marca,modelo,anioFab, numSerie);
			vehic.add(coche);
		}
		
		return vehic;
	}
	
	public static ArrayList<Camion> camionesStock(Connection c) throws SQLException {
		
		Statement stm = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList <Camion> vehic = new ArrayList<Camion>();
		Camion cami;
		
		stm = c.createStatement();
		rs = stm.executeQuery("select * from camion");
		
		while(rs.next()) {
			rs2 = stm.executeQuery("Select * from Serie where numSerie = "+rs.getInt(4));
			int numSerie = rs2.getInt(1);
			String marca = rs2.getString(2);
			String modelo = rs2.getString(3);
			int anioFab = rs2.getInt(4);
			cami = new Camion(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(5),rs.getInt(6),rs.getInt(7),rs.getString(8),marca,modelo,anioFab, numSerie);
			vehic.add(cami);
		}
		return vehic;
	}
	
	private static void inportarCoche(Connection cn) throws SQLException,NumberFormatException {
		
		Statement stm = null;
		ResultSet rs = null;


	
			System.out.println("Introduce la matricula");
			String matricula = Console.readString();
			System.out.println("Introduce el número de Bastidor");
			String numBastidor = Console.readString();
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
			int numSerie = comprobarSerie(serie,cn);
			Coche v =new Coche(matricula,numBastidor,color,numAsientos,precio,numSerie,numPuertas,capMaletero);
			
			
			PreparedStatement ps = null;
			ps = cn.prepareStatement("INSERT INTO coche values(?,?,?,?,?,?,?,?)");
			ps.setString(1, v.getMatricula());
			ps.setString(2, v.getNumBastidor());
			ps.setString(3, v.getColor());
			ps.setInt(4,v.getSerie().getNumSerie());
			ps.setDouble(5, v.getPrecio());
			ps.setInt(6, v.getNumAsientos());
			ps.setInt(7, v.getNumPuertas());
			ps.setInt(8, v.getCapMaletero());
			if(ps.executeUpdate()!=1) {
				throw new SQLException("Error");
			}

	}
	
	private static void importarCamion(Connection cn) throws SQLException,NumberFormatException {
		
		Statement stm = null;
		ResultSet rs = null;
		Boolean existe = false;

	
			System.out.println("Introduce la matricula");
			String matricula = Console.readString();
			System.out.println("Introduce el número de Bastidor");
			String numBastidor = Console.readString();
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
			System.out.println("carga total");
			int carga = Console.readInt();
			System.out.println("tipo mercancia(G = General / A = Árido / P = Peligroso)");
			String tipoMercancia = Console.readString();
			
			
			Serie serie = new Serie(marca,modelo,anioFab);
			int numSerie = comprobarSerie(serie,cn);
			Camion v =new Camion(matricula,numBastidor,color,numAsientos,precio,numSerie,carga,tipoMercancia);

			
			
			PreparedStatement ps = null;
			ps = cn.prepareStatement("INSERT INTO camion values(?,?,?,?,?,?,?,?)");
			ps.setString(1, v.getMatricula());
			ps.setString(2, v.getNumBastidor());
			ps.setString(3, v.getColor());
			ps.setInt(4,v.getSerie().getNumSerie());
			ps.setDouble(5, v.getPrecio());
			ps.setInt(6, v.getNumAsientos());
			ps.setInt(7, v.getCarga());
			ps.setObject(8, v.getTipoMercancia());
			if(ps.executeUpdate()!=1) {
				throw new SQLException("Error");
			}

		
	}
	public static void main(String[] args) {
	
		Conexion conexion = new Conexion(); 
		Connection cn = conexion.conectar();
		System.out.println("Bienvenido");
		int elec = 1;
		ArrayList<Coche> coches = new ArrayList<Coche>();
		ArrayList<Camion> camiones = new ArrayList<Camion>();
		
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
						coches = cochesStock(cn);
						camiones = camionesStock(cn);
						System.out.println("Coches Stock");
						for(Coche i : coches) {
							System.out.println(coches.toString());
							System.out.println("---------------");
						}
						System.out.println("Camiones Stock");
						for(Camion i : camiones) {
							System.out.println(camiones.toString());
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
						
						if (respuesta.equalsIgnoreCase("coche")) {
							inportarCoche(cn);
							System.out.println("Añadido OK");
						}else if (respuesta.equalsIgnoreCase("camion")){
							importarCamion(cn);
						}else {
							throw new VehiculoException("No se ha establecido bien el tipo de vehiculo");
						}
					}catch(VehiculoException e){
						System.out.println(e.getMessage());
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}catch(NumberFormatException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 3:
					try {
						System.out.println("quieres vender un coche o un camion?");
						String respuesta = Console.readString();
						
						if (respuesta.equalsIgnoreCase("coche")) {
							eliminarCoche(cn);
							System.out.println("Añadido OK");
						}else if (respuesta.equalsIgnoreCase("camion")){
						}else {
							throw new VehiculoException("No se ha establecido bien el tipo de vehiculo");
						}
					}catch(VehiculoException e){
						System.out.println(e.getMessage());
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}catch(NumberFormatException e) {
						System.out.println(e.getMessage());
					}
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

	private static void eliminarCoche(Connection cn)throws SQLException {
		
		ArrayList<Coche> coches = new ArrayList<Coche>();
		coches = cochesStock(cn);
		for(Coche i : coches) {
			System.out.println(i);
			System.out.println("---------------");
		}
		System.out.println("Escriba la matricula del coche para vender");
		String matricula = Console.readString();
		
		
	}



}

