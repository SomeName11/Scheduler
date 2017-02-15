package main.java.scheduler.controller;

import main.java.scheduler.model.Student;
import main.java.scheduler.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
    private GenericService<Student> studentService;

    @Autowired(required = true)
    @Qualifier(value = "studentService")
    public void setStudentService(GenericService<Student> studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "students", method = RequestMethod.GET)
    public String listStudents(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listStudents", this.studentService.getEntityList());

        return "students";
    }

    @RequestMapping(value = "/students/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student) {
        if (student.getId() == 0) {
            this.studentService.addEntity(student);
        } else {
            this.studentService.updateEntity(student);
        }

        return "redirect:/students";
    }

    @RequestMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int id) {
        this.studentService.removeEntity(id);

        return "redirect:/students";
    }

    @RequestMapping("edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", this.studentService.getEntityById(id));
        model.addAttribute("listStudents", this.studentService.getEntityList());

        return "students";
    }

    @RequestMapping("studentdata/{id}")
    public String studentData(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", this.studentService.getEntityById(id));

        return "studentdata";
    }
}

