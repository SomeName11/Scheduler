package main.java.scheduler.controller;

import main.java.scheduler.model.Course;
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
public class CourseController {
    private GenericService<Course> courseService;

    @Autowired(required = true)
    @Qualifier(value = "courseService")
    public void setCourseService(GenericService<Course> courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value = "courses", method = RequestMethod.GET)
    public String listCourses(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("listCourses", this.courseService.getEntityList());

        return "courses";
    }

    @RequestMapping(value = "/courses/add", method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("course") Course course) {
        if (course.getId() == 0) {
            this.courseService.addEntity(course);
        } else {
            this.courseService.updateEntity(course);
        }

        return "redirect:/courses";
    }

    @RequestMapping("/remove/{id}")
    public String removeCourse(@PathVariable("id") int id) {
        this.courseService.removeEntity(id);

        return "redirect:/courses";
    }

    @RequestMapping("edit/{id}")
    public String editCourse(@PathVariable("id") int id, Model model) {
        model.addAttribute("course", this.courseService.getEntityById(id));
        model.addAttribute("listCourses", this.courseService.getEntityList());

        return "courses";
    }

    @RequestMapping("coursedata/{id}")
    public String courseData(@PathVariable("id") int id, Model model) {
        model.addAttribute("course", this.courseService.getEntityById(id));

        return "coursedata";
    }
}
