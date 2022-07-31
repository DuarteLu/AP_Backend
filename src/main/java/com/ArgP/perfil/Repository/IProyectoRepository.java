package com.ArgP.perfil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArgP.perfil.Entity.Proyecto;

@Repository
public interface IProyectoRepository  extends JpaRepository<Proyecto,Long> {

}
