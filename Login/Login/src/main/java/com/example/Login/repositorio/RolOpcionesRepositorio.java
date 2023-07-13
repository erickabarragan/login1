package com.example.Login.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Login.modelo.RolOpciones;


@Repository
public interface RolOpcionesRepositorio extends JpaRepository<RolOpciones, Integer>{

}
