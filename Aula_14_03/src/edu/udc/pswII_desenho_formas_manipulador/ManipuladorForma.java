package edu.udc.pswII_desenho_formas_manipulador;

import java.awt.Graphics;

public interface ManipuladorForma {
	
	public void desenhar(Graphics g);
	
	void arrastar(int x, int y);
	void mover (int x, int y);
	boolean click(int x, int y);
	void apertar(int x, int y);
	boolean soltar(int x, int y);
}