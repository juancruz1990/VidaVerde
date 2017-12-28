import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Producto {

	private int idProducto;
	private String tipoProducto;
	private String nombreProducto;
	private int stock;
	private int codigo;
	private int precio;

	// constructor con atributos por parametro
	public Producto(int idProducto, String tipoProducto, String nombreProducto,
			int stock, int codigo, int precio) {
		this.idProducto = idProducto;
		this.tipoProducto = tipoProducto;
		this.nombreProducto = nombreProducto;
		this.stock = stock;
		this.codigo = codigo;
		this.precio = precio;
	}

	// constructor vacio
	public Producto() {
		this.idProducto = -1;
		this.tipoProducto = "";
		this.nombreProducto = "";
		this.stock = 0;
		this.codigo = 0;
		this.precio = 0;
	}

	// getters & setters
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	// fin de getters & setters

	public void altaProducto(Producto altaProducto) {
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("INSERT INTO producto (codigo,nombre,stock,tipo,precio,visible) VALUES ('"
					+ altaProducto.getCodigo()
					+ "', '"
					+ altaProducto.getNombreProducto()
					+ "', '"
					+ altaProducto.getStock()
					+ "', '"
					+ altaProducto.getTipoProducto()
					+ "', '"
					+ altaProducto.getPrecio() + "', 'visible');");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"No se Registro el producto (ALTA PRODUCTO)");
		}
	}

	public ArrayList<Producto> buscarProducto(Producto productoBuscado) {
		Producto aux;
		ArrayList<Producto> miListaProducto = new ArrayList<Producto>();
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT * FROM biogreen.producto where ((visible = 'visible') and (codigo = '"
							+ productoBuscado.getCodigo()
							+ "' or nombre= '"
							+ productoBuscado.getNombreProducto()
							+ "' or tipo = '"
							+ productoBuscado.getTipoProducto() + "'));");

			while (rs.next()) {
				aux = new Producto();
				aux.setIdProducto(Integer.parseInt(rs.getString("id")));
				aux.setCodigo(Integer.parseInt(rs.getString("codigo")));
				aux.setPrecio(Integer.parseInt(rs.getString("precio")));
				aux.setStock(Integer.parseInt(rs.getString("stock")));
				aux.setNombreProducto(rs.getString("nombre"));
				aux.setTipoProducto(rs.getString("tipo"));
				miListaProducto.add(aux);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"Error al consultar BUSCAR PRODUCTO", "Error ",
					JOptionPane.ERROR_MESSAGE);
		}

		return miListaProducto;
	}

	public ArrayList<Producto> buscarProducto(Producto productoBuscado,
			String mensaje) {
		Producto aux;
		ArrayList<Producto> miListaProducto = new ArrayList<Producto>();
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto.executeQuery(mensaje);
			while (rs.next()) {
				aux = new Producto();
				aux.setIdProducto(Integer.parseInt(rs.getString("id")));
				aux.setCodigo(Integer.parseInt(rs.getString("codigo")));
				aux.setPrecio(Integer.parseInt(rs.getString("precio")));
				aux.setStock(Integer.parseInt(rs.getString("stock")));
				aux.setNombreProducto(rs.getString("nombre"));
				aux.setTipoProducto(rs.getString("tipo"));
				miListaProducto.add(aux);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"Error al consultar BUSCAR PRODUCTO", "Error ",
					JOptionPane.ERROR_MESSAGE);
		}

		return miListaProducto;
	}

	public ArrayList<Producto> buscarProductoPorId(int identy) {
		Producto aux;
		ArrayList<Producto> miListaProducto = new ArrayList<Producto>();
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT * FROM biogreen.producto where id= '"
							+ identy + "'and visible = 'visible';");
			while (rs.next()) {
				aux = new Producto();
				aux.setIdProducto(Integer.parseInt(rs.getString("id")));
				aux.setCodigo(Integer.parseInt(rs.getString("codigo")));
				aux.setPrecio(Integer.parseInt(rs.getString("precio")));
				aux.setStock(Integer.parseInt(rs.getString("stock")));
				aux.setNombreProducto(rs.getString("nombre"));
				aux.setTipoProducto(rs.getString("tipo"));
				miListaProducto.add(aux);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"Error al consultar BUSCAR PRODUCTO", "Error ",
					JOptionPane.ERROR_MESSAGE);
		}

		return miListaProducto;
	}

	public void bajaProducto(int identy) {
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("UPDATE biogreen.cliente SET visible = 'falso' where id= '"
					+ identy + "';");
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"Error al consultar BAJA PRODUCTO", "Error ",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void modificarProducto(Producto aModificar) {
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("UPDATE Biogreen.producto SET codigo= '"
					+ aModificar.getCodigo() + "',nombre= '"
					+ aModificar.getNombreProducto() + "',stock = '"
					+ aModificar.getStock() + "',tipo = '"
					+ aModificar.getTipoProducto() + "',precio = '"
					+ aModificar.getPrecio() + "'where id= '"
					+ aModificar.getIdProducto() + "';");
			JOptionPane.showMessageDialog(
					null,
					"el producto" + aModificar.getCodigo()
							+ aModificar.getNombreProducto()
							+ "se ha registrado correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"Error al consultar MODIFICAR PRODUCTO", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static boolean verificaProducto(int codigo) {
		boolean esta = false;

		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement buscar = conex.getConeccion().createStatement();
			ResultSet rs = buscar
					.executeQuery("Select * from biogreen.producto where codigo = '"
							+ codigo + "';");
			if (rs.next()) {
				System.out.println(rs.toString());
				esta = true;
			}

			buscar.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"No se verifico el producto (VERIFICA PRODUCTO)");
		}
		return esta;
	}

	public boolean verificacionProductoArray(ArrayList<Producto> miLista, int id) {

		boolean esta = false;

		for (int i = 0; i < miLista.size(); i++) {
			if (miLista.get(i).getIdProducto() == id) {
				esta = true;
			}
		}
		return esta;

	}

	public String[][] obtenerMatrizProducto(ArrayList<Producto> miLista,
			Producto producto) {

		String matrizInfo[][] = new String[miLista.size()][6];

		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getIdProducto() + "";
			matrizInfo[i][1] = miLista.get(i).getCodigo() + "";
			matrizInfo[i][2] = miLista.get(i).getNombreProducto() + "";
			matrizInfo[i][3] = miLista.get(i).getStock() + "";
			matrizInfo[i][4] = miLista.get(i).getTipoProducto() + "";
			matrizInfo[i][5] = miLista.get(i).getPrecio() + "";
		}

		return matrizInfo;
	}

}
