package com.pawsitivevibes.EcommercePawsitiveVibes.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawsitivevibes.EcommercePawsitiveVibes.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
	Optional<Usuarios> findByCorreo(String correo);
}