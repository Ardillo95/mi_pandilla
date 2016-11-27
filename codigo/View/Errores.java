package View;

public final class Errores {
	private Errores(){
		
	}
	/**
     	 * Define los mensajes correspondientes a cada tipo de error
     	 * @param Como parametro recibe el código correspondiente para identificar el tipo de error
     	 * @return void
     	 */
	public static void mostrarError(int codigo) {
		System.out.print("Error(" + codigo + "): ");
		switch (codigo) {
		case 101: case 102: case 104: case 106: case 107: case 109:
			System.out.print("no existe la opcion seleccionada");
			break;
		case 103:
			System.out.print("no se encuentran eventos aplicando este filtro");
			break;
		case 105:
			System.out.print("no se encuentran usuarios aplicando este filtro");
			break;
		case 108:
			System.out.println("error al eliminar la cuenta");
		case 201:
			System.out.print("nombre de usuario incorrecto");
			break;
		case 202:
			System.out.print("contrasena incorrecta");
			break;
		case 203:
			System.out.print("nombre de usuario muy largo (maximo 10 caractares)");
			break;
		case 204:
			System.out.print("nombre de usuario ya existe");
			break;
		case 205:
			System.out.print("contrasena muy corta (minimo 6 caracteres)");
			break;
		case 206:
			System.out.print("la contrasena no contiene ningun numero");
			break;
		case 207:
			System.out.print("la contrasena no contiene ninguna letra mayuscula");
			break;
		case 208:
			System.out.print("la contrasena no puede ser ni tu nombre de usuario, ni 'password' ni 'contrasena'");
			break;
		case 209:
			System.out.print("nombre demasiado largo (maximo 15 caractares");
			break;
		case 210:
			System.out.print("apellidos demasiado largos (maximo 30 caractares)");
			break;
		case 211:
			System.out.print("dia de nacimiento incorrecto (tiene que estar entre 1 y 31)");
			break;
		case 212:
			System.out.print("mes de nacimiento incorrecto (tiene que estar entre 1 y 12)");
			break;
		case 213:
			System.out.print("ano de nacimiento incorrecto (tiene que estar entre 1900 y 2015)");
			break;
		case 214:
			System.out.print("nombre de lugar de residencia demasiado largo (maximo 15 caractares)");
			break;
		case 215:
			System.out.print("estado civil erroneo");
			break;
		case 216:
			System.out.print("frase favorita demasiado larga");
			break;
		case 217:
			System.out.print("sexo erroneo");
			break;
		case 218:
			System.out.print("el nombre del evento es demasiado largo");
			break;
		case 219:
			System.out.print("ano del evento incorrecto (tiene que estar entre 2015 y 3000)");
			break;
		case 220:
			System.out.print("en los campos numericos solo deben ser introducidos numeros");
			break;
		case 501:
			System.out.print("el comentario que quiere borrar no existe");
			break;
		case 502:
			System.out.print("el comentario existe pero no se pudo borrar");
			break;
		case 503:
			System.out.print("el comentario que quiere editar no existe");
			break;
		case 504:
			System.out.print("no hay comentarios que mostrar");
			break;
		case 505:
			System.out.print("el comentario que busca no existe");
			break;
		case 601:
			System.out.print("no fue posible borrar el comentario especificado");
			break;
		case 602:
			System.out.print("no fue posible editar el comentario especificado");
			break;
		case 603:
			System.out.print("el usuario especificado ya sigue el evento");
			break;
		case 604:
			System.out.print("el usuario especificado no sigue el evento");
			break;
		case 701:
			System.out.print("el evento que quiere borrar no existe");
			break;
		case 702:
			System.out.print("el evento existe pero no se pudo borrar");
			break;
		case 703:
			System.out.print("el evento que quiere editar no existe");
			break;
		case 704:
			System.out.print("no hay eventos que mostrar");
			break;
		case 705:
			System.out.print("el evento que busca no existe");
			break;
		case 706:
			System.out.print("no existen eventos en la lista, imposible buscar");
			break;
		case 801:
			System.out.print("el usuario no est� inscrito en ning�n evento");
			break;
		case 802:
			System.out.print("no fue posible borrar el comentario especificado");
			break;
		case 803:
			System.out.print("no fue posible editar el comentario especificado");
			break;
		case 804:
			System.out.print("el usuario especificado ya sigue el evento");
			break;
		case 805:
			System.out.print("el usuario especificado no sigue el evento");
			break;
		case 806:
			System.out.print("el usuario ya sigue al usuario especificado");
			break;
		case 807:
			System.out.print("el usuario no sigue al usuario especificado");
			break;
		case 901:
			System.out.print("el usuario que quiere borrar no existe");
			break;
		case 902:
			System.out.print("el usuario existe pero no se pudo borrar");
			break;
		case 903:
			System.out.print("el usuario que quiere editar no existe");
			break;
		case 904:
			System.out.print("no hay usuarios que mostrar");
			break;
		case 905:
			System.out.print("el usuario que busca no existe");
			break;
		case 906:
			System.out.print("no existen usuarios en la lista, imposible buscar");
			break;
		}
		System.out.println();
	}
}
