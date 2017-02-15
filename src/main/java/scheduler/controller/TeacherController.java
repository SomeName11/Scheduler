package main.java.scheduler.controller;

import main.java.scheduler.model.Teacher;
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
public class TeacherController {
    private GenericService<Teacher> teacherService;

    @Autowired(required = true)
    @Qualifier(value = "teacherService")
    public void setTeacherService(GenericService<Teacher> studentService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "teachers", method = RequestMethod.GET)
    public String listTeachers(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("listTeachers", this.teacherService.getEntityList());

        return "teachers";
    }

    @RequestMapping(value = "/teachers/add", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute("teacher") Teacher teacher) {
        if (teacher.getId() == 0) {
            this.teacherService.addEntity(teacher);
        } else {
            this.teacherService.updateEntity(teacher);
        }

        return "redirect:/teachers";
    }

    @RequestMapping("/remove/{id}")
    public String removeTeacher(@PathVariable("id") int id) {
        this.teacherService.removeEntity(id);

        return "redirect:/teachers";
    }

    @RequestMapping("edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("teacher", this.teacherService.getEntityById(id));
        model.addAttribute("listTeachers", this.teacherService.getEntityList());

        return "teachers";
    }

    @RequestMapping("teacherdata/{id}")
    public String teacherData(@PathVariable("id") int id, Model model) {
        model.addAttribute("teacher", this.teacherService.getEntityById(id));

        return "teacherdata";
    }
}