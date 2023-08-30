package com.pawsitivevibes.EcommercePawsitiveVibes.Repository;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pawsitivevibes.EcommercePawsitiveVibes.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProductoRepository extends JpaRepository<Productos, Long>{
	Optional<Productos> findByTitulo(String titulo);
}
