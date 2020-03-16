package edu.udc.pswII_desenho_formas_manipulador;

import java.awt.Graphics;

import edu.udc.pswII_desenho_formas.Linha;


public class ManipuladorLinha implements ManipuladorForma {
	
	
	Linha linha;
	
	public ManipuladorLinha(Linha l) {
		linha = l;
	}
	
	@Override
	public void desenhar(Graphics g) {
		g.drawLine(linha.getA().getX(), linha.getA().getY(), linha.getB().getX(), linha.getB().getY());		
	}

}
