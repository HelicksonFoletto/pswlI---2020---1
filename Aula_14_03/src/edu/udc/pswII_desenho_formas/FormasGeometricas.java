package edu.udc.pswII_desenho_formas;

import java.awt.Graphics;

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
	
	void desenhar(Graphics g);
}
