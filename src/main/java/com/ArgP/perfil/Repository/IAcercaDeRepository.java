package com.ArgP.perfil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArgP.perfil.Entity.AcercaDe;

@Repository
public interface IAcercaDeRepository extends JpaRepository<AcercaDe,Long>{

}
