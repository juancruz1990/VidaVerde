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

public class PanelBuscarCliente extends JPanel {

	private JTextField caja1;
	private JTextField caja2;
	private JTextField caja3;

	public PanelBuscarCliente(JFrame frame) {
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
		JLabel textoNombre = new JLabel();
		JLabel textoApellido = new JLabel();
		JLabel textoDni = new JLabel();

		JLabel texto = new JLabel();
		texto.setText("BUSCAR CLIENTE");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		caja1 = new JTextField();
		caja2 = new JTextField();
		caja3 = new JTextField();
		Cliente cliente = new Cliente();
		this.setLayout(null);
		textoNombre.setText("Nombre Cliente");
		textoNombre.setBounds(220, 90, 150, 50);
		textoNombre.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja1.setBounds(390, 100, 150, 30);
		textoApellido.setText("Apellido Cliente");
		textoApellido.setFont(new java.awt.Font("Times New Roman", 0, 20));
		textoApellido.setBounds(220, 130, 150, 50);
		caja2.setBounds(390, 140, 150, 30);
		textoDni.setText("Dni");
		textoDni.setBounds(220, 170, 150, 50);
		textoDni.setFont(new java.awt.Font("Times New Roman", 0, 20));
		caja3.setBounds(390, 180, 150, 30);

		boton1.setText("BUSCAR");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(220, 270, 150, 50);
		boton1.setBackground(Color.LIGHT_GRAY);
		boton1.setForeground(Color.DARK_GRAY);
		boton2.setText("VOLVER");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(390, 270, 150, 50);
		boton2.setBackground(Color.LIGHT_GRAY);
		boton2.setForeground(Color.DARK_GRAY);

		this.add(textoNombre);
		this.add(textoApellido);
		this.add(textoDni);

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
					PanelBuscarCliente buscarCliente = new PanelBuscarCliente(
							frame);
					buscarCliente.caja1.setText(caja1.getText());
					buscarCliente.caja2.setText(caja2.getText());
					buscarCliente.caja3.setText(caja3.getText());
					buscarCliente.setVisible(true);
					cerrarPanel();
					frame.add(buscarCliente);
				} else {
					cliente.setNombre(caja1.getText());
					cliente.setApellido(caja2.getText());
					cliente.setDni(Integer.parseInt(caja3.getText()));
					PanelOpcionCliente menuOpcion = new PanelOpcionCliente(
							frame, cliente);
					cerrarPanel();
					frame.add(menuOpcion);

				}

			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuCliente menuCliente = new PanelMenuCliente(frame);
				cerrarPanel();
				frame.add(menuCliente);
			}
		});
	}

}
