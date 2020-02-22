package br.edu.udc_25_6_Manipuladores;

import java.awt.Graphics;

import br.edu.udc_25_6_Modelos.Linha;
import br.edu.udc_25_6_Modelos.Ponto2D;

public class ManipuladorLinha implements ManipuladorFormaGeometrica {
	private Linha linha;
	
	public ManipuladorLinha(Linha l) {
		linha = l;
	}
	
	@Override
	public void click(int x, int y) {
	}

	@Override
	public void press(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		linha.setA(p);
		p = new Ponto2D(x, y);
		linha.setB(p);
	}

	@Override
	public void release(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		linha.setB(p);
	}

	@Override
	public void drag(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		linha.setB(p);
	}

	@Override
	public void paint(Graphics g) {
		g.drawLine((int) linha.getA().getX(), (int) linha.getA().getY(), 
				(int) linha.getB().getX(), (int) linha.getB().getY());
	}

}