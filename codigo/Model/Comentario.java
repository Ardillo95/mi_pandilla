package Model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Long description
 * @author
 * @author
 * @version
 * @since       2015-11-6
 */

public class Comentario {
	/**
	 * Autor del comentario.
	 */
	private String autor;
	/**
	 * La fecha del comentario. GregorianCalendar(year, month, date, hrs, min, sec)
	 */
	private GregorianCalendar fecha;
	/**
	 * El texto del comentario.
	 */
	private String mensaje;
	/**
	 * El identificador unico del comentario.
	 */
	private int id;
	/**
	 * La fecha de la ultima modificacion del comentario. GregorianCalendar(year, month, date, hrs, min, sec)
	 */
	private GregorianCalendar fechaUltimaModificacion;
	
	/**
	 * Elconstructor de la clase Comentario.
	 * <p>
     * @param  autor String que contiene el nombre del autor del comentario.
     * @param  mensaje String que contiene el comentario.
     * @param  day Entero que indica el dia del comentario.
     * @param  month Entero que indica el mes del comentario.
     * @param  year Entero que indica el año del comentario.
     * @param  hour Entero que indica lahora del comentario.
     * @param  min Entero que indica los minutos del comentario.
     * @param  sec Entero que indica los segundos del comentario.
     * @param  id Entero que identifica el comentario.
	 */
	public Comentario(String autor, String mensaje, int day, int month,
			int year, int hour, int min, int sec, int id){
		this.autor = autor;
		this.mensaje = mensaje;
		//month-1 porque los numera de 0 a 11
		this.fecha = new GregorianCalendar(year, month-1, day, hour, min, sec);
		this.fechaUltimaModificacion = new GregorianCalendar(year, month-1, day, hour, min, sec);
		this.id = id;
	}

	/**
	 * Elconstructor de la clase Comentario.
	 * <p>
     * @param  autor String que contiene el nombre del autor del comentario.
     * @param  mensaje String que contiene el comentario.
     * @param  day Entero que indica el dia del comentario.
     * @param  month Entero que indica el mes del comentario.
     * @param  year Entero que indica el aÃ±o del comentario.
     * @param  hour Entero que indica lahora del comentario.
     * @param  min Entero que indica los minutos del comentario.
     * @param  sec Entero que indica los segundos del comentario.
     * @param  id Entero que identifica el comentario.
	 */
	public Comentario(String autor, String mensaje, int day, int month,
			int year, int hour, int min, int sec, int dayUlt, int monthUlt,
			int yearUlt, int hourUlt, int minUlt, int secUlt, int id){
		this.autor = autor;
		this.mensaje = mensaje;
		//month-1 porque los numera de 0 a 11
		this.fecha = new GregorianCalendar(year, month-1, day, hour, min, sec);
		this.fechaUltimaModificacion = new GregorianCalendar(yearUlt, monthUlt-1, dayUlt, hourUlt, minUlt, secUlt);
		this.id = id;
	}

	/**
	 * Metodo que devuelve el autor de un comentario.
	 * <p>
	 * @return autor String que contiene el nombre del autor del comentario.
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Metodo que devuelve la fecha de un comentario.
	 * <p>
	 * @return fecha Objeto de tipo GegorianClendar que contiene la fecha del comentario.
	 */
	public GregorianCalendar getFecha() {
		return fecha;
	}

	/**
	 * Metodo que devuelve la fecha de la ultima modificacion del comentario.
	 * <p>
	 * @return fechaUltimaModificacion  Objeto de tipo GegorianClendar que contiene la fecha de la ultima modificacion del comentario.
	 */
	public GregorianCalendar getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	/**
	 * Metodo que devuelve el texto del comentario.
	 * <p>
	 * @return mensaje String que contiene el texto del mensaje.
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Metodo que devuelve el identificador unico del comentario.
	 * <p>
	 * @return id Entero que indica el identificador unico del comentario.
	 */
	public int getID(){
		return id;
	}
	
	/**
	 * Metodo que permite recuperar los datos de un comentario.                           
	 * <p>
	 * Longer description. If there were any, it would be    
	 * here.
	 * @return ArrayList<String> con los datos del comentario.
	 */
	public ArrayList<String> getDatosComentario() {
		ArrayList <String> datos = new ArrayList<String>();
		datos.add(autor);
		datos.add(Integer.toString(fecha.get(GregorianCalendar.YEAR)));
		datos.add(Integer.toString(fecha.get(GregorianCalendar.MONTH)));
		datos.add(Integer.toString(fecha.get(GregorianCalendar.DAY_OF_MONTH)+1));
		datos.add(Integer.toString(fecha.get(GregorianCalendar.HOUR)));	
		datos.add(Integer.toString(fecha.get(GregorianCalendar.MINUTE)));	
		datos.add(Integer.toString(fecha.get(GregorianCalendar.SECOND)));		
		
		datos.add(mensaje);
		datos.add(Integer.toString(fechaUltimaModificacion.get(GregorianCalendar.YEAR)));
		datos.add(Integer.toString(fechaUltimaModificacion.get(GregorianCalendar.MONTH)));
		datos.add(Integer.toString(fechaUltimaModificacion.get(GregorianCalendar.DAY_OF_MONTH)+1));
		datos.add(Integer.toString(fechaUltimaModificacion.get(GregorianCalendar.HOUR)));	
		datos.add(Integer.toString(fechaUltimaModificacion.get(GregorianCalendar.MINUTE)));	
		datos.add(Integer.toString(fechaUltimaModificacion.get(GregorianCalendar.SECOND)));
		
		return datos;
	}	

	/**
	 * Metodo que permite modificar un comentario.
	 * <p>
     * @param  nuevoMensaje String que contiene el nuevo comentario.
     * @param  day Entero que indica el dia del evento.
     * @param  month Entero que indica el mes del evento.
     * @param  year Entero que indica el año del evento.
     * @param  hour Entero que indica lahora del evento.
     * @param  min Entero que indica los minutos del evento.
     * @param  sec Entero que indica los segundos del evento.
	 * @return void 
	 */
	public void modificarComentario(String nuevoMensaje, int day, int month, int year, int hour, int min, int sec){
		this.mensaje = nuevoMensaje;
		this.fechaUltimaModificacion = new GregorianCalendar(year, month-1, day, hour, min, sec);
	}

	

}
