package main.java.scheduler.dao;

import main.java.scheduler.model.Scheduler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchedulerDAOImpl implements SchedulerDAO {
    private static final Logger logger = LoggerFactory.getLogger(SchedulerDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addScheduler(Scheduler scheduler) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(scheduler);
        logger.info("Scheduler successfully saved." + scheduler.toString());
    }

    @Override
    public void updateScheduler(Scheduler scheduler) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(scheduler);
        logger.info("Scheduler successfully update." + scheduler.toString());
    }

    @Override
    public void removeScheduler(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Scheduler scheduler = (Scheduler) session.load(Scheduler.class, new Integer(id));

        if(scheduler!=null){
            session.delete(scheduler);
        }
        logger.info("Scheduler successfully removed." + scheduler.toString());
    }

    @Override
    public Scheduler getSchedulerById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Scheduler scheduler = (Scheduler) session.load(Scheduler.class, new Integer(id));
        logger.info("Scheduler successfully loaded." + scheduler.toString());

        return scheduler;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Scheduler> listSchedulers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Scheduler> schedulerList = session.createQuery("from Schedule").list();

        for(Scheduler scheduler : schedulerList){
            logger.info("Scheduler list: " + scheduler.toString());
        }

        return schedulerList;
    }
}
