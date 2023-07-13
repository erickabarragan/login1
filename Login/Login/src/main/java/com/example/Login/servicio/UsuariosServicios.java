package com.example.Login.servicio;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Login.modelo.Persona;
import com.example.Login.modelo.Usuarios;
import com.example.Login.repositorio.PersonaRepositorio;
import com.example.Login.repositorio.UsuariosRepositorio;

@Service
public class UsuariosServicios {

				@Autowired
			    UsuariosRepositorio usuariosRepositorio;
				
				@Autowired
				private PersonaServicio personaService;
				
				
				//VALIDA EL USUARIO Y LA CONTRASEÑA PARA CREAR EL USUARIO
				
				public Usuarios validacionUsuarioContrasena( Usuarios usuarios) {
					
						// Verifica si contiene signos nombreUsuario***********************************
						List<Usuarios> listItem = usuariosRepositorio.findAll();
						
						if(!usuarios.getNombreUsuario().matches("[a-zA-Z0-9]+")) {
							System.out.println("El usuario no puede contener signos");
						}
						
						// Verifica si hay duplicados nombreUsuario**********************************
						for (Usuarios usuario1: listItem) {
							
							if(usuario1.getNombreUsuario().equals(usuarios.getNombreUsuario())) {
								System.out.println("El usuario ya existe");
							}	
						}
						// Validar contraseña************************************************
						if (usuarios.getContrasena().length() < 8) {
							System.out.println("La contraseña debe tener al menos 8 dígitos");
				        }

				        if (!usuarios.getContrasena().matches(".*[A-Z].*")) {
				        	System.out.println("La contraseña debe contener al menos una letra mayúscula");
				        }

				        if (usuarios.getContrasena().contains(" ")) {
				        	System.out.println("La contraseña no debe contener espacios");
				        }

				        if (!usuarios.getContrasena().matches(".*[!@#$%^&*()].*")) {
				        	System.out.println("La contraseña debe contener al menos un signo");
				        }
						
				        // Se guarda el registro del Usuario**********************************************
				        return usuariosRepositorio.save(usuarios) ;
						
						
				}
			

				
			    public List<Usuarios> ObtenerListado(){
			        return usuariosRepositorio.findAll();
			
			    }
			
			    
			    public Optional<Usuarios> ObtenerId(int id){
			        return usuariosRepositorio.findById(id);
			
			    }
			
			
			
			   public void eliminar (int id){
			
					Usuarios usuarios=usuariosRepositorio.getReferenceById(id);
					
					if(usuarios!= null) {
						usuarios.setEstado("Bloqueado");
						usuarios.setSesionActiva("0");
						usuariosRepositorio.save(usuarios);
					}
			
			   }
	
			   
			   
			   private Usuarios buscarUsuarioPorNombreUsuario(String nombreUsuario) {
				   List<Usuarios> usuarios=usuariosRepositorio.findAll();
				   
				   
				   for(Usuarios usuario1 : usuarios) {
					   
					   if(usuario1.getNombreUsuario().equals(nombreUsuario)) {
						   
						  
						   
						   return usuario1;
					   }
					   
				   }
			       
			        return null; 
			    }
			   
			   
			   //INICIO DE SESION POR NOMBRE DE USUARIO Y CORREO
			   
			   public  boolean login(String nombreUsuario, String correo) {
				   
				  
			        Usuarios usuario = buscarUsuarioPorNombreUsuario(nombreUsuario);
			        Persona persona = usuario.getPersona();
					String correoGenerado = personaService.crearCorreo(persona);

			        if (!usuario.getCorreo().equals(correoGenerado)) {
			        	System.out.println ("Correo inválido");
			        	return false;
			        }

			        if (!usuario.getNombreUsuario().equals(nombreUsuario)) {
			        	System.out.println("nombreUsuario incorrecta");
			        	return false;
			        }

			        return true;
			    }
			   
			   
			   
			   
			   
	
			   
			   
	
}
