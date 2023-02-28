package Prog32;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * No dejar NUNCA flujos en un bucle.
 */
public class CLiente32 {

	private static final String HOST = "10.210.15.1";
	private static final int PUERTO = 2000;
	private Scanner t = new Scanner(System.in);
	
	public CLiente32() {
		String numero = "";
		int intento;
		int random;
		try {
			Socket socketCliente = new Socket(HOST, PUERTO);
			DataOutputStream flujoSalida = new DataOutputStream(socketCliente.getOutputStream());
			DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());
			//String mensaje1 = flujoEntrada.readUTF();
			random =flujoEntrada.readInt();
			do {
				System.out.println(/*mensaje1*/ "Introduce el número oculto:");
				System.out.print(" > ");
				intento = Integer.parseInt(t.nextLine());
				if(intento == random) {
					System.out.println("Genial has acertao. El número secreto era: "+random);
				}else if(intento < random) {
					System.out.println("El valor introducido es inferior al número oculto.");
				}else if(intento > random) {
					System.out.println("El valor introducido es superior al número oculto.");
				}
			}while(random != intento);
			socketCliente.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		CLiente32 c = new CLiente32();
	}

}
