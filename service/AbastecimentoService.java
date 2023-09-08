package com.iris.teste.transporte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.teste.transporte.entities.Abastecimento;
import com.iris.teste.transporte.repositories.AbastecimentoRepositorie;

@Service
public class AbastecimentoService {

	
	@Autowired
	private AbastecimentoRepositorie repository;
	
	public List<Abastecimento> findAll() {
		return repository.findAll();
	}
	
	public Abastecimento findById(Long id) {		
		Optional<Abastecimento> obj = repository.findById(id);
		return obj.get();
	}
	
	public Abastecimento insert(Abastecimento obj) {	
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Abastecimento update(Long id, Abastecimento obj) {
		Abastecimento entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(Abastecimento entity, Abastecimento obj) {
		entity.setPlaca(obj.getPlaca());
		entity.setHora(obj.getHora());
		entity.setValor(obj.getValor());
	}		
}
