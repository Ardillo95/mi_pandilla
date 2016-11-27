package Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Model.Evento;
import Model.Eventos;
import Model.Usuario;
import Model.Usuarios;

public class TestImportExport {

	//Esto tené k estar en el mein shurmanico
	Usuarios usuarios = new Usuarios();
	Eventos eventos = new Eventos();
	Eventos eventosPromocionados = new Eventos();
	
	public static void main(String args[]){		
		TestImportExport test = new TestImportExport();
		
		int cosa = test.eventos.addEvento("Abel", "Consierto", "Rivas", (byte)2, 15, 11, 1995, "kOnsiErToH kaNi ShurManIKos");
		Evento evento = test.eventos.buscarEvento(cosa);
		evento.addComentario(new Usuario(), "Que bunico tronko", 10, 11, 1945, 12, 1, 0);
		evento.addComentario(new Usuario(), "Ya vesh", 10, 11, 1980, 12, 1, 0);
		System.out.println(test.exportarEventos("Eventos.txt"));
		test.importarEventos("Eventos.txt", test.eventos);
		test.eventos.mostrarEventos();
	}
	
	public int exportar(String nombreFicheroEventos, String nombreFicheroEventosPatrocinados, String nombreFicheroUsuarios){
		return exportarEventos(nombreFicheroEventos)+exportarEventos(nombreFicheroEventosPatrocinados)+exportarUsuarios(nombreFicheroUsuarios);
	}
	
	public int exportarEventos(String nombreFicheroEventos){
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
	
	
	public int exportarUsuarios(String nombreFicheroUsuarios){
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
	
	public int importar(String nombreFicheroEventos, String nombreFicheroEventosPatrocinados, 
			String nombreFicheroUsuarios, Eventos eventos, Eventos eventosPatrocinados, Usuarios usuarios){
		return importarEventos(nombreFicheroEventos, eventos)+
				importarEventos(nombreFicheroEventosPatrocinados, eventosPatrocinados)+
				importarUsuarios(nombreFicheroUsuarios, usuarios);
	}
	
	public int importarEventos(String nombreFicheroEventos, Eventos eventos){
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
	
	public int importarUsuarios(String nombreFicheroUsuarios, Usuarios usuarios){
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
				buffer.close();
			}
		} catch (FileNotFoundException e) {
			return -1;
		} catch (IOException e){
			return -1;
		}
		return 0;
	}
	
}
