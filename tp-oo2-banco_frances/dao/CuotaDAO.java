package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Cuota;

public class CuotaDAO {
	private static Session session;
	private Transaction transaction;
	private static CuotaDAO instance;
	
	private CuotaDAO() { }
	
	public static CuotaDAO getInstance() {
		if(instance == null) {
			instance = new CuotaDAO();
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
	
	public int agregar(Cuota objeto) {
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
	
	public void modificar(Cuota objeto) {
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
	
	public void eliminar(Cuota objeto) {
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
	
	public Cuota traer(long id) {
		Cuota objeto = null;
		try {
			this.iniciaOperacion();
			objeto = session.get(Cuota.class, id);
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
	public List<Cuota> traer() {
		List<Cuota> objeto = null;
		try {
			this.iniciaOperacion();
			String hql = "from Cuota x order by x.idCuota asc";
			Query<Cuota> query = session.createQuery(hql);
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
