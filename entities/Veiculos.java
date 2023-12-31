package com.iris.teste.transporte.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Veiculos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	private Long id;
	
	private String veiculo;
	private String placa;
	private Long kilometragem;
	
	
	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "veiculo")
	 @JoinColumn(name = "veiculo_id")
	
	public Long getKilometragem() {
		return kilometragem;
	}


	public void setKilometragem(Long kilometragem) {
		this.kilometragem = kilometragem;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	@Override
	public String toString() {
		return "Veículos [id=" + id + ", veiculo=" + veiculo + "placa=" + placa + "Kilometragem=" + kilometragem +  "]" ;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}


	public Veiculos() {
	}
	

	public Veiculos(Long id, String veiculo, String placa, Long kilometragem) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.placa = placa;
		this.kilometragem = kilometragem;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculos other = (Veiculos) obj;
		return Objects.equals(id, other.id);
	}
}
