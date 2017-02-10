package main.java.scheduler.dao;

import main.java.scheduler.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {
    private static final Logger logger = LoggerFactory.getLogger(CourseDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCourse(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(course);
        logger.info("Course successfully saved." + course.toString());
    }

    @Override
    public void updateCourse(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(course);
        logger.info("Course successfully update." + course.toString());
    }

    @Override
    public void removeCourse(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Course course = (Course) session.load(Course.class, new Integer(id));

        if(course!=null){
            session.delete(course);
        }
        logger.info("Course successfully removed." + course.toString());
    }

    @Override
    public Course getCourseById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Course course = (Course) session.load(Course.class, new Integer(id));
        logger.info("Course successfully loaded." + course.toString());

        return course;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Course> listCourses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Course> courseList = session.createQuery("from Course").list();

        for(Course course : courseList){
            logger.info("Course list: " + course.toString());
        }

        return courseList;
    }
}
