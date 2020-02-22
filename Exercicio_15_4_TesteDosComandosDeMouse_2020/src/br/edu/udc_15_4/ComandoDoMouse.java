package br.edu.udc_15_4;

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

public class ComandoDoMouse extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Painel mousePanel;
	private String mensagens;
	private String origem;
	private double raio;
	private int origemX, origemY;
	private int raioX, raioY;
	private int pontoAX, pontoAY, pontoBX, pontoBY, pontoCX, pontoCY;
	private int cliquesTriangulo = 3;
	
	/* Getters and Setters */
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
	
	/* Construtor */	
	public ComandoDoMouse() {
		super("Tratamento dos eventos de mouse");
		
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		mensagens = "";	
		
		/* Configuração do menu */
		
		JMenuBar menu = new JMenuBar();
		add(menu, BorderLayout.NORTH);
		
		JMenu desenhos = new JMenu("Figuras Geométricas");
		menu.add(desenhos);
		
		JMenuItem ponto = new JMenuItem("Ponto");
		desenhos.add(ponto);
		
		JMenuItem linha = new JMenuItem("Linha");
		desenhos.add(linha);
		
		JMenuItem circulo = new JMenuItem("Círculo");
		desenhos.add(circulo);
		
		JMenuItem quadrado = new JMenuItem("Quadrado");
		desenhos.add(quadrado);
		
		JMenuItem retangulo = new JMenuItem("Retângulo");
		desenhos.add(retangulo);
		
		JMenuItem triangulo = new JMenuItem("Triângulo");
		desenhos.add(triangulo);				

		/* Mensagens de Rodapé */
		
		JLabel status = new JLabel("Mensagens de evento do mouse");
		add(status, BorderLayout.SOUTH);
		
		
		/* Painel de Desenho */
		
		mousePanel = new Painel();
		add(mousePanel, BorderLayout.CENTER);
		
		mousePanel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				/* Informações do ponto */
				if(mousePanel.getOpcao() == 3){
					mousePanel.setPoint(arg0.getX(), arg0.getY());
				
					mousePanel.repaint();	
					
					mensagens = String.format("Ponto na posição [%d; %d]", arg0.getX(), arg0.getY());
					status.setText(mensagens);
				}
				
				/* Informações do triangulo */
				if(mousePanel.getOpcao() == 6){
					if (cliquesTriangulo == 3){
						pontoAX = arg0.getX();
						pontoAY = arg0.getY();
						pontoBX = arg0.getX();
						pontoBY = arg0.getY();
						pontoCX = arg0.getX();
						pontoCY = arg0.getY();
						
						mousePanel.setPontoAX(pontoAX);
						mousePanel.setPontoAY(pontoAY);
						mousePanel.setPontoBX(pontoBX);
						mousePanel.setPontoBY(pontoBY);
						mousePanel.setPontoCX(pontoCX);
						mousePanel.setPontoCY(pontoCY);
											
						mousePanel.repaint();
						
						mensagens = String.format("Ponto A: [%d; %d]", arg0.getX(), arg0.getY());
						status.setText(mensagens);
						
						cliquesTriangulo = 2;
					}
					
					else if (cliquesTriangulo == 2){
						pontoBX = arg0.getX();
						pontoBY = arg0.getY();
						pontoCX = arg0.getX();
						pontoCY = arg0.getY();
						
						mousePanel.setPontoAX(pontoAX);
						mousePanel.setPontoAY(pontoAY);
						mousePanel.setPontoBX(pontoBX);
						mousePanel.setPontoBY(pontoBY);
						mousePanel.setPontoCX(pontoCX);
						mousePanel.setPontoCY(pontoCY);
											
						mousePanel.repaint();
						
						mensagens = mensagens + " - " + String.format("Ponto B: [%d; %d]", arg0.getX(), arg0.getY());
						status.setText(mensagens);
						
						cliquesTriangulo = 1;
					}
					
					else if (cliquesTriangulo == 1){
						pontoCX = arg0.getX();
						pontoCY = arg0.getY();
						
						mensagens = mensagens + " - " + String.format("Ponto C: [%d; %d]", arg0.getX(), arg0.getY());
						status.setText(mensagens);
						
						mousePanel.setPontoAX(pontoAX);
						mousePanel.setPontoAY(pontoAY);
						mousePanel.setPontoBX(pontoBX);
						mousePanel.setPontoBY(pontoBY);
						mousePanel.setPontoCX(pontoCX);
						mousePanel.setPontoCY(pontoCY);
											
						mousePanel.repaint();
						
						cliquesTriangulo = 3;
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
					
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				origemX = arg0.getX();
				origemY = arg0.getY();
				
				mousePanel.setOriginX(origemX);
				mousePanel.setOriginY(origemY);
				origem = String.format("Origem: [%d; %d]", origemX, origemY);
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});
		
		mousePanel.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {
				/* Informações do círculo */
				if(mousePanel.getOpcao() == 1){
					raioX = arg0.getX();
					raioY = arg0.getY();
					
					int x = Math.abs(origemX - raioX);
					int y = Math.abs(origemY - raioY);
					
					raio = Math.sqrt((x*x) + (y*y));
			
					double area = Math.PI * raio * raio;
							
					double circunferencia = Math.PI * 2 * raio;
					
					mousePanel.setRadiusX(raioX);
					mousePanel.setRadiusY(raioY);
					mousePanel.setRadius((int) Math.abs(raio));
					
					mousePanel.repaint();
					
										
					mensagens = origem + " - " + String.format("Raio: [%d; %d][%.2f]", raioX, raioY, raio)  + " - " + 
							String.format("Área: [%.2f]", area) + " - " + String.format("Circunferência: [%.2f]", circunferencia);
					
					status.setText(mensagens);
				}
				
				/* Informações do retângulo */
				if(mousePanel.getOpcao() == 2){
					raioX = arg0.getX();
					raioY = arg0.getY();
					
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
				
					mensagens = String.format("Pontos: Sup Esq: [%d; %d] / Inf Dir: [%d; %d]", supX, supY, infX, infY) + " - " +
							String.format("Área: [%d]", area) + " - " + String.format("Perímetro: [%d]", perimetro);
				}
				
				/* Informações da linha */
				if(mousePanel.getOpcao() == 4){
					raioX = arg0.getX();
					raioY = arg0.getY();
					
					mousePanel.setRadiusX(raioX);
					mousePanel.setRadiusY(raioY);
					
					mousePanel.repaint();	
					
					mensagens = origem + " - " + String.format("Fim: [%d; %d]", raioX, raioY);
					
					status.setText(mensagens);
				}
				
				/* Informações do quadrado */
				if(mousePanel.getOpcao() == 5){
					raioX = arg0.getX();
					raioY = arg0.getY();
					
					int supX, supY, infX, infY;
					
					supX = Math.min(origemX, raioX);
					supY = Math.min(origemY, raioY);
					infX = Math.max(origemX, raioX);
					infY = Math.max(origemY, raioY);
					
					mousePanel.setRadiusX(raioX);
					mousePanel.setRadiusY(raioY);
					
					mousePanel.repaint();
					
					int area = (infX - supX) * (infY - supY);
					
					int perim = ((infX - supX) * 2) + ((infY - supY) * 2);  
				
					mensagens = String.format("Pontos: Sup Esq: [%d; %d] / Inf Dir: [%d; %d]", supX, supY, infX, infY) + " - " +
							String.format("Área: [%d]", area) + " - " + String.format("Perímetro: [%d]", perim);
				}	
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				String moved = String.format("Mouse na posição [%d; %d]", arg0.getX(), arg0.getY());;
				
				if (mensagens.length() > 1)
					moved = moved + " - " + mensagens;
				
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

		linha.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mousePanel.setOpcao(4);
				
			}			
		});

		quadrado.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mousePanel.setOpcao(5);
				
			}	
		});
		
		triangulo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mousePanel.setOpcao(6);
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
	public void paint(Graphics g) {
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
			/* Linha */
			case 4:{
				g.drawLine(origemX, origemY, raioX, raioY);
				break;
			}
			/* Quadrado */
			case 5:{
				if (origemX < raioX){
					if (origemY < raioY)
						if (raioX-origemX > raioY-origemY)
							g.drawRect(origemX, origemY, raioX-origemX, raioX-origemX);
						
						else
							g.drawRect(origemX, origemY, raioY-origemY, raioY-origemY);
					
					else
						if (raioX-origemX > origemY-raioY)
							g.drawRect(origemX, raioY, raioX-origemX, raioX-origemX);
						
						else
							g.drawRect(origemX, raioY, origemY-raioY, origemY-raioY);
				}
				else{
					if (origemY < raioY)
						if (origemX-raioX > raioY-origemY)
							g.drawRect(raioX, origemY, origemX-raioX, origemX-raioX);
						
						else
							g.drawRect(raioX, origemY, raioY-origemY, raioY-origemY);
					
					
					else 
						if (origemX-raioX > origemY-raioY)
							g.drawRect(raioX, raioY, origemX-raioX, origemX-raioX);
					
						else
							g.drawRect(raioX, raioY, origemY-raioY, origemY-raioY);
				}
			
				break;
			}
			/* Triangulo */
			case 6:{
				g.drawLine(pontoAX, pontoAY, pontoBX, pontoBY);
				g.drawLine(pontoBX, pontoBY, pontoCX, pontoCY);
				g.drawLine(pontoCX, pontoCY, pontoAX, pontoAY);
				
				break;
			}
		}
	}
}