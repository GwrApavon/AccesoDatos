/**
 *  Implementacion de hibernate para Difunto
 */
package com.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.controlador.HibernateUtil;
import com.dao.DifuntoDAO;
import com.modelo.Difunto;

import cementerio.app.Utilities;


/**
 * @author Angel Pavon Fraile
 */
public class DifuntoDAOImpHibernate implements DifuntoDAO{
	
	SessionFactory fabrica;
	Session sesion;	
	Transaction tx;
	Scanner sc;

	public DifuntoDAOImpHibernate() {
		fabrica = HibernateUtil.getSessionFactory();
		sc = new Scanner(System.in);
		
	}

	/*
	 * Devuelve todos los elementos de la tabla
	 */
	@Override
	public List<Difunto> getAll() {
		sesion  = fabrica.openSession();
		Query<Difunto> q = sesion.createQuery("from Difunto");
		List <Difunto> lista = q.list();
		sesion.close();
		return lista;
	}

	
	
	/**
	 * Devuelve un difunto
	 * @param idn id del difunto a devolver
	 */
	@Override
	public Difunto getOne(Integer idn) {
		sesion  = fabrica.openSession();
		Query<Difunto> q = sesion.createQuery("from Difunto where id = " + idn);
		Difunto dif = q.list().get(0);
		sesion.close();
		return dif;
	}
	
	/** Creador difuntos
	 * Crea un difunto con el objeto que recibe
	 * @param dif Objeto difunto que se va a guardar
	 * @return boolean
	 */
	@Override
	public boolean create(Difunto element) {
		sesion  = fabrica.openSession();
		tx= sesion.beginTransaction();
		sesion.saveOrUpdate(element);
		tx.commit();
		sesion.close();
		System.out.println("Difunto insertado");
		return true;
	}

	/** Modificador difuntos
	 * Modifica un difunto ya existente con nuevos datos
	 * @param id identificador del difunto
	 * @param dif Objeto difunto con nuevos datos
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	 */
	@Override
	public boolean modify(Integer idn, Difunto element) {
		sesion  = fabrica.openSession();
		tx= sesion.beginTransaction();
		sesion.saveOrUpdate(element);
		tx.commit();
		sesion.close();
		System.out.println("Difunto modificado");
		return true;
	}

	/** Borrador difuntos
	 * Borra un difunto existente cuya id sea la que se pasa por parámetro
	 * @param id identificador del difunto
	 * @return boolean
	 * @exception IndexOutOfBoundsException
	*/
	@Override
	public boolean delete(Integer idn) {
		sesion  = fabrica.openSession();
		tx= sesion.beginTransaction();
		sesion.delete(idn);
		tx.commit();
		sesion.close();
		System.out.println("Difunto borrado");
		return true;
	}

	/** Consulta difunto
	 * Hace una consulta dependiendo del número que se le pase por parámetro 
	 * Consulta: selecciona los datos del difunto, sepultura y responsable de la sepultura 
	 * 			 para aquellos difuntos que fallecieron después de la fecha que introduzcas, 
	 * 			 ordenados por fecha de defunción descendente.
	*/
	@Override
	public void query() {
		
		String hql = "SELECT D.nombre, D.apellido1, D.apellido2, D.fechaNacimiento, D.fechaDefuncion, D.fechaEnterramiento, S.calle, S.numSepultura,"
					+ " S.nombreTitular, S.apellido1Titular, S.apellido2Titular, S.tipoContrato, S.observaciones, R.nombre, R.apellido1, R.apellido2"
					+ " FROM Difunto AS D"
					+ " JOIN D.sepultura AS S JOIN S.responsable AS R"
					+ " WHERE D.fechaDefuncion >= :fecha"
					+ " ORDER BY D.fechaDefuncion DESC";
			
		System.out.println("Desde que fecha le gustaría buscar(fecha introducida hasta la actualidad):");
		Date fecha = Utilities.pedirFechaDef(sc);

		sesion  = fabrica.openSession();
		Query query = sesion.createQuery(hql);
		query.setParameter("fecha", fecha);
		
		List<Object[]> results = query.list();
		
		for(Object[] result : results) {
			System.out.println("Difunto:"
								+ "\n\tNombre: " +  result[0]
								+ "\n\tApellido1: " + result[1]  
								+ "\n\tApellido2: " +  result[2]
								
								+ "\nFechas: "
								+ "\n\tFecha de nacimiento: " +  result[3]
								+ "\n\tFecha de defunción: " +  result[4]
								+ "\n\tFecha de enterramiento: " +  result[5]
								
								+ "\nPosicion sepultura:"	
								+ "\n\tCalle sepultura: " +  result[6] 
								+ "\n\tNumero sepultura "+ result[7]
										
								+ "\nTitular de la sepultura: " 
								+ "\n\tNombre:" + result[8] 
								+ "\n\tApellido1" + result[9] 
								+ "\n\tApellido2" + result[10] 
								+ "\n\tTipo de contrato: " + result[11]
								+ "\n\tObservaciones: " + result[12]
								
								+ "\nResponsable de la sepultura: " 
								+ "\n\tNombre:" + result[13] 
								+ "\n\tApellido1: " + result[14] 
								+ "\n\tApellido2: " + result[15]);
				}
		sesion.close();
	}

}
