package com.example.p1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.p1.domain.Pedido;
import com.example.p1.repositories.PedidoRepository;
import com.example.p1.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	
	public Pedido find(Integer id) {
	Optional<Pedido> obj = repo.findById(id);
	return obj.orElseThrow(() -> new ObjectNotFoundException(
	"Objeto não encontrado ! : " + id + ", Tipo" + Pedido.class.getName()));
	}
}
