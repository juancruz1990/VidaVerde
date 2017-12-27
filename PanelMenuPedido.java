import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenuPedido extends JPanel {

	FondoPantalla fondo;
	private String nombre = "/imagen/pedidoimagen.png";

	public PanelMenuPedido(JFrame frame) {
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

		this.setLayout(null);

		JButton boton1 = new JButton();
		JButton boton2 = new JButton();
		JButton boton3 = new JButton();

		JLabel texto = new JLabel();
		texto.setText("Menu Pedido");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 20));
		texto.setBounds(12, 0, 500, 40);

		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setText("Alta Pedido");
		boton1.setBounds(12, 60, 325, 40);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setText("Mostrar Pedidos Clientes");
		boton2.setBounds(12, 100, 325, 40);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);
		boton3.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton3.setText("Volver");
		boton3.setBounds(12, 280, 250, 40);
		boton3.setBackground(Color.LIGHT_GRAY);
		boton3.setForeground(Color.DARK_GRAY);

		fondo.add(texto);
		fondo.add(boton1);
		fondo.add(boton2);
		fondo.add(boton3);
		this.add(fondo);
		this.setLayout(null);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelAltaPedido altaPedido = new PanelAltaPedido(frame);
				frame.add(altaPedido);
				cerrarPanel();

			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelMostrarPedidosClientes opcionPedido = new PanelMostrarPedidosClientes(
						frame);
				frame.add(opcionPedido);
				cerrarPanel();

			}
		});

		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelMenuPrincipal menuPrincipal = new PanelMenuPrincipal(frame);
				frame.add(menuPrincipal);
				cerrarPanel();

			}
		});

	}

}
