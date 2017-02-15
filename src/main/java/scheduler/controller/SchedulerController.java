package main.java.scheduler.controller;

import main.java.scheduler.model.Scheduler;
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
public class SchedulerController {
    private GenericService<Scheduler> schedulerService;

    @Autowired(required = true)
    @Qualifier(value = "schedulerService")
    public void setSchedulerService(GenericService<Scheduler> schedulerService) {
        this.schedulerService = schedulerService;
    }

    @RequestMapping(value = "schedulers", method = RequestMethod.GET)
    public String listSchedulers(Model model) {
        model.addAttribute("scheduler", new Scheduler());
        model.addAttribute("listSchedulers", this.schedulerService.getEntityList());

        return "schedulers";
    }

    @RequestMapping(value = "/schedulers/add", method = RequestMethod.POST)
    public String addScheduler(@ModelAttribute("scheduler") Scheduler scheduler) {
        if (scheduler.getId() == 0) {
            this.schedulerService.addEntity(scheduler);
        } else {
            this.schedulerService.updateEntity(scheduler);
        }

        return "redirect:/schedulers";
    }

    @RequestMapping("/remove/{id}")
    public String removeScheduler(@PathVariable("id") int id) {
        this.schedulerService.removeEntity(id);

        return "redirect:/schedulers";
    }

    @RequestMapping("edit/{id}")
    public String editScheduler(@PathVariable("id") int id, Model model) {
        model.addAttribute("scheduler", this.schedulerService.getEntityById(id));
        model.addAttribute("listSchedulers", this.schedulerService.getEntityList());

        return "schedulers";
    }

    @RequestMapping("schedulerdata/{id}")
    public String schedulerData(@PathVariable("id") int id, Model model) {
        model.addAttribute("scheduler", this.schedulerService.getEntityById(id));

        return "schedulerdata";
    }
}
