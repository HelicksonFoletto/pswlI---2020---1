package edu.udc.pswII_desenho_formas_manipulador;

import java.awt.Graphics;

import edu.udc.pswII_desenho_formas.Ponto;

public class ManipuladorPonto implements ManipuladorForma {
	
	Ponto ponto;
	
	public ManipuladorPonto(Ponto p) {
		ponto = p;
	}
	@Override
	public void desenhar(Graphics g) {
		g.drawOval(ponto.getX(), ponto.getY(), 5, 5);
		
	}
	@Override
	public void arrastar(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mover(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean click(int x, int y) {
		ponto.setX(x);
		ponto.setY(y);
		
		return true;
	}

}
