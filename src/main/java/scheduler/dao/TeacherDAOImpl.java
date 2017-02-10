package main.java.scheduler.dao;

import main.java.scheduler.model.Teacher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
    private static final Logger logger = LoggerFactory.getLogger(CourseDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(teacher);
        logger.info("Teacher successfully saved." + teacher.toString());
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(teacher);
        logger.info("Teacher successfully update." + teacher.toString());
    }

    @Override
    public void removeTeacher(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Teacher teacher = (Teacher) session.load(Teacher.class, new Integer(id));

        if(teacher!=null){
            session.delete(teacher);
        }
        logger.info("Teacher successfully removed." + teacher.toString());
    }

    @Override
    public Teacher getTeacherById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Teacher teacher = (Teacher) session.load(Teacher.class, new Integer(id));
        logger.info("Teacher successfully loaded." + teacher.toString());

        return teacher;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Teacher> listTeachers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Teacher> teacherList = session.createQuery("from Teacher").list();

        for(Teacher teacher : teacherList){
            logger.info("Teacher list: " + teacher.toString());
        }

        return teacherList;
    }
}
