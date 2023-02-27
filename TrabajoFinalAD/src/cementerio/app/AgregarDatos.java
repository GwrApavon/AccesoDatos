/**
 * 
 */
package cementerio.app;


import java.util.ArrayList;
import java.util.Date;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import com.modelo.Difunto;
import com.modelo.Responsable;
import com.modelo.Sepultura;



/**
 * @author alu
 *
 */
public class AgregarDatos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ODB bd = ODBFactory.open("Cementerio.db", "miusuario", "Pass!123456");
		
		//Objetos de la clase Responsable
        Responsable responsable1 = new Responsable(1, "María", "González", "García", "ES0123456789012345678901");
        Responsable responsable2 = new Responsable(2, "Juan", "Sánchez", "Martínez", "ES9876543210987654321098");
        Responsable responsable3 = new Responsable(3, "Lucía", "García", "Pérez", "ES1234567890123456789012");
        Responsable responsable4 = new Responsable(4, "Pedro", "Martínez", "Fernández", "ES2109876543210987654321");
        Responsable responsable5 = new Responsable(5, "Carmen", "Fernández", "García", "ES3210987654321098765432");
        Responsable responsable6 = new Responsable(6, "Javier", "Hernández", "Gómez", "ES0987654321098765432109");
        Responsable responsable7 = new Responsable(7, "Elena", "Sánchez", "Pérez", "ES2345678901234567890123");
        Responsable responsable8 = new Responsable(8, "Marta", "Pérez", "Fernández", "ES3456789012345678901234");
        Responsable responsable9 = new Responsable(9, "Manuel", "Fernández", "Hernández", "ES4567890123456789012345");
        Responsable responsable10 = new Responsable(10, "Ana", "Martínez", "González", "ES5678901234567890123456");
        
        //Objetos de la clase Sepultura
        Sepultura sepultura1 = new Sepultura(1, responsable1, "1234", "Calle Falsa, 123", 1, "Pedro", "García", "A");
        Sepultura sepultura2 = new Sepultura(2, responsable2, "5678", "Avenida Inexistente, 456", 2, "María", "Martínez", "V");
        Sepultura sepultura3 = new Sepultura(3, responsable3, "9012", "Calle Desconocida, 789", 3, "Juan", "García", "A");
        Sepultura sepultura4 = new Sepultura(4, responsable4, "3456", "Avenida Imaginaria, 234", 4, "Lucía", "Pérez", "V");
        Sepultura sepultura5 = new Sepultura(5, responsable5, "7890", "Calle Ficticia, 567", 5, "Pedro", "Martínez", "A");
        Sepultura sepultura6 = new Sepultura(6, responsable6, "2345", "Avenida Inexistente, 890", 6, "Carmen", "García", "V");
        Sepultura sepultura7 = new Sepultura(7, responsable7, "CON-789", "Calle San Juan", 5, "Juan", "Lopez", "Inhumación");
        Sepultura sepultura8 = new Sepultura(8, responsable8, "1234", "Avenida Imaginaria, 123", 8, "Manuel", "Fernández", "A");
        Sepultura sepultura9 = new Sepultura(9, responsable9, "5678", "Calle Falsa, 456", 9, "Ana", "González", "V");
        Sepultura sepultura10 = new Sepultura(10, responsable10, "9012", "Avenida Desconocida, 789", 10, "Elena", "Sánchez", "A");

        //Objetos de la clase Difunto
        Difunto difunto1 = new Difunto(1, sepultura1, "Juan", "González", "Hernández", new Date(74, 4, 12), new Date(2022, 1, 15), new Date(2022, 1, 16));
        Difunto difunto2 = new Difunto(2, sepultura2, "María", "Martínez", "García", new Date(57, 8, 8), new Date(2022, 2, 22), new Date(2022, 2, 23));
        Difunto difunto3 = new Difunto(3, sepultura3, "Lucía", "García", "Pérez", new Date(70, 10, 25), new Date(2022, 3, 29), new Date(2022, 3, 30));
        Difunto difunto4 = new Difunto(4, sepultura4, "Pedro", "Martínez", "Fernández", new Date(61, 5, 18), new Date(2022, 4, 14), new Date(2022, 4, 15));
        Difunto difunto5 = new Difunto(5, sepultura5, "Carmen", "Fernández", "García", new Date(48, 3, 3), new Date(2022, 5, 9), new Date(2022, 5, 10));
        Difunto difunto6 = new Difunto(6, sepultura6, "Javier", "Hernández", "Gómez", new Date(65, 11, 23), new Date(2022, 6, 2), new Date(2022, 6, 3));
        Difunto difunto7 = new Difunto(7, sepultura7, "Elena", "Sánchez", "Pérez", new Date(53, 2, 16), new Date(2022, 7, 19), new Date(2022, 7, 20));
        Difunto difunto8 = new Difunto(8, sepultura8, "Marta", "Pérez", "Fernández", new Date(59, 9, 9), new Date(2022, 8, 25), new Date(2022, 8, 26));
        Difunto difunto9 = new Difunto(9, sepultura9, "Juan", "Fernandez", "Perez", new Date(1975, 3, 25), new Date(2022, 1, 5), new Date(2022, 1, 7));
        Difunto difunto10 = new Difunto(10, sepultura7, "Ana", "Gomez", "Martinez", new Date(1985, 7, 10), new Date(2022, 2, 15), new Date(2022, 2, 18));

                // Agregar objetos a un ArrayList
                ArrayList<Responsable> responsables = new ArrayList<>();
                responsables.add(responsable1);
                responsables.add(responsable2);
                responsables.add(responsable3);
                responsables.add(responsable4);
                responsables.add(responsable5);
                responsables.add(responsable6);
                responsables.add(responsable7);
                responsables.add(responsable8);
                responsables.add(responsable9);
                responsables.add(responsable10);

                ArrayList<Sepultura> sepulturas = new ArrayList<>();
                sepulturas.add(sepultura1);
                sepulturas.add(sepultura2);
                sepulturas.add(sepultura3);
                sepulturas.add(sepultura4);
                sepulturas.add(sepultura5);
                sepulturas.add(sepultura6);
                sepulturas.add(sepultura7);
                sepulturas.add(sepultura8);
                sepulturas.add(sepultura9);
                sepulturas.add(sepultura10);

                ArrayList<Difunto> difuntos = new ArrayList<>();
                difuntos.add(difunto1);
                difuntos.add(difunto2);
                difuntos.add(difunto3);
                difuntos.add(difunto4);
                difuntos.add(difunto5);
                difuntos.add(difunto6);
                difuntos.add(difunto7);
                difuntos.add(difunto8);
                difuntos.add(difunto9);
                difuntos.add(difunto10);

        for (Responsable res : responsables) {
        	bd.store(res);
        }
        for (Sepultura sepultura : sepulturas) {
        	bd.store(sepultura);
        }
        for (Difunto difunto : difuntos) {
			bd.store(difunto);
		}
		//abrir base de datos
		

		
		bd.close();
	}

}
