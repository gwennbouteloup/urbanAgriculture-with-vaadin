package agriculture.urban.database;

import org.hibernate.cfg.Configuration;

import org.hibernate.SessionFactory;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration()
					.configure("/hbnt/hibernate.cfg.xml")
					.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("Initial SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
