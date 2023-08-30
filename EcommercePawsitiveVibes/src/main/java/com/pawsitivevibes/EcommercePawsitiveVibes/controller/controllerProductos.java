package com.pawsitivevibes.EcommercePawsitiveVibes.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pawsitivevibes.EcommercePawsitiveVibes.model.Productos;
import com.pawsitivevibes.EcommercePawsitiveVibes.service.ProductoService;

@RestController
@RequestMapping(path = "/api/productos/") // http://localhost:8080/api/productos/
public class controllerProductos {

	private final ProductoService productoService;
	
	@Autowired
	public controllerProductos(ProductoService productoService) {	
		this.productoService = productoService;
	}

	@GetMapping
	public List<Productos> getAllProducts(){
		return productoService.getAllProductos();
	}
	
	@GetMapping(path="{prodId}")
	public Productos getProduct(@PathVariable("prodId") Long id){
		return productoService.getProducto(id);
	}
	
	@DeleteMapping(path="{prodId}")
	public Productos deleteProduct(@PathVariable("prodId") Long id){
		return productoService.deleteProducto(id);
	}
	
	@PostMapping
	public Productos addProducto(@RequestBody Productos producto) {
		
		return productoService.addProducto(producto);
	}
	
	@PutMapping(path="{prodId}")
	public Productos updateProduct(@PathVariable("prodId") Long id,
			@RequestParam(required=false) String titulo,
			@RequestParam(required=false) String categoria,
			@RequestParam(required=false) Integer numStock,
			@RequestParam(required=false) String marca,
			@RequestParam(required=false) String descripcion,
			@RequestParam(required=false) String seccion,
			@RequestParam(required=false) Integer descuento,
			@RequestParam(required=false) Double precio,
			@RequestParam(required=false) String imagen
			) 
	
	{
		
		return productoService.updateProduct(id, titulo, categoria, numStock, marca, descripcion, seccion, descuento, precio, imagen);
		
	}
}
