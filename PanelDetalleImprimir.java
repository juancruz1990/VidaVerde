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

public class PanelDetalleImprimir extends JPanel {

	JTable miTabla1;
	JScrollPane mibarra1;
	private JTextField caja1;
	private JTextField caja2;
	private ArrayList<Pedido> miLista;
	private ArrayList<Cliente> miListaCliente;

	public PanelDetalleImprimir(JFrame frame, int id) {
		super();
		iniciarVentana(frame, id);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame, int id) {
		JPanel panel2 = new JPanel();
		panel2.setBounds(50, 50, 700, 370);
		panel2.setBackground(Color.ORANGE);

		this.setVisible(true);
		JButton boton1 = new JButton();
		JButton boton2 = new JButton();
		JButton boton3 = new JButton();
		JButton boton4 = new JButton();

		JLabel identy = new JLabel();
		caja1 = new JTextField();
		JLabel total = new JLabel();
		caja2 = new JTextField();

		identy.setText("seleccione id pedido");
		identy.setFont(new java.awt.Font("Times New Roman", 0, 20));
		identy.setBounds(60, 210, 200, 60);
		caja1.setBounds(260, 219, 50, 40);
		total.setText("total facturacion");
		total.setFont(new java.awt.Font("Times New Roman", 0, 20));
		total.setBounds(90, 250, 200, 60);
		caja2.setBounds(260, 270, 50, 40);
		this.add(caja1);
		this.add(identy);
		this.add(caja2);
		this.add(total);

		JLabel texto = new JLabel();
		texto.setText("DETALLE / IMPRIMIR");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		this.setLayout(null);

		boton1.setText("Imprimir Factura");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(70, 321, 200, 40);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setText("modificar Cantidad pedido");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(260, 321, 260, 40);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);
		boton3.setText("baja pedido");
		boton3.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton3.setBounds(520, 321, 200, 40);
		boton3.setBackground(Color.LIGHT_GRAY);
		boton3.setForeground(Color.DARK_GRAY);
		boton4.setText("volver");
		boton4.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton4.setBounds(260, 370, 250, 40);
		boton4.setBackground(Color.LIGHT_GRAY);
		boton4.setForeground(Color.DARK_GRAY);

		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		this.add(boton4);
		Factura factura = new Factura();
		Pedido pedido = new Pedido();
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(170, 72, 400, 130);
		this.add(mibarra1);
		miLista = new ArrayList<Pedido>();
		miListaCliente = new ArrayList<Cliente>();
		String titulos[] = { "id", "Codigo Producto", "cantidad", "Fecha" };
		miLista = pedido.buscarPedidoPorFactura(id);
		String informacion[][] = pedido.obtenerMatrizPedido(miLista);
		miTabla1 = new JTable(informacion, titulos);
		mibarra1.setViewportView(miTabla1);
		int precioFinal = factura.importeFacturacion(id);
		caja2.setText(Integer.toString(precioFinal));
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Factura factura = new Factura();
				factura.bajaFactura(id);
				JOptionPane.showMessageDialog(frame, " IMPRESION EN CURSO");
				PanelMenuPrincipal menu2 = new PanelMenuPrincipal(frame);
				cerrarPanel();
				frame.add(menu2);
			}

		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (caja1.getText().length() != 0) {
					int id = Integer.parseInt(caja1.getText());
					Pedido pedido = new Pedido();
					if (pedido.verificacionPedido(miLista, id)) {
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
						PanelOpcionFactura panelMenu = new PanelOpcionFactura(
								frame);
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
				if (pedido.verificacionPedido(miLista, id)) {
					int id = Integer.parseInt(caja1.getText());
					pedido.bajaPedido(id);
					miLista = new ArrayList<Pedido>();
					String titulos[] = { "id", "codigo", "Nombre", "stock",
							"tipo producto", "precio" };
					miLista = pedido.buscarPedidoPorFactura(id);// traigo lista
																// de clientes
																// con pedidos
					String informacion[][] = pedido
							.obtenerMatrizPedido(miLista);
					miTabla1 = new JTable(informacion, titulos);
					mibarra1.setViewportView(miTabla1);
					PanelOpcionFactura panelOpcion = new PanelOpcionFactura(
							frame);
					cerrarPanel();
					frame.add(panelOpcion);

				} else {
					JOptionPane.showMessageDialog(null,
							"El ID seleccionado no corresponde a la lista");
					cerrarPanel();
					PanelDetalleImprimir panelDetalle = new PanelDetalleImprimir(
							frame, id);
					frame.add(panelDetalle);
				}
			}
		});

		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelOpcionFactura opcionFactura = new PanelOpcionFactura(frame);
				cerrarPanel();
				frame.add(opcionFactura);
			}
		});
	}

}
