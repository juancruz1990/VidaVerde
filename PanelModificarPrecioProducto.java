import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelModificarPrecioProducto extends JPanel {
	private JTextField caja1;

	public PanelModificarPrecioProducto(JFrame frame, Producto producto) {
		super();
		iniciarVentana(frame, producto);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame, Producto producto) {
		JPanel panel2 = new JPanel();
		panel2.setBounds(50, 50, 700, 370);
		panel2.setBackground(Color.ORANGE);

		JButton boton1 = new JButton();
		JButton boton2 = new JButton();
		JLabel textoCodigo = new JLabel();
		JLabel textoNombreProducto = new JLabel();
		JLabel textoTipoProducto = new JLabel();
		JLabel textoPrecio = new JLabel();
		JLabel texto = new JLabel();
		JLabel texto2 = new JLabel();
		texto.setText("MODIFICAR PRECIO PRODUCTO");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		caja1 = new JTextField();

		textoCodigo.setText("Codigo =  " + producto.getCodigo());
		textoCodigo.setBounds(150, 50, 350, 50);
		textoCodigo.setFont(new java.awt.Font("Times New Roman", 0, 20));

		textoNombreProducto.setText("Nombre Producto  "
				+ producto.getNombreProducto());
		textoNombreProducto.setBounds(150, 100, 350, 50);
		textoNombreProducto
				.setFont(new java.awt.Font("Times New Roman", 0, 20));

		textoTipoProducto.setText("Tipo de Producto  "
				+ producto.getTipoProducto());
		textoTipoProducto.setBounds(150, 150, 350, 50);
		textoTipoProducto.setFont(new java.awt.Font("Times New Roman", 0, 20));

		textoPrecio.setText("precio actual : " + producto.getPrecio());
		textoPrecio.setBounds(150, 200, 350, 50);
		textoPrecio.setFont(new java.awt.Font("Times New Roman", 0, 20));
		texto2.setText("ingrese nuevo precio");
		texto2.setBounds(150, 250, 350, 50);
		texto2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja1.setBounds(350, 250, 150, 30);

		boton1.setText("Modificar");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(150, 310, 150, 50);
		boton2.setText("Volver");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(300, 310, 150, 50);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);
		this.setLayout(null);
		this.add(textoNombreProducto);
		this.add(textoCodigo);
		this.add(textoTipoProducto);
		this.add(textoPrecio);
		this.add(texto2);
		this.add(caja1);

		this.add(boton1);
		this.add(boton2);
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				producto.setPrecio(Integer.parseInt(caja1.getText()));
				producto.modificarProducto(producto);
				PanelMenuPrincipal menuProducto = new PanelMenuPrincipal(frame);
				cerrarPanel();
				frame.add(menuProducto);

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
