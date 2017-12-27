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

public class PanelAltaPedido extends JPanel {

	private JTextField caja1;
	private JTextField caja2;
	private JTextField caja3;
	private JTextField caja4;
	private JTextField caja5;
	JTable miTabla1;
	JScrollPane mibarra1;
	JTable miTabla2;
	JScrollPane mibarra2;
	private ArrayList<NotaPedido> miListaNota;
	private ArrayList<Cliente> miLista;

	public PanelAltaPedido(JFrame frame) {
		super();
		iniciarVentana(frame);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame) {
		JPanel panel2 = new JPanel();
		panel2.setBounds(50, 50, 310, 370);
		panel2.setSize(new Dimension(700, 420));
		panel2.setBackground(Color.ORANGE);
		panel2.setPreferredSize(new Dimension(700, 370));

		JButton boton1 = new JButton();
		JButton boton2 = new JButton();
		JButton boton3 = new JButton();
		JButton boton4 = new JButton();
		caja1 = new JTextField();
		caja2 = new JTextField();
		caja3 = new JTextField();
		caja4 = new JTextField();
		caja5 = new JTextField();

		this.setLayout(null);
		JLabel textoCodigoProducto = new JLabel();
		JLabel textoCantidad = new JLabel();
		JLabel textoFechaPedido = new JLabel();
		JLabel idCliente = new JLabel();
		JLabel idNota = new JLabel();

		JLabel texto = new JLabel();
		texto.setText("ALTA PEDIDO");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);

		textoCodigoProducto.setText("Codigo Producto");
		textoCodigoProducto.setBounds(70, 70, 150, 50);
		textoCodigoProducto
				.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja1.setBounds(250, 80, 70, 30);
		textoCantidad.setText("Cantidad");
		textoCantidad.setBounds(70, 110, 150, 50);
		textoCantidad.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja2.setBounds(250, 120, 70, 30);
		textoFechaPedido.setText("Fecha de Pedido");
		textoFechaPedido.setBounds(70, 150, 150, 50);
		textoFechaPedido.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja3.setBounds(250, 160, 70, 30);
		idCliente.setText("id Cliente");
		idCliente.setBounds(70, 190, 150, 50);
		idCliente.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja4.setBounds(250, 200, 70, 30);
		idNota.setText("id Nota Pedido");
		idNota.setBounds(70, 230, 150, 50);
		idNota.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja5.setBounds(250, 240, 70, 30);

