package edu.udc.pswII_desenho_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import edu.udc.pswII_desenho.Aplicacao;
import edu.udc.pswII_desenho_formas.Lapis;
import edu.udc.pswII_desenho_formas.Linha;
import edu.udc.pswII_desenho_formas.Ponto;
import edu.udc.pswII_desenho_formas.Triangulo;

public class JanelaAplicacao extends JFrame{

	private static final long serialVersionUID = 1L;

	public JanelaAplicacao() {
		super("Aplicação de desenho com o mouse");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
		
		this.setLayout(new BorderLayout());
		
		
		JLabel status = new JLabel("Status da aplicação");
		this.add(status, BorderLayout.SOUTH);
		
		PainelDesenho painel = new PainelDesenho(status);
		this.add(painel, BorderLayout.CENTER);
		
		
		//criar Menu
		
		JMenuBar  menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu ("Arquivo");
		mnArquivo.setMnemonic('A');
		menuBar.add(mnArquivo);
		
		JMenu mnFigura = new JMenu ("Figura");
		mnFigura.setMnemonic('F');
		menuBar.add(mnFigura);
		
		
		JMenuItem mntmPonto = new JMenuItem ("Ponto");
		mntmPonto.setMnemonic('P');
		mntmPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel.formaAtual(new Ponto(0,0));
			}
		});
		mnFigura.add(mntmPonto);
		
		JMenuItem mntmLinha = new JMenuItem ("Linha");
		mntmLinha.setMnemonic('L');
		mntmLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel.formaAtual(new Linha(new Ponto(0,0), new Ponto(0,0)));
			}
		});
		mnFigura.add(mntmLinha);
		
		JMenuItem mntmTriangulo = new JMenuItem ("Triangulo");
		mntmTriangulo.setMnemonic('T');
		mntmTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel.formaAtual(new Triangulo(new Ponto(0,0), new Ponto(0,0), new Ponto(0,0) ) );
			}
		});
		mnFigura.add(mntmTriangulo);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.setMnemonic('S');
		mntmSalvar.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					Aplicacao.getAplicacao().getDocumento().salvar(f);
				}
			}
		});
	
		
		JMenuItem mntmLapis = new JMenuItem("Lapis");
		mntmSalvar.setMnemonic('L');
		mntmSalvar.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
					//painelDesenho.novaFormaGeometrica(new Lapis());
					painel.formaAtual(new Lapis());
				}
			}
		);
		mnFigura.add(mntmLapis);
		
		mnArquivo.add(mntmSalvar);
		
		JMenuItem mntmLer = new JMenuItem("Ler");
		mntmLer.setMnemonic('L');
		mntmLer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					Aplicacao.getAplicacao().getDocumento().ler(f);
				}
			}
		});
		mnArquivo.add(mntmLer);
		
		JMenuItem mntmSalvarTxt = new JMenuItem("Salvar Texto");
		mntmLer.setMnemonic('X');
		mntmLer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					Aplicacao.getAplicacao().getDocumento().salvarTxt(f);
				}
			}
		});
		mnArquivo.add(mntmSalvarTxt);
		
		JMenuItem mntmLerTxt = new JMenuItem("Ler Texto");
		mntmLer.setMnemonic('T');
		mntmLer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					Aplicacao.getAplicacao().getDocumento().ler(f);
				}
			}
		});
		mnArquivo.add(mntmLerTxt);
	}
}
