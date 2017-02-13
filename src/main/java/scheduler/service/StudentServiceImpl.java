package main.java.scheduler.service;

import main.java.scheduler.dao.StudentDAO;
import main.java.scheduler.model.Student;
import main.java.scheduler.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Student student) {
        student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        student.setRoles(roles);
        studentDao.save(student);
    }

    @Override
    public Student findByLogin(String login) {
        return studentDao.findByLogin(login);
    }
}
