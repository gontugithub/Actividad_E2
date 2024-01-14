package objects;

import java.util.Arrays;
import java.util.Scanner;

public class Consulta {
	
	Scanner sc = new Scanner(System.in);
	private int hueco = 0;
	
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
	
	
	public void reservarCita(int dni,Horario horario) {
		
		boolean i = true;
		
		do {
		
		
		do {
			

			System.out.print("\n  >>> INTRODUCE EL HUECO (1-5): ");
			hueco = sc.nextInt();
			
			
			// QUE SOLO PUEDA METER DEL 1-5 Y LO MODIFICAMOS CON EL -- PARA QUE SE QUEDE DENTRO DEL RANGO DEL ARRAY 0-4

			if (hueco >= 1 && hueco <= 5) {
				hueco--;
				i = false;

			} else {
				System.err.println("\n  !!! HUECO INEXISTENTE");
			}
			
		}while (i == true);
		
		
		i = true;
		
			switch (horario) {
			
			case DIA: 
				
				if (huecosdia[hueco] == 0) {
					huecosdia[hueco] = dni;
					System.out.println(Arrays.toString(huecosdia));
					i = false;
					
				} else {
					System.err.println("\n   HUECO INTRODUCIDO OCUPADO \n");
					System.out.println(Arrays.toString(huecosdia));
				
				}
				break;
			case TARDE:
				
				if (huecostarde[hueco] == 0) {
					huecostarde[hueco] = dni;
					System.out.println(Arrays.toString(huecostarde));
					i = false;
				} else {
					System.err.println("\n   HUECO INTRODUCIDO OCUPADO");
					System.out.println(Arrays.toString(huecostarde));
					
				}
				
				break;
		
			}
		} while (i == true);
	
	}
	public void consultarCita(int dni) {
		
		
		
		
		
	}
		
		
		
	}
	
	
	
	
	
	
	


