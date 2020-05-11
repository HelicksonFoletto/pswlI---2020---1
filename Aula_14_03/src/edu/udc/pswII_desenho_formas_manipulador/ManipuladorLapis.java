package edu.udc.pswII_desenho_formas_manipulador;

import java.awt.Graphics;

import edu.udc.pswII_desenho_formas.Lapis;
import edu.udc.pswII_desenho_formas.Ponto;

public class ManipuladorLapis implements ManipuladorForma {
	
	private Lapis lapis;
	private int estado;
	
	public ManipuladorLapis(Lapis lapis) {
		this.lapis = lapis;
		estado = 0;
	}
	
	@Override
	public void desenhar(Graphics g) {
		if(lapis.getTam() < 2)
			return;
		
		Ponto a = lapis.getPosicao(0);
		for(int i = 1; i < lapis.getTam(); i++) {
			Ponto b = lapis.getPosicao(i);
			g.drawLine(a.getX(), a.getY(),b.getX(),b.getY());
		}

	}

	@Override
	public void arrastar(int x, int y) {
		if(estado == 1) {
			lapis.adicionar(new Ponto(x, y));
		}

	}

	@Override
	public void mover(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean click(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void apertar(int x, int y) {
		if(estado == 0) {
			lapis.adicionar(new Ponto(x,y));
			estado = 1;
		}
	}
	
	@Override
	public boolean soltar(int x , int y) {
		if(estado == 1) {
			lapis.adicionar(new Ponto(x, y));
			estado = 0;
			return true;
		}
		return false;
	}
}
