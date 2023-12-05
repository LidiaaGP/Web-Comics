package com.ipartek.modelo.dto;

public class Producto {
	private int id;
	private String nombre;
	private String editorial;
	private double precio;
	private int fk_categoria;
	

	public Producto(int id, String nombre, String editorial, double precio, int fk_categoria) {
		this.id = id;
		this.nombre = nombre;
		this.editorial = editorial;
		this.precio = precio;
		this.fk_categoria = fk_categoria;
	}

	public Producto() {
		this.id = 0;
		this.nombre = "";
		this.editorial = "";
		this.precio = 0.0;
		this.fk_categoria = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getFk_categoria() {
		return fk_categoria;
	}

	public void setFk_categoria(int fk_categoria) {
		this.fk_categoria = fk_categoria;
	}
	
	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + ", precio=" + precio
				+ ", fk_categoria=" + fk_categoria + "]";
	}
	
	
	

	
	
	
	
	
	
}
