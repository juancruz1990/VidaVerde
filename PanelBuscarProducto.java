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

public class PanelBuscarProducto extends JPanel {

	private JTextField caja1;
	private JTextField caja2;
	private JTextField caja3;

	public PanelBuscarProducto(JFrame frame) {
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

		JButton boton1 = new JButton();
		JButton boton2 = new JButton();
		JLabel textoCodigo = new JLabel();
		JLabel textoNombreProducto = new JLabel();
		JLabel textoTipo = new JLabel();

		JLabel texto = new JLabel();
		texto.setText("BUSCAR PRODUCTO");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		caja1 = new JTextField();
		caja2 = new JTextField();
		caja3 = new JTextField();
		Producto producto = new Producto();
		this.setLayout(null);
		textoCodigo.setText("Codigo Producto");
		textoCodigo.setBounds(150, 90, 150, 50);
		textoCodigo.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja1.setBounds(320, 100, 150, 30);
		textoNombreProducto.setText("Nombre Producto");
		textoNombreProducto.setBounds(150, 130, 150, 50);
		textoNombreProducto
				.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja2.setBounds(320, 140, 150, 30);
		textoTipo.setText("Tipo Producto");
		textoTipo.setBounds(150, 170, 150, 50);
		textoTipo.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja3.setBounds(320, 180, 150, 30);

		boton1.setText("Buscar");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(190, 270, 150, 50);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setText("Volver");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(350, 270, 150, 50);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);

		this.add(textoCodigo);
		this.add(textoNombreProducto);
		this.add(textoTipo);

		this.add(caja1);
		this.add(caja2);
		this.add(caja3);

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
						|| (caja3.getText().length() == 0)) {
					// si alguno esta incompleto muestro el mensaje de error
					JOptionPane.showMessageDialog(frame,
							" Quedaron campos sin completar");
					// instancio denuevo la ventana de busqueda y le paso los
					// datos q estan completos e incompletos
					PanelBuscarProducto buscarProducto = new PanelBuscarProducto(
							frame);
					buscarProducto.caja1.setText(caja1.getText());
					buscarProducto.caja2.setText(caja2.getText());
					buscarProducto.caja3.setText(caja3.getText());
					buscarProducto.setVisible(true);
					cerrarPanel();
					frame.add(buscarProducto);
				} else {
					producto.setCodigo(Integer.parseInt(caja1.getText()));
					producto.setNombreProducto(caja2.getText());
					producto.setTipoProducto(caja3.getText());
					PanelOpcionProducto menuOpcion = new PanelOpcionProducto(
							frame, producto);
					cerrarPanel();
					frame.add(menuOpcion);

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