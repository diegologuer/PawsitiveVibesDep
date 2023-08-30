package com.pawsitivevibes.EcommercePawsitiveVibes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawsitivevibes.EcommercePawsitiveVibes.Repository.ProductoRepository;
import com.pawsitivevibes.EcommercePawsitiveVibes.model.Productos;

@Service
public class ProductoService {
	
	private final ProductoRepository productoRepository;
		@Autowired
		public ProductoService(ProductoRepository productoRepository) {
			this.productoRepository = productoRepository;
		}
		
		public List<Productos> getAllProductos() {
			return this.productoRepository.findAll();
		}
		
		
		public Productos getProducto(Long id) {
			return productoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("El producto con el id [" + id + "] no existe"));
		}
		
		public Productos deleteProducto(Long id) {
			Productos tmp = null;
			if(productoRepository.existsById(id)) {
				tmp = productoRepository.findById(id).get();
				productoRepository.deleteById(id);
			}
			return tmp;
		}
		
		public Productos addProducto(Productos producto) {
			Productos tmp = null;
			if(productoRepository.findByTitulo(producto.getTitulo()).isEmpty()) {
			    tmp = productoRepository.save(producto);
		    } else{
		    	System.out.println("Ya existe el producto con el nombre [" + producto.getTitulo()
		    			+ "]");
		    }
			return tmp;
		}
		
		public Productos updateProduct(Long id, String titulo, String categoria, Integer numStock, String marca,
				String descripcion, String seccion, Integer descuento, Double precio, String imagen) {
			Productos tmp = null;
			if(productoRepository.existsById(id)) {
				tmp = productoRepository.findById(id).get();
					if(titulo!=null) tmp.setTitulo(titulo);
					if(categoria!=null) tmp.setCategoria(categoria);
					if(numStock!=null) tmp.setNumStock(numStock);
					if(marca!=null) tmp.setMarca(marca);
					if(descripcion!=null) tmp.setDescripcion(descripcion);
					if(seccion!=null) tmp.setSeccion(seccion);
					if(descuento!=null) tmp.setDescuento(descuento);
					if(precio!=null) tmp.setPrecio(precio);
					if(imagen!=null) tmp.setImagen(imagen);
					productoRepository.save(tmp);
				} else { System.out.println("El producto con el id [" + id + "] no existe");
									
			}
			return tmp;
		}
	}


