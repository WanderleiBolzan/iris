package com.iris.teste.transporte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iris.teste.transporte.entities.Veiculos;

public interface VeiculosRepositories extends JpaRepository<Veiculos, Long> {
}
