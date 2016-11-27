package Controlador;
import View.View;
import Model.Evento;
import Model.Eventos;
import Model.Usuario;
import Model.Usuarios;


/**
 * Long description
 * @author      
 * @author 
 * @version     
 * @since       2015-11-6          
 */
public class Main {

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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int resultado = 0;	     // Igual a 0 por que nada mas iniciar el programa empieza en el menu de inicio
		int iniciado = 0;
		int accederAEventos = 0;
		Usuario usuario = null;	 // Hace refencia al usuario que inicia sesion o se registra
		Usuario usuarioSeleccionado = null;
		Usuarios usuarios = new Usuarios();
		Eventos eventos = new Eventos();
		Eventos eventosPromocionados = new Eventos();
		Evento eventoSeleccionado = null;
		
		/****Usuario: abel   Password: Children3****/
		Usuario defaultUser = new Usuario();
		usuarios.registrarUsuario(defaultUser);
		/********************************************/
		
		// Importar eventos y usuarios
		Controller.importar("Eventos.txt", "EventosPatrocinados.txt", "Usuarios.txt", eventos, eventosPromocionados, usuarios);
		//resimensionar terminal
		resultado = Controller.redimensionarConsola();
		// Para moverse por el programa
		// 0 MENU DE INICIO						DONE
		//    1 INICIAR SESION					DONE
		//    2 REGISTRAR USUARIO				DONE
		//    3 SALIR							DONE
		// 4 MENU PRINCIPAL						DONE
		// 20 CREAR EVENTO						DONE
		// 5 FILTRAR EVENTOS	                DONE
		// 6 FILTRAR USUARIOS					DONE
		// 7 VER PERFIL							DONE
		//    10 MODIFICAR PERFIL				DONE
		//    11 ELIMINAR PERFIL				DONE
		//    12 VER TABLON          		    DONE
		// 8 VER EVENTO							DONE
		//    13 MODIFICAR EVENTO				DONE
		//    14 ELIMINAR EVENTO				DONE
		//	  24 COMENTAR EVENTO				DONE
		//    15 VER COMENTARIOS				DONE
		//    16 SEGUIR EVENTO					DONE
		//    17 DEJAR DE SEGUIR EVENTO			DONE
		// 9 VER USUARIO						DONE
		//    21 SEGUIR USUARIO					DONE
		//    22 DEJAR DE SEGUIR USUARIO		DONE
		//	  25 COMENTAR USUARIO				DONE
		//    23 VER TABLON						DONE
		while(true) {
			switch(resultado){
			case 0:
				Controller.limpiarConsola();
				resultado = Controller.inicio();
				break;
			case 1:
				Controller.limpiarConsola();
				if((usuario = Controller.iniciarSesion(usuarios)) == null)	resultado = 0;
				else {
					resultado = 4;
					iniciado = 1;
				}
				break;
			case 2:
				Controller.limpiarConsola();
				usuario = Controller.registrarUsuario(usuarios);
				resultado = 4;
				iniciado = 1;
				break;
			case 3:
				Controller.limpiarConsola();
				Controller.exportar("Eventos.txt", "EventosPatrocinados.txt", "Usuarios.txt", eventos, eventosPromocionados, usuarios);
				System.exit(0);
				break;
			case 4:
				if (iniciado == 0) {
					resultado = 0;
					break;
				}
				Controller.limpiarConsola();
				resultado = Controller.menuPrincipal();
				break;
			case 5: 
				Controller.limpiarConsola();
				if((eventoSeleccionado = Controller.buscarEventos(eventos, eventosPromocionados)) == null && iniciado == 1)
					resultado = 4;
				else if (eventoSeleccionado == null && iniciado == 0)
					resultado = 0;
				else
					resultado = 8;
					accederAEventos++;
					View.setAccederEventos(accederAEventos);
				break;
			case 6:
				Controller.limpiarConsola();
				//indexMaxUsuarios = 0;
				if((usuarioSeleccionado = Controller.buscarUsuarios(usuarios)) == null)	resultado = 4;
				else	resultado = 9;
				break;
			case 7:
				Controller.limpiarConsola();
				resultado = Controller.verPerfil(usuario, eventos);
				break;
			case 8:
				Controller.limpiarConsola();
				resultado = Controller.verEvento(eventoSeleccionado);
				break;
			case 9:
				Controller.limpiarConsola();
				resultado = Controller.verUsuario(usuarioSeleccionado, eventos);
				break;
			case 10:
				Controller.limpiarConsola();
				resultado = Controller.modificarPerfil(usuarios, usuario) + 4;
				break;
			case 11:
				Controller.limpiarConsola();
				resultado = Controller.eliminarPerfil(usuarios, usuario);
				break;
			case 12:
				Controller.limpiarConsola();
				resultado = Controller.verTablon(usuario);
				break;
			case 13:
				Controller.limpiarConsola();
				resultado = Controller.modificarEvento(usuario, eventoSeleccionado);   // devuelve 4
				break;
			case 14:
				Controller.limpiarConsola();
				resultado = Controller.eliminarEvento(usuario, eventos, eventoSeleccionado);
				break;
			case 15:
				Controller.limpiarConsola();
				resultado = Controller.mostrarComentariosEvento(eventoSeleccionado);
				break;
			case 16:
				if (iniciado == 0) {
					System.out.println("No puedes realizar esta acci�n si no has iniciado sesi�n.");
					resultado = 0;
					break;
				}
				Controller.limpiarConsola();
				resultado = Controller.seguirEvento(usuario, eventoSeleccionado);   // devuelve 4
				break;
			case 17:
				Controller.limpiarConsola();
				resultado = Controller.noSeguirEvento(usuario, eventoSeleccionado);   // devuelve 4
				break;
			case 20:
				Controller.limpiarConsola();
				resultado = Controller.crearEvento(usuario, eventos);   // devuelve 4.
				break;
			case 21:
				Controller.limpiarConsola();
				resultado = Controller.seguirUsuario(usuario, usuarioSeleccionado);   // devuelve 4
				break;
			case 22:
				Controller.limpiarConsola();
				resultado = Controller.noSeguirUsuario(usuario, usuarioSeleccionado);   // devuelve 4
				break;
			case 23:
				Controller.limpiarConsola();
				resultado = Controller.mostrarComentariosUsuario(usuarioSeleccionado);
				break;
			case 24:
				if (iniciado == 0) {
					System.out.println("No puedes realizar esta acci�n si no has iniciado sesi�n.");
					resultado = 0;
					break;
				}
				Controller.limpiarConsola();
				resultado = Controller.comentarEvento(eventoSeleccionado, usuario);
				break;
			case 25:
				Controller.limpiarConsola();
				resultado = Controller.comentarUsuario(usuarioSeleccionado, usuario);
				break;
			}
		}
	}

}
