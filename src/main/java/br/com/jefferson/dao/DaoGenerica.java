package br.com.jefferson.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Order;
import javax.ws.rs.NotFoundException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class DaoGenerica implements Serializable {
	
	private static final long serialVersionUID = 8689239218903563973L;
	
	@PersistenceContext(unitName = "cadastro_pu")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public <T extends BaseEntity<PK>, PK extends Serializable> PK save(T entity) {
		return (PK) getSession().save(entity);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseEntity<PK>, PK extends Serializable> T merge(T entity) {
		return (T) getSession().merge(entity);
	} 
	
	@SuppressWarnings("unchecked")
	public <T extends BaseEntity<?>> List<T> findAll(Class<T> clazz) {
		return getSession().createCriteria(clazz).list();
	}
	
	public <T extends BaseEntity<PK>, PK extends Serializable> void delete(Class<T> clazz, PK id) {
		T entity = find(clazz, id);
		if (entity != null) { 
			getSession().delete(entity);
		} else {
			throw new NotFoundException();
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseEntity<?>> T find(Class<T> clazz, Serializable id) {
		return (T) getSession().get(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseEntity<?>> List<T> findByProperty(Class<T> clazz, String propertyName, Object value) {
		return getSession().createCriteria(clazz).add(Restrictions.eq(propertyName, value)).list();
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseEntity<?>> List<T> findByProperty(Class<T> clazz, String propertyName, String value, MatchMode matchMode){
		if (matchMode != null){
			return getSession().createCriteria(clazz).add(Restrictions.ilike(propertyName, value, matchMode)).list();
		}else{
			return getSession().createCriteria(clazz).add(Restrictions.ilike(propertyName, value, MatchMode.EXACT)).list();
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseEntity<?>> List<T> findAll(Class<T> clazz, Order order, String... propertiesOrder) {
		Criteria criteria = getSession().createCriteria(clazz);

		for (String propertyOrder : propertiesOrder) {
			if (order.isAscending()) {
				criteria.addOrder(org.hibernate.criterion.Order.asc(propertyOrder));
			} else {
				criteria.addOrder(org.hibernate.criterion.Order.desc(propertyOrder));
			}
		}

		return criteria.list();
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	protected Session getSession() {
		return (Session) entityManager.getDelegate();
	}

}
