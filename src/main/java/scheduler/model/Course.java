package main.java.scheduler.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "COURSES")
public class Course {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "START_DATE")
    private Calendar startDate;

    @Column(name = "END_DATE")
    private Calendar endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Course: " + "id " + id + " name " + name + " startDate " + startDate.toString() + " endDate " + endDate.toString();
    }
}

