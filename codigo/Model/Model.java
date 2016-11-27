package Model;

import java.io.Console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date; 

import View.Errores;
import View.View;

/**
 * Long description
 * @author      
 * @author 
 * @version     
 * @since       2015-11-6          
 */
public final class Model {
	
	 // TIPO DE ERROR: 200
	
	static Scanner texto = new Scanner(System.in);
	static Scanner numero = new Scanner(System.in);
	static Scanner bait = new Scanner(System.in);
	static Scanner opcion = new Scanner(System.in);
	static int opcionSeleccionada;

	
	/**
	 * metodo que permite conseguir la opcion elegida por el usuario en el menu                            
	 * <p>
	 *  Si opcion = 1 -> resultado = 1
	 * """"""""""""2 """""""""""""""2
	 * """""""""""""3 """""""""""""""5 (por que va a la seccion de buscar eventos)
	 * """""""""""""4""""""""""""""""3 (por que va a la parte de salir del programa)
	 * @return opcionSeleccionada Entero que indica la opcion elegida por el usuario.
	 */
	public static int opcionInicio() {
		if (((opcionSeleccionada = opcion.nextInt()) < 1) || (opcionSeleccionada > 4)) opcionSeleccionada = -1;
		if(opcionSeleccionada == 3) opcionSeleccionada = 5;
		if(opcionSeleccionada == 4) opcionSeleccionada = 3;
		
		return opcionSeleccionada;
	}
	
	/**
	 * Metodo que permite a un usuario iniciar sesion.                           
	 * <p>
	 * @param  usuario Objeto de la clase Usuario que contiene las informaciones del ususario           
	 * @return usuario Objeto de la clase Usuario que contiene las informaciones del ususario que ha iniciado sesion
	 */
	public static Usuario iniciarSesion(Usuarios usuarios) {  // Devuelve objeto de tipo Usuario por que devuelve al ususario que inicia sesion
		String identificador = texto.nextLine();	// Escribes tu nombre de usuario
		System.out.println("\033[0;1;32m"+"      Y ahora...introduce tu password ^.^"+"\u001B[0m");
        System.out.println();
		String password = texto.nextLine();			// Escriber tu contrase�a
		
/////////////////////////////////////////////////////////////////////////////////////
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(Integer.toString(9239).getBytes());
		    md.update(password.getBytes());
		    byte[] out = md.digest();
		    char[] hexArray = "0123456789ABCDEF".toCharArray();
		    char[] hexChars = new char[out.length * 2];
		    int aux;
		    for (int i = 0; i < out.length; i++) {
		    	aux = out[i] & 0xFF;
		        hexChars[i * 2] = hexArray[aux >>> 4];
		        hexChars[i * 2 + 1] = hexArray[aux & 0x0F];
		    }
		    password = new String(hexChars);
		} catch (NoSuchAlgorithmException e1) {

		}
/////////////////////////////////////////////////////////////////////////////////////
		
		Usuario usuario = usuarios.buscarUsuario(identificador); // Busca al usuario
		
		if (usuario == null)	Errores.mostrarError(201);
		else if (!usuario.getPassword().equals(password)) { // Si la contraseÃ±a no se correcponde con el usuario
			Errores.mostrarError(202);
			usuario = null;
		}
		
