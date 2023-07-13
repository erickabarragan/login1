package com.example.Login.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Login.modelo.Persona;
import com.example.Login.servicio.PersonaServicio;




@RestController
public class PersonaControlador {
	
			   @Autowired
			   PersonaServicio personaServicio;
				
				
			
			    @GetMapping
			    @ResponseBody
			    public ResponseEntity<List<Persona>>  BuscarTodos() {
			    	
				            try {
				            	
				               List<Persona> listItem = personaServicio.ObtenerListado();
				               
				               if(listItem.isEmpty()) {
				            	   
				            	   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				               }
				               
				               return new ResponseEntity<>(listItem, HttpStatus.OK);
				               
				            } 
				            catch (Exception e) {
				            	
				            	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				            }
			        
			    }
	
	
				
			@PostMapping
		        @ResponseBody
		        public ResponseEntity Guardar(@RequestBody Persona persona){
		        	
				        	try {
				    
				        		boolean cedulaExistente = personaServicio.VerificarExistenciaCedula(persona.getIdentificacion());
				        		if(cedulaExistente) {
				        			
				        			return new ResponseEntity<>("El registro ya existe.", HttpStatus.BAD_REQUEST);
				        		}
				        		
				        		personaServicio.crearCorreo(persona);	
				        		personaServicio.Guarda(persona);
				        		return new ResponseEntity<>( personaServicio, HttpStatus.OK);
				        		 
				        	}	 
				        	catch (Exception e) {	        	
								
				        		return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
							}
		           

		        }
				
						
	
}
