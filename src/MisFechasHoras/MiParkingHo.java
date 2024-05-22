package MisFechasHoras;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MiParkingHo {

	public static void main(String[] args) {
		
//		calcule como funciona un parking:
		
//		*pedir datos al usuario, 
//		-pedir hora de entrada
//		-pedir hora actual
		
//		* calcular el precio
//		-si es > 2 horas es 0.10 centimos/minuto
//		-si es < 2 horas es 0.15 centimos/minuto				
//		-precio por dia 20 euros
		
        Scanner ent = new Scanner(System.in); 
        final float PRECIO = 0.10f; // precio por minuto despues de 2 horas 
        final float PRECIOBAJO = 0.15f; // precio por minuto antes de 2 horas
        final float PRECIODIA = 20.0f; //precio por dia
        final int horaTope = 2;

        LocalDateTime momentoEntrada = null;
        Duration duracion = null;

        // Pedimos la hora de entrada
        while (momentoEntrada == null) {
            System.out.println("Introduzca la hora de entrada al parking (HH:mm)");
            try {
                String entradaStr = ent.nextLine();
                LocalTime horaEntrada = LocalTime.parse(entradaStr); // Parseamos la hora de entrada 
                momentoEntrada = LocalDateTime.of(LocalDateTime.now().toLocalDate(), horaEntrada);
                            
                duracion = Duration.between(momentoEntrada, LocalDateTime.now());
                
                System.out.println("Dias -> " + duracion.toDays());
                System.out.println("Horas -> " + duracion.toHoursPart());
                System.out.println("Minutos ->" + duracion.toMinutesPart());
                
                if (momentoEntrada.isAfter(LocalDateTime.now())) {
                    throw new DateTimeParseException("Error", "Error", 0);
                }
//                long dias = ChronoUnit.DAYS.between(momentoEntrada, LocalDateTime.now());
//                if (dias > 0) {
//                    System.out.println("Total a pagar: " + (PRECIOBAJO * duracion.toMinutes()));
//                } else {
//                    System.out.println("Total a pagar: " + (PRECIO * duracion.toMinutes()));
//                }
//            } catch (DateTimeParseException ex) {
//                System.out.println("Hora incorrecta. Por favor, introduzca una hora válida en formato HH:mm.");
//                momentoEntrada = null;

                long horas = duracion.toHours();

                if (horas < horaTope) {
                    System.out.println("Total a pagar: " + (PRECIOBAJO * duracion.toMinutes()) + " euros");
                } else {
                    long dias = duracion.toDays();
                    long minutosDespuesDeDosHoras = duracion.minusDays(dias).toMinutes();
                    float totalAPagar = (dias * PRECIODIA) + (minutosDespuesDeDosHoras * PRECIO);
                    System.out.println("Total a pagar: " + totalAPagar + " euros");
                	}
            } catch (DateTimeParseException ex) {
                System.out.println("Hora incorrecta. Por favor, introduzca una hora válida en formato HH:mm.");
                momentoEntrada = null;                
            }
        }
        ent.close();
    }
}


