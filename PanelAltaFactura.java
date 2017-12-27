import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAltaFactura extends JPanel {

	private JTextField caja1;
	private JTextField caja2;
	private JTextField caja3;

	public PanelAltaFactura(JFrame frame, int identy) {
		super();
		iniciarVentana(frame, identy);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame, int identy) {
		JPanel panel2 = new JPanel();
		panel2.setBounds(43, 51, 700, 370);
		panel2.setBackground(Color.ORANGE);

		JButton boton1 = new JButton();
		boton1.setBackground(Color.LIGHT_GRAY);
		JButton boton2 = new JButton();
		boton2.setBackground(Color.LIGHT_GRAY);
		JLabel codigo = new JLabel();
		JLabel fecha = new JLabel();
		JLabel formaPago = new JLabel();

		caja1 = new JTextField();
		caja2 = new JTextField();
		caja3 = new JTextField();

		this.setLayout(null);
		JLabel texto = new JLabel();
		texto.setText("ALTA FACTURA");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		Factura factura = new Factura();
		codigo.setText("Codigo Factura");
		codigo.setBounds(250, 90, 86, 50);
		caja1.setBounds(340, 100, 150, 30);
		fecha.setText("Fecha Factura");
		fecha.setBounds(250, 130, 96, 50);
		caja2.setBounds(340, 140, 150, 30);
		formaPago.setText("Forma de Pago");
		formaPago.setBounds(250, 170, 86, 50);
		caja3.setBounds(340, 180, 150, 30);

		boton1.setText("Agregar Factura");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(150, 310, 250, 50);
		boton2.setText("Volver");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(400, 310, 150, 50);

		this.add(codigo);
		this.add(fecha);
		this.add(formaPago);

		this.add(caja1);
		this.add(caja2);
		this.add(caja3);

		this.add(boton1);
		this.add(boton2);
		this.add(panel2);

		frame.getContentPane().add(this);
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((caja1.getText().length() == 0)
						|| (caja2.getText().length() == 0)
						|| (caja3.getText().length() == 0)) {
					// si alguno esta incompleto muestro el mensaje de error
					JOptionPane.showMessageDialog(frame,
							" Quedaron campos sin completar");
					// instancio denuevo la ventana de busqueda y le paso los
					// datos q estan completos e incompletos
					PanelAltaFactura altaFactura = new PanelAltaFactura(frame,
							identy);
					altaFactura.caja1.setText(caja1.getText());
					altaFactura.caja2.setText(caja2.getText());
					altaFactura.caja3.setText(caja3.getText());

					altaFactura.setVisible(true);
					cerrarPanel();
					frame.getContentPane().add(altaFactura);

				}

				else {
					factura.setCodigo(Integer.parseInt(caja1.getText()));
					factura.setFecha(caja2.getText());
					factura.setFormaDePago(caja3.getText());
					factura.altaFactura(factura);
					int total = factura.contarFacturas();
					factura.altaFacturaPedido(total, identy);
					PanelOpcionFactura factura = new PanelOpcionFactura(frame);
					cerrarPanel();
					frame.getContentPane().add(factura);
				}

			}
		});
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuCliente menuCliente2 = new PanelMenuCliente(frame);
				cerrarPanel();
				frame.getContentPane().add(menuCliente2);

			}
		});

	}

}