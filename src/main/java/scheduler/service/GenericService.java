package main.java.scheduler.service;

import java.util.List;

public interface GenericService<T> {


    public void addEntity(T entity);

    public void updateEntity(T entity);

    public void removeEntity(T entity);

    public T getEntityById(int id);

    public List<T> getEntityList();
}