		return usuario;
	}
	
	/**
	 * Metodo que permite a un usuario resistrarse                            
	 * <p>
	 * @param  usuarios Objeto de la clase Usuarios que contiene todos los datos de los usuarios.          
	 * @return usuario Objeto de la clase Usuario que contiene las informaciones del ususario que ha iniciado sesion
	 */
	public static Usuario registrarUsuario(Usuarios usuarios) {	// Devuelve objeto de tipo Usuario por que devuelve al ususario que se registra
		boolean resultado = true; // para ejecutar los whiles
		boolean contieneMayuscula = false, contieneNumero = false;
		String identificador = "", password = "", nombre = "", apellidos = "", lugar = "", frase = "";
		int dia = 0, mes = 0, year = 0;
		byte estado = 0, sexo = 0;
		
		// IDENTIFICADOR
		while (resultado) {
			System.out.println("Nombre de usuario: ");
			identificador = texto.nextLine();				// El usuario introduce un identificador para su cuenta
			if (identificador.length() > 10) 				// posibles errores, en este caso el identificador no puede ser mayor a 10 caract�res
				Errores.mostrarError(203);
			else if (usuarios.buscarUsuario(identificador) != null)
				Errores.mostrarError(204);
			else resultado = false;
		}
		
		// CONTRASENA									// FALTA REPASAR LO DE COMPROBAR QUE LA CONTRASE�A NO CONTENGA PALABRAS ESPECIFICAS (no que no se esas palabras)
		while (!resultado) {
			System.out.println("Contrasenia: ");
			password = texto.nextLine();
			
			for (int i=0;i<password.length(); i++)
			{
			   if (Character.isUpperCase(password.charAt(i))) 
			      contieneMayuscula = true;
			   if (Character.isDigit(password.charAt(i)))
				   contieneNumero = true;
			}
			
			if (password.length() < 6)
				Errores.mostrarError(205);
			else if (!contieneNumero) // Expresion regular para comprobar que hay un nÃºmero
				Errores.mostrarError(206);
			else if (!contieneMayuscula)
				Errores.mostrarError(207);		// No tiene una mayÃºscula
			else if (password.toLowerCase().contains("contrasenia") || password.toLowerCase().contains("password") || password.toLowerCase().contains(identificador))
				Errores.mostrarError(208);
			else resultado = true;
		}
		
/////////////////////////////////////////////////////////////////////////////////////		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(Integer.toString(9239).getBytes());
		    md.update(password.getBytes());
		    byte[] out = md.digest();
		    char[] hexArray = "0123456789ABCDEF".toCharArray();
		    char[] hexChars = new char[out.length * 2];
		    int aux;
		    for (int i = 0; i < out.length; i++) {
		    	aux = out[i] & 0xFF;
		        hexChars[i * 2] = hexArray[aux >>> 4];
		        hexChars[i * 2 + 1] = hexArray[aux & 0x0F];
		    }
		    password = new String(hexChars);
		} catch (NoSuchAlgorithmException e1) {

		}
