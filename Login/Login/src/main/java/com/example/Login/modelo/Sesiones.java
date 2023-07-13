package com.example.Login.modelo;

import java.time.LocalDate;

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
@Table(name="Sesiones" , schema="dbo")
public class Sesiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSesion")
    private int idSesion;

    @Column(name = "fechaIngreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "fechaCierre")
    private LocalDate fechaCierre;

    @ManyToOne
    @JoinColumn(name="idUsuario" , referencedColumnName="idUsuario", nullable=false)
    private Usuarios usuarios;

	public int getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
    
    
    
    
    
    
    
}




