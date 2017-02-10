package main.java.scheduler.dao;

import main.java.scheduler.model.Scheduler;

import java.util.List;

public interface SchedulerDAO {

    public void addScheduler(Scheduler scheduler);

    public void updateScheduler(Scheduler scheduler);

    public void removeScheduler(int id);

    public Scheduler getSchedulerById(int id);

    public List<Scheduler> listSchedulers();
}
