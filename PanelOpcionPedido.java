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

public class PanelOpcionPedido extends JPanel {

	JTable miTabla1;
	JScrollPane mibarra1;
	private JTextField caja1;
	private ArrayList<Pedido> miListaPedido;
	private ArrayList<Cliente> miListaCliente;

	public PanelOpcionPedido(JFrame frame, int identy) {
		super();
		iniciarVentana(frame, identy);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame, int identy) {
		JPanel panel2 = new JPanel();
		panel2.setBounds(50, 50, 700, 370);
		panel2.setBackground(Color.ORANGE);

		this.setVisible(true);
		JButton boton1 = new JButton();
		JButton boton2 = new JButton();
		JButton boton3 = new JButton();

		JLabel id = new JLabel();
		caja1 = new JTextField();

		id.setText("seleccione id pedido");
		id.setFont(new java.awt.Font("Times New Roman", 0, 20));
		id.setBounds(60, 210, 200, 60);
		caja1.setBounds(260, 219, 50, 40);
		this.add(caja1);
		this.add(id);

		JLabel texto = new JLabel();
		texto.setText("OPCION PEDIDO");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		this.setLayout(null);

		boton1.setText("Baja Pedido");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(50, 321, 200, 40);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setText("Modificar cantidad pedido");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(250, 321, 250, 40);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);
		boton3.setText("volver");
		boton3.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton3.setBounds(500, 321, 200, 40);
		boton3.setBackground(Color.LIGHT_GRAY);
		boton3.setForeground(Color.DARK_GRAY);

		this.add(boton1);
		this.add(boton2);
		this.add(boton3);

		Pedido pedido = new Pedido();
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(200, 72, 400, 130);
		this.add(mibarra1);
		miListaPedido = new ArrayList<Pedido>();
		String titulos[] = { "id", "codigo", "cantidad", "fecha" };
		miListaPedido = pedido.buscarPedidosClientesConMatriz(identy);// traigo
																		// lista
																		// de
																		// clientes
																		// con
																		// pedidos
		String informacion[][] = pedido.obtenerMatrizPedido(miListaPedido);
		miTabla1 = new JTable(informacion, titulos);
		mibarra1.setViewportView(miTabla1);
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(caja1.getText());
				pedido.bajaPedido(id);
				miListaPedido = new ArrayList<Pedido>();
				String titulos[] = { "id", "codigo", "Nombre", "stock",
						"tipo producto", "precio" };
				miListaPedido = pedido.buscarPedidosClientesConMatriz(identy);// traigo
																				// lista
																				// de
																				// clientes
																				// con
																				// pedidos
				String informacion[][] = pedido
						.obtenerMatrizPedido(miListaPedido);
				miTabla1 = new JTable(informacion, titulos);
				mibarra1.setViewportView(miTabla1);
				PanelOpcionPedido panelOpcion = new PanelOpcionPedido(frame,
						identy);
				cerrarPanel();
				frame.add(panelOpcion);

			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (caja1.getText().length() != 0) {
					int id = Integer.parseInt(caja1.getText());
					Pedido pedido = new Pedido();
					if (pedido.verificacionPedido(miListaPedido, id)) {
						ArrayList<Pedido> miLista = pedido
								.buscarPedidoModificar(id);
						if (miLista.size() > 0) {
							pedido.setIdPedido(id);
							pedido.setCodigoProducto(miLista.get(0)
									.getCodigoProducto());
							pedido.setCantidad(miLista.get(0).getCantidad());
						}

						PanelModificarCantidadPedido modificarPedido = new PanelModificarCantidadPedido(
								frame, pedido);
						cerrarPanel();
						frame.add(modificarPedido);

					} else {
						JOptionPane.showMessageDialog(null,
								"El ID seleccionado no corresponde a la lista");
						cerrarPanel();
						PanelMenuPedido panelMenu = new PanelMenuPedido(frame);
						frame.add(panelMenu);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Debe seleccionar un ID para ingresar");
				}
			}
		});

		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuPedido panelMenu = new PanelMenuPedido(frame);
				cerrarPanel();
				frame.add(panelMenu);

			}
		});
	}
}