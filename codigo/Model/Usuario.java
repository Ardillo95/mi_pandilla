package Model;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import View.Errores;

/**
 * Long description
 * @author
 * @author
 * @version
 * @since       2015-11-6          
 */

public class Usuario {
	/**
	 * Tipo de usuario. TRUE patrocinador, FALSE usuario.
	 */
	private boolean tipoDeUsuario; 						//TRUE patrocinador, FALSE user						
	/**
	 * Apodo del usuario
	 */
	private String identificador;  						//Nick de usuario no tiene por qué ser el nombre
	/**
	 * Clave del usuario.
	 */
	private String password; 
	/**
	 * Nombre del usuario.
	 */
	private String nombre;
	/**
	 * Apellidos del usuario.
	 */
	private String apellidos;
	/**
	 * Lugar de residencia del usuario.
	 */
	private String lugarDeResidencia;
	/**
	 * Fecha de nacimiento del usuario. GregorianCalendar(int year, int month, int dayOfMonth)
	 */
	private GregorianCalendar fechaDeNacimiento;		// GregorianCalendar int year, int month, int dayOfMonth
	/**
	 * Frase favorita del usuario.
	 */
	private String fraseFavorita;
	/**
	 * Estado civil del usuario. 0-Solter@, 1-Casad@, 2-En Pareja.
	 */
	private byte estadoCivil;							// 0-Solter@, 1-Casad@, 2-En Pareja
	/**
	 * Byte que indica el sexo del usuario.
	 */
	private byte sexo;
	/**
	 * Objeto de tipo comentario que contiene la informcaion del comentario.
	 */
	private Comentarios comentarios;					// Gestión de comentarios con objeto de 
	/**
	 * Lista de eventos en el cual el usuario esta enscrito.
	 */
	private ArrayList <Integer> eventosInscritos; 
	/**
	 * Lista de usuarios en el cual el usuario esta suiguiendo.
	 */
	private ArrayList <String> usuariosSeguidos;

	/**
     * Constructor del la clase Usuario.
     * <p>
     * @return Objeto de tipo Usuario.
	 */
	public Usuario(){
		this.tipoDeUsuario = false;
		this.identificador = "abel";
		this.password = "7D1580236FC7D07B9928A3AE38CB16650DAEDA8EA44A173264DCD585195312B00B680682C990A5E39A69D754F7494F88E2EA52382DCE7FEE09B822BB59E8A0BA";
		this.nombre = "Abel";
		this.apellidos = "Es Tu Madre";
		this.lugarDeResidencia = "Marte";
		this.fechaDeNacimiento = new GregorianCalendar(2000, 0, 1);
		this.estadoCivil = 0;	
		this.fraseFavorita = "Yo soy Abel y tu no";
		this.comentarios = new Comentarios();
		this.sexo = 0;
		this.eventosInscritos = new ArrayList<Integer>();
		this.usuariosSeguidos =new ArrayList<String>();
	}
	
	/**
     * Constructor del la clase Usuario.
     * <p>
     * @param  tipoDeUsuario Variable boolean que indica el tipo de usuario. TRUE patrocinador, FALSE user.
     * @param  identificador Un String que indica el apodo del usuario. No tiene que ser igual que el nombre.
     * @param  password Un String que contiene la clave del usuario.
     * @param  nombre Un string que contiene el nombre del usuario.
     * @param  apellidos Un string que contiene los apellidos del usuario.
     * @param  lugarDeResidencia Un string que contiene el lugar de residencia del usuario.
     * @param  dayBirth Un entero que indica el dia de nacimiento del usuario.
     * @param  monthBirth Un entero que indica el mes de nacimiento del usuario.
     * @param  yearBirth Un entero que indica el aÃ±o de nacimiento del usuario.
     * @param  fraseFavorita Un string que contiene la frase favorita del usuario.
     * @param  estadoCivil Un byte que indica el estado civil del usuario Estado civil de la pareja. 0-Solter@, 1-Casad@, 2-En Pareja.
     * @param  sexo Un byte que indica el sexo del usuario.
     * @return      Objeto de tipo Usuario.
     */
	protected Usuario(boolean tipoDeUsuario, String identificador, String password,
			String nombre, String apellidos, String lugarDeResidencia, int dayBirth, int monthBirth, int yearBirth, 
			String fraseFavorita, byte estadoCivil, byte sexo){
		this.tipoDeUsuario = tipoDeUsuario;
		this.identificador = identificador;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.lugarDeResidencia = lugarDeResidencia;
		this.fechaDeNacimiento = new GregorianCalendar(yearBirth, monthBirth-1, dayBirth);
		this.estadoCivil = estadoCivil;	
		this.fraseFavorita = fraseFavorita;
		this.comentarios = new Comentarios();
		this.sexo = sexo;
		this.eventosInscritos = new ArrayList<Integer>();
		this.usuariosSeguidos =new ArrayList<String>();
	}

