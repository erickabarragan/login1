package com.example.Login.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Login.modelo.Persona;
import com.example.Login.repositorio.PersonaRepositorio;



@Service
public class PersonaServicio {

	
				@Autowired
				PersonaRepositorio personaRepositorio;
				
			    // GENERAR CORREO A PARTIR DE LOS NOMBRES
				
			    public String crearCorreo(Persona persona) {
			        String nombre1 = persona.getNombre1().toLowerCase();
			        String nombre2 = persona.getNombre2().toLowerCase();
			        String apellido1 = persona.getApellido1().toLowerCase();
			        String apellido2 = persona.getApellido2().toLowerCase();
			
			        // Obtener la primera letra de nombre1
			        String primeraLetraNombre1 = nombre1.substring(0, 1);
			        
			        // Obtener el apellido completo
			        String apellidoCompleto = apellido1;
			        
			        // Obtener la primera letra de apellido2
			        String primeraLetraApellido2 = apellido2.substring(0, 1);
			        
			        // Unir las partes del correo
			        String correo = primeraLetraNombre1 + apellidoCompleto + primeraLetraApellido2 + "@gmail.com";
			        
			        return correo;
			    }
    
			    
				
			    public List<Persona> ObtenerListado(){
			        return personaRepositorio.findAll();
			
			    }
			
			    
			    
			    public void Guarda(Persona persona){
			        personaRepositorio.save(persona);
			
			    }
			
			    
			    
			    public boolean VerificarExistenciaCedula(String cedula) {
			        List<Persona> listaPersona = personaRepositorio.findAll();

			        for (Persona persona1 : listaPersona) {
			            if (persona1.getIdentificacion().equals(cedula)) {
			                return true; // La cédula ya existe
			            }
			        }

			        return false; // La cédula no existe
			    }
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
	
}



