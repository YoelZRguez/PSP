package Prog34;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente34 {

	private static final String HOST = "10.210.15.1";
	private static final int PUERTO_ENVIAR = 2001;
	private static final int PUERTO_RECIBIR = 2000;
	private Scanner t = new Scanner(System.in); 
	
	public Cliente34() {
		String datos;
		try {
			DatagramSocket datagramSocketE = new DatagramSocket();
			DatagramSocket datagramSocketR = new DatagramSocket(PUERTO_RECIBIR);
			
			System.out.println("Adivina el número Oculto(0-100).");
			do {
			System.out.println("Introduce el número oculto:");
			System.out.print(" > ");
			
			String textoEnviar = t.nextLine();
			
			byte[] mensaje = new byte[1000];
			mensaje = textoEnviar.getBytes();
			DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName(HOST), PUERTO_ENVIAR);
			datagramSocketE.send(paquete);
			
			byte[] mensaje2 = new byte[1000];
			DatagramPacket paquete2 = new DatagramPacket(mensaje2, mensaje2.length);
			datagramSocketR.receive(paquete2);
			datos = new String(paquete2.getData(), 0, paquete2.getLength());
			if(datos.compareTo("=")==0) {
				System.out.println("Genial has acertao.");
			}else if(datos.compareTo("-")==0) {
				System.out.println("El valor introducido es inferior al número oculto.");
			}else if(datos.compareTo("+")==0) {
				System.out.println("El valor introducido es superior al número oculto.");
			}
			}while(datos.compareTo("=")!=0);
			datagramSocketE.close();
			datagramSocketR.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Cliente34 c = new Cliente34();
	}

}
