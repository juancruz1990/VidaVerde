public class DetalleFactura {
	private int idDetalle;
	private int idFactura;
	private int idProducto;
	private float precioTotal = 0;

	// constructor con atributos en parametros
	public DetalleFactura(int idDetalle, int idFactura, int idProducto,
			float precioTotal) {
		this.idDetalle = idDetalle;
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.precioTotal = precioTotal;
	}

	// constructor vacio
	public DetalleFactura() {
		this.idDetalle = 0;
		this.idFactura = 0;
		this.idProducto = 0;
		this.precioTotal = 0;
	}

	// getters & setters

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	// fin de getters & setters

}
