package Controlador;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Comentarios;
import Model.Evento;
import Model.Eventos;
import Model.Model;
import Model.Usuario;
import Model.Usuarios;
import View.Errores;
import View.View;

/**
 * Long description
 * @author      
 * @author 
 * @version     
 * @since       2015-11-6          
 */
public final class Controller {
	
	/**
	 * Variable que permite la correcta evolucion del programa
	 * y su funcionamiento.
	 * Permite al programa saber cual es la seccion siguiente a ejecutar.
	 */
	private static int resultado;						
												

	static Scanner opcion = new Scanner(System.in);
	
	/**
	 * Metodo que limpia la informacion del terminal, dejando
	 * solo la necesaria.                           
	 * <p>
	 * @return 0.
	 */
	public static int limpiarConsola() {
		View.limpiarPantalla();
		return 0;
	}
	/**
	 * Metodo que redimensiona el terminal.                          
	 * <p>
	 * @return 0 todo correcto y volvemos al menu principal.
	 */
	public static int redimensionarConsola() {
		View.redimensionarPantalla();
		return 0;
	}
	
	/**
	 * Metodo que representa al menu de la aplicacion.                          
	 * <p>
	 * @return -1 hubo error.
	 * @return 0 todo correcto y volvemos al menu principal.
	 */
	public static int inicio() {
		View.mostrarInicio();				// representa el menu
		if ((resultado = Model.opcionInicio()) == -1) {	// accion seleccionar una opcion, si -1 error
			Errores.mostrarError(101);
			resultado = 0;							// 0 por que volveria al menu principal
		}
		return resultado;
	}
	
/**
	 * Metodo que permite el inicio de sesion y muestra el menu de inicio de sesion.                           
	 * <p>
	 * @param  Usuario usuarios.          
	 * @return Usuario usuario que inicio la sesion.
	 */
	public static Usuario iniciarSesion(Usuarios usuarios) {	// Devuelve objeto de tipo Usuario por que devuelve al usuario que inicio sesion
		View.mostrarLogin();						// Representa el menu del login
		return Model.iniciarSesion(usuarios);	// Inicia sesion
	}
	
	/**
	 * Metodo que permite el registro de usuario y muestra el menu de registro.                           
	 * <p>
	 * @param  Usuarios usuarios.          
	 * @return usuario que se registro.
	 */
	public static Usuario registrarUsuario(Usuarios usuarios) {// Devuelve objetgo de tipo Usuario porque devuielve al usuario que se registro
		View.mostrarRegistro();					// Representar menu de registro
		Usuario usuario = Model.registrarUsuario(usuarios);// Registrar usuario
		exportarUsuarios("Usuarios.txt", usuarios);
		return usuario; 
	}
	
	/**
	 * Metodo que representa el menu principal de la aplicacion.                           
	 * <p>
	 * @return	-1 hubo error al seleccionar alguna opcion.
	 * @return 0 correcto y volvemos al menu principal.
	 */
	public static int menuPrincipal() {
		View.mostrarMenu();								// representa el menu
		if((resultado = Model.opcionMenu()) == -1) {	// accion seleccionar una opcion
			Errores.mostrarError(102);
			resultado = 0;	// Vuelve al menu principal
		}	
		return resultado;
	}
	
