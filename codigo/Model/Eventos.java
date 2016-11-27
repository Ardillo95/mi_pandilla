package Model;
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

public class Eventos {
	/**
     * Una lista dinamica de los objetos Evento que contiene toda la informacion sobre los eventos.
	 */
	private ArrayList <Evento> eventos;
	/**
	 * Description of the variable here.
	 */
	private int idCounter;

	/**
	 * Constructor de la clase Eventos.
	 * <p>
	 * @return eventos Lista dinamica donde se guardan los eventos.
	 */
	public Eventos(){
		eventos=new ArrayList<Evento>();
		idCounter = 0;
	}
	
	/**
	 * Constructor de la clase Eventos.
	 * <p>
	 * @param ArrayList<Evento> nuevos eventos.
	 * @return eventos Lista dinamica donde se guardan los eventos.
	 */
	public Eventos(ArrayList<Evento> nuevosEventos){
		eventos=nuevosEventos;	
		idCounter = nuevosEventos.size();
	}
	
	/**
	 * Metodo que devuelve el idCounter.                           
	 * <p>
	 * @return int idCounter.
	 */
	public int getIdCounter() {
		return idCounter;
	}
	
	/**
	 * Metodo que permite obtener la lista dinamica que contiene todos los eventos.
	 * <p>
	 * @return eventos Lista dinamica que contiene todos los eventos.
	 */
	public ArrayList<Evento> getEventos(){
		return eventos;
	}
	
	/**
	 * Metodo que permite obtener las informaciones de todos lo eventos en Strings.
	 * <p>
	 * @return datos Lista dinamica que contiene la informacion de todos los eventos en String.
	 */
	public ArrayList<String> getDatosEventos(){
		ArrayList<String> datos = new ArrayList<String>();
		
		datos.add(Integer.toString(eventos.size()));
		for (int i=0;i<eventos.size();i++) datos.addAll(eventos.get(i).getDatosEvento());
		return datos;
	}

