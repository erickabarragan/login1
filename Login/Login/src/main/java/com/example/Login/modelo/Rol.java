package com.example.Login.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Rol" , schema="dbo")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private int idRol;

    @Column(name = "rolNombre", length = 50, nullable = false)
    private String rolNombre;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

   
    
    
    
    
    
    
    
    
    
    
}



