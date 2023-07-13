package com.example.Login.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Login.modelo.Usuarios;
import com.example.Login.repositorio.UsuariosRepositorio;
import com.example.Login.servicio.UsuariosServicios;

import lombok.Data;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping( path="api/usuarios")
public class UsuariosControlador {
	
				@Autowired
				UsuariosServicios usuariosServicios;
				
				@Autowired
				UsuariosRepositorio usuariosRepositorio;
				
				
				@GetMapping
				public ResponseEntity<List<Usuarios>> obtenerTodos(){
					
					 try {
						 List<Usuarios> listItem = usuariosServicios.ObtenerListado();
			               
			               if(listItem.isEmpty()) {
			            	   
			            	   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			               }
			               
			               return new ResponseEntity<>(listItem, HttpStatus.OK);
						 
					 }catch (Exception e) {
						
						 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
						 
					 }
						 
				}
				

				
				@GetMapping("/{usuariosId}")
			        @ResponseBody
			        public ResponseEntity <Optional<Usuarios>> BuscarPorId(@PathVariable ("usuariosId") int usuariosId){
					        	try {
					        		Optional<Usuarios> listItem2 =usuariosServicios.ObtenerId(usuariosId);
					        		
					        		if(listItem2.isEmpty()) {
					        			
					        			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					        			
					        		}
					        		
					        		return new ResponseEntity<>(listItem2, HttpStatus.OK);
					        	}catch (Exception e) {
					        		
					        		
					        		return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
								}

			            
			        }
			        

			        @PostMapping
			        @ResponseBody
			        public void Guardar(@RequestBody Usuarios usuarios){
			        	
					      Usuarios nombreusuario = usuariosServicios.validacionUsuarioContrasena(usuarios);
					        
			        }

			        
			   

			        @DeleteMapping("/{usuariosId}")
			        @ResponseBody
			        public ResponseEntity elimina (@PathVariable ("usuariosId") int usuariosId){
					        	try {
					        		usuariosServicios.eliminar(usuariosId);
					        		
					        		return new ResponseEntity<>("registro eliminado" , HttpStatus.OK);
					        		
					        	}catch (Exception e) {
					        		
					        		return new ResponseEntity<>(e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
					        		
								}


			        }

				
			        //lOGIN 
			        
			    	@GetMapping("/{nombreUsuario}/{correo}")
			        @ResponseBody
			        public ResponseEntity Login(@PathVariable ("nombreUsuario") String nombreUsuario,@PathVariable ("correo") String correo){
					        	try {
					        		boolean Item2 =usuariosServicios.login(nombreUsuario,correo );
					        		
					        		if(Item2 == false) {
					        			
					        			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					        			
					        		}
					        		
					        		return new ResponseEntity<>(" INICIO DE SESION EXITOSO", HttpStatus.OK);
					        	}catch (Exception e) {
					        		
					        		
					        		return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
								}

			            
			        }
				
	
	
}
