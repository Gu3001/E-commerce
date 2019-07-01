package com.projeto.ecommerce.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.ecommerce.models.Produto;
import com.projeto.ecommerce.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public ModelAndView listar() {
	ModelAndView mv = new ModelAndView("tabelaProduto");
	mv.addObject("produtos", produtoRepository.findAll());
	return mv;
	}
	@GetMapping("/adicionarProduto")
	public ModelAndView add(Produto produto) {
		ModelAndView mv = new ModelAndView("cadastrarProduto");
		mv.addObject("produto", produto);
		
		return mv;
	}
	@GetMapping("/editarProduto/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional <Produto> produto = produtoRepository.findById(id);
		Produto e = produto.get();
		return add(e);
		
	}
	@GetMapping("/removerProduto/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		Optional <Produto> produto = produtoRepository.findById(id);
		Produto e = produto.get();
		produtoRepository.delete(e);
		return listar();
	
	}
	@PostMapping("/salvarProduto")
	public ModelAndView save(@Valid Produto produto) {
		produtoRepository.saveAndFlush(produto);
		return listar();
	}
}
