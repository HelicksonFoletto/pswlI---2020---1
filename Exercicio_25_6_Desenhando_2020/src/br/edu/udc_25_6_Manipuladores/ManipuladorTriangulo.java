package br.edu.udc_25_6_Manipuladores;

import java.awt.Graphics;

import br.edu.udc_25_6_Modelos.Ponto2D;
import br.edu.udc_25_6_Modelos.Triangulo;

public class ManipuladorTriangulo implements ManipuladorFormaGeometrica {
	private Triangulo triangulo;
	
	public ManipuladorTriangulo(Triangulo t) {
		triangulo = t;
	}

	@Override
	public void click(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void press(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		triangulo.setA(p);
		p = new Ponto2D(x, y);
		triangulo.setB(p);
	}

	@Override
	public void release(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		triangulo.setB(p);
		
	}

	@Override
	public void drag(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		triangulo.setB(p);
		
	}

	@Override
	public void paint(Graphics g) {
		int pontoAX = 0;
		int pontoAY = 0;
		int pontoBX = 0;
		int pontoBY = 0;
		int pontoCX = 0;
		int pontoCY = 0;
		
		g.drawLine(pontoAX, pontoAY, pontoBX, pontoBY);
		g.drawLine(pontoBX, pontoBY, pontoCX, pontoCY);
		g.drawLine(pontoCX, pontoCY, pontoAX, pontoAY);
	}
}