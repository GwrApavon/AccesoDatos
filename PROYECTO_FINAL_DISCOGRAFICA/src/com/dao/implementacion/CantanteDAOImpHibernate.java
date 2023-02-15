package com.dao.implementacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.controlador.HibernateUtil;
import com.dao.CantanteDAO;
import com.modelo.Cantante;

import discografica.MantenimientoInteracciones;



public class CantanteDAOImpHibernate implements CantanteDAO{
	
	private Session sesion;
	
	public CantanteDAOImpHibernate() {
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		Session sesion = fabrica.openSession();
		this.sesion = sesion;
	}
	
	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}

	@Override
	public boolean inserta(Cantante cant) {
		Transaction transaction = this.sesion.beginTransaction();
		this.sesion.save(cant);
		transaction.commit();
		return true;
	}

	@Override
	public boolean elimina(Integer id) {
		Transaction transaction = this.sesion.beginTransaction();
		Cantante c = comprobarId(id, transaction);
		if(c != null) {
			this.sesion.delete(c);		
			transaction.commit();
			return true;
		} else {
			return false;
		}
	
	}

	@Override
	public boolean modifica(Integer id){
		Transaction transaction = this.sesion.beginTransaction();
		Cantante c = comprobarId(id, transaction);
		if(c != null) {
			MantenimientoInteracciones mi = new MantenimientoInteracciones();
			mi.modificarCantante("MYSQL", c);
			this.sesion.update(c);
			transaction.commit();
			return true;
		} else {
			return false;
		}	
		
	}

	
	public List<String> consultaUno() {
		List<String> listaNombres = null;
		String queryTexto = "SELECT cant.nombre "
				+ "FROM cantante cant INNER JOIN cancion can ON(cant.idCantante = can.cantante.idCantante) "
				+ "WHERE can.duracion =  '2:%'";
		Query query = this.sesion.createQuery(queryTexto);
		List<String> lista = query.getResultList();
		Iterator <String> iter = lista.iterator();
		while (iter.hasNext()){
			String nombre = (String)iter.next();
			listaNombres.add(nombre);
		}
		return listaNombres;
	}
	


	@Override
	public List<Cantante> encuentraTodos() {
		Query<Cantante> cantantes = this.sesion.createQuery("from Cantante");
		List <Cantante> listaCantantes = cantantes.list();	
		return listaCantantes;
	}
	
	public Cantante comprobarId(Integer id, Transaction transaction) {
		boolean comprobacion = false;
		String queryTexto = "from Cantante where idCantante = :id";
		Query query = this.sesion.createQuery(queryTexto);
		query.setParameter("id", id);
		List<Cantante> lista = query.getResultList();
		Iterator <Cantante> iter = lista.iterator();
		while (iter.hasNext()){
			Cantante cant = (Cantante)iter.next();
			return cant;
		}
		transaction.commit();
		return null;
	}

	@Override
	public List<ArrayList<String>> consulta1() {
		List<ArrayList<String>> listaNombres = new ArrayList<ArrayList<String>>();
		String queryTexto = "SELECT cant.nombre, can.nombre "
				+ "FROM Cancion as can INNER JOIN can.cantante as cant "
				+ "WHERE can.duracion LIKE  '2:%'";
		
		Query query = this.sesion.createQuery(queryTexto);
		List<ArrayList<String>> lista = query.getResultList();
		Iterator <ArrayList<String>> iter = lista.iterator();
		while (iter.hasNext()){
			ArrayList<String> listado = (ArrayList<String>)iter.next();
			listaNombres.add(listado);
		}
		return listaNombres;
	}
	
	
	
}
