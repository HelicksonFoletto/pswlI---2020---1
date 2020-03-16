package edu.udc.pswII_desenho_formas;

import edu.udc.pswII_desenho_formas_manipulador.ManipuladorLinha;

public class Linha implements FormasGeometricas {
	private Ponto a;
	private Ponto b;
	
	public Linha(Ponto a, Ponto b) {
		this.a = a.clone();
		this.b = b.clone();
	}
	
	public Linha(Linha l) {
		this.a = l.a.clone();
		this.b = l.b.clone();
	}
	
	public void setA(Ponto a) {
		this.a = a.clone();
	}
	
	public void setB(Ponto b) {
		this.b = b.clone();
	}
	
	@Override
	public Ponto centro() {
		return new Ponto((a.getX()+b.getX()) / 2, (a.getY() + b.getY()) /2);
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimentro() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double base() {
		return Math.abs(a.getX() - b.getX());
	}

	@Override
	public double altura() {
		return Math.abs(a.getY() - b.getY());
	}
	@Override
	public double distancia(FormasGeometricas f) {
		Ponto cf = f.centro();
		Ponto cl = centro();
		int dx = cl.getX() - cf.getX();
 		int dy = cl.getY() - cf.getX();
		
		return Math.sqrt(dx*dx + dy*dy);
	}
	@Override
	public String toString() {
		return String.format("[%s %s]",a,b);
	}
	@Override
	public String getNome() {
		return "Linha";
	}
	
	@Override
	public Ponto getEnd() {
		return new Ponto(a.getX() > b.getX() ? a.getX() : b.getX(),
				a.getY() > b.getY() ? a.getX() : b.getY());
		
	
	}

	@Override
	public Ponto getStart() {
		int x;
		int y;
		
		if(a.getX() < b.getX())
			x = a.getX();
		else
			x = b.getX();
		
		if(a.getY() < b.getY())
			y = a.getY();
		else
			y = b.getY();
		
		return new Ponto(x, y);
	}

	@Override
	public Linha clone() {
		return new Linha(this);
	}	
	
	@Override
	public ManipuladorLinha getManipulador() {
		return new ManipuladorLinha(this);
	}

	public Ponto getA() {
		return a;
	}

	public Ponto getB() {
		return b;
	}
	
}
