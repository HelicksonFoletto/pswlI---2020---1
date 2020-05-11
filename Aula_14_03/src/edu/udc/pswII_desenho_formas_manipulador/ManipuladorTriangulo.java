package edu.udc.pswII_desenho_formas_manipulador;

import java.awt.Graphics;

import edu.udc.pswII_desenho_formas.Ponto;
import edu.udc.pswII_desenho_formas.Triangulo;



public class ManipuladorTriangulo implements ManipuladorForma {
	
	Triangulo triangulo;
	private int estado;
	
	public ManipuladorTriangulo(Triangulo t) {
		triangulo = t;
		estado = 0;
	}
	
	@Override
	public void desenhar(Graphics g) {
		g.drawLine(triangulo.getA().getX(), triangulo.getA().getY(),triangulo.getB().getX(), triangulo.getB().getY());
		g.drawLine(triangulo.getB().getX(), triangulo.getB().getY(), triangulo.getC().getX(), triangulo.getC().getY());
		g.drawLine(triangulo.getC().getX(), triangulo.getC().getY(), triangulo.getA().getX(), triangulo.getA().getY());
		
	}

	@Override
	public void arrastar(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(int x, int y) {
		switch(estado) {

			case 1: 
				triangulo.setB(new Ponto(x, y));
				triangulo.setC(new Ponto(x, y));			
				break;
			case 2:
				triangulo.setC(new Ponto(x, y));		
				break;
		}	
		
	}

	@Override
	public boolean click(int x, int y) {
		switch(estado) {
		case 0:
				triangulo.setA(new Ponto(x, y));
				triangulo.setB(new Ponto(x, y));
				triangulo.setC(new Ponto(x, y));
				estado = 1;
				
				return false;
	
		case 1: 
				triangulo.setB(new Ponto(x, y));
				triangulo.setC(new Ponto(x, y));
				estado = 2;
				
				return false;
		case 2:
				triangulo.setC(new Ponto(x, y));
				estado = 0;
				
				return true;
		}	
		return false;
	}

	@Override
	public void apertar(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean soltar(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
