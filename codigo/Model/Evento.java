package Model;
import java.lang.String;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import View.Errores;

/**
 * Long description
 * @author
 * @author
 * @version
 * @since       2015-11-16          
 */

public class Evento {
	/**
	 * Identificador del evento.
	 */
	private int identificador;
	/** Nombre del usuario que creÃ³ el evento
	 * 
	 */
	private String autor;
	/**
	 * Nombre del evento.
	 */
	private String nombre;
	/**
	 * Nombre del lugar donde ocurre el evento.
	 */
	private String lugar;
	/**
	 * Tipo del ambito.
	 */
	private byte ambito;
	/**
	 * La fecha del evento. GregorianCalendar(int year, int month, int dayOfMonth)
	 */
	private GregorianCalendar fecha;
	/**
	 * Objeto de la clase Comentarios que contiene los comentarios del evento.
	 */
	private Comentarios comentarios;					
	/**
	 * Lista de strings de los usuarios inscritos en el evento.
	 */
	private ArrayList<String> usuariosInscritos;
	/**
	 * String que contiene la descripcion del evento.
	 */
	private String descripcion;
	
	/**
	 * Costructor de la clase Evento.
	 * <p>
	 * @param  identificador Entero que identifica el evento.
	 * @param  nombre String que contiene el nombre del evento.
     * @param  lugar String que contiene el lugar donde ocurre el evento.
     * @param  ambito Short que indica el ambito del evento.
     * @param  day Entero que indica el dia del evento.
     * @param  month Entero que indica el mes del evento.
     * @param  year entero que indica el aÃ±o del evento.
     * @param  description String que contiene la descripion del evento.
	 * @return  Objeto de tipo Evento.
	 */
	protected Evento(int identificador, String autor, String nombre, String lugar, byte ambito, int day, int month, int year, String descripcion){
		this.identificador = identificador;
		this.autor = autor;
		this.nombre = nombre;
		this.lugar = lugar;
		this.nombre = nombre;
		this.ambito = ambito;
		this.fecha = new GregorianCalendar(year, month-1, day);
		this.descripcion = descripcion;
		this.comentarios = new Comentarios();
		this.usuariosInscritos = new ArrayList<String>();
	}
	

	public Evento(){
	
	}

	/**
	 * Metodo que devuelve el identificador del evento.
	 * <p>
	 * @return identificador  Entero que identifica el evento.
	 */
	public int getID() {
		return identificador;
	}
	
	/**
	 * Metodo que devuelve el nombre del evento.
	 * <p>
	 * @return nombre String que contiene el nombre del evento.
     */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Metodo que devuelve el lugar del evento.
	 * <p>
	 * @return lugar String que contiene el lugar donde ocurre el evento.
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Metodo que devuelve el tipo de ambito del evento.
	 * <p>
	 * @return ambito Short que indica el ambito del evento.
	 */
	public short getAmbito() {
		return ambito;
	}

	/**
	 * Metodo que devuelve la fecha del evento.
	 * <p>
	 * @return fecha objeto de la clase GregorianCalendar que indica la fecha del evento.
	 */
	public GregorianCalendar getFecha() {
		return fecha;
	}

	/**
	 * Metodo que devueleve la descripcion del evento.
	 * @return descripcion String que contiene la descripcion del evento.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * MÃ©todo que devuelve el nombre del autor
	 * @return autor String que contiene el nombre del autor
	 */
	public String getAutor(){
		return autor;
	}
	
	/**
	 * Metodo que permite conseguir todos los comentarios de un evento.
	 * <p>
	 * @return comentarios Objeto de la clase Comentarios que contiene los comentarios del evento.
	 */
	public Comentarios getComentarios() {
		return comentarios;
	}
	
	/**
	 * Metodo que permite obtener los datos de un evento en String.
	 * <p>
	 * @return datosEvento Lista dinamica de Strings que contiene los datos del evento.
	 */
	public ArrayList<String> getDatosEvento(){
		ArrayList<String> datosEvento = new ArrayList<String>();
		datosEvento.add(autor);
		datosEvento.add(nombre);
		datosEvento.add(lugar);
		datosEvento.add(Byte.toString(ambito));
		datosEvento.add(Integer.toString(fecha.get(GregorianCalendar.YEAR)));
		datosEvento.add(Integer.toString(fecha.get(GregorianCalendar.MONTH)+1));
		datosEvento.add(Integer.toString(fecha.get(GregorianCalendar.DAY_OF_MONTH)));
		datosEvento.add(descripcion);
		ArrayList <String> datosComentarios = comentarios.getDatosComentarios();
		datosEvento.addAll(datosComentarios);
		datosEvento.add(Integer.toString(usuariosInscritos.size()));
		for (int i=0;i<usuariosInscritos.size();i++) datosEvento.add(usuariosInscritos.get(i));
		return datosEvento;
	}

	/**
	 * Metodo que aÃ±ade un comentario al evento.
	 * <p>
	 * @param  usuario Objeto de la clase Usuario que indica el usuario que hace el comentario.
	 * @param  mensaje String que contiene el comentario.
     * @param  day Entero que indica el dia del evento.
     * @param  month Entero que indica el mes del evento.
     * @param  year Entero que indica el aÃ±o del evento.
     * @param  hour Entero que indica lahora del evento.
     * @param  min Entero que indica los minutos del evento.
     * @param  sec Entero que indica los segundos del evento.
	 */
	public void addComentario(Usuario usuario, String mensaje, int day, int month, 
			int year, int hour, int min, int sec) {
		comentarios.addComentario(usuario, mensaje, day, month, year, hour, min, sec);
	}

