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
import com.pawsitivevibes.EcommercePawsitiveVibes.model.Carrito;
import com.pawsitivevibes.EcommercePawsitiveVibes.service.CarritoService;
import com.pawsitivevibes.EcommercePawsitiveVibes.service.ProductoService;
import com.pawsitivevibes.EcommercePawsitiveVibes.service.UsuariosService;

@RestController
@RequestMapping(path = "/api/carrito/") // http://localhost:8080/api/carrito/
public class controllerCarrito {

	private final CarritoService carritoService;
	
	@Autowired
	public controllerCarrito(CarritoService carritoService) {	
		this.carritoService = carritoService;
	}

	@GetMapping
	public List<Carrito> getAllCarritos(){
		return carritoService.getAllCarritos();
	}
	
	@GetMapping(path="{prodId}")
	public Carrito getCarrito(@PathVariable("prodId") Long id){
		return carritoService.getCarrito(id);
	}
	
	@DeleteMapping(path="{prodId}")
	public Carrito deleteCarrito(@PathVariable("prodId") Long id){
		return carritoService.deleteCarrito(id);
	}
	
	@PostMapping
	public Carrito addCarrito(@RequestBody Carrito carrito) {
		
		return carritoService.addCarrito(carrito);
	}
	
	@PutMapping(path="{prodId}")
	public Carrito updateCarrito(@PathVariable("prodId") Long id,
			@RequestParam(required=false) Integer cantidad
			
			) 
	{
		
		return carritoService.updateCarrito(id, cantidad);
		
	}
}