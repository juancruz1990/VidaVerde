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

public class PanelOpcionFactura extends JPanel {

	JTable miTabla1;
	JScrollPane mibarra1;
	private JTextField caja1;
	private ArrayList<Factura> miLista;

	public PanelOpcionFactura(JFrame frame) {
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
		JButton boton3 = new JButton();

		JLabel id = new JLabel();
		caja1 = new JTextField();

		id.setText("Seleccione id de factura");
		id.setFont(new java.awt.Font("Times New Roman", 0, 20));
		id.setBounds(70, 219, 200, 60);
		caja1.setBounds(280, 219, 50, 40);
		this.add(caja1);
		this.add(id);

		JLabel texto = new JLabel();
		texto.setText("OPCION FACTURA");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		this.setLayout(null);

		boton1.setText("Ver detalle / Imprimir");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(70, 321, 250, 40);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);

		boton2.setText("Volver");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(70, 370, 200, 40);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);

		boton3.setText("Generar Factura");
		boton3.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton3.setBounds(350, 321, 200, 40);
		boton3.setBackground(Color.LIGHT_GRAY);
		boton3.setForeground(Color.DARK_GRAY);

		this.add(texto);
		this.add(boton1);
		this.add(boton2);
		this.add(boton3);

		Factura factura = new Factura();
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(200, 72, 400, 130);
		this.add(mibarra1);
		miLista = new ArrayList<Factura>();
		String titulos[] = { "id", "Codigo Factura", "Fecha", "Forma de pago" };
		miLista = factura.buscarFacturaConMatriz(factura);
		String informacion[][] = factura.obtenerMatrizFactura(miLista, factura);
		miTabla1 = new JTable(informacion, titulos);
		mibarra1.setViewportView(miTabla1);

		this.setLayout(null);
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (caja1.getText().length() != 0) {
					int id = Integer.parseInt(caja1.getText());
					Factura factura = new Factura();
					if (factura.verificacionFactura(miLista, id)) {
						PanelDetalleImprimir detalle = new PanelDetalleImprimir(
								frame, id);
						cerrarPanel();
						frame.add(detalle);
					} else {
						JOptionPane.showMessageDialog(null,
								"El ID seleccionado no corresponde a la lista");
						cerrarPanel();
						PanelOpcionFactura panelOpcion = new PanelOpcionFactura(
								frame);
						frame.add(panelOpcion);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Debe seleccionar un ID para ingresar");
				}
			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuPrincipal menu = new PanelMenuPrincipal(frame);
				cerrarPanel();
				frame.add(menu);
			}
		});

		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelGenerarFactura generar = new PanelGenerarFactura(frame);
				cerrarPanel();
				frame.add(generar);
			}
		});

	}

}
