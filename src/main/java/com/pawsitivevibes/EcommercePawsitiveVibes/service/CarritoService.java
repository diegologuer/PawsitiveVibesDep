package com.pawsitivevibes.EcommercePawsitiveVibes.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pawsitivevibes.EcommercePawsitiveVibes.model.Carrito;

@Service
public class CarritoService {
	
		public final ArrayList<Carrito> lista = new ArrayList<>();
		@Autowired
		public CarritoService() {
			lista.add(new Carrito(2));
			lista.add(new Carrito(4));
			lista.add(new Carrito(8));

		}
		
		public List<Carrito> getAllCarritos() {
			return this.lista;
		}
		
		public Carrito getCarrito(Long id) {
			Carrito tmp = null;
			for(Carrito carrito : lista) {
				if(carrito.getId().equals(id)) {
					tmp=carrito;
					break;
				}
			}
			return tmp;
		}
		public Carrito deleteCarrito(Long id) {
		 Carrito tmp = null;
			for (Carrito carrito : lista) {
				if(carrito.getId().equals(id)) {
					tmp=lista.remove(lista.indexOf(carrito));
					break;
				}
			}
			return tmp;
		}
		
		public Carrito addCarrito(Carrito carrito) {
			lista.add(carrito);
			return carrito;
		}
		
		
	

		public Carrito updateCarrito(Long id, Integer cantidad) {
			Carrito tmp = null;
			for(Carrito usuario : lista) {
				if(usuario.getId().equals(id)) {
					if(cantidad!=null) usuario.setCantidad(cantidad);
					tmp=usuario;
					break;
				}
			}
			return tmp;
		}
	}

