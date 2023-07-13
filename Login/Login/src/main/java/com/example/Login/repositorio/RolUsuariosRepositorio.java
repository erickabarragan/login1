package com.example.Login.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Login.modelo.RolUsuarios;


@Repository
public interface RolUsuariosRepositorio extends JpaRepository<RolUsuarios, Integer>{

}
