package Model;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import View.Errores;



/* CONTROL DE CAMBIOS
 * Eventos: CAmbio de año, mes, dia por year, month, day
 * Usuarios: FiltrarUsuarios
 * Usuario: usuariosSeguidos
 * Usuario: seguirUsuario
 * Usuario: noSeguirUsuario
 * import 
 */

/**
 * Long description
 * @author      
 * @author 
 * @version     
 * @since       2015-11-6          
 */

public class Usuarios {
	/**
     * Lista dinamica que va a contener los usuarios.
     */

	private static ArrayList <Usuario> usuarios;
	
	/**
	 * Constructor de la clase Usuario.
	 */
	public Usuarios(){
		usuarios=new ArrayList<Usuario>();
	}
	
	/**
	 * Constructor de la clase Usuarios.
	 */
	public Usuarios(ArrayList<Usuario> nuevosUsuarios){
		usuarios=nuevosUsuarios;	
	}
	
	/**
	 * Metodo que permite obtener un listado de usuarios.                           
	 * <p>
	 * @return ArrayLista listado de los usuarios.
	 */
	public ArrayList<Usuario> getUsuarios(){
		return usuarios;
	}
	
	/**
	 * Metodo que permite obtener los datos de usuarios.                           
	 * <p>
	 * @return ArrayList datos de los usuarios.
	 */
	public ArrayList<String> getDatosUsuarios(){
		ArrayList<String> datosUsuarios = new ArrayList<String>();
		datosUsuarios.add(Integer.toString(usuarios.size()));
		for (int i=0;i<usuarios.size();i++) datosUsuarios.addAll(usuarios.get(i).getDatosUsuario());
		return datosUsuarios;
	}
	
	
    /**
     * Metodo que permite crear un nuevo usuario en la lista de usuarios.
     * <p>
     * @param  tipoDeUsuario Variable boolean que indica el tipo de usuario. TRUE patrocinador, FALSE user.
     * @param  identificador Un String que indica el apodo del usuario. No tiene que ser igual que el nombre.
     * @param  password Un String que contiene la clave del usuario.
     * @param  nombre Un string que contiene el nombre del usuario.
     * @param  apellidos Un string que contiene los apellidos del usuario.
     * @param  lugarDeResidencia Un string que contiene el lugar de residencia del usuario.
     * @param  dayBirth Un entero que indica el dia de nacimiento del usuario.
     * @param  monthBirth Un entero que indica el mes de nacimiento del usuario.
     * @param  yearBirth Un entero que indica el año de nacimiento del usuario.
     * @param  fraseFavorita Un string que contiene la frase favorita del usuario.
     * @param  estadoCivil Un byte que indica el estado civil del usuario Estado civil de la pareja. 0-Solter@, 1-Casad@, 2-En Pareja.
     * @param  sexo Un byte que indica el sexo del usuario.
     * @return null Si el nombre de usuario ya esta en uso.
     * @return usuario El nuevo usuario que se ha sido creado .
     */
	public Usuario registrarUsuario(boolean tipoDeUsuario, String identificador, String password,
			String nombre, String apellidos, String lugarDeResidencia, int dayBirth, int monthBirth, int yearBirth, 
			String fraseFavorita, byte estadoCivil, byte sexo){
		
		if (this.buscarUsuario(identificador)!=null) return null; // Nombre de usuario en uso
		
		Usuario usuario = new Usuario(tipoDeUsuario, identificador, password, nombre, apellidos, lugarDeResidencia, 
				dayBirth, monthBirth, yearBirth, fraseFavorita, estadoCivil, sexo);
		usuarios.add(usuario);
		
		return usuario;
	}
	
	/**
	 * Metodo que permite registar un usuario.                           
	 * <p>
	 * @param  Usuario usuario a registrar.          
	 * @return Usuario usuario registrado.
	 */	
	public Usuario registrarUsuario(Usuario usuario){
		usuarios.add(usuario);
		return usuario;
	}
	
	/**
	 * Metodo que permite eliminar un usuario en la lista de usuarios.
	 * <p>
     * @param  id Un String que contiene el nombre de usuario.
	 * @return 0 El usuario ha sido borrado con exito.
	 * @return -1 El usuario con este nombre no existe.
     * @return -2 El usuario existe pero no se puede borrar.
	 */
	public int eliminarUsuario(String id){
		// Localiza el usuario
		Usuario usuario = buscarUsuario(id);
		if (usuario == null) {
			Errores.mostrarError(901);
			return -1; // El usuario con ese ID no existe
		}
		
		// Intenta borrar el usuario
		if (usuarios.remove(usuario)==true) return 0; // Borrado con éxito
		
		// No se pudo borrar
		Errores.mostrarError(902);
		return -2;
	}
	
