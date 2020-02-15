package br.edu.udc.pswII_colecao;

public interface IteradorAbstrato<T> {
	public boolean proximo();
	public boolean anterior();
	public T dadoAtual();
}

