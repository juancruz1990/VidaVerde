import javax.swing.JFrame;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame principal = new JFrame();
		principal.setTitle("BIOGREEN");
	    principal.setLocation(300, 100);
	    principal.setSize(800, 600);
	    @SuppressWarnings("unused")
		PanelMenuPrincipal panelMenu = new PanelMenuPrincipal(principal);
	   
	}

}
