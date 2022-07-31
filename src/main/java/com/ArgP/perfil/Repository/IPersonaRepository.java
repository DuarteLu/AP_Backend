package com.ArgP.perfil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArgP.perfil.Entity.Persona;



@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long>{

}
