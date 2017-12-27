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

public class PanelAltaCliente extends JPanel {

	private JTextField caja1;
	private JTextField caja2;
	private JTextField caja3;
	private JTextField caja4;
	private JTextField caja5;

	public PanelAltaCliente(JFrame frame) {
		super();
		iniciarVentana(frame);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame) {
		JPanel panel2 = new JPanel();
		panel2.setBounds(50, 50, 700, 370);
		panel2.setBackground(Color.ORANGE);

		JButton boton1 = new JButton();
		JButton boton2 = new JButton();
		JLabel textoNombre = new JLabel();
		JLabel textoApellido = new JLabel();
		JLabel textoDni = new JLabel();
		JLabel textoDireccion = new JLabel();
		JLabel textoLocalidad = new JLabel();
		caja1 = new JTextField();
		caja2 = new JTextField();
		caja3 = new JTextField();
		caja4 = new JTextField();
		caja5 = new JTextField();
		this.setLayout(null);
		JLabel texto = new JLabel();
		texto.setText("ALTA CLIENTE");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		Cliente cliente = new Cliente();
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
		boton1.setText("AGREGAR CLIENTE");
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
		this.add(textoDireccion);
		this.add(textoLocalidad);
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
				int dni = 0;
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
					PanelAltaCliente altaCliente = new PanelAltaCliente(frame);
					altaCliente.caja1.setText(caja1.getText());
					altaCliente.caja2.setText(caja2.getText());
					altaCliente.caja3.setText(caja3.getText());
					altaCliente.caja4.setText(caja4.getText());
					altaCliente.setVisible(true);
					cerrarPanel();
					frame.add(altaCliente);

				} else {
					if (cliente.verificaDni(caja3.getText())) { // verifico si
																// el dni
																// ingresado no
																// contenga
																// letras
						if (cliente.buscarCliente(dni)) {
							JOptionPane.showMessageDialog(frame,
									"el cliente " + cliente.getNombre() + " "
											+ cliente.getApellido()
											+ " ya existe");
							PanelAltaCliente altaCliente2 = new PanelAltaCliente(
									frame);
							cerrarPanel();
							frame.add(altaCliente2);

						} else {

							cliente.setNombre(caja1.getText());
							cliente.setApellido(caja2.getText());
							cliente.setDni(dni);
							cliente.setDireccion(caja4.getText());
							cliente.setLocalidad(caja5.getText());
							cliente.registrarCliente(cliente);

							PanelMenuCliente menuCliente = new PanelMenuCliente(
									frame);
							cerrarPanel();
							frame.add(menuCliente);
						}
					}

				}

			}
		});
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuCliente menuCliente2 = new PanelMenuCliente(frame);
				cerrarPanel();
				frame.add(menuCliente2);

			}
		});

	}

}
