import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Factura {
	private int idFactura;
	private int codigo;
	private String fecha;
	private String formaDePago;
	private ArrayList<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
	private ArrayList<Producto> productos = new ArrayList<Producto>();

	// constructor con atributos por parametro
	public Factura(int idFactura, int codigo, String fecha, String formaDePago,
			ArrayList<DetalleFactura> detallesRecibidos,
			ArrayList<Producto> productosRecibidos) {
		this.idFactura = idFactura;
		this.codigo = codigo;
		this.fecha = fecha;
		this.formaDePago = formaDePago;
		this.detalles.addAll(detallesRecibidos);
		this.productos.addAll(productosRecibidos);
	}

	// constructor vacio
	public Factura() {
		this.idFactura = -1;
		this.codigo = 0;
		this.fecha = "";
		this.formaDePago = "";
	}

	// getters & setters
	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public ArrayList<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<DetalleFactura> detalles) {
		this.detalles.addAll(detalles);
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos.addAll(productos);
	}

	public boolean verificacionFactura(ArrayList<Factura> miLista, int id) {

		boolean esta = false;

		for (int i = 0; i < miLista.size(); i++) {
			System.out.println(miLista.get(i).getIdFactura());
			if (miLista.get(i).getIdFactura() == id) {
				esta = true;
			}
		}
		return esta;

	}

	public int contarFacturas() {
		// trar en un array list todos los uduarios de la base con los datos q
		// coincidan

		GenerarConeccion conex = new GenerarConeccion();
		int i = 0;
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT count(*) as total FROM biogreen.factura;"); // mensaje
																						// contiene
																						// la
																						// consulta
																						// SQL
			while (rs.next()) {
				i = Integer.parseInt(rs.getString("total"));

			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Error al contar facturas",
					"Error", JOptionPane.ERROR_MESSAGE);

		}
		return i;
	}

	public void altaFacturaPedido(int total, int identy) {
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("UPDATE Biogreen.pedido SET facturaId = '"
					+ total + "' where clienteId= '" + identy
					+ "' and facturaId =  0 ;");
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"Error al dar de alta factura por pedido", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void altaFactura(Factura factura) {
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("insert into biogreen.factura (codigo,fecha,formaPago,visible) values ('"
					+ factura.getCodigo()
					+ "','"
					+ factura.getFecha()
					+ "','"
					+ factura.getFormaDePago() + "','visible') ;");

			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Error al dar de alta factura",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void bajaFactura(int identy) {
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("UPDATE Biogreen.factura SET visible = 'falso' where id = '"
					+ identy + "';");
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"Error al dar de baja una factura", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<Factura> buscarFacturaConMatriz(Factura factura) {
		// trar en un array list todos los uduarios de la base con los datos q
		// coincidan

		GenerarConeccion conex = new GenerarConeccion();
		ArrayList<Factura> miListaFactura = new ArrayList<Factura>();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT * FROM biogreen.factura where visible = 'visible';");
			while (rs.next()) {
				factura = new Factura();
				factura.setCodigo(Integer.parseInt(rs.getString("codigo")));
				factura.setFecha(rs.getString("fecha"));
				factura.setFormaDePago(rs.getString("formaPago"));
				factura.setIdFactura(Integer.parseInt(rs.getString("id")));
				miListaFactura.add(factura);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Error al consultar",
					"Error buscarFacturaConMatriz (CLIENTE)",
					JOptionPane.ERROR_MESSAGE);

		}
		return miListaFactura;
	}

	public int importeFacturacion(int id) {
		int i = 0;
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("select sum( cantidad * precio) as total from biogreen.pedido , biogreen.producto where"
							+ " pedido.codigoproducto=producto.codigo and facturaId = '"
							+ id + "';");

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

	public String[][] obtenerMatrizFactura(ArrayList<Factura> miLista,
			Factura factura) {

		String matrizInfo[][] = new String[miLista.size()][4];

		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getIdFactura() + "";
			matrizInfo[i][1] = miLista.get(i).getCodigo() + "";
			matrizInfo[i][2] = miLista.get(i).getFecha() + "";
			matrizInfo[i][3] = miLista.get(i).getFormaDePago() + "";
		}

		return matrizInfo;
	}

}

