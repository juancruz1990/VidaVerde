import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Pedido {
	private int idPedido;
	private int cantidad;
	private Producto productoEncargado;
	private int codigoProducto;
	private String fecha;
	private int idCliente;
	private int idFactura;
	private int idNotaPedido;

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdNotaPedido() {
		return idNotaPedido;
	}

	public void setIdNotaPedido(int idNotaPedido) {
		this.idNotaPedido = idNotaPedido;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProductoEncargado() {
		return productoEncargado;
	}

	public void setProductoEncargado(Producto productoEncargado) {
		this.productoEncargado = productoEncargado;
	}

	// constructos vacio
	public Pedido() {
		this.idPedido = -1;
		this.cantidad = 0;
	}

	public void altaPedido(Pedido altaPedido) {
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("INSERT INTO biogreen.pedido ( codigoProducto, cantidad, fecha, clienteId,facturaId , NotaPedidoId ,visible) VALUES ('"
					+ altaPedido.getCodigoProducto()
					+ "' , '"
					+ altaPedido.getCantidad()
					+ "' , ' "
					+ altaPedido.getFecha()
					+ "' , '"
					+ altaPedido.getIdCliente()
					+ "', '"
					+ 0
					+ "','"
					+ altaPedido.getIdNotaPedido() + "', 'visible')");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"No se Registro el pedido (alta pedido)");
		}
	}

	public void bajaPedido(int identy) {
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("UPDATE Biogreen.pedido SET visible= 'falso'"
					+ "where id= '" + identy + "' ;");
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"Error al dar de baja (Pedido::bajaPedido)", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<Pedido> buscarPedidoModificar(int id) {
		GenerarConeccion conex = new GenerarConeccion();
		ArrayList<Pedido> miListaPedido = new ArrayList<Pedido>();
		Pedido elemento;
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT * FROM biogreen.pedido where id = '"
							+ id + "';");

			while (rs.next()) {
				elemento = new Pedido();
				elemento.setIdPedido(Integer.parseInt(rs.getString("id")));
				elemento.setCodigoProducto(Integer.parseInt(rs
						.getString("codigoProducto")));
				elemento.setCantidad(Integer.parseInt(rs.getString("cantidad")));
				elemento.setFecha(rs.getString("fecha"));
				elemento.setIdCliente(Integer.parseInt(rs
						.getString("clienteId")));

				miListaPedido.add(elemento);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();
		}

		catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Error al consultar",
					"Error buscarPedidosModificar", JOptionPane.ERROR_MESSAGE);

		}
		return miListaPedido;
	}

	public ArrayList<Pedido> buscarPedidoPorFactura(int id) {
		GenerarConeccion conex = new GenerarConeccion();
		ArrayList<Pedido> miListaPedido = new ArrayList<Pedido>();
		Pedido elemento;
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT * FROM biogreen.pedido where ((visible = 'visible') and (facturaId = '"
							+ id + "'));");

			while (rs.next()) {
				elemento = new Pedido();
				elemento.setIdPedido(Integer.parseInt(rs.getString("id")));
				elemento.setCodigoProducto(Integer.parseInt(rs
						.getString("codigoProducto")));
				elemento.setCantidad(Integer.parseInt(rs.getString("cantidad")));
				elemento.setFecha(rs.getString("fecha"));
				elemento.setIdCliente(Integer.parseInt(rs
						.getString("clienteId")));

				miListaPedido.add(elemento);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();
		}

		catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Error al consultar",
					"Error buscarPedidosPorFactura", JOptionPane.ERROR_MESSAGE);

		}
		return miListaPedido;
	}

	public ArrayList<Pedido> buscarPedidosClientesConMatriz(int id) {

		GenerarConeccion conex = new GenerarConeccion();
		ArrayList<Pedido> miListaPedido = new ArrayList<Pedido>();
		Pedido elemento;
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT * FROM biogreen.pedido where ((visible = 'visible') and (clienteId ='"
							+ id + "')) ;");
			while (rs.next()) {
				elemento = new Pedido();
				elemento.setIdPedido(Integer.parseInt(rs.getString("id")));
				elemento.setCodigoProducto(Integer.parseInt(rs
						.getString("codigoProducto")));
				elemento.setCantidad(Integer.parseInt(rs.getString("cantidad")));
				elemento.setFecha(rs.getString("fecha"));
				elemento.setIdCliente(Integer.parseInt(rs
						.getString("clienteId")));

				miListaPedido.add(elemento);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Error al consultar",
					"Error buscarPedidosClientesConMatriz",
					JOptionPane.ERROR_MESSAGE);

		}
		return miListaPedido;
	}

	public ArrayList<Pedido> buscarPedidosConMatriz(int id) {

		GenerarConeccion conex = new GenerarConeccion();
		ArrayList<Pedido> miListaPedido = new ArrayList<Pedido>();
		Pedido elemento;
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT * FROM biogreen.pedido where clienteId ='"
							+ id + "' ;");
			while (rs.next()) {
				elemento = new Pedido();
				elemento.setIdPedido(Integer.parseInt(rs.getString("id")));
				elemento.setCodigoProducto(Integer.parseInt(rs
						.getString("codigoProducto")));
				elemento.setCantidad(Integer.parseInt(rs.getString("cantidad")));
				elemento.setFecha(rs.getString("fecha"));
				elemento.setIdCliente(Integer.parseInt(rs
						.getString("clienteId")));

				miListaPedido.add(elemento);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Error al consultar",
					"Error buscarPedidosConMatriz ", JOptionPane.ERROR_MESSAGE);

		}
		return miListaPedido;
	}

	public ArrayList<Pedido> buscarPedidosCliente(int id,
			ArrayList<Producto> producto) {

		GenerarConeccion conex = new GenerarConeccion();
		ArrayList<Pedido> miListaPedido = new ArrayList<Pedido>();
		Pedido elemento;
		Producto prod;
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("select codigoProducto , cantidad,nombre , precio from biogreen.pedido , biogreen.producto where biogreen.pedido.clienteId = '"
							+ id
							+ "' and biogreen.pedido.facturaId = 0 and biogreen.pedido.codigoProducto = biogreen.producto.codigo;");

			while (rs.next()) {
				prod = new Producto();
				elemento = new Pedido();
				elemento.setCodigoProducto(Integer.parseInt(rs
						.getString("codigoProducto")));
				elemento.setCantidad(Integer.parseInt(rs.getString("cantidad")));
				prod.setNombreProducto(rs.getString("nombre"));
				prod.setPrecio(Integer.parseInt(rs.getString("precio")));

				miListaPedido.add(elemento);
				producto.add(prod); // agrego elementos a mi lista de productos
									// pasada por paremetro
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Error al consultar",
					"Error buscarPedidosCliente", JOptionPane.ERROR_MESSAGE);

		}
		return miListaPedido;
	}

	public int importePedidos(int id) {
		int i = 0;
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("select sum( cantidad * precio) as total from biogreen.pedido , biogreen.producto where ((clienteId = '"
							+ id
							+ "' )and (biogreen.pedido.codigoProducto = biogreen.producto.codigo))and pedido.facturaId = 0;");

			while (rs.next()) {
				i = Integer.parseInt(rs.getString("total"));

			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Error al consultar",
					"Error importePedidos", JOptionPane.ERROR_MESSAGE);

		}
		return i;
	}

	public boolean verificacionPedido(ArrayList<Pedido> miLista, int id) {

		boolean esta = false;

		for (int i = 0; i < miLista.size(); i++) {
			if (miLista.get(i).getIdPedido() == id) {
				esta = true;
			}
		}
		return esta;

	}

	public boolean verificacionPedidoCliente(ArrayList<Pedido> miLista, int id) {

		boolean esta = false;

		for (int i = 0; i < miLista.size(); i++) {
			if (miLista.get(i).getIdCliente() == id) {
				esta = true;
			}
		}
		return esta;

	}

	public void modificarPedido(Pedido pedido) {
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("UPDATE Biogreen.pedido SET cantidad= '"
					+ pedido.getCantidad() + "'where id= '"
					+ pedido.getIdPedido() + "';");
			JOptionPane.showMessageDialog(null,
					"el pedido se ha registrado correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"Error al consultar MODIFICAR Pedido", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<Pedido> reducirListaPedido(ArrayList<Pedido> miLista) {
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

	public String[][] obtenerMatrizPedido(ArrayList<Pedido> miLista) {

		String matrizInfo[][] = new String[miLista.size()][4];

		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getIdPedido() + "";
			matrizInfo[i][1] = miLista.get(i).getCodigoProducto() + "";
			matrizInfo[i][2] = miLista.get(i).getCantidad() + "";
			matrizInfo[i][3] = miLista.get(i).getFecha() + "";

		}

		return matrizInfo;
	}

	public String[][] obtenerMatrizPedidoId(ArrayList<Pedido> miLista) {

		String matrizInfo[][] = new String[miLista.size()][1];

		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getIdCliente() + "";

		}

		return matrizInfo;
	}

	public String[][] obtenerMatrizPedidoFactura(ArrayList<Pedido> miLista,
			ArrayList<Producto> miProducto) {

		String matrizInfo[][] = new String[miLista.size()][4];

		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getCodigoProducto() + "";
			matrizInfo[i][1] = miLista.get(i).getCantidad() + "";
			matrizInfo[i][2] = miProducto.get(i).getNombreProducto() + "";
			matrizInfo[i][3] = miProducto.get(i).getPrecio() + "";

		}

		return matrizInfo;
	}

	public String[][] obtenerMatrizPedidoCliente(ArrayList<Cliente> miLista) {

		String matrizInfo[][] = new String[miLista.size()][4];

		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getIdCliente() + "";
			matrizInfo[i][1] = miLista.get(i).getNombre() + "";
			matrizInfo[i][2] = miLista.get(i).getApellido() + "";
			matrizInfo[i][3] = miLista.get(i).getDni() + "";

		}

		return matrizInfo;
	}

}
