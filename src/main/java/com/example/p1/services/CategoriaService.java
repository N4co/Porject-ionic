package com.example.p1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.p1.domain.Categoria;
import com.example.p1.repositories.CategoriaRepository;
import com.example.p1.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria buscar(Integer id) {
	Optional<Categoria> obj = repo.findById(id);
	return obj.orElseThrow(() -> new ObjectNotFoundException(
	"Objeto não encontrado ! : " + id + ", Tipo" + Categoria.class.getName()));
	}
}
