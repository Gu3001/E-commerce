package com.projeto.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ecommerce.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
