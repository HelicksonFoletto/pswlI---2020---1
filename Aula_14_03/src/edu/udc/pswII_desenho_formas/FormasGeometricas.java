package edu.udc.pswII_desenho_formas;

import edu.udc.pswII_desenho_formas_manipulador.ManipuladorForma;

public interface FormasGeometricas {
	
	Ponto centro();
	double area();
	double perimentro();
	double base();
	double altura();
	double distancia(FormasGeometricas p);
	
	String toString();
	String getNome();
	
	Ponto getEnd();
	Ponto getStart();
	
	FormasGeometricas clone();
	
	public ManipuladorForma getManipulador();
}
