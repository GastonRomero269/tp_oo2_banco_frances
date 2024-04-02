package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Cliente;
import datos.Prestamo;

public class ClienteDAO {
	private static Session session;
	private Transaction transaction;
	private static ClienteDAO instance;
	
	private ClienteDAO() { }
	
	public static ClienteDAO getInstance() {
		if(instance == null) {
			instance = new ClienteDAO();
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
	
	public int agregar(Cliente objeto) {
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
	
	public void modificar(Cliente objeto) {
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
	
	public void eliminar(Cliente objeto) {
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
	
	public Cliente traer(long id) {
		Cliente objeto = null;
		try {
			this.iniciaOperacion();
			objeto = session.get(Cliente.class, id);
			transaction.commit();
		} catch (HibernateException he) {
			this.manejaException(he);
			throw he;
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Cliente traerClientePrestamos(long id) {
		Cliente objeto = null;
		try {
			this.iniciaOperacion();
			objeto = session.get(Cliente.class, id);
			Hibernate.initialize(objeto.getPrestamos());
			for(Prestamo prestamo : objeto.getPrestamos()) {
				Hibernate.initialize(prestamo.getCuotas());
			}
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
	public List<Cliente> traer() {
		List<Cliente> objeto = null;
		try {
			this.iniciaOperacion();
			String hql = "from Cliente x order by x.idCliente asc";
			Query<Cliente> query = session.createQuery(hql);
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