	/**
	 * Metodo que permite editar un usuario en la lista de usuarios.
	 * <p>
     * @param  nombre Un string que contiene el nombre del usuario.
     * @param  apellidos Un string que contiene los apellidos del usuario.
     * @param  lugarDeResidencia Un string que contiene el lugar de residencia del usuario.
     * @param  dayBirth Un entero que indica el dia de nacimiento del usuario.
     * @param  monthBirth Un entero que indica el mes de nacimiento del usuario.
     * @param  yearBirth Un entero que indica el año de nacimiento del usuario.
     * @param  fraseFavorita Un string que contiene la frase favorita del usuario.
     * @param  estadoCivil Un byte que indica el estado civil del usuario Estado civil de la pareja. 0-Solter@, 1-Casad@, 2-En Pareja.
     * @param  sexo Un byte que indica el sexo del usuario.
	 * @return 0 Usuario editado con exito.
	 * @return -1 El usuario con ese id no existe.
	 */
	public int modificarUsuario(String id, String nombre, String apellidos, String lugarDeResidencia, int dayBirth, int monthBirth, int yearBirth, 
			String fraseFavorita, byte estadoCivil, byte sexo){
		
		// Localiza el usuario
		Usuario usuario = buscarUsuario(id);
		if (usuario == null) {
			Errores.mostrarError(903);
			return -1; // El usuario con ese ID no existe
		}
		
		// Modifica el usuario
		usuario.editarUsuario(nombre, apellidos, lugarDeResidencia, dayBirth, monthBirth, yearBirth, fraseFavorita, estadoCivil, sexo);
		return 0;		
	}
	
	/**
	 * Metodo que permite mostrar todos los usuarios en la lista de usuarios.
	 * <p>
	 * @return 0 Si se muestra los usuarios.
	 * @return -1 Si la lista de usuarios está vacia.
	 */
	/*public int mostrarUsuarios(){
		Usuario usuario;
		int i;
		
		if (usuarios.isEmpty()) {
			Errores.mostrarError(904);
			return -1; // No hay usuarios registrados
		}
		
		for (i = 0; i<usuarios.size(); i++){
			usuario = usuarios.get(i);
			usuario.mostrarUsuarioResumido();
		}	
		
		return 0;
	}*/
	
	/**
	 * Metodo que permite buscar un usuario por nombre en la lista de usuarios.
	 * <p>
	 * @param  Un string que contiene el nombre de usuario.
	 * @return null Si el nombre de usuario no existe en la lista de usuarios.
	 * @return usuario El perfil de usuaroi que se esta buscando
	 */
	public static Usuario buscarUsuario(String id){
		Usuario usuario;
		int i;
		// Comprueba todos los elementos del array
		for (i = 0; i<usuarios.size(); i++){
			usuario = usuarios.get(i);
			if (usuario.getID().equals(id)) return usuario;		
		}			
		
		// Si no existe un comentario con la ID, devuelve error 
		//Errores.mostrarError(905);
		return null;
	}
	
	public ArrayList<Usuario> filtrarUsuarios(String nombreDeUsuario, String nombre, String apellidos,
			String lugarDeResidencia, int day, int month, int year, byte estadoCivil, String fraseFavorita){
		ArrayList<Usuario> usuariosFiltrados = (ArrayList<Usuario>)usuarios.clone();
		int i;
		Usuario usuarioAnalizando;
		
		if (usuarios.isEmpty()) {
			Errores.mostrarError(906);
			return null;
		}

		for (i=0; i<usuarios.size(); i++){
			usuarioAnalizando=usuarios.get(i);
			if (!nombreDeUsuario.equals("")&&!nombreDeUsuario.equals(usuarioAnalizando.getID())){
				usuariosFiltrados.remove(usuarioAnalizando);
			}
			if (!nombre.equals("")&&!nombre.equals(usuarioAnalizando.getNombre())){
				usuariosFiltrados.remove(usuarioAnalizando);
			}
			if (!apellidos.equals("")&&!apellidos.equals(usuarioAnalizando.getApellidos())){
				usuariosFiltrados.remove(usuarioAnalizando);
			}
			if (!lugarDeResidencia.equals("")&&!lugarDeResidencia.equals(usuarioAnalizando.getLugarDeResidencia())){
				usuariosFiltrados.remove(usuarioAnalizando);
			}
			if (day!=0&&month!=0&&year!=0&&!usuarioAnalizando.getFechaDeNacimiento().equals(new GregorianCalendar(year, month-1, day))){
				usuariosFiltrados.remove(usuarioAnalizando);
			}
			if (estadoCivil!=0&&!(estadoCivil==usuarioAnalizando.getEstadoCivil())){
				usuariosFiltrados.remove(usuarioAnalizando);
			}
			if (!fraseFavorita.equals("")&&!fraseFavorita.equals(usuarioAnalizando.getFraseFavorita())){
				usuariosFiltrados.remove(usuarioAnalizando);
			}
		}
		if (usuariosFiltrados.isEmpty()) return null;
		return usuariosFiltrados;
	}
	
}
