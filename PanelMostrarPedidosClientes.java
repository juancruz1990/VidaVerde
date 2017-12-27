import java.awt.Color;
import java.awt.Dimension;
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

public class PanelMostrarPedidosClientes extends JPanel {

	JTable miTabla1;
	JScrollPane mibarra1;
	private JTextField caja1;
	private ArrayList<Pedido> miListaPedido;
	private ArrayList<Cliente> miListaCliente;

	public PanelMostrarPedidosClientes(JFrame frame) {
		super();
		iniciarVentana(frame);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame) {

		JPanel panel2 = new JPanel();
		panel2.setBounds(50, 50, 700, 370);
		panel2.setBackground(Color.ORANGE);

		this.setVisible(true);
		JButton boton1 = new JButton();
		JButton boton2 = new JButton();

		JLabel id = new JLabel();
		caja1 = new JTextField();

		id.setText("SELECCIONE ID PEDIDO");
		id.setBounds(100, 219, 200, 60);
		caja1.setBounds(270, 219, 50, 40);
		this.add(caja1);
		this.add(id);

		JLabel texto = new JLabel();
		texto.setText("MOSTRAR PEDIDO");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		this.setLayout(null);

		boton1.setText("OPCION PEDIDO");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(100, 321, 250, 40);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setText("VOLVER");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(400, 321, 250, 40);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);

		this.add(boton1);
		this.add(boton2);

		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(170, 72, 400, 130);
		this.add(mibarra1);
		miListaPedido = new ArrayList<Pedido>();
		miListaCliente = new ArrayList<Cliente>();
		String titulos[] = { "id", "Nombre", "Apellido", "Dni" };
		miListaCliente = cliente.buscarClientePedido();// traigo lista de
														// clientes con pedidos
		miListaCliente = cliente.reducirListaClientes(miListaCliente);// quito
																		// clientes
																		// q se
																		// repitan
																		// de la
																		// lista
		String informacion[][] = pedido
				.obtenerMatrizPedidoCliente(miListaCliente);
		miTabla1 = new JTable(informacion, titulos);
		mibarra1.setViewportView(miTabla1);
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (caja1.getText().length() != 0) {
					int id = Integer.parseInt(caja1.getText());
					Cliente cliente = new Cliente();
					if (cliente.verificacionCliente(miListaCliente, id)) {
						PanelOpcionPedido opcionPedido = new PanelOpcionPedido(
								frame, id);
						cerrarPanel();
						frame.add(opcionPedido);
					} else {
						JOptionPane.showMessageDialog(null,
								"El ID seleccionado no corresponde a la lista");
						cerrarPanel();
						PanelMenuPedido panelMostrar = new PanelMenuPedido(
								frame);
						frame.add(panelMostrar);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Debe seleccionar un ID para ingresar");
				}
			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuPedido menu = new PanelMenuPedido(frame);
				cerrarPanel();
				frame.add(menu);
			}
		});

	}

}
