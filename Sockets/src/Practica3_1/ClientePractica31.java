package Practica3_1;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientePractica31 {

	private static final String HOST = "10.210.15.1";
	private static final int PUERTO = 3000;
	private Scanner t = new Scanner(System.in);
	
	public ClientePractica31() {
		try {
			Socket socketCliente = new Socket(HOST, PUERTO);
			DataOutputStream flujoSalida = new DataOutputStream(socketCliente.getOutputStream());
			DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());
			
			System.out.println("------------------------------------------------------------------------");
			System.out.println("Introduce el nombre del fichero: ");
			System.out.print("> ");
			String fichero = t.nextLine();
			System.out.println("------------------------------------------------------------------------");
			
			flujoSalida.writeUTF(fichero);
			String respuesta = flujoEntrada.readUTF();
			if(respuesta.compareTo("Y")==0) {
				File f = new File("./"+fichero);
				f.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				String linea = flujoEntrada.readUTF();
				System.out.println(linea);
				bw.write(linea);
				bw.close();
			}else {
				System.out.println("");
			}
			
			
			socketCliente.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		ClientePractica31 c = new ClientePractica31();
	}

}
