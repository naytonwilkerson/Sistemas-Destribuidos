import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.midi.Soundbank;

import java.io.*;
import java.net.*;

public class Cliente {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
		Socket s = new Socket("lab223",2000);	
		
		DataOutputStream saida = new DataOutputStream(s.getOutputStream());
		
		DataInputStream entrada = new DataInputStream(s.getInputStream());
		
		for(int i = 0; i < 100000; i++) {
			saida.writeInt(i);
			// saida.writeUTF("Enviando String para servidor");
			// Isto é oque estou enviando.
			System.out.println("Enviei: "+i);
			String en = entrada.readUTF();
			// Isto é oque estou recebendo do servidor.  
			System.out.println("Recebi: "+en);
			
		}
		}catch (IOException ex) {
			// Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println(ex.getMessage());
		}
	}
}

