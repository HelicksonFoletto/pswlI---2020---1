package edu.udc.pswII_desenho_gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.udc.pswII_desenho.Aplicacao;
import edu.udc.pswII_desenho_formas.FormaGeometrica;

public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	private JLabel status;
	
	private FormaGeometrica formaAtual;
		
	
	public PainelDesenho(JLabel status) {
		this.status= status;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		formaAtual = null;
	}
	
	public void formaAtual(FormaGeometrica forma) {
		formaAtual = forma;

	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		if(formaAtual != null)		
			formaAtual.getManipulador().desenhar(g);
		Iterator<FormaGeometrica> it = Aplicacao.getAplicacao().getDocumento().getIterador();
		while(it.hasNext()) {
			it.next().getManipulador().desenhar(g);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(formaAtual != null) {
			if(formaAtual.getManipulador().click(e.getX(), e.getY())) {
				Aplicacao.getAplicacao().getDocumento().novaForma(formaAtual);
				formaAtual = formaAtual.clone();
			}
				
			repaint();
		}
		
		
		String msg = String.format( "Mouse clicado em (%d; %d)", e.getX(), e.getY());
		if(formaAtual != null)
			msg = msg + "- desenhando " + formaAtual.getNome() + " em " + formaAtual;
		status.setText(msg);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		if(formaAtual != null) {
			formaAtual.getManipulador().mover(e.getX(),e.getY());
			repaint();
		}
		
		String msg = String.format( "Mouse movimentado em (%d; %d)", e.getX(), e.getY());
		if(formaAtual != null)
			msg = msg + "- desenhando " + formaAtual.getNome() + " em " + formaAtual;
		status.setText(msg);		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(formaAtual != null) {
			formaAtual.getManipulador().apertar(e.getX(),e.getY());
			repaint();
		}
		
		
		String msg = String.format( "Mouse pressionado em (%d; %d)", e.getX(), e.getY());
		if(formaAtual != null)
			msg = msg + "- desenhando " + formaAtual.getNome() + " em " + formaAtual;
		status.setText(msg);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(formaAtual != null) {
			if(formaAtual.getManipulador().soltar(e.getX(), e.getY())) {
				Aplicacao.getAplicacao().getDocumento().novaForma(formaAtual);
				formaAtual = formaAtual.clone();
			}
				
			repaint();
		}
		
		String msg = String.format( "Botão solto em (%d; %d)", e.getX(), e.getY());
		status.setText(msg);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		String msg = String.format( "Mouse arrastado em (%d; %d)", e.getX(), e.getY());
		if(formaAtual != null)
			msg = msg + "- desenhando " + formaAtual.getNome() + " em " + formaAtual;
		status.setText(msg);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		String msg = String.format( "Mouse saiu do painel em (%d; %d)", e.getX(), e.getY());
		if(formaAtual != null)
			msg = msg + "- desenhando " + formaAtual.getNome() + " em " + formaAtual;
		status.setText(msg);
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		if(formaAtual != null) {
			formaAtual.getManipulador().arrastar(e.getX(),e.getY());
			repaint();
		}
		
		String msg = String.format( "Mouse arrastado em (%d; %d)", e.getX(), e.getY());
		if(formaAtual != null)
			msg = msg + "- desenhando " + formaAtual.getNome() + " em " + formaAtual;
		status.setText(msg);	

	}
}