	/**
	 * Metodo que permite añadir un nuevo evento.
	 * <p>
     * @param  nombre String que contiene el nombre del evento.
     * @param  lugar String que contiene el lugar donde ocurre el evento.
     * @param  ambito Short que indica el ambito del evento.
     * @param  day Entero que indica el dia del evento.
     * @param  month Entero que indica el mes del evento.
     * @param  year entero que indica el año del evento.
     * @param  description String que contiene la descripion del evento.
	 * @return void 
	 */
	public int addEvento(String autor, String nombre, String lugar, byte ambito, int day, int month, int year, String descripcion){
		eventos.add(new Evento(idCounter, autor, nombre, lugar, ambito, day, month, year, descripcion));	
		return idCounter++;
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
	/*No estoy seguro de si es necesaria
	   public void addEventos(ArrayList<Evento> nuevosEventos){
		for (int i=0; i<nuevosEventos.size(); i++) eventos.add(nuevosEventos.get(i));
	}*/

	/**
	 * Metodo que permite eliminar un evento.
	 * <p>
	 * @param  id Entero que permite identificar un evento.
	 * @return 0 Evento borrado con exito.
	 * @return -1 Evento con esa id no existe.
     * @return -2 Evento existe pero no se pudo borrar.
	 */
	public int eliminarEvento(int id){
		// Localiza el evento
		Evento evento = buscarEvento(id);
		if (evento == null) {
			Errores.mostrarError(701);
			return -1; // El evento con esa ID no existe
		}

		// Intenta borrar el evento
		if (eventos.remove(evento)==true) return 0; // Borrado con exito

		// No se pudo borrar
		Errores.mostrarError(702);
		return -2;
	}

	/**
	 * Metodo  que permite editar un evento dado su id.
	 * <p>
     * @param  id Entero que permite identificar un evento.
     * @param  nombre String que contiene el nombre del evento.
     * @param  lugar String que contiene el lugar donde ocurre el evento.
     * @param  ambito Short que indica el ambito del evento.
     * @param  day Entero que indica el dia del evento.
     * @param  month Entero que indica el mes del evento.
     * @param  year entero que indica el año del evento.
     * @param  description String que contiene la descripion del evento.
	 * @return 0 Evento modificado con exito.
	 * @return -1 El evento con esa id no existe.
	 */
	public int editarEvento(int id, String nombre, String lugar, byte ambito, int day, int month, int year, String descripcion){
		// Localiza el evento
		Evento evento = buscarEvento(id);
		if (evento == null) {
			Errores.mostrarError(703);
			return -1; // El evento con esa ID no existe
		}
		
		// Modifica el evento
		evento.editarEvento(nombre, lugar, ambito, day, month, year, descripcion);
		return 0;		
	}
	
	/**
	 * Metodo que permite mostrar todos los eventos de le lista de evento.
	 * <p>
	 * @return void
	 */
	public void mostrarEventos(){
		Evento evento;
		int i;
		
		if (eventos.size()==0) Errores.mostrarError(704);
		
		for (i = 0; i<eventos.size(); i++){
			evento = eventos.get(i);
			evento.mostrarEventoResumido();
		}		
	}
	
	/**
	 * Metodo que permite comentar un evento dado su id.
	 * <p>
     * @param  id Entero que indica el identificador del evento.
     * @param  usuario Objeto de tipo Usuario que contiene la informcaion del usuario que hace el comentario.
     * @param  Mensaje String que contiene el comentario.
     * @param  day Entero que indica el dia del comentario.
     * @param  month Entero que indica el mes del comentario.
     * @param  year Entero que indica el año del comentario.
     * @param  hour Entero que contiene la hora del comentario.
     * @param  min Entero que contiene los minutos del comentario.
     * @param  sec Entero que contiene los segundos del comentario.
	 * @return return Description text text text.
	 * @return return Description text text text.
	 */
	public Evento buscarEvento(int id){
		Evento evento;
		int i;
		
		// Comprueba todos los elementos del array
		for (i = 0; i<eventos.size(); i++){
			evento = eventos.get(i);
			if (evento.getID()==id) return evento;		
		}

		// Si no existe un evento con la ID, devuelve error 
		Errores.mostrarError(705);
		return null;
	}
	
	/**
	 * Metodo que permite comentar un evento.
	 * <p>
	 * @param  id Entero que indica el identificador del evento.
	 * @param  usuario Objeto de la clase Usuario que contiene las informaciones del ususario.
	 * @return return Description text text text.
	 * @return return Description text text text.
	 */
	public void comentarEvento(int id, Usuario usuario, String mensaje, int day, int month, int year, int hour, int min, int sec){
		Evento evento = buscarEvento(id);
		evento.addComentario(usuario, mensaje, day, month, year, hour, min, sec);
	}
	
	/**
	 * Metodo que permite Obtener una lista de eventos dado un cierto filtro
	 * <p>
     * @param  nombre String que contiene el nombre del evento.
     * @param  lugar String que contiene el lugar donde ocurre el evento.
     * @param  dia Entero que indica el dia del evento.
     * @param  mes Entero que indica el mes del evento.
     * @param  aÃ±o entero que indica el aÃ±o del evento.
     * @param  ambito Byte que indica el ambito del evento.
     * @param  usuarioInscrito Byte que indica el ambito del evento.
     * @return null Si no se ha encontrado ningun evento con la informacion mostrada en el filtro.
     * @return eventosFiltrados Lista de objetos Evento que contiene todos los eventos con la informacion del filtro.
     */
	public ArrayList<Evento> filtrarEventos(String nombreEvento, String lugar, int day, int month, 
			int year, byte ambito, String usuarioInscrito){
		ArrayList<Evento> eventosFiltrados = (ArrayList<Evento>) eventos.clone();
		int i;
		Evento eventoAnalizando;
		
		if (eventos.size()<=0) {
			Errores.mostrarError(706);
			return null;
		}

		for (i=0; i<eventos.size(); i++){
			eventoAnalizando=eventos.get(i);
			if (!nombreEvento.equals("")&&!nombreEvento.equals(eventoAnalizando.getNombre())){
				eventosFiltrados.remove(eventoAnalizando);
			}
			if (!lugar.equals("")&&!lugar.equals(eventoAnalizando.getLugar())){
				eventosFiltrados.remove(eventoAnalizando);
			}
			if (ambito!=0&&!(ambito==eventoAnalizando.getAmbito())){
				eventosFiltrados.remove(eventoAnalizando);
			}
			if (day!=0&&month!=0&&year!=0&&!eventoAnalizando.getFecha().equals(new GregorianCalendar(year, month-1, day))){
				eventosFiltrados.remove(eventoAnalizando);
			}
		}
		if (eventosFiltrados.isEmpty()) return null;

		return eventosFiltrados;
	}
}
