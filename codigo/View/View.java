package View;
import Model.Comentarios;
import Model.Comentario;
import java.text.SimpleDateFormat;
import Model.Evento;
import Model.Eventos;
import Model.Usuario;
import Model.Usuarios;
import java.util.Random;
import java.util.ArrayList;


public class View {

	public static int indexMaxPromocionados = 0;
	public static int indexMaxNoPromocionados = 0;
	public static int indexMaxUsuarios = 0;
	public static int indexMaxComentarios = 0;
	public static int accederEventos = 0;
	
	public View() {
		// TODO Auto-generated constructor stub
	}
	
		/**
	     * Declaracion de variables globales para definir los colores q
	     * que se van a usar.                          
	     */
		 public static final String BLACK = "\033[0;30m";
		 public static final String BLACK_SOFT = "\033[0;1;30m";
	 	 public static final String RED = "\033[0;31m";
		 public static final String RED_SOFT = "\033[0;1;31m";
		 public static final String GREEN = "\033[0;32m";
		 public static final String GREEN_SOFT = "\033[0;1;32m";
		 public static final String BROWN = "\033[0;33m";
		 public static final String BROWN_SOFT = "\033[0;1;33m";
		 public static final String BLUE = "\033[0;34m";
		 public static final String BLUE_SOFT = "\033[0;1;34m";
		 public static final String PURPLE = "\033[0;35m";
		 public static final String PURPLE_SOFT = "\033[0;1;35m";
		 public static final String CYAN = "\033[0;36m";
		 public static final String CYAN_SOFT = "\033[0;1;36m";
		 public static final String GREY = "\033[0;37m";
		 public static final String GREY_SOFT = "\033[0;1;37m";
		 public static final String RESET = "\u001B[0m";
	
	public int getAccederEventos(){
		return accederEventos;
	}
	
