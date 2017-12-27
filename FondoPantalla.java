import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FondoPantalla extends Container {

	public ImageIcon icono;
	public JLabel labelTitulo;

	public FondoPantalla(String nombre) {
		icono = new ImageIcon(getClass().getResource(nombre)); // ruta de imagen
																// de ventana
																// principal

		labelTitulo = new JLabel();
		labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 28));
		// labelTitulo.setText(titulo);
		labelTitulo.setBounds(20, 10, 300, 40);
		add(labelTitulo);

	}

	public void paint(Graphics g) {
		Rectangle r = g.getClipBounds();
		g.setColor(this.getBackground());
		g.fillRect(r.x, r.y, r.width, r.height);
		g.drawImage(icono.getImage(), 0, 0, this.getWidth(), this.getHeight(),
				this.getBackground(), this);
		super.paint(g);
	}

}