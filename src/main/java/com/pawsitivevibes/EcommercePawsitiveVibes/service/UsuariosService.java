package com.pawsitivevibes.EcommercePawsitiveVibes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pawsitivevibes.EcommercePawsitiveVibes.Repository.UsuariosRepository;
import com.pawsitivevibes.EcommercePawsitiveVibes.model.CambiarContrasena;
import com.pawsitivevibes.EcommercePawsitiveVibes.model.Usuarios;

@Service
public class UsuariosService {
	
		public final UsuariosRepository usuariosRepository;
		
		@Autowired
		public UsuariosService(UsuariosRepository usuariosRepository) {
			this.usuariosRepository = usuariosRepository;
		}
		
		
		public List<Usuarios> getAllUsuarios() {
			return usuariosRepository.findAll();
		}
		


		public Usuarios getUsuario(Long id) {
			return usuariosRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("El producto con el id [" + id + "] no existe"));
		}
		
		
		public Usuarios deleteUsuario(Long id) {
		 Usuarios tmp = null;
			if (usuariosRepository.existsById(id)) {
				tmp = usuariosRepository.findById(id).get();
				usuariosRepository.deleteById(id);
			}
			return tmp;
		}
		
		
		public Usuarios addUsuario(Usuarios usuario) {
			Usuarios tmp = null;
			if (usuariosRepository.findByCorreo(usuario.getCorreo()).isEmpty()){
			tmp = usuariosRepository.save(usuario);
			} else System.out.println("El usuario con el email [" + usuario.getCorreo()
					+ "] ya se encuentra registrado");
			return tmp;
		}
		
		
		public  Usuarios updateUsuario(Long id, CambiarContrasena cambiarContrasena) {
			Usuarios tmp = null;
			if (usuariosRepository.existsById(id)) {
				tmp = usuariosRepository.findById(id).get();
				if (cambiarContrasena.getOldPassword() != null && cambiarContrasena.getNewPassword() != null) {
					if (tmp.getContrasena().equals(cambiarContrasena.getOldPassword())) {
						tmp.setContrasena(cambiarContrasena.getNewPassword());
						usuariosRepository.save(tmp);
					} // coincidencia de las contras 
					else {
						tmp = null;
					}
				} // contraseñas 
				System.out.println(cambiarContrasena.getOldPassword() + " " + cambiarContrasena.getNewPassword());
			} // usuario
			else {
				System.out.println("El usuario con el id [" + id
						+ "] no existe");
			}
			return tmp;
		}
	}