	/**
	 * Metodo que permite buscar eventos.                           
	 * <p>
	 * @param  Eventos eventos.          
	 * @param  Eventos eventosPromocionados.
	 * @return Evento evento, el evento buscado.
	 */
	public static Evento buscarEventos(Eventos eventos, Eventos eventosPromocionados) {  // Devuelve objeto de tipo Evento porque devuelve el evento buscado
		ArrayList<Evento> eventosFiltrados = new ArrayList<Evento>();
		//ArrayList<Evento> eventosPromocionadosFiltrados = new ArrayList<Evento>();
		
		Evento eventoSeleccionado = new Evento();
		boolean resultado = true, finalDeLaLista = false;
		int identificador;
		int pagina = 1;
		
		View.mostrarFiltroEventos();
		
		eventosFiltrados.addAll(Model.filtrarEventos(eventos));

		//eventosPromocionadosFiltrados.addAll(Model.filtrarEventos(eventosPromocionados));
		
		if (eventosFiltrados == null || eventosFiltrados.size()<1) {
			Errores.mostrarError(103);
			return null;					// Si no encuentra eventos, vuelve al menu principal
		}
		
		Eventos eventosFiltradosObj = new Eventos(eventosFiltrados);
		//Eventos eventosPromocionadosFiltradosObj = new Eventos(eventosPromocionadosFiltrados);
		
		while(resultado) {					// Encuenta eventos por loq eu ahora te pide que selecciones uno oq eu te desplaces por la lista para ver mas
			finalDeLaLista = View.mostrarEventos(eventosFiltradosObj, eventosPromocionados, pagina); // finalDeLaLista = true si llega a la ultima pagina
			
			System.out.println("Selecciona una opcion: 0-mostrar mas eventos, 1-salir, 2-ver evento de uno de los eventos mostrados");
			int seleccion = 0;
			try
	        {
				seleccion = opcion.nextInt();
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	            opcion.nextLine();
	        }
			switch(seleccion) {
			case 0: 		// Opcion 0, siguiente pagina, si pagina == ultimaPagina, se quedsa en esa pagina
				finalDeLaLista = View.mostrarEventos(eventosFiltradosObj, eventosPromocionados, pagina);
				break;
			case 1:			// Opcion 2, pagina anterior, si pagina == 1, se queda en esa pagina
				return null;
			case 2:
				System.out.println("Introduce el identificador del evento que deseas ver");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				try{ 
					identificador = Integer.parseInt(br.readLine());
					System.out.println(identificador);
					eventoSeleccionado = eventos.buscarEvento(identificador);
					return eventoSeleccionado;
				}catch (IOException e){
					System.out.println("error");
				}
				break;
			default:           // opcion erronea
				Errores.mostrarError(104);
				break;
			}
		}
		return null;
	}
	
	/**
	 * Metodo que permite buscar usuarios y muestra la informacion correspondiente.                           
	 * <p>
	 * @param  Usuarios usuarios.          
	 * @return Usuario usuario, el usuario que buscabamos.
	 */
	public static Usuario buscarUsuarios(Usuarios usuarios) { 		// Igual que buscar eventos
		ArrayList<Usuario> usuariosFiltrados = new ArrayList<Usuario>();
		Usuario usuarioSeleccionado = null;
		int result = 0;
		String identificator; 
		boolean resultado = true, finalDeLaLista = false;
		int pagina = 1;
		
		View.mostrarFiltroUsuarios();
		
		usuariosFiltrados = Model.filtrarUsuarios(usuarios);
		Usuarios usuariosFiltradosObjc = new Usuarios(usuariosFiltrados);
		
		if (usuariosFiltrados == null || usuariosFiltrados.size()<1) {
			Errores.mostrarError(105);
			return null;					// Si no encuentra usuarios, vuelve al menu principal
		}
		while(resultado) {
			if (finalDeLaLista)
				pagina = 1;
			finalDeLaLista = View.mostrarUsuarios(usuariosFiltradosObjc);
			
			System.out.println("Selecciona una opcion: 0-mostrar mas usuario, 1-salir, 2-ver perfil de uno de los usuarios mostrados ");
			int seleccion = 0;
			try
	        {
				seleccion = opcion.nextInt();
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	            opcion.nextLine();
	        }
			switch(seleccion) {
			case 0: 		// Opcion 0, siguiente pagina, si pagina == ultimaPagina, se quedsa en esa pagina
				finalDeLaLista = View.mostrarUsuarios(usuariosFiltradosObjc);
				break;
			case 1: 
				return null;
			case 2:		// Opcion de salir de esta seccion
				System.out.println("Introduce el identificador del usuario que deseas ver");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				try{ 
					identificator = br.readLine();
					usuarioSeleccionado = Usuarios.buscarUsuario(identificator);
					return usuarioSeleccionado;
				}catch (IOException e){
					System.out.println("error");
				}
			default:
				Errores.mostrarError(106);
				break;
			}
		}
		return usuarioSeleccionado;
	}

