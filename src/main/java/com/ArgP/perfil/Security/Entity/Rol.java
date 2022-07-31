package com.ArgP.perfil.Security.Entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.ArgP.perfil.Security.Enums.RolNombre;

@Entity
public class Rol {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    //anotation que define los valores que van a ingresar. 
    //si o si tiene que ser alfanumericos. si ponemos EnumType.ORDINAL en vez de EnumType.STRING 
    //ORDINAL, solo permite valores enteros
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
    
    //Constructor
    public Rol() {
    }

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    //Getter y Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
}