	/**
     * Metodo que aÃ±ade un comentario al evento.
     * <p>
     * @param  autor String que contiene el nombre del autor del comentario.
     * @param  mensaje String que contiene el comentario.
     * @param  day Entero que indica el dia del evento.
     * @param  month Entero que indica el mes del evento.
     * @param  year Entero que indica el aÃƒÂ±o del evento.
     * @param  hour Entero que indica lahora del evento.
     * @param  min Entero que indica los minutos del evento.
     * @param  sec Entero que indica los segundos del evento.
     * @param  dayUlt Entero que indica el Ultimo dia del evento.
     * @param  monthUlt Entero que indica el ultimo mes del evento.
     * @param  yearUlt Entero que indica el ultimo aÃ±o del evento.
     * @param  hourUlt Entero que indica la ultima hora del evento.
     * @param  minUlt Entero que indica los ultimos minutos del evento.
     * @param  secUlt Entero que indica los ultimos segundos del evento.
     */
	public void addComentario(String autor, String mensaje, int day, int month, 
			int year, int hour, int min, int sec, int dayUlt, int monthUlt, 
			int yearUlt, int hourUlt, int minUlt, int secUlt) {
		comentarios.addComentario(autor, mensaje, day, month, year, hour, min, sec,
				dayUlt, monthUlt, yearUlt, hourUlt, minUlt, secUlt);
	}
	
	/**
	 * Metodo que elimina un comentario dado su id.
	 * <p>
	 * @param  id   Entero que identifica el comentario.
	 */
	public int eliminarComentario(int id){
		int resultado = comentarios.eliminarComentario(id);
		if (resultado == -1 ) Errores.mostrarError(601);
		return resultado;
	}
	
	/**
	 * Metodoa que edita un comentario dado su identificador y la informcaion a editar.                           
	 * <p>
     * @param  id Entero que identifica el evento.
     * @param  nuevoMensaje String que contiene el nuevo comentario.
     * @param  day Entero que indica el dia del evento.
     * @param  month Entero que indica el mes del evento.
     * @param  year Entero que indica el aÃ±o del evento.
     * @param  hour Entero que indica lahora del evento.
     * @param  min Entero que indica los minutos del evento.
     * @param  sec Entero que indica los segundos del evento.
	 * @return 0 Si el comentario a sido editado correctamente.
	 * @return -1 si el comentario con ese id no existe.
	 */
	public int editarComentario(int id, String nuevoMensaje, int day, int month, int year, int hour, int min, int sec){
		int resultado = comentarios.editarComentario(id, nuevoMensaje, day, month, year, hour, min, sec);
		if (resultado == -1 ) Errores.mostrarError(602);
		return resultado;
	}
	
	/**
	 * Metodo que permite editar un evento.
	 * <p>
     * @param  nombre String que contiene el nombre del evento.
     * @param  lugar String que contiene el lugar donde ocurre el evento.
     * @param  ambito Short que indica el ambito del evento.
     * @param  day Entero que indica el dia del evento.
     * @param  month Entero que indica el mes del evento.
     * @param  year entero que indica el aÃ±o del evento.
     * @param  description String que contiene la descripion del evento.
	 */
	public void editarEvento(String nombre, String lugar, byte ambito, int day, int month, int year, String descripcion){
		this.nombre = nombre;
		this.lugar = lugar;
		this.fecha = new GregorianCalendar(year, month-1, day);
		this.ambito = ambito;	
		this.descripcion = descripcion;
	}
	
	/**
	 * Metodo que permite seguir un evento.
	 * <p>
	 * @param  ID String que contiene el identificador del evento.
	 * @return 0 Si el evento a sido seguido correctamente.
	 * @return -1 Si el evento ya esta inscrito.
	 */
	public int seguirEvento(String ID){
		
		if (usuariosInscritos.contains(ID)) {
			Errores.mostrarError(603);
			return -1;
		}
		else usuariosInscritos.add(ID);
		
		return 0;
	}
	
	/**
	 * Metodo que permite dejar de seguir un evento.
     * <p>
     * @param  ID String que contiene el identificador del evento.
     * @return 0 Si el evento ya no esta seguido.
     * @return -1 Si el evento no esta inscrito.
	 */
	public int noSeguirEvento(String ID){
		
		if (!usuariosInscritos.contains(ID)){
			Errores.mostrarError(604);
			return -1;
		}
		else usuariosInscritos.remove(ID);
		
		return 0;
	}
	
	/**
	 * Short one line description.                           
	 * <p>
	 * Longer description. If there were any, it would be    
	 * here.
	 * @param  variable Description text text text.          
	 * @param  variable Description text text text.
	 * @return return Description text text text.
	 * @return return Description text text text.
	 */
	/*
	 * Printea el evento cuando estas viendolo completo, mostrar todos los datos, y los comentarios 
	 * que tenga con comentarios.printComentarios()
	 */
	public void mostrarDatosEvento(){
		//////////////////DALIT AQUÃ�////////////////////
	}
	
	/**
	 * Short one line description.                           
	 * <p>
	 * Longer description. If there were any, it would be    
	 * here.
	 * @param  variable Description text text text.          
	 * @param  variable Description text text text.
	 * @return return Description text text text.
	 * @return return Description text text text.
	 */
	/*
	 * Printea el evento de forma muy resumida para cuando se busquen eventos y salga una lista. Incluir ID
	 */
	public void mostrarEventoResumido(){
		//////////////////DALIT AQUÃ�////////////////////		
	}
	
}
