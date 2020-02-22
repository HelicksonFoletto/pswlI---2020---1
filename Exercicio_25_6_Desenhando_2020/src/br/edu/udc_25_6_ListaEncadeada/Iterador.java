package br.edu.udc_25_6_ListaEncadeada;

public  interface Iterador<T> {
	
	T getObjeto();
	T proximo();
	T anterior();

}