	/**
     * Metodo que devuelve el tipo de usuario.
     * <p>
     * @return tipoDeUsuario Variable boolean que indica el tipo de usuario.
     */
	public boolean getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	/**
	 * Metodo que permite obtener los datos del usuario en String
	 * <p>
	 * @return datosUsuario Lista de String que contiene la informacion del usuario.
	 */
	public ArrayList<String> getDatosUsuario() {
		ArrayList<String> datosUsuario = new ArrayList<String>();
		datosUsuario.add(Boolean.toString(tipoDeUsuario));
		datosUsuario.add(identificador);
		datosUsuario.add(password);
		datosUsuario.add(nombre);
		datosUsuario.add(apellidos);
		datosUsuario.add(lugarDeResidencia);
		datosUsuario.add(Integer.toString(fechaDeNacimiento.get(GregorianCalendar.YEAR)));
		datosUsuario.add(Integer.toString(fechaDeNacimiento.get(GregorianCalendar.MONTH)+1));
		datosUsuario.add(Integer.toString(fechaDeNacimiento.get(GregorianCalendar.DAY_OF_MONTH)));
		datosUsuario.add(fraseFavorita);
		datosUsuario.add(Byte.toString(estadoCivil));
		datosUsuario.add(Byte.toString(sexo));		
		ArrayList <String> datosComentarios = comentarios.getDatosComentarios();
		datosUsuario.addAll(datosComentarios);
		datosUsuario.add(Integer.toString(eventosInscritos.size()));
		for (int i=0;i<eventosInscritos.size();i++) datosUsuario.add(Integer.toString(eventosInscritos.get(i)));
		datosUsuario.add(Integer.toString(usuariosSeguidos.size()));
		for (int i=0;i<usuariosSeguidos.size();i++) datosUsuario.add(usuariosSeguidos.get(i));
		return datosUsuario;
	}

	/**
     *  Metodo permite especificar el tipo de usuario.
     * <p>
     * @param  patrocinador Variable boolean que indica el tipo de usuario.
     * @return void
     */
	public void hacerPatrocinador(boolean patrocinador) {
		this.tipoDeUsuario = patrocinador;
	}

	 /**
     * Metodo que devuelve el apodo del usuario.
     * <p>
     * @return identificador Un String que contiene el apodo del usuario.
     */
	public String getID() {
		return identificador;
	}
	
	/**
     * Metodo que devuelve la clave de un usuario.
     * <p>
     * @return password Un String que contiene la clave del usuario.
     */
	public String getPassword(){
		return password;
	}
	
	/**
     * Metodo que permite cambiar la clave de un usuario.
     * <p>
     * @return 0 Si la clave ha sido cambiada con exito.
     * @return -1 Si el usuario introduzca la calve incorrecta.
     * @return -2 Si el usuario falla en introducir correctamente el duplicado de la nueva calve.
     */
	
	public void cambiarPassword(String nuevaPassword){
		password=nuevaPassword;
	}

	/**
     * Metodo que devuelve el nombre de usuario.
     * <p>
     * @return nombre Un String que contiene el nombre del usuario.
     */
	public String getNombre() {
		return nombre;
	}

	/**
     * Metodo que devuelve los apellidos del usuario.
     * <p>
     * @return apellidos Un String que contiene los apellidos del usuario.
     */
	public String getApellidos() {
		return apellidos;
	}

	/**
     * Metodoque devuelve el lugar de residencia del usuario.
     * <p>
     * @return lugarDeResidencia Un String que contiene el lugar de residencia del usuario.
     */
	public String getLugarDeResidencia() {
		return lugarDeResidencia;
	}

