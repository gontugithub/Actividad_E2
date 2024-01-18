package main;

import java.util.Arrays;
import java.util.Scanner;

import objects.Consulta;
import objects.Horario;
import objects.TipoConsulta;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Consulta[] revision = { new Consulta("DR.PIRES"), new Consulta("DRA.SANCHEZ"), new Consulta("DR.SUGIMOTO"), new Consulta("DR.PROFE"), new Consulta("DR.SANCHEZ") };
		Consulta[] tratamiento = { new Consulta("DR.YIYI"), new Consulta("DR.VIGARA"), new Consulta("DR.JAVIER"), new Consulta("DRA.CLAUDIA"), new Consulta("DRA.SONIA") };
		char[] letrasdni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E', };

		TipoConsulta tipoconsulta = null;
		Horario horario = null;
		boolean x = true;
		boolean x3 = true;
		boolean x2 = true;
		int numeroconsulta = 0;
		int dni = 0;
		
		
		// REGLAS GENERALES DURANTE EL PROGRAMA 
		// SINO METE UN DATO VALIDO, ENTRA EN BUCLE HASTA QUE SEA VALIDO
		
		
		

		do {
			
			// SOLICITAMOS EL DNI

			System.out.print("\n  >>> INTRODUCE LOS NUMEROS DEL DNI: ");
			dni = sc.nextInt();

			do {

				x = true;
				x2 = true;

				System.out.print("\n  --- CLINICA GONZALO ---" + "\n\n   -1 SOLICITAR UNA CITA"
						+ "\n   -2 CAMBIAR UNA CITA" + "\n   -3 MIS DATOS" + "\n   -4 VER CITA ACTIVAS"
						+ "\n   -5 CAMBIAR USUARIO" +"\n   -6 EXIT" + "\n\n  >> ");

				switch (sc.nextInt()) {

				// 1 -> SOLICITAR UNA CITA

				case 1:

					// PREGUNTAMOS AL USUARIO LOS DATOS NECESARIOS
				
					/* - TIPO CONSULTA 
					 * - NUMERO DE CONSULTA
					 * - HORARIO
					 * - HUECO
					 */

					do {


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

					do {

						System.out.print("\n  >>> QUE CONSULTA QUIERE (1-5): ");
						numeroconsulta = sc.nextInt();

						// QUE SOLO PUEDA METER DEL 1-5 Y LO MODIFICAMOS CON EL -- PARA QUE SE QUEDE
						// DENTRO DEL RANGO DEL ARRAY 0-4

						if (numeroconsulta >= 1 && numeroconsulta <= 10) {
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

					if (tipoconsulta == TipoConsulta.REVISION) {

						revision[numeroconsulta].reservarCita(dni, horario);

					} else {

						tratamiento[numeroconsulta].reservarCita(dni, horario);

					}
					break;
					
					
				// 4 -> VER LAS CITAS QUE TENEMOS PENDIENTES 

				case 4:

					do {

						// TIPO DE CONSULTA QUE QUIERE CONSULTAR

						System.out.print("\n  >>> QUE QUIERE CONSULTAR (REVISION / TRATAMIENTO): ");

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

					System.out.println("\n  -> CITAS DISPONIBLES <- ");
					// CUANDO LA CONSULTA SEA REVISON

					if (tipoconsulta == TipoConsulta.REVISION) {

						for (int i = 0; i < revision.length; i++) {

							// Y EL VALOR QUE NO DEVUELVA EL METODO NO SEA 0 (YA QUE QUIERO QUE ME MUESTRE
							// OS QUE TIENEN DNI)

							if (revision[i].consultarCitaDia(dni) != 0) {

								System.out.println("\n  >> CONSULTA " + (i + 1) + "| HORARIO: DIA | HUECO: "
										+ revision[i].consultarCitaDia(dni));
							}

							if (revision[i].consultarCitaTarde(dni) != 0) {

								System.out.println("\n  >> CONSULTA " + (i + 1) + "| HORARIO: TARDE | HUECO: "
										+ revision[i].consultarCitaTarde(dni));

							}

						}

					} else {

						for (int i = 0; i < tratamiento.length; i++) {

							// Y EL VALOR QUE NO DEVUELVA EL METODO NO SEA 0 (YA QUE QUIERO QUE ME MUESTRE
							// OS QUE TIENEN DNI)

							if (tratamiento[i].consultarCitaDia(dni) != 0) {

								System.out.println("\n  >> CONSULTA " + (i + 1) + "| HORARIO: DIA | HUECO: "
										+ tratamiento[i].consultarCitaDia(dni));
							}

							if (tratamiento[i].consultarCitaTarde(dni) != 0) {

								System.out.println("\n  >> CONSULTA " + (i + 1) + "| HORARIO: TARDE | HUECO: "
										+ tratamiento[i].consultarCitaTarde(dni));

							}

						}

					}

					break;
					
				// 2 -> ELIMINA LA CITA QUE TENEMOS Y SOLICITA UNA NUEVA 

				case 2:

					// ELIMINAMOS LA CITA QUE TIENE

					for (int i = 0; i < tratamiento.length; i++) {
						tratamiento[i].elminarConsulta(dni);
					}

					for (int i = 0; i < revision.length; i++) {
						revision[i].elminarConsulta(dni);
					}


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

						// QUE SOLO PUEDA METER DEL 1-5 Y LO MODIFICAMOS CON EL -- PARA QUE SE QUEDE
						// DENTRO DEL RANGO DEL ARRAY 0-4

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

					if (tipoconsulta == TipoConsulta.REVISION) {

						revision[numeroconsulta].reservarCita(dni, horario);

					} else {

						tratamiento[numeroconsulta].reservarCita(dni, horario);

					}
					break;
					
					
				// 3 -> VER LOS DATOS, MUESTRA EL DNI DEL USUARIO CON SU LETRA 

				case 3:
					System.out.println("\n  > DNI: " + dni + letrasdni[dni % 23]);
					break;
					
				
				// 5 -> CAMBIAR DE USUARIO, SALDRIA DEL BUCLE Y TE DEJA METER OTRO DNI

				case 5:
					x2 = false;
					break;
					
				// 6 -> FINALIZA EL PROGRAMA, SALIENDO DE LOS BUCLES Y MOSTRANDO EL MENSAJE FINAL
				
				case 6:
					x3 = false;
					x2 = false;
					break;

				}
			} while (x2 == true);
		} while (x3 == true);
		
		
		System.out.println("\n   [ HASTA OTRA ]\n\n   CUANDO TU MUNDO SE PARA CLINICA GONZALO TE AYUDARA");

	}

}