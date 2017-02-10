package main.java.scheduler.model;

import javax.persistence.*;

@Entity
@Table(name = "SCHEDULERS")
public class Scheduler {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "STUDENT_ID")
    private int studentId;

    @Column(name = "TEACHER_ID")
    private int teacherId;

    @Column(name = "COURSE_ID")
    private int courseId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Scheduler: " + "id " + id + " studentId " + studentId + " teacherId " + teacherId + " courseId " + courseId;
    }
}
