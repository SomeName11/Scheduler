package main.java.scheduler.dao;

import java.util.List;

public interface GenericDAO<T> {

    public void addEntity(T entity);

    public void updateEntity(T entity);

    public void removeEntity(T entity);

    public T getEntityById(int id);

    public List<T> getEntityList();
}