	/**
	 * Metodo que permite mostrar el perfil de un usuario.                           
	 * <p>
	 * @param  Usuario usuario, usuario del que se mostrara el perfil.          
	 * @return -1 hubo error.
	 * @return 0 correcto.
	 */
	public static int verPerfil(Usuario usuario, Eventos eventos) {
		View.mostrarPerfil(usuario, eventos);			// representa el perfil de usuario
		if ((resultado = Model.opcionPerfil()) == -1) {	// accion seleccionar una opcion
			Errores.mostrarError(107);
			resultado = 0;
		}
		return resultado;
	}
	
	/**
	 * Metodo que permite modificar el perfil de usuario y muestra el menu correspondiente.                           
	 * <p>
	 * @param  Usuarios usuarios.          
	 * @param  Usuario usuario.
	 * @return .
	 */
	public static int modificarPerfil(Usuarios usuarios, Usuario usuario) {  // Devuelve objeto de dipo Usuario por que devuelve el nuevo usuario modificado
		View.modificarPerfil();
		return Model.modificarPerfil(usuarios, usuario);
	}
	
	/**
	 * Metodo que permite eliminar un perfil de usuario.                           
	 * <p>
	 * Longer description. If there were any, it would be    
	 * here.
	 * @param  Usuarios usuarios.          
	 * @param  Usuario usuario.
	 * @return 4 error y vuelvo al menu principal.
	 * @return 0 El usuario ha sido borrado con exito.
	 * @return -1 El usuario con este nombre no existe.
     * @return -2 El usuario existe pero no se puede borrar.
	 */
	public static int eliminarPerfil(Usuarios usuarios, Usuario usuario) {
		if ((resultado = usuarios.eliminarUsuario(usuario.getID())) != -2)
			System.out.println("Cuenta de usuario eliminada.");
		else {				// Si no se puede eliminar la cuenta de usuario
			Errores.mostrarError(108);
			resultado = 4;					// Vuelve al men� principal
		}
		return resultado;
	}
	
	/**
	 * Metodo que permite mostrar un evento.                           
	 * <p>
	 * Longer description. If there were any, it would be    
	 * here.
	 * @param  Evento evento.          
	 * @return -1 error.
	 */
	public static int verEvento(Evento evento) {
		View.mostrarEvento(evento);			// representa el perfil del evento
		if ((resultado = Model.opcionEvento()) == -1) {	// accion seleccionar una opcion
			Errores.mostrarError(109);
			resultado = 0;
		}
		return resultado;
	}
	
	/**
	 * Metodo que permite crear un evento y muestra el menu correspondiente.                           
	 * <p>
	 * Por defecto lo exporta como evento no patrocinado.   
	 * Si se quiere patrocinar, sera exportado posteriormente.
	 *
	 * @param  Usuario usuario que crea el evento.          
	 * @param  Eventos eventos.
	 * @return Evento evento que se crea.
	 */
	public static int crearEvento(Usuario usuario, Eventos eventos) {
		View.mostrarCrearEvento();
		
		int evento = Model.crearEvento(usuario, eventos);
		exportarEventos("Eventos.txt", eventos);			// Exporta por defecto al crear como evento no patrocinado. Si se quiere patrocinar, sera exportado posteriormente
		
		return evento; 			// Crear evento, devuelve 4
	}
	
	/**
	 * Metodo que permite modificar un evento y muestra el menu correspondiente.                           
	 * <p>
	 * @param  Usuario usuario que modifica el evento.          
	 * @param  Evento evento a modificar.
	 * @return 4 error al comprobar par usuario-idautor.
	 */
	public static int modificarEvento(Usuario usuario, Evento evento) {
		if (evento.getAutor().equals(usuario.getID()) != true) {
			Errores.mostrarError(110);
			return 4;
		}
		View.mostrarModificarEvento();
		return Model.modificarEvento(usuario, evento);
	}
	
