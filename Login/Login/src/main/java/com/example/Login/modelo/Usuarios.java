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
@Table(name="Usuarios" , schema="dbo")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private int idUsuario;

    @Column(name = "nombreUsuario", length = 50, nullable = false)
    private String nombreUsuario;

    @Column(name = "contrasena", length = 50, nullable = false)
    private String contrasena;

    @Column(name = "correo", length = 120)
    private String correo;

    @Column(name = "sesionActiva", length = 1, nullable = false)
    private String sesionActiva;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;
  
    @ManyToOne
    @JoinColumn(name="idPersona" , referencedColumnName="idPersona", nullable=false)
    private Persona persona;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSesionActiva() {
		return sesionActiva;
	}

	public void setSesionActiva(String sesionActiva) {
		this.sesionActiva = sesionActiva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
    
    
    
}



