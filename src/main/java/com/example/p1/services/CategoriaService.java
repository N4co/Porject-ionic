package com.example.p1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.p1.domain.Categoria;
import com.example.p1.repositories.CategoriaRepository;
import com.example.p1.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria find(Integer id) {
	Optional<Categoria> obj = repo.findById(id);
	return obj.orElseThrow(() -> new ObjectNotFoundException(
	"Objeto não encontrado ! : " + id + ", Tipo" + Categoria.class.getName()));
	}
    
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
   public Categoria update(Categoria obj) {
	  return repo.save(obj);
   }
    public void delete(Integer id) {
    	find(id);
    	try {
    	repo.deleteById(id);
    }
       catch(DataIntegrityViolationException e) {
    	   throw new DataIntegrityViolationException("não é possível excluir uma categoria que possui produtos");
       }   
    }
    	public List <Categoria> findAll() {
    	return repo.findAll();
    }
    
    }   
    
       

