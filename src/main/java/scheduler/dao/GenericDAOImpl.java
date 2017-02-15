package main.java.scheduler.dao;

import main.java.scheduler.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDAOImpl<T> implements GenericDAO<T> {

    private static final Logger logger = LoggerFactory.getLogger(GenericDAOImpl.class);

    private SessionFactory sessionFactory;

    protected Class<? extends T> daoType;

    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addEntity(T entity) {
        currentSession().save(entity);
        logger.info("Entity successfully saved." + entity.toString());
    }

    @Override
    public void updateEntity(T entity) {
        currentSession().update(entity);
        logger.info("Entity successfully update." + entity.toString());
    }

    @Override
    public void removeEntity(T entity) {
        currentSession().delete(entity);
        logger.info("Entity successfully removed." + entity.toString());
    }

    @Override
    public T getEntityById(int id) {
        return (T) currentSession().get(daoType, id);
    }

    @Override
    public List<T> getEntityList() {
        return currentSession().createCriteria(daoType).list();
    }
}
