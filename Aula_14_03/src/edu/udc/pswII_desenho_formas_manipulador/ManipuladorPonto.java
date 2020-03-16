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

}
