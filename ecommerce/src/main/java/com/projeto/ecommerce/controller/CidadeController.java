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
import com.projeto.ecommerce.models.Estado;
import com.projeto.ecommerce.repository.CidadeRepository;
import com.projeto.ecommerce.repository.EstadoRepository;

@Controller
public class CidadeController {
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping("/cidades")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/tabelaCidade");
		mv.addObject("cidades", cidadeRepository.findAll());
		return mv;
	}
	@GetMapping("/adicionarCidade")
		public ModelAndView add(Cidade cidade) {
		ModelAndView mv = new ModelAndView("cadastrarCidade");
		mv.addObject("cidade",cidade);
		
		List<Estado> listaEstado = estadoRepository.findAll();
		mv.addObject("estados",listaEstado);
		
		return mv;
	}
	@GetMapping("/editarCidade/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		Cidade e = cidade.get();
		
		return add(e);
	}
	@GetMapping("/removerCidade/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		Cidade e = cidade.get();
		cidadeRepository.delete(e);
		return listar();
	}
	@PostMapping("/salvarCidade")
	public ModelAndView salvar(@Valid Cidade cidade) {
		cidadeRepository.saveAndFlush(cidade);
		return listar();
		
	}
}
