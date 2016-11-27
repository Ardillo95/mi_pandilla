package Test;
import Model.Comentarios;
import Model.Usuario;

public class TestComentarios {
	public static void main(String[] args){
		Comentarios comentarios = new Comentarios();
		Usuario usuario = new Usuario();
		
		
		//comentarios.addComentario(usuario, "Tu, Abel es calvo", 10, 11, 2015, 11, 50, 50);
		int ID2 = comentarios.addComentario(usuario, "Un comentario", 11, 11, 2015, 1, 50, 50);
		//comentarios.addComentario(usuario, "Otro comentario", 1, 11, 2015, 5, 50, 50);
		int ID4 = comentarios.addComentario(usuario, "Otro comentario más", 7, 11, 2015, 7, 50, 50);
		//comentarios.addComentario(usuario, "Casi el último", 20, 11, 2015, 6, 50, 50);
		int ID6 = comentarios.addComentario(usuario, "Hale, ya", 19, 11, 2015, 4, 50, 50);
		comentarios.editarComentario(ID2, "GAGA", 17, 11, 2015, 13, 17, 0);
		comentarios.editarComentario(100, "GAGAGAGA", 17, 11, 2015, 13, 17, 0);
		comentarios.editarComentario(ID2, "", 17, 11, 2015, 13, 17, 0);
		comentarios.imprimirComentarios();
		
		comentarios.eliminarComentario(ID2);
		comentarios.eliminarComentario(ID4);
		comentarios.eliminarComentario(ID6);
		comentarios.imprimirComentarios();
		
		comentarios.eliminarComentario(ID2);
		comentarios.eliminarComentario(100);
	}
}

/*public void addComentario(Usuario usuario, String mensaje, int day, int month, 
		int year, int hour, int min, int sec)
public int eliminarComentario(int id)
public int editarComentario(int id, String nuevoMensaje, int day, int month, int year, int hour, int min, int sec)
public void imprimirComentarios()
public Comentario localizarComentario(int id)*/
