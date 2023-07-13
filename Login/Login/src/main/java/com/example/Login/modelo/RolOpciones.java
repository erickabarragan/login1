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
@Table(name="RolOpciones" , schema="dbo")
public class RolOpciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOpcion")
    private int idOpcion;

    @Column(name = "nombreOpcion", length = 50, nullable = false)
    private String nombreOpcion;

	public int getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getNombreOpcion() {
		return nombreOpcion;
	}

	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}

    
    
    
    
}



