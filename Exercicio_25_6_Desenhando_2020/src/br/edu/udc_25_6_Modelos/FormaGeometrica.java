package br.edu.udc_25_6_Modelos;

import br.edu.udc_25_6_Manipuladores.ManipuladorFormaGeometrica;

public interface FormaGeometrica {
	
	public Ponto2D centro();
	public double area();
	public double perimetro();
	public double base();
	public double altura();
	
	public ManipuladorFormaGeometrica getManipulador();
	public FormaGeometrica clone();

}