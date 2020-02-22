package br.edu.udc_25_6_Manipuladores;

import java.awt.Graphics;

import br.edu.udc_25_6_Modelos.Ponto2D;
import br.edu.udc_25_6_Modelos.Retangulo;

public class ManipuladorRetangulo implements ManipuladorFormaGeometrica {
	private Retangulo retangulo;
	
	public ManipuladorRetangulo(Retangulo r) {
		retangulo = r;
	}
	
	@Override
	public void click(int x, int y) {
	}

	@Override
	public void press(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		retangulo.setA(p);
		p = new Ponto2D(x, y);
		retangulo.setB(p);
	}

	@Override
	public void release(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		retangulo.setB(p);
	}

	@Override
	public void drag(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		retangulo.setB(p);
	}

	@Override
	public void paint(Graphics g) {
		int xa = (int) retangulo.getA().getX();
		int xb = (int) retangulo.getB().getX();
		int ya = (int) retangulo.getA().getY();
		int yb = (int) retangulo.getB().getY();
		g.drawRect(xa < xb ? xa : xb, ya < yb ? ya : yb, 
				(int) retangulo.base(), (int) retangulo.altura() );
	}
}