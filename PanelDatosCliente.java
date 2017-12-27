import java.awt.Color;
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

public class PanelDatosCliente extends JPanel {

	JTable miTabla1;
	JScrollPane mibarra1;
	private ArrayList<Pedido> miLista;
	private ArrayList<Cliente> miCliente;

	public PanelDatosCliente(JFrame frame, int id) {
		super();
		iniciarVentana(frame, id);

	}

	private void cerrarPanel() {
		this.setVisible(false);
	}

	public void iniciarVentana(JFrame frame, int id) {

		JPanel panel2 = new JPanel();
		panel2.setBounds(50, 50, 700, 370);
		panel2.setBackground(Color.ORANGE);

		JButton boton1 = new JButton();
		JLabel texto = new JLabel();
		JLabel nombre = new JLabel();
		JLabel apellido = new JLabel();
		texto.setText("DATOS CLIENTE");
		texto.setFont(new java.awt.Font("Times New Roman", 0, 30));
		texto.setBounds(12, 0, 500, 40);
		this.add(texto);
		this.setLayout(null);

		boton1.setText("ACEPTAR");
		boton1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		boton1.setBounds(250, 300, 150, 50);
		this.add(boton1);
		Cliente cliente = new Cliente();
		Pedido pedido = new Pedido();
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(200, 100, 400, 130);
		this.add(nombre);
		this.add(apellido);
		this.add(mibarra1);
		miCliente = new ArrayList<Cliente>();
		miLista = new ArrayList<Pedido>();
		miCliente = cliente.buscarClienteId(id);
		String titulos[] = { "id pedido", "codigo producto", "cantidad",
				"fecha" };
		miLista = pedido.buscarPedidosConMatriz(id);
		if (miLista.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"la persona seleccionada no registra ningun pedido");
		}

		String informacion[][] = pedido.obtenerMatrizPedido(miLista);
		miTabla1 = new JTable(informacion, titulos);
		mibarra1.setViewportView(miTabla1);
		nombre.setText(miCliente.get(0).getNombre());
		nombre.setBounds(50, 50, 100, 50);
		apellido.setText(miCliente.get(0).getApellido());
		apellido.setBounds(110, 50, 100, 50);
		this.add(panel2);
		frame.add(this);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarPanel();
				PanelMenuCliente menuCliente = new PanelMenuCliente(frame);
				frame.add(menuCliente);
			}
		});
	}

}
