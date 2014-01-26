package service.abstractions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.abstractions.EntityInterface;

/**
 * CRUD operations for EJBs which manage Entities
 * 
 * @author ilja
 * @param <T>
 *            - Type of an EntityInterace
 * @see {@link EntityInterface}
 */
public abstract class AbstractFacade<T extends EntityInterface> {

	private final Class<T> entityClass;

	public AbstractFacade(final Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@PersistenceContext(unitName = "MusicStore")
	private EntityManager em;

	/**
	 * @return injected EntityManager
	 */
	protected EntityManager getEm() {
		return em;
	}

	/**
	 * @param em
	 *            entityManager to be set
	 */
	protected void setEm(final EntityManager em) {
		this.em = em;
	}

	/**
	 * @param entity
	 *            to be persisted to database
	 * 
	 */
	public void create(final T entity) {
		getEm().persist(entity);
	}

	/**
	 * @param entity
	 *            which will be synchronized with database
	 */
	public void update(final T entity) {
		getEm().merge(entity);
	}

	/**
	 * @param entity
	 *            which will be removed from database
	 * 
	 */
	public void delete(final T entity) {
		getEm().remove(entity);
	}

	/**
	 * @return all entities
	 */
	public List<T> findAll() {
		return getEm().createQuery(
				"SELECT e FROM " + entityClass.getName() + " e", entityClass)
				.getResultList();
	}

	/**
	 * @param id
	 *            of entity which you want to find
	 * @return entity with given id from database
	 */
	public T find(final long id) {
		return getEm().find(entityClass, id);
	}

	/**
	 * @return sum of entities of a given type
	 */
	public long count() {
		return ((Long) getEm().createQuery(
				"select count(e) from " + entityClass.getName() + " as e")
				.getSingleResult()).longValue();
	}

	/**
	 * flushes EntityManger
	 */
	public void flushEm() {
		getEm().flush();
	}
}