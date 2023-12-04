package com.example.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
