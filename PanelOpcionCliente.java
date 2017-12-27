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

public class PanelOpcionCliente extends JPanel {

	JTable miTabla1;
	JScrollPane mibarra1;
	private JTextField caja1;
	private ArrayList<Cliente> miLista;

	public PanelOpcionCliente(JFrame frame, Cliente cliente) {
		super();
		iniciarVentana(frame, cliente);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame, Cliente cliente) {
		JPanel panel2 = new JPanel();
		panel2.setBounds(12, 50, 755, 359);
		panel2.setBackground(Color.ORANGE);

		this.setVisible(true);
		JButton boton1 = new JButton();
		JButton boton2 = new JButton();
		JButton boton3 = new JButton();
		JButton boton4 = new JButton();

		JLabel id = new JLabel();
		caja1 = new JTextField();

		id.setText("SELECCIONE ID CLIENTE");
		id.setBounds(50, 219, 200, 60);
		id.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja1.setBounds(350, 219, 50, 40);
		this.add(caja1);
		this.add(id);

		JLabel texto = new JLabel();
		texto.setText("OPCION CLIENTE");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		this.setLayout(null);

		boton1.setText("Baja Cliente");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(12, 321, 250, 40);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setText("Modificar Cliente");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(270, 321, 250, 40);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);
		boton3.setText("Ver Datos Cliente");
		boton3.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton3.setBounds(521, 321, 245, 40);
		boton3.setBackground(Color.LIGHT_GRAY);
		boton3.setForeground(Color.DARK_GRAY);
		boton4.setText("Volver");
		boton4.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton4.setBounds(12, 370, 200, 40);
		boton4.setBackground(Color.LIGHT_GRAY);
		boton4.setForeground(Color.DARK_GRAY);

		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		this.add(boton4);

		mibarra1 = new JScrollPane();
		mibarra1.setBounds(200, 72, 400, 130);
		this.add(mibarra1);
		miLista = new ArrayList<Cliente>();
		String titulos[] = { "id", "dni", "Nombre", "apellido", "direccion",
				"localidad" };
		miLista = cliente.buscarClientesConMatriz(cliente);
		String informacion[][] = cliente.obtenerMatrizCliente(cliente, miLista);
		miTabla1 = new JTable(informacion, titulos);
		mibarra1.setViewportView(miTabla1);
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(caja1.getText());
				cliente.bajaCliente(id);
				miLista = new ArrayList<Cliente>();
				String titulos[] = { "id", "codigo", "Nombre", "stock",
						"tipo producto", "precio" };
				miLista = cliente.buscarClientesConMatriz(cliente);
				String informacion[][] = cliente.obtenerMatrizCliente(cliente,
						miLista);
				miTabla1 = new JTable(informacion, titulos);
				mibarra1.setViewportView(miTabla1);
				PanelOpcionCliente panelOpcion = new PanelOpcionCliente(frame,
						cliente);
				cerrarPanel();
				frame.add(panelOpcion);

			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(caja1.getText());
				Cliente persona = new Cliente();
				if (persona.verificacionCliente(miLista, id)) {
					PanelModificarCliente modificarCliente = new PanelModificarCliente(
							frame, cliente, id);
					cerrarPanel();
					frame.add(modificarCliente);

				} else {
					JOptionPane.showMessageDialog(null,
							"El ID seleccionado no corresponde a la lista");
					cerrarPanel();
					PanelOpcionCliente panelOpcion = new PanelOpcionCliente(
							frame, cliente);
					frame.add(panelOpcion);
				}
			}
		});

		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(caja1.getText());
				Cliente persona = new Cliente();
				if (persona.verificacionCliente(miLista, id)) {
					PanelDatosCliente datos = new PanelDatosCliente(frame, id);
					cerrarPanel();
					frame.add(datos);
				} else {
					JOptionPane.showMessageDialog(null,
							"El ID seleccionado no corresponde a la lista");
					cerrarPanel();
					PanelOpcionCliente panelOpcion = new PanelOpcionCliente(
							frame, cliente);
					frame.add(panelOpcion);
				}
			}
		});

		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuCliente menuCliente = new PanelMenuCliente(frame);
				cerrarPanel();
				frame.add(menuCliente);

			}
		});
	}

}
