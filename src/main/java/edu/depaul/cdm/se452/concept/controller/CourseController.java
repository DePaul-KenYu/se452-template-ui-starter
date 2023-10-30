package edu.depaul.cdm.se452.concept.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.depaul.cdm.se452.concept.dao.school.simple.Course;
import edu.depaul.cdm.se452.concept.service.CourseService;


@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping
    public String list(Model model, HttpSession session) {
        model.addAttribute("courses", service.findAll());
        if (session.getAttribute("course") == null) {
            model.addAttribute("course", new Course());
            model.addAttribute("btnAddOrModifyLabel", "Add");
        } else {
            model.addAttribute("course", session.getAttribute("course"));
            model.addAttribute("btnAddOrModifyLabel", "Modify");
        }
        return "course/list";
    }

    @GetMapping("/edit/{id}")
    public String get(@PathVariable("id") Long id, Model model, HttpSession session) {
        session.setAttribute("course", service.find(id));
        return "redirect:/course";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        service.delete(id);
        return "redirect:/course";
    }

    @PostMapping
    public String save(@ModelAttribute Course course, HttpSession session) {
        if (course.getId() == 0)
            service.create(course);
        else {
            var editCourse = service.find(course.getId());
            editCourse.setDept(course.getDept());
            editCourse.setNum(course.getNum());
            editCourse.setDescription(course.getDescription());
            service.create(editCourse);
            session.setAttribute("course", null);
        }
        return "redirect:/course";
    }    
}
