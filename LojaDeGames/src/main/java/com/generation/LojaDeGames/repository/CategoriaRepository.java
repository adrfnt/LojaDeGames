package com.generation.LojaDeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.LojaDeGames.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
	List<Categoria> findAllByNomeContainingIgnoreCase(String nome);
 

}
