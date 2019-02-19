import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String[] args) {

		try {
			ServerSocket s = new ServerSocket(2000);
			System.out.println("Esperando conexao....................");
			
			Socket conexao = s.accept();
			System.out.println("Conexao aceita, esoerando dados....");
			
			DataInputStream entrada = new DataInputStream(conexao.getInputStream());
			DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
			
			for (int i = 0; i<100000;i++) {
				
				Integer resp = entrada.readInt();
				System.out.println("Processando.....");
				saida.writeUTF("Recebi seu dado: "+ resp);
				
			}
					
			
		} catch (IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
