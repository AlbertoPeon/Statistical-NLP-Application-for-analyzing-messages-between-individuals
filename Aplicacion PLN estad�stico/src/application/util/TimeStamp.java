package application.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase que implementa una fecha de forma de forma sencilla y accesible para la
 * aplicación
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class TimeStamp {
	private int year;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private int segundo;

	public TimeStamp(int year, int mes, int dia, int hora, int minuto,
			int segundo) {
		super();
		this.year = year;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}

	public TimeStamp(String fecha, String hora) {
		crearTimestamp(fecha, hora);
	}

	public TimeStamp(Date date) {
		Calendar calendar = GregorianCalendar.getInstance(); // creates a new
																// calendar
																// instance
		calendar.setTime(date); // assigns calendar to given date
		this.year = calendar.get(Calendar.YEAR);
		this.mes = calendar.get(Calendar.MONTH) + 1;
		this.dia = calendar.get(Calendar.DAY_OF_MONTH);
		this.hora = calendar.get(Calendar.HOUR_OF_DAY);
		this.minuto = calendar.get(Calendar.MINUTE);
		this.segundo = calendar.get(Calendar.SECOND);
	}

	public TimeStamp(TimeStamp t) {
		this.year = t.getYear();
		this.mes = t.getMes();
		this.dia = t.getDia();
		this.hora = t.getHora();
		this.minuto = t.getMinuto();
		this.segundo = t.getSegundo();
	}

	public TimeStamp(String timestamp) {
		String[] fecha = timestamp.split(" ");
		crearTimestamp(fecha[0], fecha[1]);
	}

	private void crearTimestamp(String fecha, String hora) {
		String[] fechaCampos = fecha.split("-");
		this.year = Integer.parseInt(fechaCampos[0]);
		this.mes = Integer.parseInt(fechaCampos[1]);
		this.dia = Integer.parseInt(fechaCampos[2]);

		String[] horaCampos = hora.split(":");
		this.hora = Integer.parseInt(horaCampos[0]);
		this.minuto = Integer.parseInt(horaCampos[1]);
		this.segundo = Integer.parseInt(horaCampos[2]);
	}

	public int getYear() {
		return year;
	}

	public int getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dia;
		result = prime * result + hora;
		result = prime * result + mes;
		result = prime * result + minuto;
		result = prime * result + segundo;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeStamp other = (TimeStamp) obj;
		if (dia != other.dia)
			return false;
		if (hora != other.hora)
			return false;
		if (mes != other.mes)
			return false;
		if (minuto != other.minuto)
			return false;
		if (segundo != other.segundo)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = year + "-" + mes + "-" + dia + " " + hora + ":";
		s += (minuto < 10) ? "0" + minuto : minuto;
		s += ":";
		s += (segundo < 10) ? "0" + segundo : segundo;

		return s;

	}

	/**
	 * Compara el TimeStamp actual con los que se le pasan como parámetro para
	 * ver si desde es anterior y hasta posterior
	 * 
	 * @param desde
	 *            TimeStamp que ha de ser anterior al actual
	 * @param hasta
	 *            TimeStamp que ha de ser posterior al actual
	 * @return true si el TimeStamp está comprendido entre desde y hasta, false
	 *         en cualquier otro caso
	 */
	public boolean comprendidoEntre(TimeStamp desde, TimeStamp hasta) {
		return this.posteriorA(desde) && this.anteriorA(hasta);
	}

	/**
	 * Compara el TimeStamp actual con el que se le pasa como parámetro para ver
	 * si es anterior.
	 * 
	 * @param timestamp
	 *            TimeStamp a comparar
	 * @return true si el TimeStamp actual es estrictamente menor que timestamp,
	 *         false en caso contrario
	 */
	public boolean anteriorA(TimeStamp timestamp) {
		return !(this.posteriorA(timestamp)) && !(this.equals(timestamp));
	}

	/**
	 * compara el TimeStamp actual con el que se le pasa como parámetro para ver
	 * si es posterior.
	 * 
	 * @param timestamp
	 *            TimeStamp a comparar
	 * @return true si el TimeStamp actual es estrictamente mayor que timestamp,
	 *         false en caso contrario
	 */
	public boolean posteriorA(TimeStamp timestamp) {
		if (this.year > timestamp.getYear()) {
			return true;
		} else if (this.year == timestamp.getYear()) {
			if (this.mes > timestamp.getMes()) {
				return true;
			} else if (this.mes == timestamp.getMes()) {
				if (this.dia > timestamp.getDia()) {
					return true;
				} else if (this.dia == timestamp.getDia()) {
					if (this.hora > timestamp.getHora()) {
						return true;
					} else if (this.hora == timestamp.getHora()) {
						if (this.minuto > timestamp.getMinuto()) {
							return true;
						} else if (this.minuto == timestamp.getMinuto()) {
							if (this.segundo > timestamp.getSegundo()) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

}
