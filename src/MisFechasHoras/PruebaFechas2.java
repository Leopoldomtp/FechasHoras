package MisFechasHoras;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PruebaFechas2 {
	
	public static void main(String[] arg) {
//		
//		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//		
//		LocalDate miFecha = LocalDate.parse("06/02/2024", df);
//		
//		System.out.println(miFecha.format(df));
//		
//		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy_09:23:00");
//		LocalDateTime fechaLog = LocalDateTime.parse("06/02/2024_09:23:00", df);
//		
//		System.out.println(fechaLog.format(df));		
//		LocalDate ahora =LocalDate.now();
//		
//		LocalDate nacimiento = 
//				LocalDate.parse("06/01/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		
//		Period per = Period.between(nacimiento, ahora);
//		
//		System.out.println("Años " + per.getYears());
//		System.out.println("Meses " + per.getMonths());
//		System.out.println("Dias " + per.getDays());
//		System.out.println("Dias totales " + ChronoUnit.DAYS.between(nacimiento, ahora)); //esto es para representarlo en dias en vez de meses
//		System.out.println("Meses totales " + ChronoUnit.MONTHS.between(nacimiento, ahora));
//			
//		
	
		
//		LocalTime entrada = LocalTime.parse("08:30");		
//		LocalTime ahora = LocalTime.now();
		
		LocalDateTime entrada = LocalDateTime.parse("2024-02-05T08:15:30");		
		LocalDateTime ahora = LocalDateTime.now();	
		
		Duration duracion = Duration.between(entrada,  ahora);
		
		System.out.println("Tiempo efectivo en clase "+ duracion.toMinutes());
		System.out.println("Tiempo efectivo de clase " + duracion.toHoursPart());	
	}
}

//un periodo es dias, meses y años
