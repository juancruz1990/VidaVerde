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

public class PanelListarClientes extends JPanel {

	JTable miTabla1;
	JScrollPane mibarra1;
	private ArrayList<Cliente> miLista;

	public PanelListarClientes(JFrame frame) {
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

		JLabel texto = new JLabel();
		texto.setText("LISTAR CLIENTE");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);

		Cliente cliente = new Cliente();
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(80, 70, 650, 250);
		miLista = new ArrayList<Cliente>();
		String titulos[] = { "id", "dni", "Nombre", "apellido", "direccion",
				"localidad" };
		miLista = cliente.listarClientes();
		String informacion[][] = cliente.obtenerMatrizCliente(cliente, miLista);
		miTabla1 = new JTable(informacion, titulos);
		mibarra1.setViewportView(miTabla1);
		JButton boton1 = new JButton();
		boton1.setText("ACEPTAR");
		boton1.setBounds(300, 340, 100, 50);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		this.setVisible(true);
		this.setLayout(null);
		this.add(mibarra1);
		this.add(boton1);
		this.add(panel2);

		this.add(texto);

		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuCliente menuCliente = new PanelMenuCliente(frame);
				cerrarPanel();
				frame.add(menuCliente);

			}
		});

	}

}
