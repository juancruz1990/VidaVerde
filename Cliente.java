import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Cliente {

	private int idCliente;
	private int dni;
	private String nombre;
	private String apellido;
	private String direccion;
	private String localidad;

	// constructor con todos los atributos por parametro
	public Cliente(int idCliente, int dni, String nombre, String apellido,
			String direccion, String localidad) {
		this.idCliente = idCliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.localidad = localidad;
	}

	// constructor vacio
	public Cliente() {
		this.idCliente = -1;
		this.dni = -1;
		this.nombre = "";
		this.apellido = "";
		this.direccion = "";
		this.localidad = "";
	}

	// getters & setters
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	// fin de getter & setters

	public void registrarCliente(Cliente cliente) {
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("INSERT INTO cliente (dni,nombre,apellido,direccion,localidad,visible) VALUES ('"
					+ cliente.getDni()
					+ "', '"
					+ cliente.getNombre()
					+ "', '"
					+ cliente.getApellido()
					+ "', '"
					+ cliente.getDireccion()
					+ "', '" + cliente.getLocalidad() + "', 'visible');");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente el cliente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			conex.desconectar();
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"ERROR No se Registro el cliente");
		}
	}

	public ArrayList<Cliente> buscarClientePedido() {
		GenerarConeccion conex = new GenerarConeccion();
		ArrayList<Cliente> miListaCliente = new ArrayList<Cliente>();
		Cliente persona;
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT cliente.* FROM biogreen.cliente , biogreen.pedido where cliente.id = pedido.clienteId;");

			while (rs.next()) {
				persona = new Cliente();
				persona.setIdCliente(Integer.parseInt(rs.getString("id")));
				persona.setNombre(rs.getString("nombre"));
				persona.setApellido(rs.getString("apellido"));
				persona.setDni(Integer.parseInt(rs.getString("dni")));
				persona.setLocalidad(rs.getString("localidad"));
				persona.setDireccion(rs.getString("direccion"));
				miListaCliente.add(persona);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"Error al buscar cliente por pedido", "Error",
					JOptionPane.ERROR_MESSAGE);

		}
		return miListaCliente;
	}

	public boolean buscarCliente(int dni) {
		boolean esta = false;
		String h = "das";
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement buscar = conex.getConeccion().createStatement();
			ResultSet rs = buscar
					.executeQuery("Select dni from biogreen.cliente where dni = "
							+ h);
			if (rs.next()) {
				esta = true;
			}

			buscar.close();
			conex.desconectar();

		} catch (SQLException e) {
			conex.desconectar();
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"El cliente no se encuentra registrado");
		}
		return esta;
	}

	public void bajaCliente(int identy) {
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("UPDATE Biogreen.cliente SET visible= 'falso'"
					+ "where id= '" + identy + "' ;");
			JOptionPane.showMessageDialog(null, "el cliente ha sido eliminado",
					"Error ", JOptionPane.ERROR_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "ERROR el cliente no existe",
					"Error ", JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean verificaDni(String cadena) {
		boolean verdadero = true;
		try {
			int dni = Integer.parseInt(cadena);
		} catch (Exception p) {
			System.out.println(p.getMessage());
			verdadero = false;
			JOptionPane
					.showMessageDialog(null, "el dni ingresado no es valido");
		}
		return verdadero;

	}

	public ArrayList<Cliente> buscarClienteId(int identy) {
		// trar en un array list todos los uduarios de la base con los datos q
		// coincidan

		GenerarConeccion conex = new GenerarConeccion();
		ArrayList<Cliente> miListaCliente = new ArrayList<Cliente>();
		Cliente persona;
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT * FROM biogreen.cliente where id = '"
							+ identy + "';");

			while (rs.next()) {
				persona = new Cliente();
				persona.setIdCliente(Integer.parseInt(rs.getString("id")));
				persona.setNombre(rs.getString("nombre"));
				persona.setApellido(rs.getString("apellido"));
				persona.setDni(Integer.parseInt(rs.getString("dni")));
				persona.setLocalidad(rs.getString("localidad"));
				persona.setDireccion(rs.getString("direccion"));
				miListaCliente.add(persona);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"Error al realizar operacion buscarClienteId", "Error",
					JOptionPane.ERROR_MESSAGE);

		}
		return miListaCliente;
	}

	public ArrayList<Cliente> listarClientes() {
		// trar en un array list todos los uduarios de la base con los datos q
		// coincidan

		GenerarConeccion conex = new GenerarConeccion();
		ArrayList<Cliente> miListaCliente = new ArrayList<Cliente>();
		Cliente persona;
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT * FROM biogreen.cliente where visible =  'verdadero';");

			while (rs.next()) {
				persona = new Cliente();
				persona.setIdCliente(Integer.parseInt(rs.getString("id")));
				persona.setNombre(rs.getString("nombre"));
				persona.setApellido(rs.getString("apellido"));
				persona.setDni(Integer.parseInt(rs.getString("dni")));
				persona.setLocalidad(rs.getString("localidad"));
				persona.setDireccion(rs.getString("direccion"));
				miListaCliente.add(persona);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Error al listar clientes",
					"Error", JOptionPane.ERROR_MESSAGE);

		}
		return miListaCliente;
	}

	public ArrayList<Cliente> buscarClientesConMatriz(Cliente cliente) {
		// trar en un array list todos los uduarios de la base con los datos q
		// coincidan

		GenerarConeccion conex = new GenerarConeccion();
		ArrayList<Cliente> miListaCliente = new ArrayList<Cliente>();
		Cliente persona;
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT * FROM biogreen.cliente where  ((dni='"
							+ cliente.getDni()
							+ "' or nombre= '"
							+ cliente.getNombre()
							+ "' or apellido = '"
							+ cliente.getApellido()
							+ "') and (visible = 'verdadero'));");
			while (rs.next()) {
				persona = new Cliente();
				persona.setIdCliente(Integer.parseInt(rs.getString("id")));
				persona.setNombre(rs.getString("nombre"));
				persona.setApellido(rs.getString("apellido"));
				persona.setDni(Integer.parseInt(rs.getString("dni")));
				persona.setLocalidad(rs.getString("localidad"));
				persona.setDireccion(rs.getString("direccion"));
				miListaCliente.add(persona);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Error al consultar",
					"Error buscarClientesConMatriz (CLIENTE)",
					JOptionPane.ERROR_MESSAGE);

		}
		return miListaCliente;
	}

	public boolean verificacionCliente(ArrayList<Cliente> miLista, int id) {

		boolean esta = false;

		for (int i = 0; i < miLista.size(); i++) {
			if (miLista.get(i).getIdCliente() == id) {
				System.out.println(miLista.get(i).getIdCliente());
				esta = true;
			}
		}
		return esta;

	}

	public ArrayList<Cliente> reducirListaClientes(ArrayList<Cliente> miLista) {
		for (int i = 0; i < miLista.size(); i++) {
			for (int j = 0; j < miLista.size(); j++) {
				if (i != j) {
					if ((miLista.get(i).getIdCliente()) == (miLista.get(j)
							.getIdCliente())) {
						miLista.remove(i);
					}
				}
			}

		}

		return miLista;
	}

	public void modificaCliente(Cliente cliente) {

		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("UPDATE biogreen.cliente SET nombre = '"
					+ cliente.getNombre() + "' , apellido = '"
					+ cliente.getApellido() + "', dni = '" + cliente.getDni()
					+ "' , localidad = '" + cliente.getLocalidad()
					+ "', direccion = '" + cliente.getDireccion()
					+ "' where id = '" + cliente.getIdCliente() + "';");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane
					.showMessageDialog(
							null,
							"No se pudo modificar datos de la persona"
									+ cliente.getNombre() + " "
									+ cliente.getApellido());
		}

	}

	public String[][] obtenerMatrizCliente(Cliente cliente,
			ArrayList<Cliente> miLista) {

		String matrizInfo[][] = new String[miLista.size()][6];

		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getIdCliente() + "";
			matrizInfo[i][1] = miLista.get(i).getDni() + "";
			matrizInfo[i][2] = miLista.get(i).getNombre() + "";
			matrizInfo[i][3] = miLista.get(i).getApellido() + "";
			matrizInfo[i][4] = miLista.get(i).getDireccion() + "";
			matrizInfo[i][5] = miLista.get(i).getLocalidad() + "";
		}

		return matrizInfo;
	}
}


