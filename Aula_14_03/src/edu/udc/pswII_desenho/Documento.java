package edu.udc.pswII_desenho;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.udc.pswII_desenho_formas.FabricaFormas;
import edu.udc.pswII_desenho_formas.FormaGeometrica;
import edu.udc.pswII_desenho_gui.PainelDesenho;

public class Documento {
	private List<FormaGeometrica> listaFormas;
	private PainelDesenho painel;
	
	public Documento() {
		painel = null;
		listaFormas = new LinkedList<FormaGeometrica>();
	}
	
	public void setPainel(PainelDesenho painel) {
		this.painel = painel;
	}
	
	public void novaForma(FormaGeometrica forma) {
		listaFormas.add(forma);
		atualizarPainel();
	}
	public void atualizarPainel() {
		if(painel != null)
			painel.repaint();
	}
	public Iterator<FormaGeometrica> getIterador(){
		return listaFormas.iterator();
	}
	
	public void salvar(File file) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			
			for(FormaGeometrica f : listaFormas) {
				oos.writeObject(f);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ler(File file) {
		ObjectInputStream ois = null;
		
		try {
			 ois = new ObjectInputStream( new FileInputStream(file));
			
			listaFormas.clear();
			
			FormaGeometrica formaAux = null;
			
			while(true) {
				formaAux = (FormaGeometrica) ois.readObject();
				listaFormas.add(formaAux);
			}
			
		} catch (EOFException endOfFileExeption) {
			try {
				ois.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		atualizarPainel();
	}

	public void salvarTxt(File file) {
		try {
			FileWriter fw = new FileWriter(file);
			
			for(FormaGeometrica f : listaFormas) {
				fw.append(f.getClass().getSimpleName() + " " + f.toString() + "\n");
			}
			
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void lerTxt(File file) {
		try {
			Scanner sc = new Scanner (file);
			
			listaFormas.clear();
			
			FormaGeometrica formaAux = null;
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				formaAux = FabricaFormas.fabricarForma(line);
				listaFormas.add(formaAux);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		atualizarPainel();
	}
}
