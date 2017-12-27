import java.awt.Color;
import java.awt.Dimension;
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

public class PanelModificarCantidadPedido extends JPanel {

	JTable miTabla1;
	JScrollPane mibarra1;
	private JTextField caja1;

	public PanelModificarCantidadPedido(JFrame frame, Pedido pedido) {
		super();
		iniciarVentana(frame, pedido);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame, Pedido pedido) {
		JPanel panel2 = new JPanel();
		panel2.setBounds(50, 50, 700, 370);
		panel2.setBackground(Color.ORANGE);

		JButton boton1 = new JButton();
		JButton boton2 = new JButton();
		JLabel textoCodigoProducto = new JLabel();
		JLabel textoCantidad = new JLabel();
		JLabel textoIdPedido = new JLabel();
		JLabel texto = new JLabel();
		JLabel texto2 = new JLabel();
		texto.setText("Modificar Cantidad Pedido");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		caja1 = new JTextField();

		textoIdPedido.setText("Id Pedido  " + pedido.getIdPedido());
		textoIdPedido.setBounds(150, 140, 350, 50);
		textoIdPedido.setFont(new java.awt.Font("Times New Roman", 0, 20));

		textoCodigoProducto.setText("codigo = " + pedido.getCodigoProducto());
		textoCodigoProducto.setBounds(150, 180, 350, 50);
		textoCodigoProducto
				.setFont(new java.awt.Font("Times New Roman", 0, 20));

		textoCantidad.setText("cantidad actual : " + pedido.getCantidad());
		textoCantidad.setBounds(150, 210, 350, 50);
		textoCantidad.setFont(new java.awt.Font("Times New Roman", 0, 20));
		texto2.setText("ingrese nueva cantidad");
		texto2.setBounds(150, 250, 350, 50);
		texto2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja1.setBounds(300, 290, 150, 30);

		boton1.setText("Modificar");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(150, 350, 150, 50);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setText("Volver");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(300, 350, 150, 50);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);

		this.add(textoIdPedido);
		this.add(textoCodigoProducto);
		this.add(textoCantidad);
		this.add(texto2);
		this.add(caja1);
		this.setLayout(null);
		this.add(boton1);
		this.add(boton2);
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pedido.setCantidad(Integer.parseInt(caja1.getText()));
				pedido.modificarPedido(pedido);
				PanelMenuProducto menuProducto = new PanelMenuProducto(frame);
				cerrarPanel();
				frame.add(menuProducto);

			}

		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuPedido pedido = new PanelMenuPedido(frame);
				cerrarPanel();
				frame.add(pedido);

			}
		});

	}

}
