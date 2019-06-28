package com.projeto.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.ecommerce.models.Cidade;
import com.projeto.ecommerce.models.Cliente;
import com.projeto.ecommerce.models.Venda;
import com.projeto.ecommerce.repository.ClienteRepository;
import com.projeto.ecommerce.repository.VendaRepository;

@Controller
public class VendaController {
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/vendas")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("tabelaVenda");
		mv.addObject("vendas", vendaRepository.findAll());
		return mv;
	}
	
	@GetMapping("/adicionarVenda")
	public ModelAndView add(Venda venda) {
		ModelAndView mv = new ModelAndView("cadastrarVenda");
		mv.addObject("venda", venda);
		
		List <Cliente> listaCliente = clienteRepository.findAll();
		mv.addObject("clientes", listaCliente);
		return mv;
		
	}
	@GetMapping("/editarVenda/{id}")
	public ModelAndView edit(@PathVariable ("id") Long id) {
		Optional <Venda> venda = vendaRepository.findById(id);
		Venda e = venda.get();
		return add(e);
		
	}
	@GetMapping("/removerVenda/{id}")
	public ModelAndView remover(@PathVariable ("id") Long id) {
		Optional <Venda> venda = vendaRepository.findById(id);
		Venda e = venda.get();
		vendaRepository.delete(e);
		return findAll();
	}
	
	
	@PostMapping("/salvarVenda")
	public ModelAndView save(@Valid Venda venda) {
		vendaRepository.saveAndFlush(venda);
		return findAll();
	}
	
	
}
