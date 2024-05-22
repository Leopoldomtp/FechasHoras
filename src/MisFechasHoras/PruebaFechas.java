package MisFechasHoras;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PruebaFechas {

	public static void main(String[] args) {
		
		Scanner ent = new Scanner(System.in);
		LocalDate fecha=null;
		
		// tres formas para crear una fecha utilizando LocalDate
//		LocalDate fechaActual=LocalDate.now();
//		LocalDate fechaFinDAM = LocalDate.of(2024, 6, 26); //aqui esta con valores enteros
//		LocalDate fechaInicioDam = LocalDate.parse("2023-09-18"); // tiene que tener mes y dia  2 digitos
//																	// aqui esta con un string
//		
//		System.out.println("Fecha actual " + fechaActual);
//		System.out.println("Fecha fin de DAM " + fechaFinDAM);
//		System.out.println("Fecha inicio DAM " + fechaInicioDam);
				
//		LocalDate miNacimiento=null; // se inicializa en null y no en cero
		
		try {
//			System.out.println("Dame tu fecha de nacimiento: ");
			System.out.println("Dame una fecha cualquiera (yyyy-MM-dd)");
			fecha = LocalDate.parse(ent.nextLine());
//
//			if (fecha.getDayOfWeek()==DayOfWeek.SATURDAY ||
//					fecha.getDayOfWeek()==DayOfWeek.SUNDAY) {
//				System.out.println("Fin de semana ");				
//			}else {
//				System.out.println("Laborable"); 
//				
//			}
			
			switch (fecha.getMonth()) {
						
			case DECEMBER, JANUARY, FEBRUARY:
				System.out.println("Invierno");
			break;
			
			case MARCH, APRIL, MAY:
				System.out.println("Primavera");
			break;
			
			case JUNE, JULY, AUGUST:
				System.out.println("verano");
			break;
			
			case SEPTEMBER, OCTOBER, NOVEMBER:
				System.out.println("Otoño");
			break;
			
			}
												
//			miNacimiento = LocalDate.parse(ent.nextLine());
//			System.out.println("La fecha de nacimiento es " + miNacimiento);
//			
////			LocalDate nuevaDate = miNacimiento.plusDays(22);
////			LocalDate nuevaDate = miNacimiento.plusWeeks(22);
////			LocalDate nuevaDate = miNacimiento.plusYears(122);
//
////			LocalDate nuevaDate = miNacimiento.plusDays(12);
//			LocalDate nuevaDate = LocalDate.now();
//			
//			if(nuevaDate.isAfter(miNacimiento)) {
//				System.out.println("Felicidades");
//			}else {
//				System.out.println("Aun no es tu cumpleaños ");
//			}
//			
//			System.out.println(miNacimiento.plusDays(22) + "22 dias" + nuevaDate);
//			System.out.println(LocalDate.now());
						
		}catch (DateTimeParseException ex) {
			System.out.println("Fecha Invalida");
		}
		ent.close();
	}
}