		boton1.setText("Agregar Pedido");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(100, 400, 200, 50);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setText("Alta nuevo cliente");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(310, 400, 200, 50);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);
		boton3.setText("Volver");
		boton3.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton3.setBounds(520, 400, 150, 50);
		boton3.setBackground(Color.LIGHT_GRAY);
		boton3.setForeground(Color.DARK_GRAY);
		boton4.setText("agregar nueva nota pedido");
		boton4.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton4.setBounds(360, 300, 250, 50);
		boton4.setBackground(Color.LIGHT_GRAY);
		boton4.setForeground(Color.DARK_GRAY);

		NotaPedido nota = new NotaPedido();
		mibarra2 = new JScrollPane();
		mibarra2.setBounds(250, 300, 100, 80);

		miListaNota = new ArrayList<NotaPedido>();
		String titulos2[] = { "id nota pedido" };
		miListaNota = nota.mostrarNotasPedido();
		String informacion2[][] = nota.obtenerNotasPedido(miListaNota);
		miTabla2 = new JTable(informacion2, titulos2);
		mibarra2.setViewportView(miTabla2);

		Cliente cliente = new Cliente();
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(370, 72, 350, 200);

		miLista = new ArrayList<Cliente>();
		String titulos[] = { "id", "dni", "Nombre", "apellido", "direccion",
				"localidad" };
		miLista = cliente.listarClientes();
		String informacion[][] = cliente.obtenerMatrizCliente(cliente, miLista);
		miTabla1 = new JTable(informacion, titulos);
		mibarra1.setViewportView(miTabla1);
		this.add(idCliente);
		this.add(textoCodigoProducto);
		this.add(textoFechaPedido);
		this.add(textoCantidad);
		this.add(idNota);
		this.add(caja1);
		this.add(caja2);
		this.add(caja3);
		this.add(caja4);
		this.add(caja5);
		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		this.add(boton4);
		this.add(mibarra2);
		this.add(mibarra1);
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((caja1.getText().length() == 0)
						|| (caja2.getText().length() == 0)
						|| (caja3.getText().length() == 0)
						|| (caja4.getText().length() == 0)
						|| (caja5.getText().length() == 0)) {
					// si alguno esta incompleto muestro el mensaje de error
					JOptionPane.showMessageDialog(frame,
							" Quedaron campos sin completar");
					// instancio denuevo la ventana de busqueda y le paso los
					// datos q estan completos e incompletos
					PanelAltaPedido altaPedido = new PanelAltaPedido(frame);
					altaPedido.caja1.setText(caja1.getText());
					altaPedido.caja2.setText(caja2.getText());
					altaPedido.caja3.setText(caja3.getText());
					altaPedido.caja4.setText(caja4.getText());
					altaPedido.caja5.setText(caja5.getText());

					altaPedido.setVisible(true);
					cerrarPanel();
					frame.add(altaPedido);

				} else {
					int codigoProd = Integer.parseInt(caja1.getText());
					Producto producto = new Producto();
					int idNota = Integer.parseInt(caja5.getText());
					Pedido pedido = new Pedido();
					int id = Integer.parseInt(caja4.getText());
					Cliente persona = new Cliente();
					if (persona.verificacionCliente(miLista, id)) {
						if (nota.verificacionNota(miListaNota, idNota)) {
							if (Producto.verificaProducto(codigoProd)) {
								pedido.setCodigoProducto(Integer.parseInt(caja1
										.getText()));
								pedido.setCantidad(Integer.parseInt(caja2
										.getText()));
								pedido.setFecha(caja3.getText());
								pedido.setIdCliente(Integer.parseInt(caja4
										.getText()));
								pedido.setIdNotaPedido(Integer.parseInt(caja5
										.getText()));
								pedido.altaPedido(pedido);
								JOptionPane.showMessageDialog(frame,
										"el pedido para  " + id
												+ " ha sido agregado");
								PanelAltaPedido altaPedido2 = new PanelAltaPedido(
										frame);
								cerrarPanel();
								frame.add(altaPedido2);
							} else {
								JOptionPane
										.showMessageDialog(null,
												"El codigo de producto no existe por favor de de alta al producto");
								cerrarPanel();
								PanelAltaPedido panelAltaPedido = new PanelAltaPedido(
										frame);
								frame.add(panelAltaPedido);
							}
						} else {
							JOptionPane
									.showMessageDialog(null,
											"El ID seleccionado no corresponde a la lista de las notas");
							cerrarPanel();
							PanelAltaPedido panelAltaPedido = new PanelAltaPedido(
									frame);
							frame.add(panelAltaPedido);
						}

					} else {
						JOptionPane
								.showMessageDialog(null,
										"El ID seleccionado no corresponde a la lista de los clientes");
						cerrarPanel();
						PanelAltaPedido panelAltaPedido = new PanelAltaPedido(
								frame);
						frame.add(panelAltaPedido);
					}

				}

			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAltaCliente menuAltaCliente = new PanelAltaCliente(frame);
				cerrarPanel();
				frame.add(menuAltaCliente);

			}
		});

		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuPedido menuPedido = new PanelMenuPedido(frame);
				cerrarPanel();
				frame.add(menuPedido);

			}
		});

		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nota.altaNotaPedido();
				PanelAltaPedido menuAltaPedido2 = new PanelAltaPedido(frame);
				cerrarPanel();
				frame.add(menuAltaPedido2);

			}
		});

	}

}
