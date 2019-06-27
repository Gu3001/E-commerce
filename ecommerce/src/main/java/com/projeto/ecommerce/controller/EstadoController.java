package com.projeto.ecommerce.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.ecommerce.models.Estado;
import com.projeto.ecommerce.repository.EstadoRepository;

@Controller
public class EstadoController {
	@Autowired
	private EstadoRepository repository;
	
	@GetMapping("/estados")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/tabelaEstado");
		mv.addObject("estados", repository.findAll());
		return mv;
	}
	@GetMapping("/cadastrarEstado")
	public ModelAndView cadastrar(Estado estado) {
		ModelAndView mv = new ModelAndView("cadastroEstado");
		mv.addObject("estado", estado);
		return mv;
	}
	@GetMapping("/editarEstado/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Estado> estado = repository.findById(id);
		Estado e = estado.get();
		return cadastrar(e);
	}
	@GetMapping("/removerEstado/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Estado> estado = repository.findById(id);
		Estado e = estado.get();
		repository.delete(e);
		return listar();
	}
	@PostMapping("salvarEstado")
	public ModelAndView salvar(@Valid Estado est) {
		repository.saveAndFlush(est);
		return listar();
	}
	
}
