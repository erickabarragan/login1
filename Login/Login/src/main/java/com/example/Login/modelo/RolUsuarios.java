package com.example.Login.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="RolUsuarios" , schema="dbo")
public class RolUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRolUsuarios")
    private int idRolUsuarios;
    
    @ManyToOne
    @JoinColumn(name="idUsuario" , referencedColumnName="idUsuario", nullable=false)
    private Usuarios usuarios;
    
    @ManyToOne
    @JoinColumn(name="idRol" , referencedColumnName="idRol", nullable=false)
    private Rol rol;

	public int getIdRolUsuarios() {
		return idRolUsuarios;
	}

	public void setIdRolUsuarios(int idRolUsuarios) {
		this.idRolUsuarios = idRolUsuarios;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
    
    
    
    
    
    
}
