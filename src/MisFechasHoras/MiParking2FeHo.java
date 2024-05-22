package MisFechasHoras;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MiParking2FeHo {

	public static void main(String[] arg) {

		Scanner ent = new Scanner(System.in);
			
		//Variables
		final int HORATOPE = 2;
		float  precioTotal = 0.0f;
		final float PRECIO = 0.15f, PRECIOMAS = 0.10f, PRECIODIA = 20.0f;
		LocalDateTime entrada = null;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
		boolean excep = false;
		//mas de 1 día, 20€ por día. Había que introducir también para que ponga el día.

		//while(entrada == null){
		try {
			System.out.println("Introduce el día y la hora de la entrada (dd/MM/yy HH:mm)");

			entrada = LocalDateTime.parse(ent.nextLine(),df);

			LocalDateTime ahora = LocalDateTime.now();
				
			//Excepcion si introducimos una fecha posterior a la actual
			if(entrada.isAfter(ahora)) {
				throw new DateTimeParseException("Error", "Error" , 0);
			}

			long dias = ChronoUnit.DAYS.between(entrada, ahora);
			Duration aparcado = Duration.between(entrada, ahora);

			System.out.println("Tiempo aparcado: ");			
            System.out.println("Dias: " + aparcado.toDays());
            System.out.println("Horas: " + aparcado.toHoursPart());
            System.out.println("Minutos: " + aparcado.toMinutesPart());
						
			//Cálculo del precio si lleva más de un día
			if (dias > 1) {

				precioTotal = dias * PRECIODIA;
				System.out.println("Precio total: " + precioTotal + " € " );
			//Cálculo del precio si lleva menos de un día
			} else {

				if (aparcado.toHours() < HORATOPE) {
					precioTotal = aparcado.toMinutes()*PRECIO;
					System.out.println("Tienes que pagar: " + precioTotal + " € por " + aparcado.toHours() + " horas.");

				}else {
					precioTotal = aparcado.toMinutes()*PRECIOMAS;
					System.out.println("Tienes que pagar: " + precioTotal + " € por " + aparcado.toHours() + " horas.");
				}
			}while(excep);
		}catch(DateTimeParseException ex) {
			
			System.out.println("Fecha no válida");
			excep = true;
			
		}finally {		 
			ent.close();	// Cerrar el Scanner al finalizar su uso
		}
	}//Fin del main
}//Fin	



