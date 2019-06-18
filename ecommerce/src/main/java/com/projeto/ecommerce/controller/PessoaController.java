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
import com.projeto.ecommerce.models.Pessoa;
import com.projeto.ecommerce.repository.CidadeRepository;
import com.projeto.ecommerce.repository.PessoaRepository;



@Controller
public class PessoaController {
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoas")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/tabelaPessoa");
		mv.addObject("pessoas", pessoaRepository.findAll());
		return mv;
	}
	@GetMapping("/adicionarPessoa")
	public ModelAndView add(Pessoa pessoa) {
		ModelAndView mv = new ModelAndView("/cadastrarPessoa"); 
		mv.addObject("pessoa", pessoa);
		
		List<Cidade> listaCidade = cidadeRepository.findAll();
		mv.addObject("cidades", listaCidade);
		return mv;
	
	}/**	
	@GetMapping("/editarPessoa/{id")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		Pessoa e = pessoa.get();
		return add(e);
		
	}**/
	
	@GetMapping("/editarPessoa/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		Pessoa e = pessoa.get(); //utiliza .get
		ModelAndView mv = new ModelAndView("/cadastrarPessoa"); //objeto pessoa, Optional é uma classe, ele é que retorna casso seja null ou não, faz o tratamento
		mv.addObject("pessoa", e); // a variavel do tipo pessoa "e" recebe pessoa.get()
		
		List<Cidade> listaCidade = cidadeRepository.findAll();
		mv.addObject("cidades", listaCidade);
	
		return mv;
	}
	
	
	@GetMapping("/removerPessoa/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		Pessoa e = pessoa.get(); 
		pessoaRepository.delete(e);
		return listar();
	}
	@PostMapping("/salvarPessoa")
	public ModelAndView salvar(@Valid Pessoa pessoa) {
		pessoaRepository.saveAndFlush(pessoa);
		return listar();
		
	}
}
