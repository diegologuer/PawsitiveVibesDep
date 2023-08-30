package com.pawsitivevibes.EcommercePawsitiveVibes.model;

public class Carrito {
	
	private Long id;
	private Integer cantidad;
	private Long productos_id;
	private Long usuario_id;

	private static long total= 0;

	public Carrito(Integer cantidad) {
		super();
		this.cantidad = cantidad;
		Carrito.total++;
		this.id = Carrito.total;
	}
	
	public Carrito() {
		Carrito.total++;
		this.id = Carrito.total;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public static long getTotal() {
		return total;
	}

	public static void setTotal(long total) {
		Carrito.total = total;
	}
	
	

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", cantidad=" + cantidad + "]";
	}
	
	

}