	/**
	 *Metodo que elimina un evento.                           
	 * <p>
	 * @param  Usuario usuario.          
	 * @param  Eventos eventos.
	 * @param  Evento evento a eliminar.
	 * @return 4 error al comprobar par usuario-idautor o no se puede eliminar evento.
	 * @return -2 se pudo eliminar el evento.
	 */
	public static int eliminarEvento(Usuario usuario, Eventos eventos, Evento evento) {
		if (evento.getAutor().equals(usuario.getID()) != true) {
			Errores.mostrarError(111);
			return 4;
		}
		if ((resultado = eventos.eliminarEvento(evento.getID())) != -2)
			System.out.println("Evento eliminado.");
		else {				// Si no se puede eliminar el evento
			Errores.mostrarError(112);
			resultado = 4;					// Vuelve al men� principal
		}
		return resultado;
	}
	
	/**
	 * Metodo que permite seguir un evento.                           
	 * <p>
	 * @param  Usuario usuario que sigue el evento.          
	 * @param  Evento evento a seguir.
	 * @return 4.
	 */
	public static int seguirEvento(Usuario usuario, Evento evento) {
		if ((resultado = usuario.seguirEvento(evento.getID())) == -1) 
			Errores.mostrarError(113);
		return 4;
	}
	
	/**
	 * Metodo que permite dejar de seguir un evento.                           
	 * <p>
	 * @param  Usuario usuario que sigue el evento.          
	 * @param  Evento evento a seguir.
	 * @return 4.
	 */
	public static int noSeguirEvento(Usuario usuario, Evento evento) {
		if ((resultado = evento.noSeguirEvento(usuario.getID())) == -1) 
			Errores.mostrarError(114);
		return 4;
	}
	
	/**
	 * Metodo que permite ver la informacion de un usuario.                           
	 * <p>
	 * Longer description. If there were any, it would be    
	 * here.
	 * @return 0 correcto.
	 */
	public static int verUsuario(Usuario usuario, Eventos eventos) {
		View.mostrarUsuario(usuario, eventos);		// representa el perfil de usuario
		int resultado = 0;
		if ((resultado = Model.opcionUsuario()) == -1) {	// accion seleccionar una opcion
			Errores.mostrarError(115);
			resultado = 0;
		}
		return resultado;
	}
	
	/**
	 * Metodo que permite seguir a un usuario.                           
	 * <p>
	 * @param  Usuario usuario.          
	 * @param  Usuario usuarioSeleccionado, al que se va a seguir.
	 * @return 4.
	 */
	public static int seguirUsuario(Usuario usuario, Usuario usuarioSeleccionado) {
		if ((resultado = usuario.seguirUsuario(usuarioSeleccionado.getID())) == -1) 
			Errores.mostrarError(116);
		return 4;
	}
	
	/**
	 * Metodo que permite dejar de seguir a un usuario.                           
	 * <p>
	 * @param  Usuario usuario.          
	 * @param  Usuario usuarioSeleccionado, al que se va a dejar de seguir.
	 * @return 4.
	 */
	public static int noSeguirUsuario(Usuario usuario, Usuario usuarioSeleccionado) {
		if ((resultado = usuarioSeleccionado.noSeguirUsuario(usuario.getID())) == -1) 
			Errores.mostrarError(117);
		return 4;
	}
	
	/**
	 * Metodo que permite ver el tablon.                           
	 * <p>
	 * @param  Usuario usuario.          
	 * @return 0.
	 */
	public static int verTablon(Usuario usuario) {
		View.mostrarComentarios(usuario.getComentarios());
		int resultado = 0;
		if ((resultado = Model.opcionComentario()) == -1) {	// accion seleccionar una opcion
			Errores.mostrarError(115);
			resultado = 0;
		}
		return resultado;
	}
	
