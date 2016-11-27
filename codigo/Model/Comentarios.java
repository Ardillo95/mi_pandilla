package Model;
import java.util.ArrayList;

import View.Errores;

/**
 * Long description
 * @author
 * @author
 * @version
 * @since       2015-11-6          
 */

public class Comentarios {
	/**
	 * Listado de los comentarios que hay en la aplicacion.
	 */
	private ArrayList <Comentario> comentarios;
	/**
	 * Variable para saber que id darle a cada nuevo comentario.
	 */
	private int idCounter;

	/**
	 * Constructor de la clase Comentarios.
	 * <p>
	 * @return comentarios Lista dinamica donde se guardan los comentarios.
	 */
	public Comentarios(){
		comentarios=new ArrayList<Comentario>();	// Array de comentarios
		idCounter = 0;
	}

	/**
	 * Metodo que permite obtener un listado de los datos de los comentarios.                           
	 * <p>
	 * @return ArrayList con los datos de comentarios.
	 */
	public ArrayList<String> getDatosComentarios() {
		ArrayList <String> datos = new ArrayList<String>();
		datos.add(Integer.toString(comentarios.size()));
		for (int i=0;i<comentarios.size();i++) datos.addAll(comentarios.get(i).getDatosComentario());
		return datos;
	}

	/**
	 * Metodo que permite obtener un listado de los comentarios.                           
	 * <p>
	 * @return ArrayList de comentarios.
	 */
	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}	
	
	/**
	 * Metodo que permite anadir un comentario.                           
	 * <p>
	 * @param  Usuario usuario.          
	 * @param  String mensaje.
	 * @param  int day.          
	 * @param  int month.
	 * @param  int year.          
	 * @param  int hour.
	 * @param  int min.          
	 * @param  int sec.
	 * @return int idCounter mas uno porque anadimos el comentario.
	 */
	public int addComentario(Usuario usuario, String mensaje, int day, int month, 
			int year, int hour, int min, int sec){

		// Coge el nombre y apellidos del usuario y los junta en un solo string
		String autor = usuario.getNombre()+" "+usuario.getApellidos();
		comentarios.add(new Comentario(autor, mensaje, day, month, year, hour, min, sec, idCounter));
		return idCounter++;
	}	
	
	/**
	 * Metodo que permite anadir un comentario.                           
	 * <p>
	 * @param  Usuario usuario.          
	 * @param  String mensaje.
	 * @param  int day.          
	 * @param  int month.
	 * @param  int year.          
	 * @param  int hour.
	 * @param  int min.          
	 * @param  int sec.
	 * @param  int dayUlt.          
	 * @param  int monthUlt.
	 * @param  int yearUlt.          
	 * @param  int hourUlt.
	 * @param  int minUlt.          
	 * @param  int secUlt.
	 * @return int idCounter mas uno porque anadimos el comentario.
	 */
	public int addComentario(String autor, String mensaje, int day, int month, 
			int year, int hour, int min, int sec, int dayUlt, int monthUlt, 
			int yearUlt, int hourUlt, int minUlt, int secUlt){
		comentarios.add(new Comentario(autor, mensaje, day, month, year, hour, min, sec, 
				dayUlt, monthUlt, yearUlt, hourUlt, minUlt, secUlt, idCounter));
		return idCounter++;
	}

	/**
	 * Metodo que permite eliminar un comentario.
	 * <p>
	 * @param  int id del comentario.
	 * @return 0  Éxito.
	 * @return -1  Comentario no existe.
	 * @return -2  Comentario existe pero no se pudo borrar.
	 */
	public int eliminarComentario(int id){
		// Localiza el comentario
		Comentario comentario = localizarComentario(id);
		if (comentario == null) {
			Errores.mostrarError(501);
			return -1; // El comentario con esa ID no existe
		}

		// Intenta borrar el comentario
		if (comentarios.remove(comentario)==true) return 0; // Borrado con éxito

		// No se pudo borrar
		Errores.mostrarError(502);
		return -2;
	}

	/**
	 * Metodo que permite editar un comentario.
	 * <p>
	 * @param  int id.          
	 * @param  String nuevoMensaje.
	 * @param  int day.          
	 * @param  int month.
	 * @param  int year.          
	 * @param  int hour.
	 * @param  int min.          
	 * @param  int sec.
	 * @return -1 el comentario no existe.
	 * @return 0 correcto.
	 */
	
	public int editarComentario(int id, String nuevoMensaje, int day, int month, int year, int hour, int min, int sec){
		// Localiza el comentario
		Comentario comentario = localizarComentario(id);
		if (comentario == null) {
			Errores.mostrarError(503);
			return -1; // El comentario con esa ID no existe
		}
		
		// Modifica el comentario, parametros el mensaje y la fecha de modificacion
		comentario.modificarComentario(nuevoMensaje, day, month, year, hour, min, sec);
		return 0;		
	}
	
	/**
	 * Metodo que permite imprimir todos los comentarios.                           
	 * <p>
	 */
	
	public void imprimirComentarios(){
		Comentario comentario;
		int i, size = comentarios.size();
		
		if (size>0) System.out.println("Imprimiendo "+size+" comentarios");
		else if (size==0) Errores.mostrarError(504);
		else{
			//ERROR MUY EXTRAÑO
		}
		
		for (i = 0; i<size; i++){
			comentario = comentarios.get(i);
			
		}
	}
	
	/**
	 * Metodo que permite localizar comentarios.                           
	 * <p>
	 * @param  int id del comentario.          
	 * @return Comentario comentario localizado.
	 */
	public Comentario localizarComentario(int id){
		Comentario comentario;
		int i;
		
		// Comprueba todos los elementos del array
		for (i = 0; i<comentarios.size(); i++){
			comentario = comentarios.get(i);
			if (comentario.getID()==id) return comentario;		
		}

		// Si no existe un comentario con la ID, devuelve error 
		Errores.mostrarError(505);
		return null;
	}
}
