package br.edu.udc_arquivosRaquete;

import java.io.Serializable;

public class Raquete implements Serializable {

	float peso;
	String cor;
	int comprimento;
	
	public Raquete(float peso, String cor, int comprimento) {
		super();
		this.peso = peso;
		this.cor = cor;
		this.comprimento = comprimento;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}

	@Override
	public String toString() {
		return "Informações da raquete: Peso: " + peso + ", Cor: " + cor + ", Comprimento: " + comprimento + "";
	}
	
}