	/**
	 * Metodo que permite comentar en un evento.                           
	 * <p>
	 * @param  Evento evento a comentar.          
	 * @param  Usuario usuario que comenta.
	 * @return 4.
	 */
	public static int comentarEvento(Evento evento, Usuario usuario) {
		Model.comentarEvento(evento, usuario);
		return 4;
	}
	
	/**
	 * Metodo que permite comentar a un usuario.                           
	 * <p>
	 * @param  Usuario usuarioSeleccionado, a quien comentaremos.          
	 * @param  Usuario usuario, quien comenta.
	 * @return 4.
	 */
	public static int comentarUsuario(Usuario usuarioSeleccionado, Usuario usuario) {
		Model.comentarUsuario(usuarioSeleccionado, usuario);
		return 4;
	}
	
	/**
	 * Metodo que permite exportar los ficheros de la aplicacion.                           
	 * <p>
	 * @param  String nombreFicheroEventos.          
	 * @param  String nombreFicheroEventosPatrocinados.
	 * @param  String nombreFicheroUsuarios.          
	 * @param  Eventos eventos.
	 * @param  Eventos eventosPatrocinados.          
	 * @param  Usuarios usuarios.
	 * @return -1 error.
	 * @return 0 correcto.
	 */
	public static int exportar(String nombreFicheroEventos, String nombreFicheroEventosPatrocinados, String nombreFicheroUsuarios,
			Eventos eventos, Eventos eventosPatrocinados, Usuarios usuarios){
		return exportarEventos(nombreFicheroEventos, eventos)+exportarEventos(nombreFicheroEventosPatrocinados, eventosPatrocinados)
				+exportarUsuarios(nombreFicheroUsuarios, usuarios);
	}
	
	/**
	 * Metodo que permite exportar los eventos a un fichero.                           
	 * <p>
	 * @param  String nombreFicheroEventos.          
	 * @param  Eventos eventos.
	 * @return -1 IOException.
	 * @return 0 correcto.
	 */
	public static int exportarEventos(String nombreFicheroEventos, Eventos eventos){
		try {
			FileWriter file = new FileWriter(nombreFicheroEventos);
			BufferedWriter buffer = new BufferedWriter(file);

			ArrayList <String> datos = eventos.getDatosEventos();
			for (int i=0;i<datos.size();i++){
				buffer.write(datos.get(i));
				buffer.newLine();
			}
			buffer.close();
			
		}
		catch (IOException ex){
			return -1;
		}
		
		return 0;
	}
	
	/**
	 * Metodo que permite exportar los usuarios a un fichero.                           
	 * <p>
	 * @param  String nombreFicheroUsuaros.          
	 * @param  Usuarios usuarios.
	 * @return -1 IOException.
	 * @return 0 correcto.
	 */
	public static int exportarUsuarios(String nombreFicheroUsuarios, Usuarios usuarios){
		try {
			FileWriter file = new FileWriter(nombreFicheroUsuarios);
			BufferedWriter buffer = new BufferedWriter(file);

			ArrayList <String> datos = usuarios.getDatosUsuarios();
			for (int i=0;i<datos.size();i++){
				buffer.write(datos.get(i));
				buffer.newLine();
			}
			buffer.close();
			
		}
		catch (IOException ex){
			return -1;
		}
		
		return 0;
	}
	
	/**
     * Metodo que permite importar los ficheros de la aplicacion.                           
	 * <p>
	 * @param  String nombreFicheroEventos.          
	 * @param  String nombreFicheroEventosPatrocinados.
	 * @param  String nombreFicheroUsuarios.          
	 * @param  Eventos eventos.
	 * @param  Eventos eventosPatrocinados.          
	 * @param  Usuarios usuarios.
	 * @return -1 error--IOException/FileNotFoundException.
	 * @return 0 correcto.
	 */
	public static int importar(String nombreFicheroEventos, String nombreFicheroEventosPatrocinados, 
			String nombreFicheroUsuarios, Eventos eventos, Eventos eventosPatrocinados, Usuarios usuarios){
		return importarEventos(nombreFicheroEventos, eventos)+
				importarEventos(nombreFicheroEventosPatrocinados, eventosPatrocinados)+
				importarUsuarios(nombreFicheroUsuarios, usuarios);
	}
	
