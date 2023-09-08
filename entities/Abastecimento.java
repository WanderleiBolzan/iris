package com.iris.teste.transporte.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Abastecimento implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@JsonProperty("_id")
	private Long id;
	@JsonFormat(locale = "BR", timezone = "GMT" , pattern = "dd-MM-yyyy")
	private LocalDate data;
	private String hora;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "veiculo_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Veiculos placa ;
    private Double valor;
    
	public Abastecimento() {
	}

	public Abastecimento(Long id,LocalDate data, String hora, Veiculos placa, Veiculos kilometragem, Double valor) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.placa = placa;
		this.valor = valor;
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
		Abastecimento other = (Abastecimento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Abastecimento [id=" + id + ", data=" + data + ", hora=" + hora + ", placa=" + placa 
				+ ", valor=" + valor + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Veiculos getPlaca() {
		return placa;
	}

	public void setPlaca(Veiculos placa) {
		this.placa = placa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	} 	

}
