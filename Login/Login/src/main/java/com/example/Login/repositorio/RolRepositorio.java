package com.example.Login.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Login.modelo.Rol;


@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {

}
