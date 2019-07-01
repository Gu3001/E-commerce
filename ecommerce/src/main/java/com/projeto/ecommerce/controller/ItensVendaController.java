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

import com.projeto.ecommerce.models.ItensVenda;
import com.projeto.ecommerce.models.Produto;
import com.projeto.ecommerce.models.Venda;
import com.projeto.ecommerce.repository.ItensVendaRepository;
import com.projeto.ecommerce.repository.ProdutoRepository;
import com.projeto.ecommerce.repository.VendaRepository;

@Controller //anotação
public class ItensVendaController {
	@Autowired
	private ItensVendaRepository itensVendaRepository; 
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/itensVendas")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("tabelaItensVenda");
		mv.addObject("itensVendas", itensVendaRepository.findAll());
		return mv;
	}
	@GetMapping("/adicionarItensVenda")
	public ModelAndView add(ItensVenda itensVenda) {
		ModelAndView mv = new ModelAndView("cadastrarItensVenda");
		mv.addObject("itensVenda", itensVenda);
		
		List <Produto> produtos = produtoRepository.findAll();
		mv.addObject("produtos", produtos);
		
		List<Venda> vendas = vendaRepository.findAll();
		mv.addObject("vendas", vendas);
		
		
		return mv;
	}
	@GetMapping("/editarItensVenda/{id}")
	public ModelAndView edit(@PathVariable ("id") Long id) {
		Optional <ItensVenda> itensVenda = itensVendaRepository.findById(id);
		ItensVenda e = itensVenda.get();
		return add(e);
	}
	@GetMapping("/removerItensVenda/{id}")
	public ModelAndView delete(@PathVariable ("id") Long id) {
		Optional <ItensVenda> itensVenda = itensVendaRepository.findById(id);
		ItensVenda e = itensVenda.get();
		itensVendaRepository.delete(e);
		return listar();
	}
	@PostMapping("/salvarItensVenda")
	public ModelAndView save(@Valid ItensVenda itensVenda) {
		itensVendaRepository.saveAndFlush(itensVenda);
		return listar();
	}
	
}
