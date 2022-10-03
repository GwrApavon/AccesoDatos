package EjercicioObjetos;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TestAgenda {
	

	public static void main(String[] args){
		
		String nombreFichero = "src//EjercicioObjetos//agenda.dat";
		
		Agenda a = new Agenda();
	
		try{
			FileOutputStream fs = new FileOutputStream(nombreFichero);//Creamos el archivo
			ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el m�todo writeObject() que necesitamos
			Scanner sc = new Scanner(System.in);
			String esc = "";
			do{
				System.out.println("Nombre:");
				String nombre = sc.nextLine();
				System.out.println("Apellido:");
				String pa = sc.nextLine();
				System.out.println("Apellido 2:");
				String sa = sc.nextLine();
				
				a.setNombre(nombre);
				a.setP_Apellido(pa);
				a.setS_Apellido(sa);
				os.writeObject(a);
				
				System.out.println("Desea continuar añadiendo?");
				esc = sc.nextLine();
				
			}while(esc.equalsIgnoreCase("Si"));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

		ArrayList <Agenda> agenda = new ArrayList<Agenda>();
		//Ahora lo leemos
		try{
			  
			  FileInputStream fis = new FileInputStream(nombreFichero);
			  ObjectInputStream ois = new ObjectInputStream(fis);
			  boolean terminar = false;
			  while(!terminar){
				  agenda.add((Agenda) ois.readObject());//El m�todo readObject() recupera el objeto
			  }
			  ois.close();
			  fis.close();
			}catch(EOFException e) {
				System.out.println("Ha terminado");
			}catch(FileNotFoundException e){
			  e.printStackTrace();
			}catch(IOException e){
			  e.printStackTrace();
			}catch(ClassNotFoundException e){
			  e.printStackTrace();
			}
		for (Iterator<Agenda> iterator = agenda.iterator(); iterator.hasNext();) {
			Agenda agenda2 = (Agenda) iterator.next();
			System.out.println(a);
		}
		
	}
	
}

