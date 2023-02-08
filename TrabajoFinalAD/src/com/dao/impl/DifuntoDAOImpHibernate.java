/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.DifuntoDAO;
import com.modelo.Difunto;

//import controlador.HibernateUtil;

/**
 * @author alu
 *
 */
public class DifuntoDAOImpHibernate implements DifuntoDAO{
	
	SessionFactory fabrica;
	Session sesion;	
	Transaction tx;

	public DifuntoDAOImpHibernate() {
		//fabrica = HibernateUtil.getSessionFactory();
		sesion  = fabrica.openSession();
		tx= sesion.beginTransaction();
	}
	@Override
	public List<Difunto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Difunto create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Difunto modify(int id) {
		// TODO Auto-generated method stub
		return null;
//		mostrarDep(s);
//		System.out.println("Introduce el codigo del departamento que quiers modificar:");
//		int id = sacarIntValido(sc);
//		Departamento dep = (Departamento)s.get(Departamento.class, (byte)id);
//		System.out.println("Que desea modificar: "
//							+ "\n1. Nombre"
//							+ "\n2. Localidad");
//		int opcion = sacarIntValido(sc);
//		switch(opcion) {
//		
//			case 1:
//				System.out.print("Introduce el nuevo nombre que le quieras dar: ");
//				String name = sc.nextLine();
//				dep.setNombre(name);
//				break;
//			case 2: 
//				System.out.print("Introduce la nueva localidad que le quieras dar: ");
//				String loc = sc.nextLine();
//				dep.setLocalidad(loc);
//				break;
//			default:
//				System.err.println("Introduce un número válido");
//		}
//		s.update(dep);
	}
	@Override
	public Difunto delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
