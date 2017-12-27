import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PanelConsultarFactura extends JPanel {

	JTable miTabla1;
	JScrollPane mibarra1;
	private JTextField caja1;
	private ArrayList<Pedido> miListaPedido;
	private ArrayList<Producto> miListaProducto;

	public PanelConsultarFactura(JFrame frame, int identy) {
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

		JLabel total = new JLabel();
		caja1 = new JTextField();

		total.setText("total importe factura");
		total.setBounds(100, 219, 200, 60);
		total.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja1.setBounds(300, 219, 50, 40);
		this.add(caja1);
		this.add(total);

		JLabel texto = new JLabel();
		texto.setText("generar factura");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		this.setLayout(null);

		boton1.setText("agregar factura");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(100, 321, 250, 40);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setText("volver");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(370, 321, 250, 40);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);

		this.add(boton1);
		this.add(boton2);

		Pedido pedido = new Pedido();
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(200, 72, 400, 130);
		this.add(mibarra1);
		miListaPedido = new ArrayList<Pedido>();
		miListaProducto = new ArrayList<Producto>();
		String titulos[] = { "codigo producto", "cantidad", "nombre producto",
				"precio" };
		miListaPedido = pedido.buscarPedidosCliente(identy, miListaProducto);// traigo
																				// lista
																				// de
																				// clientes
																				// con
																				// pedidos
		String informacion[][] = pedido.obtenerMatrizPedidoFactura(
				miListaPedido, miListaProducto);
		miTabla1 = new JTable(informacion, titulos);
		mibarra1.setViewportView(miTabla1);
		int imp = pedido.importePedidos(identy);
		caja1.setText(Integer.toString(imp));
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAltaFactura altaFactura = new PanelAltaFactura(frame,
						identy);
				cerrarPanel();
				frame.add(altaFactura);

			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelOpcionFactura opcionFactura = new PanelOpcionFactura(frame);
				cerrarPanel();
				frame.add(opcionFactura);

			}
		});

	}
}
