package com.api.springboot.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDto {

	@NotBlank
	private String numeroDaVaga;
	@NotBlank
	@Size(max = 7)
	private String placaDoVeiculo;
	@NotBlank
	private String marcaDoVeiculo;
	@NotBlank
	private String modeloDoVeiculo;
	@NotBlank
	private String corDoVeiculo;
	@NotBlank
	private String nomeDoResponsavel;
	@NotBlank
	private String apartamento;
	@NotBlank
	private String bloco;

	public ParkingSpotDto() {
		super();
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
