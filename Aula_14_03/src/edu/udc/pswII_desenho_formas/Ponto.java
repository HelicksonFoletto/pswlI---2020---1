package edu.udc.pswII_desenho_formas;

import edu.udc.pswII_desenho_formas_manipulador.ManipuladorPonto;

public class Ponto implements FormaGeometrica {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	
	private transient ManipuladorPonto manipulador = null;
	
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y; 
	}
	
	public Ponto(Ponto p) {
		x = p.x;
		y = p.y;
	}
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
		
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override 
	public String toString() {
		return String.format("(%d; %d)",x,y);
	}
	public String getNome() {
		return "Ponto";
	}
	
	@Override
	public Ponto centro() {
		return (Ponto)this.clone();
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimentro() {
		
		return 0;
	}

	@Override
	public double base() {
		return 0;
	}

	@Override
	public double altura() {
		return 0;
	}
	
	public double distancia(FormaGeometrica f) {
		Ponto c = f.centro();
		int dx = x - c.x;
		int dy = y - c.y;
		
		return Math.sqrt(dx*dx + dy*dy);
	}
	@Override
	public Ponto getEnd() {
		return new Ponto(this);
	}

	@Override
	public Ponto getStart() {
		return new Ponto(this);
	}

	@Override
	public Ponto clone() {
		return new Ponto(x,y);
	}
	
	@Override
	public ManipuladorPonto getManipulador() {
		if(manipulador == null)
			manipulador = new ManipuladorPonto(this);
		
		return manipulador;
	}
}
