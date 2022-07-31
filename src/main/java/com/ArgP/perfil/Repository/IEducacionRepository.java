package com.ArgP.perfil.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArgP.perfil.Entity.Educacion;



@Repository
public interface IEducacionRepository extends JpaRepository<Educacion,Long> {

	 public Optional<Educacion> findByTituloEdu(String tituloEdu);
	    public boolean existsByTituloEdu(String tituloEdu);
}