	/**
     * Metodo que devuelve la fech de nacimiento del usuario.
     * <p>
     * @return fechaDeNacimiento Un objeto de la clase GregorianCalendar que contiene la fecha de nacimiento del usuario.
     */
	public GregorianCalendar getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}


	/**
	 * Metodo que permite conseguir la frase favorita del usuario                          
	 * <p>
	 * @return fraseFavorita String que contiene la frase favorita del usuario.
	 */
	public String getFraseFavorita() {
		return fraseFavorita;
	}

	/**
     * Metodo que devuelve el estado civil del usuario.
     * <p>
     * @return estadoCivil Un byte que indica el estado civil del usuario. 0-Solter@, 1-Casad@, 2-En Pareja.
     */
	public byte getEstadoCivil() {
		return estadoCivil;
	}

	/**
     * Metodo que devuelve el sexo del usuario.
     * <p>
     * @return sexo Un byte que indica el sexo del usuario.
     */
	public byte getSexo() {
		return sexo;
	}
	
	/**
	 * Metodo que permite los eventos en el cual el usuario esta inscrito                           
	 * <p>
	 * @return eventosInscritos que idevuelve el listado de eventos inscritos por el usuario.
	 */
	public ArrayList <Integer> getEventosInscritos() {
		return eventosInscritos;
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
	public ArrayList <String> getUsuariosSeguidos() {
		return usuariosSeguidos;
	}
	
	/**
	 * Metodo que permite obtener los comentarios.                           
	 * <p>
	 * @return comentarios.
	 */
	public Comentarios getComentarios(){
		return comentarios;
	}

	/**
	 * Metodo que añade un comentario al evento.
	 * <p>
	 * @param  usuario Objeto de la clase Usuario que indica el usuario que hace el comentario.
	 * @param  mensaje String que contiene el comentario.
     * @param  day Entero que indica el dia del evento.
     * @param  month Entero que indica el mes del evento.
     * @param  year Entero que indica el año del evento.
     * @param  hour Entero que indica lahora del evento.
     * @param  min Entero que indica los minutos del evento.
     * @param  sec Entero que indica los segundos del evento.
	 */
	public void addComentario(String autor, String mensaje, int day, int month, 
			int year, int hour, int min, int sec, int dayUlt, int monthUlt, 
			int yearUlt, int hourUlt, int minUlt, int secUlt) {
		comentarios.addComentario(autor, mensaje, day, month, year, hour, min, sec,
				dayUlt, monthUlt, yearUlt, hourUlt, minUlt, secUlt);
	}

	 /**
	 * Metodo que añade un comentario al evento.
	 * <p>
	 * @param  usuario Objeto de la clase Usuario que indica el usuario que hace el comentario.
	 * @param  mensaje String que contiene el comentario.
     * @param  day Entero que indica el dia del evento.
     * @param  month Entero que indica el mes del evento.
     * @param  year Entero que indica el año del evento.
     * @param  hour Entero que indica lahora del evento.
     * @param  min Entero que indica los minutos del evento.
     * @param  sec Entero que indica los segundos del evento.
	 */
	public void addComentario(Usuario usuario, String mensaje, int day, int month, 
			int year, int hour, int min, int sec) {
		comentarios.addComentario(usuario, mensaje, day, month, year, hour, min, sec);
	}
	
	 /**
	 * Metodo que elimina un comentario dado su identificador.
     * <p>
     * @param  id Entero que indica el identificador del comentario.
     * @return 0 Comentario borrado con exito.
     * @return -1 Comnetario con esa id no existe.
     * @return -2 No se pudo borrar.
     */
	public int eliminarComentario(int id){
		int resultado = comentarios.eliminarComentario(id);
		if (resultado == -1) Errores.mostrarError(802);
		return resultado;
	}
	
	/**
     * Metodo que permite modificar un comentario.
     * <p>
     * @param  id Entero que indica el identificador del comentario.
     * @param  nuevoMensaje String que contiene el nuevo comentario.
     * @param  day Entero que indica el dia del comentario.
     * @param  month Entero que indica el mes del comentario.
     * @param  year Entero que indica el aÃ±o del comentario.
     * @param  hour Entero que contiene la hora del comentario.
     * @param  min Entero que contiene los minutos del comentario.
     * @param  sec Entero que contiene los segundos del comentario.
     * @return return Description text text text.
     */
	public int modificarComentario(int id, String nuevoMensaje, int day, int month, int year, int hour, int min, int sec){
		int resultado = comentarios.editarComentario(id, nuevoMensaje, day, month, year, hour, min, sec);
		if (resultado == -1) Errores.mostrarError(803);
		return resultado;
	}
	
		/**
	 * Metodo que permite editar el perfil del usuario                          
	 * <p>
     * @param  nombre Un string que contiene el nombre del usuario.
     * @param  apellidos Un string que contiene los apellidos del usuario.
     * @param  lugarDeResidencia Un string que contiene el lugar de residencia del usuario.
     * @param  dayBirth Un entero que indica el dia de nacimiento del usuario.
     * @param  monthBirth Un entero que indica el mes de nacimiento del usuario.
     * @param  yearBirth Un entero que indica el aÃ±o de nacimiento del usuario.
     * @param  fraseFavorita Un string que contiene la frase favorita del usuario.
     * @param  estadoCivil Un byte que indica el estado civil del usuario Estado civil de la pareja. 0-Solter@, 1-Casad@, 2-En Pareja.
     * @param  sexo Un byte que indica el sexo del usuario.
     * @return void.
     */
	public void editarUsuario(String nombre, String apellidos, String lugarDeResidencia, int dayBirth, int monthBirth, int yearBirth, 
			String fraseFavorita, byte estadoCivil, byte sexo){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.lugarDeResidencia = lugarDeResidencia;
		this.fechaDeNacimiento = new GregorianCalendar(yearBirth, monthBirth-1, dayBirth);
		this.estadoCivil = estadoCivil;	
		this.fraseFavorita = fraseFavorita;
		this.sexo = sexo;
	}
	
	/**
     * Metodo que permite seguir un evento.
     * <p>
     * @param  IDevento Un entero que indica el evento a seguir.
     * @return -1 Si el evento ya esta inscrito.
     * @return 0 cuando se sigue el evento con exito.
     */
	public int seguirEvento(int IDevento){
		Integer ID = Integer.valueOf(IDevento);
		
		if (eventosInscritos.contains(ID)) {
			Errores.mostrarError(804);
			return -1;	
		}
		else eventosInscritos.add(ID);
		
		return 0;
	}
	
	/**
     * Metodo que elimina un evento de la lista de eventos seguidos.
     * <p>
     * @param  IDevento Un entero que indica el evento a eliminar.
     * @return -1 Si el evento no exist en la lista de eventoas seguidos.
     * @return 0 Si el evento ha sido eliminado con exito.
     */
	public int noSeguirEvento(int IDevento){
		Integer ID = Integer.valueOf(IDevento);
		
		if (!eventosInscritos.contains(ID)) {
			Errores.mostrarError(805);
			return -1;
		}
		else eventosInscritos.remove(ID);
		
		return 0;
	}
	
	/**
	 * Metodo que permite a un usuario seguir otro usuario                           
	 * <p>
	 * @param  ID Strig que indica la informacion del usuario a seguir.         
	 * @return 0 Si se encontra el usuario
	 * @return -1 si el usuario con esta id no exista
	 */
	public int seguirUsuario(String ID){
		
		if (usuariosSeguidos.contains(ID)) {
			Errores.mostrarError(805);
			return -1;
		}
		else usuariosSeguidos.add(ID);
		
		return 0;
	}
	
	/**
	 * Metodo que permite a un usuario no seguir otro usuario                           
	 * <p>
	 * @param  ID Strig que indica la informacion del usuario a seguir.         
	 * @return 0 Si se el usuario ha sido no seguido con exito
	 * @return -1 si el usuario con esta id no inscrito
	 */
	public int noSeguirUsuario(String ID){
		
		if (!usuariosSeguidos.contains(ID)) {
			Errores.mostrarError(805);
			return -1;
		}
		else usuariosSeguidos.remove(ID);
		
		return 0;
	}
	
	/**
	 * Metodo que imprime los datos del usuario.
	 * <p>
	 * @return void
	 */
	public void mostrarDatosUsuario(){
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-YYYY");
		//////////////////DALIT AQU�?////////////////////
		System.out.println("Nombre: "+nombre+" "+apellidos);
		System.out.println("Vive en: "+lugarDeResidencia);
		System.out.println("Nacio el: "+formatoFecha.format(fechaDeNacimiento.getTime()));
		System.out.println();
		System.out.println("'"+fraseFavorita+"'");
		System.out.println();
		comentarios.imprimirComentarios();
	}
	
	
		
}