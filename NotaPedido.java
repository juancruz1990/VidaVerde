import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class NotaPedido {

	private String visible;
	private int idNotaPedido;

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public int getIdNotaPedido() {
		return idNotaPedido;
	}

	public void setIdNotaPedido(int idNotaPedido) {
		this.idNotaPedido = idNotaPedido;
	}

	public NotaPedido() {

	}

	public void altaNotaPedido() {
		GenerarConeccion conex = new GenerarConeccion();
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			estatuto.executeUpdate("INSERT INTO biogreen.notapedido (visible) VALUES ('visible');");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"No se Registro la nota pedido (alta nota pedido)");
		}
	}

	public ArrayList<NotaPedido> mostrarNotasPedido() {
		GenerarConeccion conex = new GenerarConeccion();
		ArrayList<NotaPedido> miListaNotas = new ArrayList<NotaPedido>();
		NotaPedido nota;
		try {
			Statement estatuto = conex.getConeccion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT * FROM biogreen.notapedido where visible = 'visible';");
			while (rs.next()) {
				nota = new NotaPedido();
				nota.setIdNotaPedido(Integer.parseInt(rs.getString("id")));
				nota.setVisible(rs.getString("visible"));
				miListaNotas.add(nota);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			conex.desconectar();
			JOptionPane.showMessageDialog(null,
					"Error al mostrar notas pedido", "Error ",
					JOptionPane.ERROR_MESSAGE);

		}
		return miListaNotas;
	}

	public String[][] obtenerNotasPedido(ArrayList<NotaPedido> miLista) {

		String matrizInfo[][] = new String[miLista.size()][1];

		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getIdNotaPedido() + "";
		}

		return matrizInfo;
	}

	public boolean verificacionNota(ArrayList<NotaPedido> miLista, int id) {

		boolean esta = false;

		for (int i = 0; i < miLista.size(); i++) {
			if (miLista.get(i).getIdNotaPedido() == id) {

				esta = true;
			}
		}
		return esta;

	}

}
