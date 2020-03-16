package edu.udc.pswII_desenho_formas_manipulador;

import java.awt.Graphics;

import edu.udc.pswII_desenho_formas.Triangulo;



public class ManipuladorTriangulo implements ManipuladorForma {
	
	Triangulo triangulo;
	
	public ManipuladorTriangulo(Triangulo t) {
		triangulo = t;
	}
	
	@Override
	public void desenhar(Graphics g) {
		g.drawLine(triangulo.getA().getX(), triangulo.getA().getY(),triangulo.getB().getX(), triangulo.getB().getY());
		g.drawLine(triangulo.getB().getX(), triangulo.getB().getY(), triangulo.getC().getX(), triangulo.getC().getY());
		g.drawLine(triangulo.getC().getX(), triangulo.getC().getY(), triangulo.getA().getX(), triangulo.getA().getY());
		
	}

}
