/**
 * 
 */
package EjercicioXML;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;



/**
 * @author alu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		
		
		try {
			
			File myFile = new File("datos.txt");
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
					
			ArrayList <String> agenda = new ArrayList<String>();
			
			String linea = br.readLine();
			while(linea != null) {
				agenda.add(linea);
				linea = br.readLine();
			}
			DocumentBuilder builder = factoria.newDocumentBuilder();
			DOMImplementation implementatio = builder.getDOMImplementation();
			Document document = implementatio.createDocument(null, "Datos", null);
			document.setXmlVersion("1.0");

			for (String string : agenda) {
				
				String nombre = string.split(",")[0];
				String apellidos = string.split(",")[1];
				String altura = string.split(",")[2];
				String edad = calcularEdad(string.split(",")[3]);
				String telefono = string.split(",")[4];
				
				Element raiz = document.createElement("persona");
				document.getDocumentElement().appendChild(raiz);
			
				
				Element elem = document.createElement("nombre");
				Text text = document.createTextNode(nombre);
				raiz.appendChild(elem);
				elem.appendChild(text);

				elem = document.createElement("apellidos");
				text = document.createTextNode(apellidos);
				raiz.appendChild(elem);
				elem.appendChild(text);
				
				elem = document.createElement("altura");
				text = document.createTextNode(altura);
				raiz.appendChild(elem);
				elem.appendChild(text);
				
				elem = document.createElement("edad");
				text = document.createTextNode(edad);
				raiz.appendChild(elem);
				elem.appendChild(text);
				
				elem = document.createElement("telefono");
				text = document.createTextNode(telefono);
				raiz.appendChild(elem);
				elem.appendChild(text);
			}
			
		      TransformerFactory xformFactory = TransformerFactory.newInstance();  
		      Transformer idTransform = xformFactory.newTransformer();
		      Source input = new DOMSource(document);
		      Result output = new StreamResult(new File("datos.xml"));
		      idTransform.transform(input, output);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	public static String calcularEdad(String fecha) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);
		
		return (periodo.getYears() + " años, " + periodo.getMonths() + " meses, "+ periodo.getDays() + " dias");
		
	}

}
