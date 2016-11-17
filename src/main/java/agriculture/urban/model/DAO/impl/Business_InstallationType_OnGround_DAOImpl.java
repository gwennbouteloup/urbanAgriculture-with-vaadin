package agriculture.urban.model.DAO.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import agriculture.urban.database.HibernateUtil;
import agriculture.urban.model.Business_InstallationType_OnGround;
import agriculture.urban.model.DAO.core.Business_InstallationType_OnGround_DAO;

public class Business_InstallationType_OnGround_DAOImpl implements Business_InstallationType_OnGround_DAO {
	private final Logger logger = Logger.getLogger(getClass().getName());
	private SessionFactory sessionFactory;
	@PersistenceContext
	protected EntityManager entityManager;

	// for dev
	public Business_InstallationType_OnGround_DAOImpl() throws ExceptionInInitializerError {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	// for tests
	/*
	 * public Business_InstallationType_OnGround_DAOImpl(SessionFactory
	 * sessionFactory) { this.sessionFactory = sessionFactory; }
	 */

	// save
	// - will execute an INSERT statement called outside or inside of
	// transaction boundaries
	// - identifier value will be assigned to the persistent instance
	// immediately
	@Override
	public void create(Business_InstallationType_OnGround business_InstallationType_OnGround) {
		Transaction tx = null;
		Session session = null;
		try {
			// session = sessionFactory.openSession();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.persist(business_InstallationType_OnGround); // save
			tx.commit();
		} catch (HibernateException ex) {
			logger.info("Create error: " + ex.getLocalizedMessage());
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void delete(Business_InstallationType_OnGround business_InstallationType_OnGround) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Business_InstallationType_OnGround> getAll() {
		logger.info("TypedQuery coucou");
		TypedQuery<Business_InstallationType_OnGround> allQuery = null;

		try {
			logger.info("Avant CriteriaBuilder");
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			logger.info("Avant CriteriaQuery");
			CriteriaQuery<Business_InstallationType_OnGround> criteriaQuery = criteriaBuilder
					.createQuery(Business_InstallationType_OnGround.class);
			logger.info("Avant Root");
			Root<Business_InstallationType_OnGround> rootEntry = criteriaQuery
					.from(Business_InstallationType_OnGround.class);
			logger.info("Après Root");
			CriteriaQuery<Business_InstallationType_OnGround> all = criteriaQuery.select(rootEntry);
			logger.info("avant createQuery");
			allQuery = entityManager.createQuery(all);
		} catch (Exception e) {
			logger.severe("Exception in Business_InstallationType_OnGround_DAOImpl.getAll(): " + e.getMessage());
		}
		logger.info("avant allQuery.getResultList()");
		return allQuery.getResultList();
	}

	@Override
	public void update(Business_InstallationType_OnGround business_InstallationType_OnGround) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Long countAll() {
		try (Session session = sessionFactory.openSession()) {
			return (Long) session.createQuery("select count(*) from Business_InstallationType_OnGround").uniqueResult();
		} catch (HibernateException ex) {
			logger.info("getCount error: " + ex.getLocalizedMessage());
			return null;
		}
	}

	@Override
	public Integer deleteAll() {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			int result = session.createQuery("delete from Business_InstallationType_OnGround").executeUpdate();
			tx.commit();
			return result;
		} catch (HibernateException ex) {
			logger.info("deleteAll error: " + ex.getLocalizedMessage());
			if (tx != null) {
				tx.rollback();
			}
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// #GB TO_DELETE
	public void coucou() {
		logger.info("coucou");
	}

}
