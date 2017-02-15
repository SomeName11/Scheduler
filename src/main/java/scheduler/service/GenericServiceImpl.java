package main.java.scheduler.service;

import main.java.scheduler.dao.GenericDAO;

import java.util.List;

public class GenericServiceImpl<T> implements GenericService<T> {
    private GenericDAO<T> genericDAO;

    public GenericServiceImpl(GenericDAO<T> genericDAO) {
        this.genericDAO = genericDAO;
    }

    @Override
    public void addEntity(T entity) {
        genericDAO.addEntity(entity);
    }

    @Override
    public void updateEntity(T entity) {
        genericDAO.updateEntity(entity);
    }

    @Override
    public void removeEntity(T entity) {
        genericDAO.removeEntity(entity);
    }

    @Override
    public T getEntityById(int id) {
        return genericDAO.getEntityById(id);
    }

    @Override
    public List<T> getEntityList() {
        return genericDAO.getEntityList();
    }
}
