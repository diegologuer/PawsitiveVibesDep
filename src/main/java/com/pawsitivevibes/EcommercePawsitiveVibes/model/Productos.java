package com.pawsitivevibes.EcommercePawsitiveVibes.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;
	
	@Column(nullable=false)
	private String titulo;
	
	@Column(nullable=false)
	private String categoria;
	
	@Column(nullable=false)
	private Integer numStock;
	
	@Column(nullable=false)
	private String marca;
	
	@Column(nullable=false)
	private String descripcion;
	
	@Column(nullable=false)
	private String seccion;
	
	@Column(nullable=false)
	private Integer descuento;
	
	@Column(nullable=false)
	private Double precio;
	
	@Column(nullable=false)
	private String imagen;
	

	public Productos(String titulo, String categoria, Integer numStock, String marca, String descripcion,
			String seccion, Integer descuento, Double precio, String imagen) {
		this.titulo = titulo;
		this.categoria = categoria;
		this.numStock = numStock;
		this.marca = marca;
		this.descripcion = descripcion;
		this.seccion = seccion;
		this.descuento = descuento;
		this.precio = precio;
		this.imagen = imagen;
		}
	
	public Productos() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getNumStock() {
		return numStock;
	}

	public void setNumStock(Integer numStock) {
		this.numStock = numStock;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", titulo=" + titulo + ", categoria=" + categoria + ", numStock=" + numStock
				+ ", marca=" + marca + ", descripcion=" + descripcion + ", seccion=" + seccion + ", descuento="
				+ descuento + ", precio=" + precio + ", imagen=" + imagen + "]";
	}
	
	
	
	
	
	
	
}