	/**
	 * Metodo que permite mostrar comentarios de un evento.                           
	 * <p>
	 * @param  Evento evento.       
	 * @return 4, opcion seleccionada.
	 */
	public static int mostrarComentariosEvento(Evento evento) {
		View.mostrarComentarios(evento.getComentarios());
		int opcionSeleccionada = 0;
		try
        {
			opcionSeleccionada = opcion.nextInt();
        } 
        catch (java.util.InputMismatchException e)
        {
            opcion.nextLine();
        }
		opcionSeleccionada = 4;
		return opcionSeleccionada;
	}
	
	/**
	 * Metodo que permite mostrar los comentarios de un usuario.                           
	 * <p>
	 * @param  Usuario usuario.          
	 * @return 4, opcion seleccionada.
	 */
	public static int mostrarComentariosUsuario(Usuario usuario) {
		View.mostrarComentarios(usuario.getComentarios());
		int opcionSeleccionada = 0;
		try
        {
			opcionSeleccionada = opcion.nextInt();
        } 
        catch (java.util.InputMismatchException e)
        {
            opcion.nextLine();
        }
		opcionSeleccionada = 4;
		return opcionSeleccionada;
	}
	
	/**
	 * Metodo que permite importar los eventos a un fichero.                           
	 * <p>
	 * @param  String nombreFicheroEventos.          
	 * @param  Eventos eventos.
	 * @return -1 IOException.
	 * @return 0 correcto.
	 */
	public static int importarEventos(String nombreFicheroEventos, Eventos eventos){
		try {
			FileReader file = new FileReader(nombreFicheroEventos);
			BufferedReader buffer = new BufferedReader(file);
			String autor, nombre, lugar, descripcion, mensaje;
			int year, yearUlt, month, monthUlt, day, dayUlt, hour, hourUlt, min, minUlt, sec, secUlt, id;
			byte ambito;
			Evento evento;
			int numEventos, numComentarios, numUsuarios;
			
			numEventos=Integer.parseInt(buffer.readLine());
			for (int i=0;i<numEventos;i++){
				autor= buffer.readLine();
				nombre = buffer.readLine();
				lugar = buffer.readLine();
				ambito = Byte.parseByte(buffer.readLine());
				year = Integer.parseInt(buffer.readLine());
				month = Integer.parseInt(buffer.readLine());
				day = Integer.parseInt(buffer.readLine());
				descripcion = buffer.readLine();
				id = eventos.addEvento(autor, nombre, lugar, ambito, day, month, year, descripcion);
				
				evento = eventos.buscarEvento(id);
				numComentarios = Integer.parseInt(buffer.readLine());
				for (int j=0;j<numComentarios;j++){
					autor = buffer.readLine();
					year = Integer.parseInt(buffer.readLine());
					month = Integer.parseInt(buffer.readLine());
					day = Integer.parseInt(buffer.readLine());
					hour = Integer.parseInt(buffer.readLine());
					min = Integer.parseInt(buffer.readLine());
					sec = Integer.parseInt(buffer.readLine());
					mensaje = buffer.readLine();
					yearUlt = Integer.parseInt(buffer.readLine());
					monthUlt = Integer.parseInt(buffer.readLine());
					dayUlt = Integer.parseInt(buffer.readLine());
					hourUlt = Integer.parseInt(buffer.readLine());
					minUlt = Integer.parseInt(buffer.readLine());
					secUlt = Integer.parseInt(buffer.readLine());
					evento.addComentario(autor, mensaje, day, month, year, hour, min, sec, dayUlt, monthUlt, yearUlt, hourUlt, minUlt, secUlt);
				}
				numUsuarios = Integer.parseInt(buffer.readLine());
				for (int j=0;j<numUsuarios;j++){
					evento.seguirEvento(buffer.readLine());
				}
			}
			
			buffer.close();
			
		} catch (FileNotFoundException e) {
			return -1;
		} catch (IOException e){
			return -1;
		}
		return 0;
	}
	
	
	/**
	 * Metodo que permite importar los usuarios a un fichero.                           
	 * <p>
	 * @param  String nombreFicheroUsuaros.          
	 * @param  Usuarios usuarios.
	 * @return -1 IOException.
	 * @return 0 correcto.
	 */
	public static int importarUsuarios(String nombreFicheroUsuarios, Usuarios usuarios){
		try {
			FileReader file = new FileReader(nombreFicheroUsuarios);
			BufferedReader buffer = new BufferedReader(file);
			int numUsuarios, numEventos, numComentarios, numUsuariosSeguidos;
			String identificador, password, nombre, apellidos, lugarDeResidencia, fraseFavorita, autor, mensaje;
			int year, month, day, hour, min, sec, yearUlt, monthUlt, dayUlt, hourUlt, minUlt, secUlt;
			byte estadoCivil, sexo;
			boolean tipoDeUsuario;
			Usuario usuario;
			
			numUsuarios = Integer.parseInt(buffer.readLine());
			for (int i=0;i<numUsuarios;i++){
				tipoDeUsuario =Boolean.parseBoolean(buffer.readLine());
				identificador = buffer.readLine();
				password = buffer.readLine();
				nombre = buffer.readLine();
				apellidos = buffer.readLine();
				lugarDeResidencia = buffer.readLine();
				year = Integer.parseInt(buffer.readLine());
				month = Integer.parseInt(buffer.readLine());
				day = Integer.parseInt(buffer.readLine());
				fraseFavorita = buffer.readLine();
				estadoCivil = Byte.parseByte(buffer.readLine());
				sexo = Byte.parseByte(buffer.readLine());
				usuarios.registrarUsuario(tipoDeUsuario, identificador, 
						password, nombre, apellidos, lugarDeResidencia, 
						day, month, year, fraseFavorita, estadoCivil, sexo);
				
				usuario = usuarios.buscarUsuario(identificador);
				numComentarios = Integer.parseInt(buffer.readLine());
				for (int j=0;j<numComentarios;j++){
					autor = buffer.readLine();
					year = Integer.parseInt(buffer.readLine());
					month = Integer.parseInt(buffer.readLine());
					day = Integer.parseInt(buffer.readLine());
					hour = Integer.parseInt(buffer.readLine());
					min = Integer.parseInt(buffer.readLine());
					sec = Integer.parseInt(buffer.readLine());
					mensaje = buffer.readLine();
					yearUlt = Integer.parseInt(buffer.readLine());
					monthUlt = Integer.parseInt(buffer.readLine());
					dayUlt = Integer.parseInt(buffer.readLine());
					hourUlt = Integer.parseInt(buffer.readLine());
					minUlt = Integer.parseInt(buffer.readLine());
					secUlt = Integer.parseInt(buffer.readLine());
					usuario.addComentario(autor, mensaje, day, month, year, hour, min, sec, dayUlt, monthUlt, yearUlt, hourUlt, minUlt, secUlt);
				}
				numEventos = Integer.parseInt(buffer.readLine());
				for (int j=0;j<numEventos;j++){
					usuario.seguirEvento(Integer.parseInt(buffer.readLine()));
				}
				numUsuariosSeguidos = Integer.parseInt(buffer.readLine());
				for (int j=0;j<numUsuariosSeguidos;j++){
					usuario.seguirUsuario(buffer.readLine());
				}
			}
			buffer.close();
		} catch (FileNotFoundException e) {
			return -1;
		} catch (IOException e){
			return -1;
		}
		return 0;
	}
}