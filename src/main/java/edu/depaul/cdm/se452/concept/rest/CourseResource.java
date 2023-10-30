package edu.depaul.cdm.se452.concept.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.concept.dao.school.simple.Course;
import edu.depaul.cdm.se452.concept.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseResource {
    @Autowired
    private CourseService service;

    @GetMapping("/")
    public List<Course> findAll() {
        List<Course> retval = service.findAll();
        return retval;
    }    

    @GetMapping(value="/{id}")
    public Course find(@PathVariable Long id) {
        return service.find(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Course course) {
        return service.create(course);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable( "id" ) Long id, @RequestBody Course course) {
        // Given it is an update, need to find the course
        Course foundCourse = service.find(id);

        // if foundCourse ID does not match the id then it means that we created new course object and so will need to
        // set the primary key
        if (foundCourse.getId() != id) {
            foundCourse.setId(id);
        }
        service.update(id, foundCourse);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }    

}
