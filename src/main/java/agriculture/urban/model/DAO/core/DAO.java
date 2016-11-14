package agriculture.urban.model.DAO.core;

import java.util.List;

/**
 * Define the global comportment of DAO for link and non lik entities
 * 
 * @author Gwennaël Bouteloup
 *
 * @param <T>
 */
public interface DAO<T> {
	public void create(T entity);
	public void delete(T entity);
	public void update(T entity);
	public List<T> getAll();	
	public Long countAll();
	public Integer deleteAll();
}
