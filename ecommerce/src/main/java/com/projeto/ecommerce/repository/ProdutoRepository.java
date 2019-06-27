package com.projeto.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ecommerce.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>  {

}
