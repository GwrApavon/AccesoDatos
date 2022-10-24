/**
 * 
 */
package Ejercicio_21;

import java.io.*;
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
public class DepartamentosXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		GestorDepartamento gestor = new GestorDepartamento("departamentos.dat");
		
		
		try {
			
			ArrayList <Departamento> registro = new ArrayList<Departamento>();
			registro = gestor.leerTodo();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			DOMImplementation implementatio = builder.getDOMImplementation();
			Document document = implementatio.createDocument(null, "Departamentos", null);
			document.setXmlVersion("1.0");

			System.out.println(registro.size());
			for (Departamento d : registro) {
				
				String numeroDep = Integer.toString(d.getNum());
				String nombreDep = d.getNombre().trim();
				String LocalidadDep = d.getLocalidad().trim();
				
				Element raiz = document.createElement("departamento");
				document.getDocumentElement().appendChild(raiz);
			
			
				Element elem = document.createElement("numero");
				Text text = document.createTextNode(numeroDep);
				raiz.appendChild(elem);
				elem.appendChild(text);

				elem = document.createElement("nombre");
				text = document.createTextNode(nombreDep);
				raiz.appendChild(elem);
				elem.appendChild(text);

				elem = document.createElement("localidad");
				text = document.createTextNode(LocalidadDep);
				raiz.appendChild(elem);
				elem.appendChild(text);
			}
			
		      TransformerFactory xformFactory = TransformerFactory.newInstance();  
		      Transformer idTransform = xformFactory.newTransformer();
		      Source input = new DOMSource(document);
		      Result output = new StreamResult(new File("departamentos.xml"));
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
		}
	}

}
