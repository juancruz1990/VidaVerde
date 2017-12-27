import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenuProducto extends JPanel {

	FondoPantalla fondo;
	private String nombre = "/imagen/productos.jpg";

	public PanelMenuProducto(JFrame frame) {
		super();
		iniciarVentana(frame);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame) {
		fondo = new FondoPantalla(nombre); // ruta de la imagen de fondo de
											// pantalla
		fondo.setSize(800, 600);
		fondo.setLayout(null);
		fondo.setVisible(true);

		JButton boton1 = new JButton();
		JButton boton2 = new JButton();
		JButton boton3 = new JButton();
		JButton boton4 = new JButton();
		JLabel texto = new JLabel();
		texto.setText("Menu Producto");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 20));
		texto.setBounds(12, 0, 500, 40);
		texto.setForeground(Color.GREEN);

		boton1.setText("Alta Producto");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(12, 60, 250, 40);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setText("Buscar Producto");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(12, 100, 250, 40);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);
		boton3.setText("Mostrar Stock");
		boton3.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton3.setBounds(12, 140, 250, 40);
		boton3.setBackground(Color.LIGHT_GRAY);
		boton3.setForeground(Color.DARK_GRAY);
		boton4.setText("Volver");
		boton4.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton4.setBounds(12, 200, 200, 40);
		boton4.setBackground(Color.LIGHT_GRAY);
		boton4.setForeground(Color.DARK_GRAY);
		fondo.add(texto);
		fondo.add(boton1);
		fondo.add(boton2);
		fondo.add(boton3);
		fondo.add(boton4);
		this.add(fondo);
		this.setLayout(null);
		frame.add(this);
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelAltaProducto altaProducto = new PanelAltaProducto(frame);
				frame.add(altaProducto);
				cerrarPanel();

			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelBuscarProducto buscaProducto = new PanelBuscarProducto(
						frame);
				frame.add(buscaProducto);
				cerrarPanel();

			}
		});

		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelMostrarStock mostrarStock = new PanelMostrarStock(frame);
				frame.add(mostrarStock);
				cerrarPanel();

			}
		});
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelMenuPrincipal menuPrincipal = new PanelMenuPrincipal(frame);
				frame.add(menuPrincipal);
				cerrarPanel();

			}
		});

	}
}