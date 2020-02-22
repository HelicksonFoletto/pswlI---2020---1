package br.edu.udc_15_6;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DesenharFiguras extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Painel mousePanel;
	private String mensagem;
	private String origem;
	private double raio;
	private int origemX, origemY;
	private int raioX, raioY;
	private int pontoAX, pontoAY, pontoBX, pontoBY, pontoCX, pontoCY;
	
	public int getOrigemX() {
		return origemX;
	}
	public void setOrigemX(int origemX) {
		this.origemX = origemX;
	}
	public int getOrigemY() {
		return origemY;
	}
	public void setOrigemY(int origemY) {
		this.origemY = origemY;
	}
	public int getRaioX() {
		return raioX;
	}
	public void setRaioX(int raioX) {
		this.raioX = raioX;
	}
	public int getRaioY() {
		return raioY;
	}
	public void setRaioY(int raioY) {
		this.raioY = raioY;
	}



	DesenharFiguras(){
		super("Desenhar Figuras");
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		mensagem = "";
		
		/* Menu */
		
		JMenuBar menu = new JMenuBar();
		add(menu, BorderLayout.NORTH);
		
		JMenu desenhos = new JMenu("Modos de desenhos:");
		menu.add(desenhos);
		
		JMenuItem ponto = new JMenuItem("Ponto");
		desenhos.add(ponto);
		
		JMenuItem circulo = new JMenuItem("Círculo");
		desenhos.add(circulo);

		JMenuItem retangulo = new JMenuItem("Retângulo");
		desenhos.add(retangulo);
		
		/* Mensagem do rodapé*/
		JLabel status = new JLabel("Mensagens de evento do mouse");
		add(status, BorderLayout.SOUTH);
		
		mousePanel = new Painel();
		add(mousePanel, BorderLayout.CENTER);
		
		mousePanel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {	
				/* Informações do ponto */
				if(mousePanel.getOpcao() == 3){
					mousePanel.setPoint(e.getX(), e.getY());
				
					mousePanel.repaint();	
					
					mensagem = String.format("Ponto na posição [%d; %d]", e.getX(), e.getY());
					status.setText(mensagem);
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				origemX = e.getX();
				origemY = e.getY();
				
				mousePanel.setOriginX(origemX);
				mousePanel.setOriginY(origemY);
				origem = String.format("Origem: [%d; %d]", origemX, origemY);
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {	
			}
			@Override
			public void mouseEntered(MouseEvent e) {	
			}
			@Override
			public void mouseExited(MouseEvent e) {	
			}
		
		});
		mousePanel.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				/* Informações do círculo */
				if(mousePanel.getOpcao() == 1){
					raioX = e.getX();
					raioY = e.getY();
					
					int x = Math.abs(origemX - raioX);
					int y = Math.abs(origemY - raioY);
					
					raio = Math.sqrt((x*x) + (y*y));
			
					double area = Math.PI * raio * raio;
							
					double circunferencia = Math.PI * 2 * raio;
					
					mousePanel.setRadiusX(raioX);
					mousePanel.setRadiusY(raioY);
					mousePanel.setRadius((int) Math.abs(raio));
					
					mousePanel.repaint();
					
										
					mensagem = origem + " - " + String.format("Raio: [%d; %d][%.2f]", raioX, raioY, raio)  + " - " + 
							String.format("Área: [%.2f]", area) + " - " + String.format("Circunferência: [%.2f]", circunferencia);
					
					status.setText(mensagem);
				}
				/* Informações do retângulo */
				if(mousePanel.getOpcao() == 2){
					raioX = e.getX();
					raioY = e.getY();
					
					int supX, supY, infX, infY;
					
					supX = Math.min(origemX, raioX);
					supY = Math.min(origemY, raioY);
					infX = Math.max(origemX, raioX);
					infY = Math.max(origemY, raioY);
					
					mousePanel.setRadiusX(raioX);
					mousePanel.setRadiusY(raioY);
					
					mousePanel.repaint();
					
					int area = (infX - supX) * (infY - supY);
					
					int perimetro = ((infX - supX) * 2) + ((infY - supY) * 2);  
				
					mensagem = String.format("Pontos: Sup Esq: [%d; %d] / Inf Dir: [%d; %d]", supX, supY, infX, infY) + " - " +
							String.format("Área: [%d]", area) + " - " + String.format("Perímetro: [%d]", perimetro);
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {

				String moved = String.format("Mouse na posição [%d; %d]", e.getX(), e.getY());;
				
				if (mensagem.length() > 1)
					moved = moved + " - " + mensagem;
				
				status.setText(moved);
			}
			
		});
		
		circulo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mousePanel.setOpcao(1);
				
			}
		});
		
		retangulo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mousePanel.setOpcao(2);
				
			}
		});
		
		ponto.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mousePanel.setOpcao(3);	
			}
		});
		
		setVisible(true);
	}

}
class Painel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private int pontoX, pontoY;
	private int origemX, origemY, raioX, raioY, raio;
	private int pontoAX, pontoAY, pontoBX, pontoBY, pontoCX, pontoCY;
	private int item;
	
	private Circulo[] vetorCirculo;
	private int posCirculo = 0;
	
	
	/* Getters and Setters */
	public int getPontoAX() {
		return pontoAX;
	}
	public void setPontoAX(int pontoAX) {
		this.pontoAX = pontoAX;
	}
	public int getPontoAY() {
		return pontoAY;
	}
	public void setPontoAY(int pontoAY) {
		this.pontoAY = pontoAY;
	}
	public int getPontoBX() {
		return pontoBX;
	}
	public void setPontoBX(int pontoBX) {
		this.pontoBX = pontoBX;
	}
	public int getPontoBY() {
		return pontoBY;
	}
	public void setPontoBY(int pontoBY) {
		this.pontoBY = pontoBY;
	}
	public int getPontoCX() {
		return pontoCX;
	}
	public void setPontoCX(int pontoCX) {
		this.pontoCX = pontoCX;
	}
	public int getPontoCY() {
		return pontoCY;
	}
	public void setPontoCY(int pontoCY) {
		this.pontoCY = pontoCY;
	}
	public int getOpcao() {
		return item;
	}
	public void setOpcao(int opcao) {
		this.item = opcao;
	}
	public void setPoint(int pointX, int pointY){
		this.pontoX = pointX;
		this.pontoY = pointY;
	}
	public int getPointX() {
		return pontoX;
	}
	public void setPointX(int pointX) {
		this.pontoX = pointX;
	}
	public int getPointY() {
		return pontoY;
	}
	public void setPointY(int pointY) {
		this.pontoY = pointY;
	}
	public int getOriginX() {
		return origemX;
	}
	public void setOriginX(int originX) {
		this.origemX = originX;
	}
	public int getOriginY() {
		return origemY;
	}
	public void setOriginY(int originY) {
		this.origemY = originY;
	}
	public int getRadiusX() {
		return raioX;
	}
	public void setRadiusX(int radiusX) {
		this.raioX = radiusX;
	}
	public int getRadiusY() {
		return raioY;
	}
	public void setRadiusY(int radiusY) {
		this.raioY = radiusY;
	}
	public int getRadius() {
		return raio;
	}
	public void setRadius(int radius) {
		this.raio = radius;
	}
	
	
	
	/* Método paint */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		switch(item){
			/* Círculo */
			case 1:{
				int x = origemX - raio;
				int y = origemY - raio;
	
				g.drawOval(x, y, raio*2, raio*2);
				break;
				
			}
			/* Retângulo */
			case 2:{
				if (origemX < raioX){
					if (origemY < raioY)
						g.drawRect(origemX, origemY, raioX-origemX, raioY-origemY);
					
					else 
						g.drawRect(origemX, raioY, raioX-origemX, origemY-raioY);
				}
				else{
					if (origemY < raioY)
						g.drawRect(raioX, origemY, origemX-raioX, raioY-origemY);
					
					else 
						g.drawRect(raioX, raioY, origemX-raioX, origemY-raioY);
				}
				break;
			}
			/* Ponto */
			case 3:{
				g.fillOval(pontoX-1, pontoY-1, 3, 3);
				break;
			}
			
		}
	}
}
class Circulo {
	private int originX, originY;
	private int radiusX, radiusY;
	private int radius;
	
	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
	}


	public int getOriginX() {
		return originX;
	}
	
	
	public void setOriginX(int originX) {
		this.originX = originX;
	}
	
	public int getOriginY() {
		return originY;
	}
	
	public void setOriginY(int originY) {
		this.originY = originY;
	}
	
	public int getRadiusX() {
		return radiusX;
	}
	
	public void setRadiusX(int radiusX) {
		this.radiusX = radiusX;
	}
	
	public int getRadiusY() {
		return radiusY;
	}
	
	public void setRadiusY(int radiusY) {
		this.radiusY = radiusY;
	}
	
	public void calcRadius() {
		int x = Math.abs(originX - radiusX);
		int y = Math.abs(originY - radiusY);
		
		radius = (int) Math.abs(Math.sqrt((x*x) + (y*y)));
	}
	
	Circulo(){
		this.originX = 0;
		this.originY = 0;
		this.radiusX = 0;
		this.radiusY = 0;
	}
	
}