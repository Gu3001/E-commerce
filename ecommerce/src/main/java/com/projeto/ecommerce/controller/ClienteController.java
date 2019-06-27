package com.projeto.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.ecommerce.models.Cidade;
import com.projeto.ecommerce.models.Cliente;
import com.projeto.ecommerce.repository.CidadeRepository;
import com.projeto.ecommerce.repository.ClienteRepository;

@Controller
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired CidadeRepository cidadeRepository;
	
	@GetMapping("/clientes")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("tabelaCliente");
		mv.addObject("clientes",clienteRepository.findAll());
		return mv;	
	}
	
	@GetMapping("/addCliente")
	public ModelAndView add(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cadastrarCliente");
		mv.addObject("cliente",cliente);
		
		List <Cidade> listaCidade = cidadeRepository.findAll();
		mv.addObject("cidades", listaCidade);
		return mv;
	}
	
	@GetMapping("/editarCliente/{id}")
	public ModelAndView edit(@PathVariable ("id") Long id) {
		Optional <Cliente> cliente = clienteRepository.findById(id);
		Cliente e = cliente.get();
		return add(e);
	}
	@GetMapping("/removerCliente/{id}")
	public ModelAndView delete(@PathVariable ("id") Long id) {
		Optional <Cliente> cliente = clienteRepository.findById(id);
		Cliente e = cliente.get();
		clienteRepository.delete(e);
		return listar();
	}
	
	@PostMapping("/salvarCliente")
	public ModelAndView save(@Valid Cliente cliente) {
		clienteRepository.saveAndFlush(cliente);
		return listar();
	}
	
}