/////////////////////////////////////////////////////////////////////////////////////
		
		// NOMBRE DEL USUARIO
		while (resultado) {
			System.out.println("Nombre: ");
			nombre = texto.nextLine();
			if (nombre.length() > 15)
				Errores.mostrarError(209);
			else resultado = false;
		}
		
		// APELLIDOS
		while (!resultado) {
			System.out.println("Apellidos: ");
			apellidos = texto.nextLine();
			if (apellidos.length() > 30)
				Errores.mostrarError(210);
			else resultado = true;
		}
		
		// DIA DE NACIMIENTO
		while (resultado) {
			System.out.println("Dia de nacimiento: ");
			try
	        {
				dia = numero.nextInt();
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	            numero.nextLine();
	        }
			if (dia < 1 || dia > 31)
				Errores.mostrarError(211);
			else resultado = false;
		}
		
		// MES DE NACIMIENTO
		while (!resultado) {
			System.out.println("Mes de nacimiento: ");
			try
	        {
				mes = numero.nextInt();
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	            numero.nextLine();
	        }
			if (mes < 1 || mes > 12)
				Errores.mostrarError(212);
			else resultado = true;
		}
				
		// AÃ‘O DE NACIMIENTO
		while (resultado) {
			System.out.println("Anio de nacimiento: ");
			try
	        {
				year = numero.nextInt();
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	            numero.nextLine();
	        }
			if (year < 1900 || year > 2015)
				Errores.mostrarError(213);
			else resultado = false;
		}
		
		// LUGAR DE RESIDENCIA
		while (!resultado) {
			System.out.println("Lugar de residencia: ");
			lugar = texto.nextLine();
			if (nombre.length() > 15)
				Errores.mostrarError(214);
			else resultado = true;
		}
		
		// ESTADO CIVIL
		while (resultado) {
			System.out.println("Estado civil: (1 = soltero, 2 = con pareja, 3 = casado, 4 = prefiero no decirlo)");
			try
	        {
				estado = bait.nextByte();
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	            bait.nextLine();
	        }
			if (estado < 1 || estado > 4)
				Errores.mostrarError(215);
			else resultado = false;
		}
				
		// FRASE FAVORITA
		while (!resultado) {
			System.out.println("Frase favorita: ");
			frase = texto.nextLine();
			if (frase.length() > 50)
				Errores.mostrarError(216);
			else resultado = true;
		}
		
		// SEXO
		while (resultado) {
			System.out.println("Sexo: (1 = hombre, 2 = mujer, 3 = prefiero no decirlo)");
			try
	        {
				sexo = bait.nextByte();
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	            bait.nextLine();
	        }
			if (sexo < 1 || sexo > 3)
				Errores.mostrarError(217);
			else resultado = false;
		}
				
		return usuarios.registrarUsuario(false, identificador, password, nombre, apellidos, lugar, dia, mes, year, frase, estado, sexo);
	}
	
	/**
	 * Metodo que permite conseguir la opcion elegida por el usuario                         
	 * <p>
	 * @return opcionSeleccionada Entero que indica la opcion elegida por el usuario.
	 */
	public static int opcionMenu() {
		int opcionSeleccionada = 0;
		try
        {
			opcionSeleccionada = opcion.nextInt();
        } 
        catch (java.util.InputMismatchException e)
        {
            opcion.nextLine();
        }
		
		
		switch (opcionSeleccionada) {
		case 1:
			opcionSeleccionada = 20; // Crear evento
			break;
		case 2:
			opcionSeleccionada = 5;	// Buscar eventos
			break;
		case 3:
			opcionSeleccionada = 6; // Buscar usuarios
			break;
		case 4:
			opcionSeleccionada = 7; // Ver Perfil
			break;
		case 5:
			opcionSeleccionada = 3; // Salir del programa
			break;
		default:
			opcionSeleccionada = -1; // Error
			break;
		}
		
		return opcionSeleccionada;
	}
	
	/**
	 * Metodo que permite al usuario filtrar eventos                            
	 * <p>
	 * @param  eventos Objeto de la clase Eventos que contiene todos los datos de los eventos          
	 * @return eventos Objeto de la clase Eventos que contiene todos los datos de los eventos  filtrados
	 */
	public static ArrayList<Evento> filtrarEventos(Eventos eventos) {		// Devuelve un objeto Eventos que se correcpjnde con topdos los eventos filtrados
		int dia = 0, mes = 0, year = 0;
		byte ambito = 0;
		ArrayList<Evento> eventosFiltrados = new ArrayList<Evento>();
		
		try{
			System.out.println("Nombre de evento: ");
			String nombreEvento = texto.nextLine();
			
			System.out.println("Lugar de realizacion del evento");
			String lugar = texto.nextLine();
			
			System.out.println("Dia del evento:");
			String diaStr = texto.nextLine();
			if (diaStr.equals("")) 
				dia = 0;
			else dia = Integer.parseInt(diaStr);
			
			System.out.println("Mes del evento:");
			String mesStr = texto.nextLine();
			if (mesStr.equals("")) 
				mes = 0;
			else mes = Integer.parseInt(mesStr);
			
			System.out.println("Anio del evento:");
			String yearStr = texto.nextLine();
			if (yearStr.equals("")) 
				year = 0;
			else year = Integer.parseInt(yearStr);
			
			System.out.println("Ambito: (1 : deportivo, 2 : cultural, 3 : social, 4 : musical, 5 : benefico, 6 : gastronomico, 7 : otro)");
			String ambitoStr = texto.nextLine();
			if (ambitoStr.equals("")) 
				ambito = 0;
			else ambito = Byte.parseByte(ambitoStr);
			
			System.out.println("Usuario inscrito:");
			String usuarioInscrito = texto.nextLine();
			
			ArrayList<Evento> aux = eventos.filtrarEventos(nombreEvento, lugar, dia, mes, year, ambito, usuarioInscrito);
			if (aux != null && !aux.isEmpty()) eventosFiltrados.addAll(aux);
	
			return eventosFiltrados;
			
		} catch (NumberFormatException e){
			Errores.mostrarError(220);
			return null;
		}
	}
	
	/**
	 * Metodo que permite filtrar usuarios                           
	 * <p>
	 * @param  usuarios Objeto de la clase Usuarios que contiene todos los datos de los usuarios.         
	 * @return usuarios Objeto de la clase Usuarios que contiene todos los datos de los usuarios filtrados por lo que buscaba el usuario
	 */
	public static ArrayList<Usuario> filtrarUsuarios(Usuarios usuarios) {
		int dia = 0, mes = 0, year = 0;
		byte estado = 0;
		
		try {
			System.out.println("Nombre de usuario: ");
			String nombreUsuario = texto.nextLine();
			
			System.out.println("Nombre: ");
			String nombre = texto.nextLine();
			
			System.out.println("Apellidos: ");
			String apellidos = texto.nextLine();
			
			System.out.println("Lugar de residencia: ");
			String lugar = texto.nextLine();
			
			System.out.println("Dia de nacimiento:");
			String diaStr = texto.nextLine();
			if (diaStr.equals("")) 
				dia = 0;
			else dia = Integer.parseInt(diaStr);
			
			System.out.println("Mes de nacimiento:");
			String mesStr = texto.nextLine();
			if (mesStr.equals("")) 
				mes = 0;
			else mes = Integer.parseInt(mesStr);
			
			System.out.println("Anio de nacimiento:");
			String yearStr = texto.nextLine();
			if (yearStr.equals("")) 
				year = 0;
			else year = Integer.parseInt(yearStr);
			
			System.out.println("Estado civil: (1 = soltero, 2 = con pareja, 3 = casado, 4 = prefiero no decirlo)");
			String estadoStr = texto.nextLine();
			if (estadoStr.equals("")) 
				estado = 0;
			else estado = Byte.parseByte(estadoStr);
			
			System.out.println("Frase favorita: ");
			String frase = texto.nextLine();
	
			return usuarios.filtrarUsuarios(nombreUsuario, nombre, apellidos, lugar, dia, mes, year, estado, frase);
		
		} catch (NumberFormatException e){
			Errores.mostrarError(220);
			return null;
		}
	}
	
	/**
	 * Metodo que permite conseguir la opcion elegida por el usuario en el menu                           
	 * <p>
	 * Si opcion = 1 -> resultado = 10 (opcion modificar perfil)
	 * """"""""""""2 """""""""""""""11 (opcion eliminar cuenta de usuario)
	 * """"""""""""3""""""""""""""""12 (va a ver tablon)
	 * """""""""""""4 """""""""""""""4 (sale, va hacia el menu principal otra vez)
	 * @return opcionSeleccionada Entero que indica la opcion elegida por el usuario.
	 */
	 
	public static int opcionPerfil() {
		int opcionSeleccionada = 0;
		try
        {
			opcionSeleccionada = opcion.nextInt();
        } 
        catch (java.util.InputMismatchException e)
        {
            opcion.nextLine();
        }
		
		if (opcionSeleccionada > 0 && opcionSeleccionada < 4)	opcionSeleccionada += 9;
		else if (opcionSeleccionada == 4);
		else 	opcionSeleccionada = -1;
		
		return opcionSeleccionada;
	}
	
	/**
	 * Metodo que permite conseguir la opcion de comentario                          
	 * <p>
	 * Si opcion = 1 -> resultado = 4 
	 * """"""""""""2 """""""""""""""3 
	 * """"""""""""3""""""""""""""""23
	 * sino opcion = -1
	 * @return opcionSeleccionada Entero que indica la opcion elegida.
	 */
	 
	 public static int opcionComentario() {
			int opcionSeleccionada = 0;
			try
	        {
				opcionSeleccionada = opcion.nextInt();
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	            opcion.nextLine();
	        }
			
			if (opcionSeleccionada == 1) {
				return opcionSeleccionada = 4;
			} else {
				opcionSeleccionada = 4;
			}
			
			return opcionSeleccionada;
		}

	
	/**
	 * Metodo que permite conseguir la opcion elegida por un usuario en un menu                           
	 * <p>
	 * Si opcion = 1 -> resultado = 21 (opcion seguir usuario)
	 * """"""""""""2 """""""""""""""22 (opcion dejar de seguir usuario)
	 * """"""""""""3""""""""""""""""23 (opcion ver tablon)
	 * """""""""""""4 """""""""""""""4 (sale, va hacia el menu principal otra vez)
	 * @return opcionSeleccionada Entero que indica la opcion elegida por el usuario.
	 */
	public static int opcionUsuario() {
		int opcionSeleccionada = 0;
		try
        {
			opcionSeleccionada = opcion.nextInt();
        } 
        catch (java.util.InputMismatchException e)
        {
            opcion.nextLine();
        }
		
		switch (opcionSeleccionada) {
		case 1:
			return opcionSeleccionada = 4;
		case 2:
			return opcionSeleccionada = 23;
		case 3:
			return opcionSeleccionada = 25;
		case 4:
			return opcionSeleccionada = 21;
		case 5:
			return opcionSeleccionada = 22;
		default:
			opcionSeleccionada = -1;
		}
		
		return opcionSeleccionada;
	}
	
	/**
	 * Metdodo que permite al usuario modificar su perfil                           
	 * <p>
	 * @param usuarios Objeto de la clase Usuarios que contiene todos los datos de los usuarios.
	 * @param  usuario Objeto de la clase Usuario que contiene todos los datos de el usuario que se va ser ser modificado.        
	 * @return usuario Objeto de la clase Usuario que contiene todos los datos de el usuario que ha sido modificado.
	 */
	public static int modificarPerfil(Usuarios usuarios, Usuario usuario) {
		boolean resultado = true; // para ejecutar los whiles
		boolean contieneMayuscula = false, contieneNumero = false;
		String password = "", nombre = "", apellidos = "", lugar = "", frase = "";
		int dia = 0, mes = 0, year = 0;
		byte estado = 0, sexo = 0;
		
		// PASSWORD
		while (!resultado) {
			System.out.println("Nueva Contrasena: ");
			password = texto.nextLine();
			if (password.equals("")) password = usuario.getPassword();
			
			for (int i=0;i<password.length(); i++)
			{
			   if (Character.isUpperCase(password.charAt(i))) 
			      contieneMayuscula = true;
			   if (Character.isDigit(password.charAt(i)))
				   contieneNumero = true;
			}
			
			if (password.length() < 6)
				Errores.mostrarError(205);
			else if (!contieneNumero) // Expresion regular para comprobar que hay un nÃºmero
				Errores.mostrarError(206);
			else if (!contieneMayuscula)
				Errores.mostrarError(207);		// No tiene una mayÃºscula
			else if (password.toLowerCase().contains("contrasenia") || password.toLowerCase().contains("password") || password.toLowerCase().contains(usuario.getID()))
				Errores.mostrarError(208);
			else resultado = true;
		}
		
		try {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(Integer.toString(9239).getBytes());
		md.update(password.getBytes());
		byte[] out = md.digest();
		char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[out.length * 2];
		int aux;
		for (int i = 0; i < out.length; i++) {
			aux = out[i] & 0xFF;
			hexChars[i * 2] = hexArray[aux >>> 4];
			hexChars[i * 2 + 1] = hexArray[aux & 0x0F];
		}
	    password = new String(hexChars);
		} catch (NoSuchAlgorithmException e1) {
		
		}
		
		usuario.cambiarPassword(password);
		
		// NOMBRE DEL USUARIO
		while (resultado) {
			System.out.println("Nuevo nombre: ");
			nombre = texto.nextLine();
			if (nombre.equals("")) nombre = usuario.getNombre();
			
			if (nombre.length() > 15)
				Errores.mostrarError(209);
			else resultado = false;
		}
		
		// APELLIDOS
		while (!resultado) {
			System.out.println("Nuevos apellidos: ");
			apellidos = texto.nextLine();
			if (apellidos.equals("")) apellidos = usuario.getApellidos();
			if (apellidos.length() > 30)
				Errores.mostrarError(210);
			else resultado = true;
		}
		
		// DIA DE NACIMIENTO
		while (resultado) {
			System.out.println("Nuevo dia de nacimiento: ");
			String diaStr = texto.nextLine();
			if (diaStr.equals("")) {
				dia = usuario.getFechaDeNacimiento().get(GregorianCalendar.DAY_OF_MONTH);
				resultado = false;
				break;
			} else dia = Integer.parseInt(diaStr);
			if (dia < 1 || dia > 31) {
				System.out.println(diaStr);
				Errores.mostrarError(211);}
			else resultado = false;
		}
		
		// MES DE NACIMIENTO
		while (!resultado) {
			System.out.println("Nuevo mes de nacimiento: ");
			String mesStr = texto.nextLine();
			if (mesStr.equals("")) {
				mes = usuario.getFechaDeNacimiento().get(GregorianCalendar.MONTH) + 1;
				resultado = true;
				break;
			} else mes = Integer.parseInt(mesStr);
			if (mes < 1 || mes > 12)
				Errores.mostrarError(212);
			else resultado = true;
		}
				
		// ANO DE NACIMIENTO
		while (resultado) {
			System.out.println("Nuevo anio de nacimiento: ");
			String yearStr = texto.nextLine();
			if (yearStr.equals("")) {
				year = usuario.getFechaDeNacimiento().get(GregorianCalendar.YEAR);
				resultado = false;
				break;
			} else year = Integer.parseInt(yearStr);
			if (year < 1900 || year > 2015)
				Errores.mostrarError(213);
			else resultado = false;
		}
		
		// LUGAR DE RESIDENCIA
		while (!resultado) {
			System.out.println("Nuevo lugar de residencia: ");
			lugar = texto.nextLine();
			if (lugar.equals("")) lugar = usuario.getLugarDeResidencia();
			if (nombre.length() > 15)
				Errores.mostrarError(214);
			else resultado = true;
		}
		
		// ESTADO CIVIL
		while (resultado) {
			System.out.println("Nuevo estado civil: (1 = soltero, 2 = con pareja, 3 = casado, 4 = prefiero no decirlo");
			String estadoStr = texto.nextLine();
			if (estadoStr.equals("")) {
				estado = usuario.getEstadoCivil();
				resultado = false;
				break;
			} else estado = Byte.parseByte(estadoStr);
			if (estado < 1 || estado > 4)
				Errores.mostrarError(215);
			else resultado = false;
		}
				
		// FRASE FAVORITA
		while (!resultado) {
			System.out.println("Nueva frase favorita: ");
			frase = texto.nextLine();
			if (frase.equals("")) frase = usuario.getFraseFavorita();
			if (frase.length() > 50)
				Errores.mostrarError(216);
			else resultado = true;
		}
		
		// SEXO
		while (resultado) {
			System.out.println("Nuevo sexo: (1 = hombre, 2 = mujer, 3 = prefiero no decirlo");
			String sexoStr = texto.nextLine();
			if (sexoStr.equals("")) {
				sexo = usuario.getSexo();
				break;
			} else sexo = Byte.parseByte(sexoStr);
			if (sexo < 1 || sexo > 3)
				Errores.mostrarError(217);
			else resultado = false;
		}
				
		return usuarios.modificarUsuario(usuario.getID(), nombre, apellidos, lugar, dia, mes, year, frase, estado, sexo);
	}
	
	/**
	 * Metodo que permite al conseguir la opcion elegida por el usuario                          
	 * <p>
	 * Si opcion = 1 -> resultado = 13 (opcion modificar evento)
	 * """"""""""""2 """""""""""""""14 (opcion eliminar evento)
	 * """"""""""""3""""""""""""""""15 (opcion ver comentarios)
	 * """"""""""""4""""""""""""""""16 (opcion seguir evento)
	 * """"""""""""5""""""""""""""""17 (opcion dejar de seguir evento)
	 * """""""""""""6 """""""""""""""4 (sale, va hacia el menu principal otra vez) 
	 * @return opcionSeleccionada Entero que indica la opcion elegida por el usuario.
	 */
	public static int opcionEvento() {
		int opcionSeleccionada = 0;
		try
        {
			opcionSeleccionada = opcion.nextInt();
        } 
        catch (java.util.InputMismatchException e)
        {
            opcion.nextLine();
        }
		
		if(opcionSeleccionada > 0 && opcionSeleccionada < 6)	opcionSeleccionada += 12;
		else if (opcionSeleccionada == 6)	opcionSeleccionada = 24;
		else if (opcionSeleccionada == 7)	opcionSeleccionada = 4;
		else opcionSeleccionada = -1;

		return opcionSeleccionada;
	}
	
	/**
	 * Metodo que permite al usuario crear un evento                          
	 * <p>
	 * @param  usuario Objeto de la clase Usuario que contiene los datos de el usuario.         
	 * @return eventos Objeto de la clase Eventos que contiene todos los datos de los eventos 
	 */
	public static int crearEvento(Usuario usuario, Eventos eventos) {
		boolean resultado = true; // para ejecutar los whiles
		String nombre = "", lugar = "", descripcion = "";
		int dia = 0, mes = 0, year = 0;
		byte ambito = 0;
		
		// NOMBRE DEL EVENTO
		while (resultado) {
			System.out.println("Nombre del evento: ");
			nombre = texto.nextLine();				// El usuario introduce un nombre para le evento
			if (nombre.length() > 30) 				
				Errores.mostrarError(218);
			else resultado = false;
		}
		
		// LUGAR DE RESIDENCIA
		while (!resultado) {
			System.out.println("Lugar del evento: ");
			lugar = texto.nextLine();
			if (nombre.length() > 30)
				Errores.mostrarError(219);
			else resultado = true;
		}
				
		// AMBITO DEL EVENTO
		while (resultado) {
			System.out.println("Ambito: (1 : deportivo, 2 : cultural, 3 : social, 4 : musical, 5 : benefico, 6 : gastronomico, 7 : otro)");
			try
	        {
				ambito = bait.nextByte();
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	            bait.nextLine();
	        }
			if (ambito < 1 || ambito > 7)
				Errores.mostrarError(220);
			else resultado = false;
		}
		
		// DIA DEL EVENTO
		while (!resultado) {
			System.out.println("Dia del evento: ");
			try
	        {
				dia = numero.nextInt();
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	            numero.nextLine();
	        }
			if (dia < 1 || dia > 31)
				Errores.mostrarError(211);
			else resultado = true;
		}
		
		// MES DEL EVENTO
		while (resultado) {
			System.out.println("Mes del evento: ");
			try
	        {
				mes = numero.nextInt();
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	            numero.nextLine();
	        }
			if (mes < 1 || mes > 12)
				Errores.mostrarError(212);
			else resultado = false;
		}
				
		// YEAR DEL EVENTO
		while (!resultado) {
			System.out.println("Anio del evento: ");
			try
	        {
				year = numero.nextInt();
	        } 
	        catch (java.util.InputMismatchException e)
	        {
	            numero.nextLine();
	        }
			if (year < 2015 || year > 3000)
				Errores.mostrarError(219);
			else resultado = true;
		}
				
		// DESCRIPCION DEL EVENTO
		while (resultado) {
			System.out.println("Descripcion del evento: ");
			descripcion = texto.nextLine();
			if (descripcion.length() > 200)
				Errores.mostrarError(221);
			else resultado = false;
		}
				
		eventos.addEvento(usuario.getID(), nombre, lugar, ambito, dia, mes, year, descripcion);
		return 4;
	}
	
	/**
	 * Metodo que permite a un usuario modificar su evento                         
	 * <p>
	 * @param  usuario Objeto de la clase Usuario que contiene los datos de el usuario.           
	 * @param  evento Objeto de la clase Evento que contiene los datos de el evento a modificar 
	 * @return 4 el evento ha sido modificado Description text text text.
	 */
	public static int modificarEvento(Usuario usuaio, Evento evento) {
		boolean resultado = true; // para ejecutar los whiles
		String nombre = "", lugar = "", descripcion = "";
		int dia = 0, mes = 0, year = 0;
		byte ambito = 0;
		
		// NOMBRE DEL EVENTO
		while (resultado) {
			System.out.println("Nuevo nombre del evento: ");
			nombre = texto.nextLine();				// El usuario introduce un nombre para le evento
			if (nombre.equals("")) nombre = evento.getNombre();
			if (nombre.length() > 30) 
				Errores.mostrarError(218);
			else resultado = false;
		}
		
		// LUGAR DE RESIDENCIA
		while (!resultado) {
			System.out.println("Nuevo lugar del evento: ");
			lugar = texto.nextLine();
			if (lugar.equals("")) lugar = evento.getLugar();
			if (nombre.length() > 15)
				Errores.mostrarError(219);
			else resultado = true;
		}
				
		// AMBITO DEL EVENTO
		while (resultado) {
			System.out.println("Nuevo ambito: (1 : deportivo, 2 : cultural, 3 : social, 4 : musical, 5 : benefico, 6 : gastronomico, 7 : otro)");
			String ambitoStr = texto.nextLine();
			if (ambitoStr.equals("")) {
				ambito = (byte) evento.getAmbito();
				resultado = false;
				break;
			} else ambito = Byte.parseByte(ambitoStr);
			if (ambito < 1 || ambito > 7)
				Errores.mostrarError(220);
			else resultado = false;
		}
		
		// DIA DEL EVENTO
		while (!resultado) {
			System.out.println("Nuevo dia del evento: ");
			String diaStr = texto.nextLine();
			if (diaStr.equals("")) {
				dia = evento.getFecha().get(GregorianCalendar.DAY_OF_MONTH);
				resultado = true;
				break;
			} else dia = Integer.parseInt(diaStr);
			if (dia < 1 || dia > 31)
				Errores.mostrarError(211);
			else resultado = true;
		}
		
		// MES DEL EVENTO
		while (resultado) {
			System.out.println("Nuevo mes del evento: ");
			String mesStr = texto.nextLine();
			if (mesStr.equals("")) {
				mes = evento.getFecha().get(GregorianCalendar.MONTH) + 1;
				resultado = false;
				break;
			} else mes = Integer.parseInt(mesStr);
			if (mes < 1 || mes > 12)
				Errores.mostrarError(212);
			else resultado = false;
		}
				
		// YEAR DEL EVENTO
		while (!resultado) {
			System.out.println("Nuevo anio del evento: ");
			String yearStr = texto.nextLine();
			if (yearStr.equals("")) {
				year = evento.getFecha().get(GregorianCalendar.YEAR);
				resultado = true;
				break;
			} else year = Integer.parseInt(yearStr);
			if (year < 2015 || year > 3000)
				Errores.mostrarError(219);
			else resultado = true;
		}
				
		// DESCRIPCION DEL EVENTO
		while (resultado) {
			System.out.println("Nueva descripcion del evento: ");
			descripcion = texto.nextLine();
			if (descripcion.equals("")) descripcion = evento.getDescripcion();
			if (descripcion.length() > 200)
				Errores.mostrarError(221);
			else resultado = false;
		}
				
		evento.editarEvento(nombre, lugar, ambito, dia, mes, year, descripcion);
		return 4;
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
	public static void comentarEvento(Evento evento, Usuario usuario){
		boolean resultado = false;
		String mensaje = "";
		
		Calendar fecha = Calendar.getInstance();
		
		// TEXTO
		while (!resultado) {
			System.out.println("Introduce el mensaje: ");
			mensaje = texto.nextLine();
			resultado = true;
		}
				
		evento.addComentario(usuario, mensaje, fecha.get(Calendar.DATE), fecha.get(Calendar.MONTH), 
				fecha.get(Calendar.YEAR), fecha.get(Calendar.HOUR), fecha.get(Calendar.MINUTE), 
				fecha.get(Calendar.SECOND));
	}
	
	/**
	 * SMetodo que permite comentar a un usuario.                           
	 * <p>
	 * @param  Usuario usuarioSeleccionado que vamos a comentar.          
	 * @param  Usuario usuario que comenta.
	 */
	public static void comentarUsuario(Usuario usuarioSeleccionado, Usuario usuario){
		boolean resultado = false;
		String mensaje = "";
		
		Calendar fecha = Calendar.getInstance();
		
		// TEXTO
		while (!resultado) {
			System.out.println("Introduce el mensaje: ");
			mensaje = texto.nextLine();
			resultado = true;
		}
				
		usuarioSeleccionado.addComentario(usuario, mensaje, fecha.get(Calendar.DATE), fecha.get(Calendar.MONTH), 
				fecha.get(Calendar.YEAR), fecha.get(Calendar.HOUR), fecha.get(Calendar.MINUTE), 
				fecha.get(Calendar.SECOND));
	}
}
