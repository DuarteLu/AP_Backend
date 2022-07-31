package com.ArgP.perfil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArgP.perfil.Entity.Experiencia;


@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia,Long>{

}
