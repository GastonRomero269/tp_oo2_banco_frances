package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Prestamo;

public class PrestamoDAO {
	private static Session session;
	private Transaction transaction;
	private static PrestamoDAO instance;
	
	private PrestamoDAO() { }
	
	public static PrestamoDAO getInstance() {
		if(instance == null) {
			instance = new PrestamoDAO();
		}
		return instance;
	}
	
	private void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}
	
	private void manejaException(HibernateException he) {
		transaction.rollback();
		throw he;
	}
	
	public int agregar(Prestamo objeto) {
		int id = -1;
		try {
			this.iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			transaction.commit();
		} catch (HibernateException he) {
			this.manejaException(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public void modificar(Prestamo objeto) {
		try {
			this.iniciaOperacion();
			session.update(objeto);
			transaction.commit();
		} catch (HibernateException he) {
			this.manejaException(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminar(Prestamo objeto) {
		try {
			this.iniciaOperacion();
			session.delete(objeto);
			transaction.commit();
		} catch (HibernateException he) {
			this.manejaException(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public Prestamo traer(long id) {
		Prestamo objeto = null;
		try {
			this.iniciaOperacion();
			objeto = session.get(Prestamo.class, id);
			transaction.commit();
		} catch (HibernateException he) {
			this.manejaException(he);
			throw he;
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Prestamo traerPrestamoCuotas(long id) {
		Prestamo objeto = null;
		try {
			this.iniciaOperacion();
			objeto = session.get(Prestamo.class, id);
			Hibernate.initialize(objeto.getCuotas());
			transaction.commit();
		} catch (HibernateException he) {
			this.manejaException(he);
			throw he;
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Prestamo> traer() {
		List<Prestamo> objeto = null;
		try {
			this.iniciaOperacion();
			String hql = "from Prestamo x order by x.idPrestamo asc";
			Query<Prestamo> query = session.createQuery(hql);
			objeto = query.getResultList();
			transaction.commit();
		} catch (HibernateException he) {
			this.manejaException(he);
			throw he;
		} finally {
			session.close();
		}
		return objeto;
	}
}
