import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAltaProducto extends JPanel {

	private JTextField caja1;
	private JTextField caja2;
	private JTextField caja3;
	private JTextField caja4;
	private JTextField caja5;

	public PanelAltaProducto(JFrame frame) {
		super();
		iniciarVentana(frame);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame) {

		JPanel panel2 = new JPanel();
		panel2.setBounds(50, 50, 310, 370);
		panel2.setSize(new Dimension(700, 370));
		panel2.setBackground(Color.ORANGE);
		panel2.setPreferredSize(new Dimension(700, 370));

		this.setLayout(null);

		JButton boton1 = new JButton();
		JButton boton2 = new JButton();

		JLabel textoCodigoProducto = new JLabel();
		JLabel textoNombreProducto = new JLabel();
		JLabel textoStock = new JLabel();
		JLabel textoTipoProducto = new JLabel();
		JLabel textoPrecioUnitario = new JLabel();

		caja1 = new JTextField();
		caja2 = new JTextField();
		caja3 = new JTextField();
		caja4 = new JTextField();
		caja5 = new JTextField();

		JLabel texto = new JLabel();
		texto.setText("ALTA PRODUCTO");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		textoCodigoProducto.setText("Codigo Producto");
		textoCodigoProducto.setBounds(150, 90, 150, 50);
		textoCodigoProducto
				.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja1.setBounds(320, 100, 150, 30);
		textoNombreProducto.setText("Nombre Producto");
		textoNombreProducto.setBounds(150, 130, 150, 50);
		textoNombreProducto
				.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja2.setBounds(320, 140, 150, 30);
		textoStock.setText("Stock");
		textoStock.setBounds(150, 170, 150, 50);
		textoStock.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja3.setBounds(320, 180, 150, 30);
		textoTipoProducto.setText("Tipo Producto");
		textoTipoProducto.setBounds(150, 210, 150, 50);
		textoTipoProducto.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja4.setBounds(320, 220, 150, 30);
		textoPrecioUnitario.setText("Precio Unitario");
		textoPrecioUnitario.setBounds(150, 250, 150, 50);
		textoPrecioUnitario
				.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja5.setBounds(320, 260, 150, 30);

		boton1.setText("AGREGAR PRODUCTO");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(100, 340, 250, 50);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setText("VOLVER");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(400, 340, 150, 50);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);

		this.add(textoStock);
		this.add(textoTipoProducto);
		this.add(textoPrecioUnitario);
		this.add(textoCodigoProducto);
		this.add(textoNombreProducto);
		this.add(caja1);
		this.add(caja2);
		this.add(caja3);
		this.add(caja4);
		this.add(caja5);
		Producto producto = new Producto();
		this.add(boton1);
		this.add(boton2);
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * si el usuario no completa los campos con datos el programa le
				 * muestra un mensaje de error y vuelve a la pantalla de
				 * busqueda para completar los campos que quedaron vacios
				 */

				// verifico que los campos esten completos o contengan datos
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
					PanelAltaProducto altaProducto = new PanelAltaProducto(
							frame);
					altaProducto.caja1.setText(caja1.getText());
					altaProducto.caja2.setText(caja2.getText());
					altaProducto.caja3.setText(caja3.getText());
					altaProducto.caja4.setText(caja4.getText());
					altaProducto.caja5.setText(caja5.getText());
					altaProducto.setVisible(true);
					cerrarPanel();
					frame.add(altaProducto);
				} else {

					int codigo = Integer.parseInt(caja1.getText());
					if (producto.verificaProducto(codigo)) {
						JOptionPane.showMessageDialog(frame, "el producto "
								+ producto.getNombreProducto() + " ya existe");
						PanelAltaProducto altaProducto = new PanelAltaProducto(
								frame);
						cerrarPanel();
						frame.add(altaProducto);
					} else {

						producto.setCodigo(codigo);
						producto.setNombreProducto(caja2.getText());
						int cantidad = Integer.parseInt(caja3.getText());
						producto.setStock(cantidad);
						producto.setTipoProducto(caja4.getText());
						int precio = Integer.parseInt(caja5.getText());
						producto.setPrecio(precio);
						producto.altaProducto(producto);

						JOptionPane.showMessageDialog(frame,
								"el producto " + producto.getNombreProducto()
										+ " " + producto.getCodigo()
										+ " ha sido agregado");
						PanelAltaProducto altaProducto = new PanelAltaProducto(
								frame);
						cerrarPanel();
						frame.add(altaProducto);
					}

				}
			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuProducto menuProducto = new PanelMenuProducto(frame);
				cerrarPanel();
				frame.add(menuProducto);

			}
		});
	}

}
