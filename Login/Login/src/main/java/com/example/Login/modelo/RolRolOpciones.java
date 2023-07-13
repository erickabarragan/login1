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
@Table(name="RolRolOpciones" , schema="dbo")
public class RolRolOpciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRolRolOpcion")
    private int idRolRolOpcion;
    
    @ManyToOne
    @JoinColumn(name="idRol" , referencedColumnName="idRol", nullable=false)
    private Rol rol;
    
    @ManyToOne
    @JoinColumn(name="idOpcion" , referencedColumnName="idOpcion", nullable=false)
    private RolOpciones rolOpciones;

	public int getIdRolRolOpcion() {
		return idRolRolOpcion;
	}

	public void setIdRolRolOpcion(int idRolRolOpcion) {
		this.idRolRolOpcion = idRolRolOpcion;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public RolOpciones getRolOpciones() {
		return rolOpciones;
	}

	public void setRolOpciones(RolOpciones rolOpciones) {
		this.rolOpciones = rolOpciones;
	}
    
    
    
    
    
    
}