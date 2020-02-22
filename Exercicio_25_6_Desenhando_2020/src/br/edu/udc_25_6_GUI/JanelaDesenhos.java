package br.edu.udc_25_6_GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

import br.edu.udc_25_6_Modelos.FormaGeometrica;
import br.edu.udc_25_6_Modelos.Linha;
import br.edu.udc_25_6_Modelos.Ponto2D;
import br.edu.udc_25_6_Modelos.Retangulo;
import br.edu.udc_25_6_Modelos.Triangulo;


public class JanelaDesenhos extends JFrame {
	private static final long serialVersionUID = 1L;
	private PainelDesenhos contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaDesenhos frame = new JanelaDesenhos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaDesenhos() {
		setTitle("Janela de desenho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new PainelDesenhos();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFiguras = new JMenu("geometria");
		menuBar.add(mnFiguras);
		
		JMenuItem mntmPonto = new JMenuItem("Ponto");
		mntmPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ponto2D ponto = new Ponto2D();
				
				contentPane.setFormaGeometrica(ponto);
			}
		});
		mnFiguras.add(mntmPonto);
		
		JMenuItem mntmLinha = new JMenuItem("Linha");
		mntmLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Linha linhas = new Linha();
				
				contentPane.setFormaGeometrica(linhas);
			}
		});
		mnFiguras.add(mntmLinha);
		
		JMenuItem mntmRetangulo = new JMenuItem("Retângulo");
		mntmRetangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Retangulo retangulo = new Retangulo();
				contentPane.setFormaGeometrica(retangulo);
			}
		});
		mnFiguras.add(mntmRetangulo);
		
		JMenuItem mntmTriangulo = new JMenuItem("Triângulo");
		mntmTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Triangulo triangulo = new Triangulo();
				contentPane.setFormaGeometrica(triangulo);
			}
		});
		mnFiguras.add(mntmRetangulo);
		
		
	}
}