package edu.udc.pswII_desenho;

import edu.udc.pswII_desenho_gui.JanelaAplicacao;

public class Aplicacao {
	
	static Aplicacao aplicacao;
	private Documento documento;
	
	private Aplicacao() {
		documento = new Documento();
		JanelaAplicacao janela = new JanelaAplicacao();
		
		janela.setVisible(true);
	}
	
	public static Aplicacao getAplicacao() {
		if(aplicacao == null)
			aplicacao = new Aplicacao();
		return aplicacao;
	}
	
	public Documento getDocumento() {
		return documento;
	}
	public static void main(String args[]) {
		getAplicacao();
	}
}
