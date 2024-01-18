package objects;

import java.util.Arrays;
import java.util.Scanner;

public class Consulta {

	Scanner sc = new Scanner(System.in);
	

	
	// CREAR CONSTRUCTOR CON NUMERO-IDENTIFICACION Y NOIMBRE MEDICO
	

	private String nombremedico = "";
	private int hueco = 0;
	private int tamhuecosarray = 10;
	private int[] huecosdia = new int[tamhuecosarray];
	private int[] huecostarde = new int[tamhuecosarray];
	
	
	// CONSTRUCTORES
	
	public Consulta() {

	}
	
	public Consulta(String nombremedico) {
		this.nombremedico = nombremedico;
	}
	
	// LOS SETTER Y GETTERS 

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

	public int getTamhuecosarray() {
		return tamhuecosarray;
	}

	public void setTamhuecosarray(int tamhuecosarray) {
		this.tamhuecosarray = tamhuecosarray;
	}

	public String getNombremedico() {
		return nombremedico;
	}

	public void setNombremedico(String nombremedico) {
		this.nombremedico = nombremedico;
	}
	
	
	// RESERVA UNA CITA, INTRODUCE UN HUECO, SI EL HUECO INTRODUCIDO NO ESTA OCUPADO POR OTRO DNI, ES DECIR == 0, LO CAMBIA POR EL DNI DEL USUARIO Y MUESTRA EL ARRAY 

	public void reservarCita(int dni, Horario horario) {

		boolean i = true;

		do {

			do {

				System.out.print("\n  >>> INTRODUCE EL HUECO (1-"+tamhuecosarray+"): ");
				hueco = sc.nextInt();

				// QUE SOLO PUEDA METER DEL 1-10 Y LO MODIFICAMOS CON EL -- PARA QUE SE QUEDE
				// DENTRO DEL RANGO DEL ARRAY 0-4

				if (hueco >= 1 && hueco <= tamhuecosarray) {
					hueco--;
					i = false;

				} else {
					System.err.println("\n  !!! HUECO INEXISTENTE");
				}

			} while (i == true);

			i = true;

			switch (horario) {

			case DIA:

				if (huecosdia[hueco] == 0) {
					huecosdia[hueco] = dni;

					System.out.println("\n   "+Arrays.toString(huecosdia));
					i = false;

				} else {
					System.err.println("\n   HUECO INTRODUCIDO OCUPADO \n");
					System.out.println("\n   "+Arrays.toString(huecosdia));

				}
				break;
			case TARDE:

				if (huecostarde[hueco] == 0) {
					huecostarde[hueco] = dni;
					System.out.println("\n   "+Arrays.toString(huecostarde));
					i = false;
				} else {
					System.err.println("\n   HUECO INTRODUCIDO OCUPADO");
					System.out.println("\n   "+Arrays.toString(huecostarde));

				}

				break;

			}
		} while (i == true);

	}

	

	// CONSULTAR CITAS (DIA, TARDE): BUSCA EL DNI DEL USUARIO Y COMPRUEBA SI TIENE ALGUNA COINDICIENDIA EN ALGUNA POSICION DE TODOS LOS ARRAYS, SI ES ASI DEVUELVE
	// EL HUECO DEL ARRAY DONDE SE ENCUENTRA

	public int consultarCitaDia(int dni) {

		int numerohueco = 0;

		for (int i = 0; i < huecosdia.length; i++) {

			if (huecosdia[i] == dni) {

				// SIN ESTA VAMOS A GUARDAR EL NUMERO DEL HUECO EN *numerohueco
				numerohueco = i + 1;
			}
		}

		return numerohueco;
	}

	public int consultarCitaTarde(int dni) {

		int numerohueco = 0;
		// VEMOS SI SU DNI ESTA POR EL DIA

		for (int i = 0; i < huecostarde.length; i++) {

			if (huecostarde[i] == dni) {

				// SIN ESTA VAMOS A GUARDAR EL NUMERO DEL HUECO EN *numerohueco
				numerohueco = i + 1;
			}
		}

		return numerohueco;

	}
	
	
	// ELIMINA EL DNI, BUSCA EL DNI Y SI LO ENCUENTRA LO CAMBIA POR UN CERO 
	
	public void elminarConsulta(int dni) {
		
		for (int i = 0; i < huecosdia.length; i++) {

			if (huecosdia[i] == dni) {

				huecosdia[i] = 0;
				
				
			}
		}
		
		for (int i = 0; i < huecostarde.length; i++) {

			if (huecostarde[i] == dni) {

				huecostarde[i] = 0;
				
			}
		}
		
	}

}
