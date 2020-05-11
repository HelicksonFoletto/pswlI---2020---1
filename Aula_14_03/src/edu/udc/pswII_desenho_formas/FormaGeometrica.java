package edu.udc.pswII_desenho_formas;

import java.io.Serializable;

import edu.udc.pswII_desenho_formas_manipulador.ManipuladorForma;

public interface FormaGeometrica extends Serializable{
	
	Ponto centro();
	double area();
	double perimentro();
	double base();
	double altura();
	double distancia(FormaGeometrica p);
	
	String toString();
	String getNome();
	
	Ponto getEnd();
	Ponto getStart();
	
	FormaGeometrica clone();
	
	public ManipuladorForma getManipulador();
}
