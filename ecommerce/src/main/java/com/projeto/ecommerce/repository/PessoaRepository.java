package com.projeto.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ecommerce.models.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
