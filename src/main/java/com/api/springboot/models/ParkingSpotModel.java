package com.api.springboot.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, unique = true, length = 10)
	private String numeroDaVaga;
	@Column(nullable = false, unique = true, length = 10)
	private String placaDoVeiculo;
	@Column(nullable = false, unique = true, length = 10)
	private String marcaDoVeiculo;
	@Column(nullable = false, unique = true, length = 10)
	private String modeloDoVeiculo;
	@Column(nullable = false, unique = true, length = 10)
	private String corDoVeiculo;
	@Column(nullable = false, unique = true, length = 10)
	private String dataRegistro;
	@Column(nullable = false, unique = true, length = 10)
	private String nomeDoResponsavel;
	@Column(nullable = false, unique = true, length = 10)
	private String apartamento;
	@Column(nullable = false, unique = true, length = 10)
	private String bloco;

	public ParkingSpotModel() {
		super();
	}

	public ParkingSpotModel(String numeroDaVaga, String placaDoVeiculo, String marcaDoVeiculo, String modeloDoVeiculo,
			String corDoVeiculo, String dataRegistro, String nomeDoResponsavel, String apartamento, String bloco) {
		super();
		this.numeroDaVaga = numeroDaVaga;
		this.placaDoVeiculo = placaDoVeiculo;
		this.marcaDoVeiculo = marcaDoVeiculo;
		this.modeloDoVeiculo = modeloDoVeiculo;
		this.corDoVeiculo = corDoVeiculo;
		this.dataRegistro = dataRegistro;
		this.nomeDoResponsavel = nomeDoResponsavel;
		this.apartamento = apartamento;
		this.bloco = bloco;

	}

	public Integer getId() {
		return id;
	}

	public void Integer(Integer id) {
		this.id = id;
	}

	public String getNumeroDaVaga() {
		return numeroDaVaga;
	}

	public void setNumeroDaVaga(String numeroDaVaga) {
		this.numeroDaVaga = numeroDaVaga;
	}

	public String getPlacaDoVeiculo() {
		return placaDoVeiculo;
	}

	public void setPlacaDoVeiculo(String placaDoVeiculo) {
		this.placaDoVeiculo = placaDoVeiculo;
	}

	public String getMarcaDoVeiculo() {
		return marcaDoVeiculo;
	}

	public void setMarcaDoVeiculo(String marcaDoVeiculo) {
		this.marcaDoVeiculo = marcaDoVeiculo;
	}

	public String getModeloDoVeiculo() {
		return modeloDoVeiculo;
	}

	public void setModeloDoVeiculo(String modeloDoVeiculo) {
		this.modeloDoVeiculo = modeloDoVeiculo;
	}

	public String getCorDoVeiculo() {
		return corDoVeiculo;
	}

	public void setCorDoVeiculo(String corDoVeiculo) {
		this.corDoVeiculo = corDoVeiculo;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getNomeDoResponsavel() {
		return nomeDoResponsavel;
	}

	public void setNomeDoResponsavel(String nomeDoResponsavel) {
		this.nomeDoResponsavel = nomeDoResponsavel;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

}
