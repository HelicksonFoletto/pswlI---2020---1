package br.edu.udc_arquivosRaquete;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Aplicacao {
	
	//private FileWriter output; // objeto utilizado para gerar saída de texto no arquivo

	public static void main(String[] args) {
		
		new Aplicacao();

	}
	
	public Aplicacao() {
		Raquete raquete = lerRaquete();
		
		System.out.println("A sua raquete:  " + raquete);
		
		FileWriter output = writeTextFile();
		
		try {
			output.append(raquete.toString());
			output.append(String.format("Agora vou salvar a raquete diferente: \n" ));
			output.append(String.format("A raquete:\n"));
			output.close();
			
		} catch (IOException e) {
			e.printStackTrace();	
		}

		ObjectOutputStream objectOutput = writeObjectFile();
		
		try {
			objectOutput.writeObject(raquete);
			objectOutput.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		leitor();
		
	}
	
	static Raquete lerRaquete() {
		float peso;
		String cor;
		int comprimento;
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Qual o peso da raquete (em quilos)?");
		peso = sc.nextFloat();
		
		System.out.println("Qual o comprimento da raquete (em milimetros)?");
		comprimento = sc.nextInt();
		
		System.out.println("Qual é a cor da raquete?");
		cor = sc.next();
		
		Raquete raquete = new Raquete(peso, cor, comprimento);
		sc.close();
		
		return raquete;
	}
	
	// permite ao usuário abrir o arquivo
	
	public FileWriter writeTextFile() {
		FileWriter output = null;
		
		try {
			output = new FileWriter ("raquetes.txt"); //método pra criar o arquivo... SEMPRE CRIA UM ARQUIVO NOVO
		} // fim do try
		
		catch (SecurityException securityException) {
			System.err.println("You do not have write access to this file.");
			System.exit(1);
		} // fim do catch
		
		catch ( FileNotFoundException filesNotFoundException) {
			System.err.println("Error creating file.");
			System.exit(1);
		}// fim do catch
		
		catch (IOException e) {
			System.err.println("Error creating file.");
			System.exit(1);
		}
		return output;
	}
	
	public ObjectOutputStream writeObjectFile() {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream ("raquete.Serial") );
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return oos;
	}
	public void leitor (){
		try {
			
			FileInputStream arq = new FileInputStream("raquetes.txt");
			InputStreamReader input = new InputStreamReader(arq);
			BufferedReader buffer = new BufferedReader(input);
			
			String texto = null;
			
			do {
				
				texto = buffer.readLine();
				if(texto != null) {
					//System.out.println(texto);
					JOptionPane.showMessageDialog(null, texto);
				}
				
			}while( texto != null);
			
			
			
			
		}catch(Exception erro) {
			System.out.println("Erro ao ler o arquivo");
		}
		
	}
}
