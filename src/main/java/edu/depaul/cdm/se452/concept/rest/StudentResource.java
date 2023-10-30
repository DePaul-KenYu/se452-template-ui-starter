package edu.depaul.cdm.se452.concept.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.concept.dao.school.simple.Student;
import edu.depaul.cdm.se452.concept.service.StudentService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/students/")
@Log4j2
public class StudentResource {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> list() {
        log.traceEntry();
        List<Student> retval = service.list();
        log.traceExit();
        return retval;
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        log.traceEntry();
        Student retval = service.save(student);
        log.traceExit();
        return retval;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id ) {
        log.traceEntry();
        service.delete(id);
        log.traceExit();
    }           
}
