import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelModificarFactura extends JPanel {

	public PanelModificarFactura(JFrame frame) {
		super();
		iniciarVentana(frame);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame) {

		JButton boton1 = new JButton();
		JButton boton2 = new JButton();

		JLabel texto = new JLabel();
		texto.setText("Modificar Factura");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 20));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);

		this.setLayout(null);

		boton1.setText("Modificar");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(12, 60, 200, 40);
		boton2.setText("Volver");
		boton2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton2.setBounds(12, 100, 200, 40);

		this.add(boton1);
		this.add(boton2);

		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,
						"LA FACTURA HA SIDO MODIFICADA");
				PanelMenuPrincipal menu = new PanelMenuPrincipal(frame);
				cerrarPanel();
				frame.add(menu);

			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenuPrincipal menu2 = new PanelMenuPrincipal(frame);
				cerrarPanel();
				frame.add(menu2);
			}
		});
	}

}
