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
import org.springframework.web.bind.annotation.RestController;

import com.pawsitivevibes.EcommercePawsitiveVibes.model.CambiarContrasena;
import com.pawsitivevibes.EcommercePawsitiveVibes.model.Usuarios;
import com.pawsitivevibes.EcommercePawsitiveVibes.service.UsuariosService;

@RestController
@RequestMapping(path = "/api/usuarios/") // http://localhost:8080/api/usuarios/
public class controllerUsuarios {

	private final UsuariosService usuariosService;
	
	@Autowired
	public controllerUsuarios(UsuariosService usuariosService) {	
		this.usuariosService = usuariosService;
	}

	@GetMapping
	public List<Usuarios> getAllUsuarios(){
		return usuariosService.getAllUsuarios();
	}
	
	@GetMapping(path="{prodId}")
	public Usuarios getUsuario(@PathVariable("prodId") Long id){
		return usuariosService.getUsuario(id);
	}
	
	@DeleteMapping(path="{prodId}")
	public Usuarios deleteUsuario(@PathVariable("prodId") Long id){
		return usuariosService.deleteUsuario(id);
	}
	
	@PostMapping
	public Usuarios addUsuario(@RequestBody Usuarios usuario) {
		
		return usuariosService.addUsuario(usuario);
	}
	
	@PutMapping(path="{prodId}")
	public Usuarios updateUsuario(@PathVariable("prodId") Long id, @RequestBody CambiarContrasena cambiarContrasena)
	{

		return usuariosService.updateUsuario(id, cambiarContrasena);
		
	}
}