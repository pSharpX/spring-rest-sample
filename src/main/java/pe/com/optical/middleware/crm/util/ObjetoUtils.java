package pe.com.optical.middleware.crm.util;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class ObjetoUtils {

	public static <T> T getValorPorDefecto(T posibleNulo, T valorPorDefecto) {
		return Optional.ofNullable(posibleNulo).orElse(valorPorDefecto);
	}

	public static <K, V> Map<K, V> getMapa(Map<K, V> mapa) {
		return getValorPorDefecto(mapa, emptyMap());
	}

	public static <E> List<E> getLista(List<E> lista) {
		return getValorPorDefecto(lista, emptyList());
	}

	public static Date getHoy() {
		return Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static Date getAhora() {
		return new Date();
	}

	public static boolean antesDe(Date fechaEvaluar, Date fechaTope) {
		return fechaEvaluar.before(fechaTope);
	}

	public static boolean despuesDe(Date fechaEvaluar, Date fechaBase) {
		return fechaEvaluar.after(fechaBase);
	}

	public static boolean antesDeHoy(Date fecha) {
		return antesDe(fecha, getHoy());
	}

	public static boolean despuesDeHoy(Date fecha) {
		return despuesDe(fecha, getHoy());
	}

	public static long getDiasEntre(Date fecha1, Date fecha2) {
		LocalDate fechaInicio = fecha1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate fechaFin = fecha2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
	}

	// public static void main(String[] args) {
	// Date hoy = getHoy();
	// System.out.println("Dias entre hoy y hoy: " + getDiasEntre(hoy, new Date()));
	// }
}
