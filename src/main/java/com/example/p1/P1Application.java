package com.example.p1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.p1.domain.Categoria;
import com.example.p1.domain.Cidade;
import com.example.p1.domain.Cliente;
import com.example.p1.domain.Endereco;
import com.example.p1.domain.Estado;
import com.example.p1.domain.Produto;
import com.example.p1.domain.enums.TipoCliente;
import com.example.p1.repositories.CategoriaRepository;
import com.example.p1.repositories.CidadeRepository;
import com.example.p1.repositories.ClienteRepository;
import com.example.p1.repositories.EnderecoRepository;
import com.example.p1.repositories.EstadoRepository;
import com.example.p1.repositories.ProdutoRepository;

@SpringBootApplication
public class P1Application implements CommandLineRunner {

    @Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
    
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired 
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String [] args) {
		SpringApplication.run(P1Application.class, args);
	}
		
	@Override
	public void run(String...args )throws Exception{
		
    Categoria cat1 = new Categoria(null, "Informatica");
    Categoria cat2 = new Categoria(null, "Escritório");
		
	Produto p1 = new Produto(null, "Computador", 2000.00);
	Produto p2 = new Produto(null, "Impressora", 800.00);
	Produto p3 = new Produto(null, "Mouse",  80.00);

	cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
	cat2.getProdutos().addAll(Arrays.asList(p2));
	
	p1.getCategoria().addAll(Arrays.asList(cat1));
	p2.getCategoria().addAll(Arrays.asList(cat1, cat2));
	p3.getCategoria().addAll(Arrays.asList(cat1));
	
	Estado est1 = new Estado(null, "Minas Gerais");
	Estado est2 = new Estado(null, "São Paulo");
	
	Cidade c1 = new Cidade(null, "Ubatuba", est2);
	Cidade c2 = new Cidade(null, "Uberlandia", est1 );
	Cidade c3 = new Cidade(null, "Campinas", est2);		
	
	est1.getCidades().addAll(Arrays.asList(c2));
	est2.getCidades().addAll(Arrays.asList(c1, c3));
	
    categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
    produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	
    estadoRepository.saveAll(Arrays.asList(est1, est2));
    cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	
    Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "363.789.123-77", TipoCliente.PESSOAFISICA);
    
    cli1.getTelefones().addAll(Arrays.asList("(11)9977-5544","(11)9955-4577"));
    
    Endereco e1 = new Endereco(null, "Rua: Flores", "300", "Apto203", "Jardim", "3820834", cli1, c1);
	Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala800", "Centro", "3877012", cli1, c2);
	
	cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
	
	clienteRepository.saveAll(Arrays.asList(cli1));
	enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}
}

