package agriculture.urban.model.DAO.core;

/**
 * Define the global comportment of DAONonLinkEntity classes for non link entity
 * 
 * @author Gwennaël Bouteloup
 *
 * @param <T>
 */
public interface DAONonLinkEntity<T> extends DAO<T>{
	@SuppressWarnings("hiding")
	<T> T getById(Integer id);
}
