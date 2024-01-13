package main;

import java.util.Arrays;
import java.util.Scanner;

import objects.Consulta;
import objects.Horario;
import objects.TipoConsulta;

public class Main {

	public static void main(String[] args) {
		
		
		// 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

		Scanner sc = new Scanner(System.in);
	

		Consulta [] revision = { new Consulta(), new Consulta(), new Consulta(), new Consulta(), new Consulta() };
		Consulta [] tratamiento = { new Consulta(), new Consulta(), new Consulta(), new Consulta(),new Consulta() };
		
		

		TipoConsulta tipoconsulta = null;
		Horario horario = null;
		boolean x = true;
		int numeroconsulta = 0;
		int dni = 0;
		int hueco = 0;
		int x2 = 1;

		
		do {
		
		System.out.print("\n   >>> INTRODUCE LOS NUMEROS DEL DNI: ");
		dni = sc.nextInt();
		System.out.print("\n  --- CLINICA GONZALO ---"+
				"\n\n   -1 SOLICITAR UNA CITA"+
				"\n   -2 CAMBIAR UNA CITA"+
				"\n   -3 MIS DATOS"+
				"\n\n  >> ");
		
		switch (sc.nextInt()) {
		
		// 1 -> SOLICITAR UNA CITA 
		
		case 1: 
			
			
			// PREGUNTAMOS AL USUARIO LOS DATOS NECESARIOS 
			
			// SINO METE UN DATO VALIDO, ENTRA EN BUCLE HASTA QUE SE VALIDO (ASI EN  EL PROGRAMA)
			
				do {
	
					// TIPO DE CONSULTA
					
					System.out.print("\n  >>> INTRODUCE EL TIPO DE CONSULTA (REVISION / TRATAMIENTO): ");
	
					switch (sc.next().toUpperCase()) {
	
					case "REVISION":
						tipoconsulta = TipoConsulta.REVISION;
						x = false;
						break;
	
					case "TRATAMIENTO":
						tipoconsulta = TipoConsulta.TRATAMIENTO;
						x = false;
						break;
	
					default:
						
						System.err.println("\n  !!! DATO INTRODUCIDO INCORRECTO");
						break;
	
					}
	
				} while (x == true);
				
				
	
	
				x = true;
	
				// QUE CONSULTA QUIERE
				
				do {
	
					System.out.print("\n  >>> QUE CONSULTA QUIERE (1-5): ");
					numeroconsulta = sc.nextInt();
					
					// QUE SOLO PUEDA METER DEL 1-5 Y LO MODIFICAMOS CON EL -- PARA QUE SE QUEDE DENTRO DEL RANGO DEL ARRAY 0-4
	
					if (numeroconsulta >= 1 && numeroconsulta <= 5) {
						numeroconsulta--;
						x = false;
	
					} else {
						System.err.println("\n  !!! CONSULTA INEXISTENTE");
					}
	
				} while (x == true);
				
				
				x = true;
	
				// 
				
				do {
	
					System.out.print("\n  >>> INTRODUCE EL HORARIO (DIA / TARDE): ");
					
					switch (sc.next().toUpperCase()) {
	
					case "DIA":
						horario = Horario.DIA;
						x = false;
						break;
	
					case "TARDE":
						horario = Horario.TARDE;
						x = false;
						break;
	
					default:
						System.err.println("\n  !!! DATO INTRODUCIDO INCORRECTO");
						break;
					}
	
				} while (x == true);
				
				do {
					
					
					
					
					System.out.print("\n  >>> INTRODUCE EL HUECO (1-5): ");
					hueco = sc.nextInt();
					
					
					// QUE SOLO PUEDA METER DEL 1-5 Y LO MODIFICAMOS CON EL -- PARA QUE SE QUEDE DENTRO DEL RANGO DEL ARRAY 0-4
	
					if (hueco >= 1 && hueco <= 5) {
						hueco--;
						x = false;
	
					} else {
						System.err.println("\n  !!! HUECO INEXISTENTE");
					}
	
				} while (x == true);
				
				
				
				if(tipoconsulta == TipoConsulta.REVISION) {
					
					revision[numeroconsulta].reservarCita(dni, horario, hueco);
					
					
				} else {
					
					tratamiento[numeroconsulta].reservarCita(dni, horario, hueco);
					
				}
				
				
				
				
				
				break;
				
				
				
				
				
				
		
		case 2: 
			break;
			
			
			
		case 3:
			break;
			
		default:
			
			break;
		}
		}while (x2 == 1);
		
		
		
		

		
		
		
	
		

	}

}