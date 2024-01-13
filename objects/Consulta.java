package objects;

import java.util.Arrays;
import java.util.Scanner;

public class Consulta {
	

	
	private int numeroidentificacion;
	private TipoConsulta tipo;
	private String nombremedico;
	private int[] huecosdia = new int[10];
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


	private int[] huecostarde = new int[10];
	
	public Consulta() {
		
	}
	
	
	public void menu() {

		
	}
	
	
	public void reservarCita(int dni,Horario horario,int hueco) {
		
		if (hueco <= huecosdia.length && hueco >= 1) {
			
			switch (horario) {
			
			case DIA: 
				
				if (huecosdia[hueco] == 0) {
					huecosdia[hueco] = dni;
				} else {
					System.out.println("HUECO INTRODUCIDO OCUPADO");
					menu();
				}
				break;
			case TARDE:
				
				if (huecostarde[hueco] == 0) {
					huecostarde[hueco] = dni;
				} else {
					System.out.println("HUECO INTRODUCIDO OCUPADO");
					menu();
				}
				
				break;
		
			}
		} else {
			
			System.out.println("HUECO INTRODUCIDO INCORRECTO");
			menu();
		}
		
		
		
	}
	
	
	
	
	
	
	

}
