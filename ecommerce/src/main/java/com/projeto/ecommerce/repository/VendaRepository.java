package com.projeto.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ecommerce.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>  {

}
