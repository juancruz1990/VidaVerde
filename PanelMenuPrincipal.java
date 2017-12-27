import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class PanelMenuPrincipal extends JPanel {

	FondoPantalla fondo;
	private String nombre = "/imagen/biogreen.jpg";

	public PanelMenuPrincipal(JFrame frame) {
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
		JButton boton5 = new JButton();
		JLabel texto = new JLabel();
		texto.setText("Menu Principal");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 20));
		texto.setBounds(12, 0, 500, 40);

		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setText("Menu Cliente");
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton1.setBounds(12, 60, 250, 40);
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);
		boton2.setText("Menu Pedido");
		boton2.setBounds(12, 100, 250, 40);
		boton3.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton3.setText("Menu Producto");
		boton3.setBackground(Color.LIGHT_GRAY);
		boton3.setForeground(Color.DARK_GRAY);
		boton3.setBounds(12, 140, 250, 40);
		boton4.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton4.setText("Menu Factura");
		boton4.setBackground(Color.LIGHT_GRAY);
		boton4.setForeground(Color.DARK_GRAY);
		boton4.setBounds(12, 180, 250, 40);
		boton5.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton5.setText("Salir");
		boton5.setBackground(Color.LIGHT_GRAY);
		boton5.setForeground(Color.DARK_GRAY);
		boton5.setBounds(12, 260, 250, 40);
		fondo.add(texto);
		fondo.add(boton1);
		fondo.add(boton2);
		fondo.add(boton3);
		fondo.add(boton4);
		fondo.add(boton5);

		this.add(fondo);
		this.setLayout(null);
		frame.add(this);
		frame.setVisible(true);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuCliente menuUsuario = new PanelMenuCliente(frame);
				cerrarPanel();
				frame.add(menuUsuario);

			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuPedido menuPedido = new PanelMenuPedido(frame);
				frame.add(menuPedido);
				cerrarPanel();

			}
		});

		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuProducto menuProducto = new PanelMenuProducto(frame);
				frame.add(menuProducto);
				cerrarPanel();

			}
		});

		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelOpcionFactura opcionFactura = new PanelOpcionFactura(frame);
				frame.add(opcionFactura);
				cerrarPanel();

			}
		});

		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);

			}
		});

	}

}
