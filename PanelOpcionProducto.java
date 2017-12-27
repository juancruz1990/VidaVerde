import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PanelOpcionProducto extends JPanel {

	JTable miTabla1;
	JScrollPane mibarra1;
	private JTextField caja1;
	private ArrayList<Producto> miLista;

	public PanelOpcionProducto(JFrame frame, Producto producto) {
		super();
		iniciarVentana(frame, producto);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame, Producto producto) {
		JPanel panel2 = new JPanel();
		panel2.setBounds(12, 50, 755, 359);
		panel2.setBackground(Color.ORANGE);

		this.setVisible(true);
		JButton boton1 = new JButton();
		JButton boton2 = new JButton();
		JButton boton3 = new JButton();

		JLabel id = new JLabel();
		caja1 = new JTextField();

		id.setText("Seleccione ID Producto");
		id.setBounds(15, 219, 200, 60);
		id.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja1.setBounds(230, 219, 50, 40);
		this.add(caja1);
		this.add(id);

		JLabel texto = new JLabel();
		texto.setText("OPCION PRODUCTO");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		this.setLayout(null);

		boton1.setText("Baja Producto");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(13, 321, 250, 40);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setText("Modificar Producto");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(270, 321, 250, 40);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);
		boton3.setText("Volver");
		boton3.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton3.setBounds(521, 321, 250, 40);
		boton3.setBackground(Color.LIGHT_GRAY);
		boton3.setForeground(Color.DARK_GRAY);

		this.add(boton1);
		this.add(boton2);
		this.add(boton3);

		mibarra1 = new JScrollPane();
		mibarra1.setBounds(200, 72, 400, 130);
		this.add(mibarra1);
		Producto mercancia = new Producto();
		miLista = new ArrayList<Producto>();
		String titulos[] = { "id", "codigo", "Nombre", "stock",
				"tipo producto", "precio" };
		miLista = mercancia.buscarProducto(producto);
		String informacion[][] = producto.obtenerMatrizProducto(miLista,
				producto);
		miTabla1 = new JTable(informacion, titulos);
		mibarra1.setViewportView(miTabla1);
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(caja1.getText());
				mercancia.bajaProducto(id);
				miLista = new ArrayList<Producto>();
				String titulos[] = { "id", "codigo", "Nombre", "stock",
						"tipo producto", "precio" };
				miLista = mercancia.buscarProducto(producto);
				String informacion[][] = producto.obtenerMatrizProducto(
						miLista, producto);
				miTabla1 = new JTable(informacion, titulos);
				mibarra1.setViewportView(miTabla1);
				PanelOpcionProducto panelOpcion = new PanelOpcionProducto(
						frame, producto);
				cerrarPanel();
				frame.add(panelOpcion);

			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (caja1.getText().length() != 0) {
					int id = Integer.parseInt(caja1.getText());
					if (mercancia.verificacionProductoArray(miLista, id)) {
						ArrayList<Producto> miLista = mercancia
								.buscarProductoPorId(id);
						if (miLista.size() > 0) {
							mercancia.setIdProducto(id);
							mercancia.setPrecio(miLista.get(0).getPrecio());
							mercancia.setCodigo(miLista.get(0).getCodigo());
							mercancia.setNombreProducto(miLista.get(0)
									.getNombreProducto());
							mercancia.setTipoProducto(miLista.get(0)
									.getTipoProducto());
							mercancia.setStock(miLista.get(0).getStock());
						}
						PanelModificarPrecioProducto modificarProducto = new PanelModificarPrecioProducto(
								frame, mercancia);
						cerrarPanel();
						frame.add(modificarProducto);

					} else {
						JOptionPane.showMessageDialog(null,
								"El ID seleccionado no corresponde a la lista");
						cerrarPanel();
						PanelOpcionProducto panelOpcion = new PanelOpcionProducto(
								frame, producto);
						frame.add(panelOpcion);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Debe seleccionar un ID para ingresar");
				}
			}
		});

		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuProducto menuProducto = new PanelMenuProducto(frame);
				cerrarPanel();
				frame.add(menuProducto);

			}
		});
	}
}