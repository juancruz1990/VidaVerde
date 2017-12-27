import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelModificarCliente extends JPanel {
	private JTextField caja1;
	private JTextField caja2;
	private JTextField caja3;
	private JTextField caja4;
	private JTextField caja5;

	public PanelModificarCliente(JFrame frame, Cliente cliente, int identy) {
		super();
		iniciarVentana(frame, cliente, identy);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame, Cliente cliente, int identy) {

		JPanel panel2 = new JPanel();
		panel2.setBounds(50, 50, 700, 370);
		panel2.setBackground(Color.ORANGE);

		JButton boton1 = new JButton();
		JButton boton2 = new JButton();
		JLabel textoNombre = new JLabel();
		JLabel textoApellido = new JLabel();
		JLabel textoDni = new JLabel();
		JLabel textoLocalidad = new JLabel();
		JLabel textoDireccion = new JLabel();
		JLabel texto = new JLabel();
		texto.setText("MODIFICAR CLIENTE");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		caja1 = new JTextField();
		caja2 = new JTextField();
		caja3 = new JTextField();
		caja4 = new JTextField();
		caja5 = new JTextField();

		this.setLayout(null);
		textoNombre.setText("Nombre");
		textoNombre.setBounds(250, 90, 150, 50);
		textoNombre.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja1.setBounds(340, 100, 150, 30);
		textoApellido.setText("Apellido");
		textoApellido.setFont(new java.awt.Font("Times New Roman", 0, 20));
		textoApellido.setBounds(250, 130, 150, 50);
		caja2.setBounds(340, 140, 150, 30);
		textoDni.setText("Dni");
		textoDni.setBounds(250, 170, 150, 50);
		textoDni.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja3.setBounds(340, 180, 150, 30);
		textoDireccion.setText("Direccion");
		textoDireccion.setBounds(250, 210, 150, 50);
		textoDireccion.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja4.setBounds(340, 220, 150, 30);
		textoLocalidad.setText("Localidad");
		textoLocalidad.setBounds(250, 250, 150, 50);
		textoLocalidad.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja5.setBounds(340, 260, 150, 30);
		Cliente miCliente = new Cliente();

		ArrayList<Cliente> miLista = miCliente.buscarClienteId(identy);
		if (miLista.size() > 0) {
			caja1.setText(miLista.get(0).getNombre());
			caja2.setText(miLista.get(0).getApellido());
			Integer.toString(miLista.get(0).getDni());
			caja3.setText(Integer.toString(miLista.get(0).getDni()));
			caja4.setText(miLista.get(0).getLocalidad());
			caja5.setText(miLista.get(0).getDireccion());
		}

		boton1.setText("MODIFICAR CLIENTE");
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(230, 310, 300, 50);
		boton2.setText("VOLVER");
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(300, 370, 150, 50);

		this.add(textoNombre);
		this.add(textoApellido);
		this.add(textoDni);
		this.add(textoLocalidad);
		this.add(textoDireccion);
		this.add(caja1);
		this.add(caja2);
		this.add(caja3);
		this.add(caja4);
		this.add(caja5);
		this.add(boton1);
		this.add(boton2);
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cliente persona = new Cliente();
				int dni = Integer.parseInt(caja3.getText());
				persona.setIdCliente(identy);
				persona.setNombre(caja1.getText());
				persona.setApellido(caja2.getText());
				persona.setDni(dni);
				persona.setLocalidad(caja4.getText());
				persona.setDireccion(caja5.getText());
				persona.modificaCliente(persona);
				PanelMenuCliente menuCliente = new PanelMenuCliente(frame);
				cerrarPanel();
				frame.add(menuCliente);

			}

		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuCliente modificarCliente = new PanelMenuCliente(frame);
				cerrarPanel();
				frame.add(modificarCliente);

			}
		});

	}
}