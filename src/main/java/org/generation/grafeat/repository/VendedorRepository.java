package org.generation.grafeat.repository;

import java.util.Optional;

import org.generation.grafeat.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>{
	
	public Optional<Vendedor>findByUsuario(String usuario);
	
}
