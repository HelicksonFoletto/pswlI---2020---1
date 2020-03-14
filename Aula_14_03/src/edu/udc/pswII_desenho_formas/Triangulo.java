package edu.udc.pswII_desenho_formas;

import java.awt.Graphics;

public class Triangulo implements FormasGeometricas {
	private Ponto a;
	private Ponto b;
	private Ponto c;
	
	public Triangulo(Ponto a, Ponto b, Ponto c) {
		this.a = a.clone();
		this.b = b.clone();
		this.c = c.clone();
	}
	
	public Triangulo(Triangulo t) {
		this.a = t.a.clone();
		this.b = t.b.clone();
		this.c = t.c.clone();
	}
	public void setA(Ponto a) {
		this.a = a.clone();
	}
	
	public void setB(Ponto b) {
		this.b = b.clone();
	}
	
	public void setC(Ponto c) {
		this.c = c.clone();
	}

	@Override
	public Ponto centro() {
		return new Ponto((a.getX()+b.getX() + c.getX()) / 3, (a.getY() + b.getY() + c.getY()) /3);
	}

	@Override
	public double area() {
		// faze
		return 0;
	}

	@Override
	public double perimentro() {
		return a.distancia(b) + b.distancia(c) + c.distancia(a);
	}

	@Override
	public double base() {
		// fazer
		return 0;
	}

	@Override
	public double altura() {
		// faze
		return 0;
	}

	@Override
	public double distancia(FormasGeometricas f) {
		Ponto cf = f.centro();
		Ponto ct = centro();
		int dx = ct.getX() - cf.getX();
 		int dy = ct.getY() - cf.getX();
		
		return Math.sqrt(dx*dx + dy*dy);
	}
	@Override
	public String toString() {
		return String.format("[%s %s %s]",a,b,c);
	}
	@Override
	public String getNome() {
		return "Triangulo";
	}
	
	@Override
	public Ponto getEnd() {
		// fazer
		return null;
	}

	@Override
	public Ponto getStart() {
		// fazer
		return null;
	}

	@Override
	public Triangulo clone() {
		return new Triangulo(this);
	}

	@Override
	public void desenhar(Graphics g) {
		g.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
		g.drawLine(b.getX(), b.getY(), c.getX(), c.getY());
		g.drawLine(c.getX(), c.getY(), a.getX(), a.getY());
		
	}

}