	public static void setAccederEventos (int accederEvent){
	    accederEventos = accederEvent;
	}
	/**
     * Limpia los mensajes de la terminal                                
     * La terminal se muestra limpia (sin ningún mensaje ni dibujo) tras llamar esta función
     * @param none
     * @return void
     */
	public static void limpiarPantalla() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush(); 
	}	 
	/**
     * Establece un tamaño fijo para la terminal
     * @param none
     * @return void
     */
	public static void redimensionarPantalla() {
		System.out.println("\033[8;70;80t");
	}
	
	/**
     * Muestra el titulo de la aplicacion y el menu principal
     * @param none
     * @return void
     */
	public static void mostrarInicio() {
		System.out.println("\t\t      "+RED+"*"+GREEN+"*"+BROWN+"*"+BLUE+"*"+PURPLE+"*"+CYAN+"*"+GREY+"*"+RED_SOFT+"*"+GREEN_SOFT+"*"+BROWN_SOFT+"*"+BLUE_SOFT+"*"+PURPLE_SOFT+"*"+CYAN_SOFT+"*"+GREY_SOFT+"*"+RED+"*"+GREEN+"*"+BROWN+"*"+BLUE+"*"+PURPLE+"*"+CYAN+"*"+GREY+"*"+RED_SOFT+"*"+GREEN_SOFT+"*"+BROWN_SOFT+"*"+BLUE_SOFT+"*"+PURPLE_SOFT+"*"+CYAN_SOFT+"*"+GREY_SOFT+"*"+RED+"*"+GREEN+"*"+BROWN+"*"+BLUE+"*"+PURPLE+"*"+CYAN+"*"+GREY+"*"+RESET+"\t\t");
        System.out.println("\t\t\t      Welcome to MiPandilla\t\t\t");
        System.out.println("\t\t      "+RED+"*"+GREEN+"*"+BROWN+"*"+BLUE+"*"+PURPLE+"*"+CYAN+"*"+GREY+"*"+RED_SOFT+"*"+GREEN_SOFT+"*"+BROWN_SOFT+"*"+BLUE_SOFT+"*"+PURPLE_SOFT+"*"+CYAN_SOFT+"*"+GREY_SOFT+"*"+RED+"*"+GREEN+"*"+BROWN+"*"+BLUE+"*"+PURPLE+"*"+CYAN+"*"+GREY+"*"+RED_SOFT+"*"+GREEN_SOFT+"*"+BROWN_SOFT+"*"+BLUE_SOFT+"*"+PURPLE_SOFT+"*"+CYAN_SOFT+"*"+GREY_SOFT+"*"+RED+"*"+GREEN+"*"+BROWN+"*"+BLUE+"*"+PURPLE+"*"+CYAN+"*"+GREY+"*"+RESET+"\t\t");
        System.out.println();
        System.out.println(GREEN_SOFT+"------------------------------Selecciona una opcion-----------------------------");
        System.out.println("  1-. Iniciar sesion");
        System.out.println("  2-. Registrarse");
        System.out.println("  3-. Buscar eventos");
        System.out.println("  4-. Salir"+RESET+"\n");
	}
	
	/**
     * Muestra un mensaje pidiendo al usuario un nombre de una cuenta ya creada
     * @param none
     * @return void
     */
	public static void mostrarLogin() {
		System.out.println(GREEN_SOFT);
		System.out.println("Iniciando  sesion...");
        System.out.println();
        System.out.println(BROWN+"                    ......              ");
        System.out.println("                 .:||||||||:.           ");
        System.out.println("                /            \\         ");
        System.out.println("               (   o      o   )         ");
        System.out.println("--------@@@@---------:  :---------@@@@--------");
		System.out.println(GREEN_SOFT);
        System.out.println("\tIntroduce tu nombre de usuario: ");
		System.out.println(RESET);
	}
	
	/**
     * Muestra un mensaje pidiendo al usuario una contraseña de una cuenta 
     * @param none
     * @return void
     */ 
    public static void preguntarContraseniaLoginYRegistro() {
            System.out.println(GREEN_SOFT+"\t Y ahora...introduce tu password ^.^"+RESET);
            System.out.println();
           
   	}
    
    /**
     * Muestra un mensaje pidiendo al usuario el nombre de cuenta que desea tener si el usuario decide registrarse 
     * @param none
     * @return void
     */ 
 	public static void mostrarRegistro() {
 		System.out.println(GREEN_SOFT);
 		System.out.println("\t"+" Quieres formar parte de "+RED+"*"+GREEN_SOFT+"miPandilla"+RED+"*"+GREEN_SOFT+"?");
 		System.out.println();
 		System.out.println("\t\t Good decision!\t");
 		System.out.println();
 		System.out.println("El primer paso es sencillo...introduce tu nombre de usuario: "+RESET);
 	}
 	
 	/**
     * Muestra el menu de los usuarios registrados una vezz inician sesion o se acaban de registrar 
     * @param none
     * @return void
     */ 
	public static void mostrarMenu() {
		System.out.println(RED);
		System.out.println("                       __________________________________                   ");
		System.out.println("          ____________|                                  |____________      ");
		System.out.println("          \\           |                                  |           /      ");
		System.out.println("           \\          | "+RESET+"         MENU PRINCIPAL"+RED+"          |          /       ");
		System.out.println("           /          |                                  |          \\      ");
  		System.out.println("          /           |__________________________________|           \\     ");
    	System.out.println("         /_____________)                                (_____________\\    ");
		System.out.println("\n\n");
		System.out.println(GREEN_SOFT+"------------------------------Selecciona una opcion-----------------------------");
		System.out.println("  1-. Crear evento");
		System.out.println("  2-. Buscar eventos");
		System.out.println("  3-. Buscar usuarios");
		System.out.println("  4-. Ver perfil");
		System.out.println("  5-. Salir");
		System.out.println(RESET+"\n");
	}

	/**
     * Muestra un mensaje pidiendo que no se introduzca valor a los campos de un evento que no se desea filtrar  
     * @param none
     * @return void
     */  
	public static void mostrarFiltroEventos() {
		System.out.println(GREEN_SOFT+"\t\tBuscando eventos interesantes?");
		System.out.println("Puedes filtrar los eventos para encontrar mas rapido lo que realmente deseas");
		System.out.println("pero...deja en blanco los campos que no quieras filtrar,gracias guap@ ;)"+RESET);
		System.out.println();
	}
	
	/**
     * Muestra un mensaje pidiendo que no se introduzca valor a los campos de un usuario que no se desea filtrar  
     * @param none
     * @return void
     */   
	public static void mostrarFiltroUsuarios() {
		System.out.println(GREEN_SOFT+"\t\tQuieres encontrar a alguien?");
		System.out.println("\t     Genial!Nos encanta the gossip people!");
		System.out.println("Pero por favor...deja en blanco los campos que no quieras filtrar"+RESET);
		System.out.println();
	}
	
	/**
     * Muestra una lista de comentarios 
     * @param Un objeto de tipo comentario
     * @return Devuelve 'true' si se han representado todos los comentarios
     */  
	public static boolean mostrarComentarios(Comentarios comentarios) {
		int sizeComentarios = comentarios.getComentarios().size();

		  if(indexMaxComentarios != sizeComentarios){
			for(int x=0; x<sizeComentarios; x++) {
		    		imprimirComentario(comentarios.getComentarios().get(x));
		    		indexMaxComentarios++;
		    	
		    }
			System.out.println("Selecciona una opcion: ");
			System.out.println("  1-. Menu principal");
			System.out.println(RESET);
			
		  }else{
			  System.out.println("Selecciona una opcion: ");
			  System.out.println("  1-. Menu principal");
			  System.out.println(RESET);
		  }
		return false;
	}
	/**
     * Muestra los eventos priorizando a los promocionados frente a los no promocionados
     * Los patrocinados se mostraran en las tres primeras posiciones (si existieran) y despues los eventos no 
     * promocionados (si existieran) hasta llegar a un maximo de 10 eventos mostrados en total
     * @param Dos objeto de tipo Eventos, uno para los promocionados y otro para los no promocionados, y un entero de la pagina
     * @return Devuelve 'true' si se han representado todos los eventos
     */  
	public static boolean mostrarEventos(Eventos eventosNoPromocionados, Eventos eventosPromocionados, int pagina) {
		int sizePromocionados = eventosPromocionados.getIdCounter();
		int sizeNoPromocionados = eventosNoPromocionados.getIdCounter();
		if(accederEventos!=0){
			indexMaxPromocionados = 0;
			indexMaxNoPromocionados = 0;
		}
		if(indexMaxPromocionados != sizePromocionados){
			for(int x=indexMaxPromocionados; x<sizePromocionados; x++) {
				mostrarEventoSinMenu(eventosPromocionados.getEventos().get(x));
	    		indexMaxPromocionados++;
	    		if((indexMaxPromocionados % 3)==0) {
	    			break;
	    		}
			}
		 }
		if(indexMaxNoPromocionados != sizeNoPromocionados){
			for(int j=indexMaxNoPromocionados; j<sizeNoPromocionados; j++) {
	        	mostrarEventoSinMenu(eventosNoPromocionados.getEventos().get(j));
	        	indexMaxNoPromocionados++;
	        	if((indexMaxNoPromocionados % 10)==0){
	        		break;
	        	}
			}
		}
		return false;
	}

	/**
     * Muestra a los usuarios de 10 en 10
     * @param Un objeto de tipo Usuarios, con la lista de los usuarios
     * @return Devuelve 'true' si se han representado todos los usuarios
     */  
	public static boolean mostrarUsuarios(Usuarios usuarios) {
		int sizeUsuarios = usuarios.getUsuarios().size();
		if(indexMaxUsuarios != sizeUsuarios){
	
			for(int x=indexMaxUsuarios; x<sizeUsuarios; x++) {
		    		mostrarUsuarioResumido(usuarios.getUsuarios().get(x));
		    		indexMaxUsuarios++;
		        if((indexMaxUsuarios % 10)==0) {
		        	break;
		        }
		    }
		}
		return false;
	}
	
	/**
     * Muestra el perfil del usuario registrado (nombre, sexo, identificador, estado civil, donde vive y 
     * fecha de nacimiento )junto con un menu que permite modificar o eliminar el perfil, ver el menu principal o 
     * salir de esta interfaz
     * @param Un objeto de tipo Usuarios, con la lista de los usuarios
     * @return void 
     */  
	public static void mostrarPerfil(Usuario usuario, Eventos eventos) {
		
		if(usuario.getSexo() == 1){
			System.out.println(BROWN_SOFT);
		} else {
			System.out.println(RED_SOFT);
		}
		Random r = new Random();
		int avatar = r.nextInt(6);
		switch (avatar) {
			case 1:
				fish();
				break;
			case 2:
				bird();
				break;
			case 3:
				frog();
				break;
			case 4:
				pig();
				break;
			case 5:
				bear();
				break;
			default:
				bear();
				break;
		
		}
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
		System.out.printf("Hola %s %s!\n", usuario.getNombre(), usuario.getApellidos());
		System.out.printf("Tu identificador es *%s* \n", usuario.getID());
		System.out.println("Vives en " + usuario.getLugarDeResidencia() + " y naciste el " + formatoFecha.format(usuario.getFechaDeNacimiento().getTime()));
		System.out.println("Y para animarnos el dia...una frase genial, tu frase favorita: " + usuario.getFraseFavorita());
		if(usuario.getEstadoCivil()==1 && usuario.getSexo()==1){
			System.out.println("Nos has dicho que eres chico y estas soltero");
		} else if(usuario.getEstadoCivil()==2 && usuario.getSexo()==1){
			System.out.println("Nos has dicho que eres chico y tienes pareja");
		} else if(usuario.getEstadoCivil()==3 && usuario.getSexo()==1){
			System.out.println("Nos has dicho que eres chico y estas casado");
		}else if(usuario.getEstadoCivil()==1 && usuario.getSexo()==2){
			System.out.println("Nos has dicho que eres chica y estas soltera");
		} else if(usuario.getEstadoCivil()==2 && usuario.getSexo()==2){
			System.out.println("Nos has dicho que eres chica y tienes pareja");
		} else if(usuario.getEstadoCivil()==3 && usuario.getSexo()==2){
			System.out.println("Nos has dicho que eres chico y estas casada");
		} else if(usuario.getEstadoCivil()==2 && usuario.getSexo()==3){
			System.out.println("Nos has dicho que tienes pareja");
		} else if(usuario.getEstadoCivil()==3 && usuario.getSexo()==3){
			System.out.println("Nos has dicho que estas casad@");
		} else if(usuario.getEstadoCivil()==1 && usuario.getSexo()==3){
			System.out.println("Nos has dicho que estas solter@");
		} else {
			System.out.println("No nos has dado nada de informacion sobre tu sexo o tu pareja :( ");
		}
		
		if(usuario.getEventosInscritos().size() == 0){
			System.out.println("Te has inscrito en cero patatero eventos");
		} else {
			for (int j =0; j < usuario.getEventosInscritos().size();j++){
				eventos.buscarEvento(usuario.getEventosInscritos().get(j)).getNombre();
			}
		}
		
		if(usuario.getUsuariosSeguidos().size() == 0){ 
			System.out.println("No sigues a ningun usuario");
		} else {
			System.out.println("Sigues a:");
			for (int i=0; i<usuario.getUsuariosSeguidos().size(); i++) System.out.println("        "+usuario.getUsuariosSeguidos().get(i));
		}
		System.out.println();
		System.out.println("Selecciona una opcion: ");
		System.out.println("  1-. Modificar perfil");
		System.out.println("  2-. Eliminar perfil");
		System.out.println("  3-. Ver tablon");
		System.out.println("  4-. Salir");
		System.out.println(RESET);
	}
	
	/*
	 * Imprime la informacion basica de un usuario.
	 * Esta funcion se ejecuta cuando un usuario decide ver la lista de usuarios registrados ne la aplicacion
	 * @param Un objeto de tipo Usuario
	 * @return void
	 */
	public static void mostrarUsuarioResumido(Usuario usuario){
		System.out.println(GREEN_SOFT+usuario.getNombre()+" "+usuario.getApellidos()+": vive en "+usuario.getLugarDeResidencia()+"->identificador: "+usuario.getID()+RESET);
	}
	
	/**
     * Muestra un mensaje pidiendo que deje en blanco los campos que no desea cambiar cuando el usuario decide 
     * modificar el perfil
     * @param none
     * @return void
     */  
	public static void modificarPerfil() {
		System.out.println(GREEN_SOFT+"\t Quieres modificar tu perfil? Algo nuevo in your life ^^ ?");
		System.out.println("Por favor, deja en blanco los campos que no quieras modificar");
		System.out.println(RESET + "\n");	
	}
	
	/**
     * Muestra toda la información relacionada con un evento (como su numero identificativo, el titulo y la 
     * descripcion del mismo, el lugar y la fecha donde se realiza y el ambito. 
     * Esta funcion se ejecuta cuando el usuario elige la opcion de buscar eventos
     * @param Un objeto de tipo Evento
     * @return void 
     */  
	public static void mostrarEventoSinMenu(Evento evento) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
		System.out.println(GREEN_SOFT);
		System.out.println("Numero identificativo: " + evento.getID());
		System.out.println("Titulo del evento: " + evento.getNombre());
		System.out.println("Descripcion: " + evento.getDescripcion());
		System.out.println("Lugar: " + evento.getLugar());
		System.out.println("Ambito: " + evento.getAmbito());
		System.out.println("Fecha: " + formatoFecha.format(evento.getFecha().getTime()));
		System.out.println(RESET);
	}
	
	/**
     * Muestra toda la información relacionada con un evento (como su numero identificativo, el titulo y la 
     * descripcion del mismo, el lugar y la fecha donde se realiza y el ambito. Ademas muestra un menu que 
     * permite modificar dicho evento, eliminarlo, ver sus comentarios, seguirlo o dejar de seguirlo y salir
     * de dicha interfaz. 
     * Esta funcion se ejecuta cuando el usuario busca en la lista de eventos y selecciona uno para ver 
     * detalladamente
     * @param Un objeto de tipo Evento
     * @return void
     */  
	public static void mostrarEvento(Evento evento) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
		System.out.println(GREEN_SOFT);
		System.out.println("Numero identificativo: " + evento.getID());
		System.out.println("Titulo del evento: " + evento.getNombre());
		System.out.println();
		System.out.println("Descripcion: " + evento.getDescripcion());
		System.out.println("Lugar: " + evento.getLugar());
		switch(evento.getAmbito()){
		case 1:
			System.out.println("Ambito: deportivo");
			break;
		case 2:
			System.out.println("Ambito: cultural");
			break;
		case 3:
			System.out.println("Ambito: social");
			break;
		case 4:
			System.out.println("Ambito: musical");
			break;
		case 5:
			System.out.println("Ambito: benefico");
			break;
		case 6:
			System.out.println("Ambito: gastronomico");
			break;
		default:
			System.out.println("Ambito raro");
			break;
		}
		System.out.println("Fecha: " + formatoFecha.format(evento.getFecha().getTime()));
		System.out.println();
		System.out.println("Selecciona una opcion: ");
		System.out.println("  1-. Modificar evento");
		System.out.println("  2-. Eliminar evento");
		System.out.println("  3-. Ver comentarios");
		System.out.println("  4-. Seguir evento");
		System.out.println("  5-. Dejar de seguir evento");
		System.out.println("  6-. Comentar evento");
		System.out.println("  7-. Salir");
		System.out.println(RESET + "\n");
	}
	
	/**
     * Muestra un mensaje agradable por pantalla cuando el usuario elige la opcion de crear un evento nuevo
     * @param none
     * @return void
     */  
	public static void mostrarCrearEvento(){
		System.out.println(GREEN_SOFT);
		System.out.println();
		System.out.println("Tenemos un nuevo evento? Genial ^^");
		System.out.println();
		System.out.println(RESET + "\n");
	}
	
	/**
     * Muestra un mensaje por pantalla que pide dejar en blanco las campos que no se quieran cambiar
     * al modificar un evento
     * @param none
     * @return void
     */  
	public static void mostrarModificarEvento(){
		System.out.println(GREEN_SOFT);
		System.out.println("Modifiquemos el evento pero recuerda.............:");
		System.out.println("Deja en blanco los campos que no quieras modificar");
		System.out.println(RESET + "\n");
	}
	
	/**
     * Muestra toda la informacion sobre un usuario que hayamos buscado previamente (nombre, sexo, identificador
     * estado civil, donde vive y fecha de nacimiento )junto con un menu que permite seguir o dejar de seguir al 
     * usuario, escribirle un comentario, ver su tablon o volver al menu principal
     * @param Un objeto de tipo Usuarios, con la lista de los usuarios
     * @return void   
     */  
	public static void mostrarUsuario(Usuario usuario, Eventos eventos) {
		if(usuario.getSexo() == 1){
			System.out.println(BROWN_SOFT);
		} else {
			System.out.println(RED_SOFT);
		}
		Random r = new Random();
		int avatar = r.nextInt(6);
		switch (avatar) {
			case 1:
				fish();
				break;
			case 2:
				bird();
				break;
			case 3:
				frog();
				break;
			case 4:
				pig();
				break;
			case 5:
				bear();
				break;
			default:
				bear();
				break;
		
		}
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
		int sizeEventosInscritos = usuario.getEventosInscritos().size();
		System.out.printf("Este es %s %s!\n", usuario.getNombre(), usuario.getApellidos());
		System.out.printf("Su identificador es *%s* \n", usuario.getID());
		System.out.println("Vive en " + usuario.getLugarDeResidencia() + " y naciste el " + formatoFecha.format(usuario.getFechaDeNacimiento().getTime()));
		System.out.println("Y esta es su frase favorita: " + usuario.getFraseFavorita());
		if(usuario.getEstadoCivil()==1 && usuario.getSexo()==1){
			System.out.println("Nos ha dicho que es chico y esta soltero ;)");
		} else if(usuario.getEstadoCivil()==2 && usuario.getSexo()==1){
			System.out.println("Nos ha dicho que es chico y tiene pareja");
		} else if(usuario.getEstadoCivil()==3 && usuario.getSexo()==1){
			System.out.println("Nos ha dicho que es chico y esta casado");
		}else if(usuario.getEstadoCivil()==1 && usuario.getSexo()==2){
			System.out.println("Nos ha dicho que es chica y estas soltera ;)");
		} else if(usuario.getEstadoCivil()==2 && usuario.getSexo()==2){
			System.out.println("Nos ha dicho que es chica y tiene pareja");
		} else if(usuario.getEstadoCivil()==3 && usuario.getSexo()==2){
			System.out.println("Nos ha dicho que es chica y esta casada");
		} else if(usuario.getEstadoCivil()==2 && usuario.getSexo()==3){
			System.out.println("Nos ha dicho que tiene pareja");
		} else if(usuario.getEstadoCivil()==3 && usuario.getSexo()==3){
			System.out.println("Nos ha dicho que esta casad@");
		} else if(usuario.getEstadoCivil()==1 && usuario.getSexo()==3){
			System.out.println("Nos ha dicho que esta solter@");
		} else {
			System.out.println("No nos has dado nada de informacion sobre tu sexo o tu pareja :( ");
		}
		
		if(usuario.getEventosInscritos().size() == 0){
			System.out.println("Se ha inscrito en cero patatero eventos");
		} else {
			for (int j =0; j<usuario.getEventosInscritos().size();j++) {
				eventos.buscarEvento(usuario.getEventosInscritos().get(j)).getNombre();
			}
				
		}
		
		if(usuario.getUsuariosSeguidos().size() == 0){ 
			System.out.println("No sigue a ningun usuario");
		} else {
			System.out.println("Sigue a:");
			for (int i=0; i<usuario.getUsuariosSeguidos().size(); i++) System.out.println("        "+usuario.getUsuariosSeguidos().get(i));
		}
		
		System.out.println("Selecciona una opcion: ");
		System.out.println("  1-. Menu principal");
		System.out.println("  2-. Ver tablon");
		System.out.println("  3-. Comentar tablon");
		System.out.println("  4-. Seguir usuario");
		System.out.println("  5-. Dejar de seguir al usuario");
		System.out.println(RESET);
	}
	
	/**
     * Imprime por pantalla un comentario mostrando su numero identificativo, el autor del comenario,
     * la fecha en la que se creó y el comentario en si
     * @param Un objetivo de tipo Comentarios
     * @return void  
     */  
	public static void imprimirComentario(Comentario comentario){
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
		System.out.println("ID: "+comentario.getID());
		System.out.println("Autor: "+comentario.getAutor());
		System.out.println("Fecha: "+formatoFecha.format(comentario.getFecha().getTime()));
		System.out.println("Mensaje: "+comentario.getMensaje());
		System.out.println();
		System.out.println(RESET);
	}
	
	/**
     * Imprime por pantalla un dibujo ASCII de un pez 
     * @param none
     * @return void 
     */  
	public static void fish(){
        System.out.println("              "+"           .'|_.-          ");
        System.out.println("              "+"         .'  '  /_         ");
        System.out.println("              "+"      .-\"    -.   '>       ");
        System.out.println("              "+"   .- -. -.    '. /    /|_ ");
        System.out.println("              "+"  .-.--.-.       ' >  /  / ");
        System.out.println("              "+" (o( o( o )      \\_.\"  <  ");
        System.out.println("              "+"  '-'-''-'            ) <  ");
        System.out.println("              "+"(       _.-'-.   ._\\.  _\\  ");
        System.out.println("              "+" '----\"/--.__.-) _-  \\|    ");
        System.out.println("              "+"       \"\"V\"\"   \"V\"         ");
	}
	
	/**
     * Imprime por pantalla un dibujo ASCII de una gallina
     * @param none
     * @return void  
     */  
	public static void bird(){
        System.out.println("                           .'`  `.      __            ");
        System.out.println("                          /      |  ,-'`  `'.         ");
        System.out.println("                         ;       '-'         )        ");
        System.out.println("                         |              _,.-'         ");
        System.out.println("                     _   |_.--.,       (_             ");
        System.out.println("                  .'` `'-'__    \\        ''\"'-.       ");
        System.out.println("                 /  .-\"-/`  `\\   ;_          \\      ");
        System.out.println("                 | /   ;      ;  | `.   (`'.__.'      ");
        System.out.println("                  |   o| o    | __   \\   `.          ");
        System.out.println("            _,.---'\\___.\\.__.'    `'. |_   )        ");
        System.out.println("        _.-'               _.-\"\"-.   '-.'-'         ");
       	System.out.println("      ,'                     |   \\`.    `.           ");
        System.out.println("     /                       ;   |       |            ");
        System.out.println("    (_.-'\"\"''---..           /   |      /             ");
        System.out.println("                  `'-..___.-'    ;  ,.-'              ");
        System.out.println("                       \\ 7      ' / |                ");
        System.out.println("                        |/_  _  ; /  '                ");
        System.out.println("                    .-  /' /` j/ '   |                ");
        System.out.println("                    | \\|  '   /  |                   ");
        System.out.println("                    '  `.___.'  ;     '               ");
        System.out.println("                    ;          /      |               ");
        System.out.println("                    \\        /       |               ");
        System.out.println("                      `.,__,.'         '              ");
        System.out.println("                         |             |              ");
        System.out.println("                         ;              '             ");
        System.out.println("                        /                |mx          ");
        System.out.println("                       ' ___________ ...-'            ");
    }

	/**
     * Imprime por pantalla un dibujo ASCII de una rana
     * @param none
     * @return void  
     */  
	 public static void frog(){

         System.out.println("              "+"          ____  __.---\"\"---.__  ____                 ");
         System.out.println("              "+"         /####\\/              \\/####\\                ");
         System.out.println("              "+"        (/-----)              (------)               ");
         System.out.println("              "+"         \\__OO/                \\OO__/                ");
         System.out.println("              "+"       __/                          \\__              ");
         System.out.println("              "+"    .-\"    .                      .    \"-.           ");
         System.out.println("              "+"    |  |   \\.._                _../   |  |           ");
         System.out.println("              "+"     \\  \\    \\.\"-.__________.-\"./    /  /            ");
         System.out.println("              "+"       \\  \\    \"--.________.--\"    /  /              ");
         System.out.println("              "+"     _ _\\  \\_                    _/  /___            ");
         System.out.println("              "+"   ./    )))))                  (((((   \\.          ");
         System.out.println("              "+"   \\                                     /          ");
         System.out.println("              "+"    \\          \\_          _/           /           ");
         System.out.println("              "+"      \\   \\____/\"\"-.____.-\"\"\\____/    /             ");
         System.out.println("              "+"        \\    \\                 /    /               ");
         System.out.println("              "+"         -.  .|              ./.                    ");
         System.out.println("              "+"       .\" / |  -             /  | - \".             ");
         System.out.println("              "+"    .\"  /   |   -          /   |   - \".           ");
         System.out.println("              "+"   /.-./.--.|.--.\\         /.--.|.--.\\.-.|          ");
	 }

	 /**
	  * Imprime por pantalla un dibujo ASCII de un cerdo  
	  * @param none
	  * @return void
	  */  
	 public static void pig(){
         System.out.println("              "+"           _,--.       ,--._              ");
         System.out.println("              "+"           \\  > `-\"\"\"-' <  /              ");
         System.out.println("              "+"            `-.         .-'               ");
         System.out.println("              "+"              / 'e___e` \\                 ");
         System.out.println("              "+"             (   (o o)   )                ");
         System.out.println("              "+"             _\\_  `='  _/_                ");
         System.out.println("              "+"            / / `-._.-' \\ \\               ");
         System.out.println("              "+"           / /           \\ \\              ");
         System.out.println("              "+"         _/ /             \\ \\_            ");
         System.out.println("              "+"        / _/               \\_ \\           ");
         System.out.println("              "+"        `'(        o        )`'           ");
         System.out.println("              "+"           \\               /              ");
         System.out.println("              "+"            \\             /          ");
         System.out.println("              "+"             \\    ___    /            ");
         System.out.println("              "+"              )__|   |__(                 ");
         System.out.println("              "+"             /   ]   [   \\                ");
         System.out.println("              "+"             `--'     `--'                ");
 }

	 	/**
	     * Imprime por pantalla un dibujo ASCII de un oso 
	     * @param none
	     * @return void
	     */  
	 public static void bear(){
         System.out.println("            _,-\"\"`\"\"-~`)                            ");
         System.out.println("         (`~_,=========\\                            ");
         System.out.println("          |---,___.-.__,\\                           ");
         System.out.println("          |        o     \\ ___  _,,,,_     _.--.    ");
         System.out.println("           \\      `^`    /`_.-\"~      `~-;`     \\   ");
         System.out.println("            \\_      _  .'                 `,    |  ");
         System.out.println("              |`-                          \\'__/   ");
         System.out.println("             /                      ,_      \\  `'-.");
         System.out.println("            /    .-\"\"~~--.            `\"-,   ;_    /");
         System.out.println("           |              \\               \\  | `\"\"` ");
         System.out.println("            \\__.--'`\"-.   /_               |'       ");
         System.out.println("                       `\"`  `~~~---..,     |        ");
         System.out.println("                                      \\ _.-'`-.     ");
         System.out.println("                                       \\      \\    ");
         System.out.println("                                        '.     /    ");
         System.out.println("                                          `\"~\"`     ");
	 }

}
