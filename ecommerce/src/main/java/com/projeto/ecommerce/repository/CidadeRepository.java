package com.projeto.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ecommerce.models.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>  {

}
