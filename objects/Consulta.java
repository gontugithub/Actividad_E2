package objects;

import java.util.Arrays;
import java.util.Scanner;

public class Consulta {
	

	
	private int numeroidentificacion;
	private TipoConsulta tipo;
	private String nombremedico;
	private int[] huecosdia = new int[5];
	private int[] huecostarde = new int[10];
	
	public int[] getHuecosdia() {
		return huecosdia;
	}


	public void setHuecosdia(int[] huecosdia) {
		this.huecosdia = huecosdia;
	}


	public int[] getHuecostarde() {
		return huecostarde;
	}


	public void setHuecostarde(int[] huecostarde) {
		this.huecostarde = huecostarde;
	}



	
	public Consulta() {
		
	}
	
	
	public void menu() {

		
	}
	
	
	public void reservarCita(int dni,Horario horario,int hueco) {
		
		boolean i = true;
		
		
		do {
			
			switch (horario) {
			
			case DIA: 
				
				if (huecosdia[hueco] == 0) {
					huecosdia[hueco] = dni;
					System.out.println(Arrays.toString(huecosdia));
					i = false;
					
				} else {
					System.err.println("   HUECO INTRODUCIDO OCUPADO \n");
					System.out.println(Arrays.toString(huecosdia));
				
				}
				break;
			case TARDE:
				
				if (huecostarde[hueco] == 0) {
					huecostarde[hueco] = dni;
					System.out.println(Arrays.toString(huecostarde));
					i = false;
				} else {
					System.err.println("HUECO INTRODUCIDO OCUPADO");
					System.out.println(Arrays.toString(huecostarde));
					
				}
				
				break;
		
			}
		} while (i == true);
	
	}
	public void consultarCita(int dni) {
		
		
		
		
		
	}
		
		
		
	}
	
	
	
	
	
	
	


