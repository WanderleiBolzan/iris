package com.iris.teste.transporte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.teste.transporte.entities.Veiculos;
import com.iris.teste.transporte.repositories.VeiculosRepositories;

@Service
public class VeiculosService {


	@Autowired
	private VeiculosRepositories repository;
	
	public List<Veiculos> findAll() {
		return repository.findAll();
	}
	
	public Veiculos findById(Long id) {		
		Optional<Veiculos> obj = repository.findById(id);
		return obj.get();
	}
	
	public Veiculos insert(Veiculos obj) {	
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Veiculos update(Long id, Veiculos obj) {
		Veiculos entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(Veiculos entity, Veiculos obj) {
		entity.setPlaca(obj.getPlaca());
		entity.setVeiculo(obj.getVeiculo());
		entity.setKilometragem(obj.getKilometragem());
	}	
	
}
