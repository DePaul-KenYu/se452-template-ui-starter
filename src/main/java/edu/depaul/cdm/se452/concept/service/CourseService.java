package edu.depaul.cdm.se452.concept.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se452.concept.dao.school.simple.Course;
import edu.depaul.cdm.se452.concept.dao.school.simple.CourseRepository;
import edu.depaul.cdm.se452.concept.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CourseService {
    @Autowired
    private CourseRepository repo;

    public List<Course> findAll() {
        log.traceEntry();
        List<Course> retval = StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
        log.traceExit(retval);
        return retval;
    }    

    public Course find(Long id) {
        log.traceEntry("enter find", id);
        Course retval = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        log.traceExit("Exit list", retval);
        return retval;
    }

    public Long create(Course course) {
        log.traceEntry("enter create", course);

        Course saved = repo.save(course);
        Long retval = saved.getId();
        
        log.traceExit("Exit create", retval);
        return retval;
    }

    public void update(Long id, Course course) {
        log.traceEntry("enter update", id, course);
        // Given it is an update, need to find the course
        Course foundCourse = repo.findById(id).orElse(new Course());

        // if foundCourse ID does not match the id then it means that we created new course object and so will need to
        // set the primary key
        if (foundCourse.getId() != id) {
            foundCourse.setId(id);
        }
        repo.save(foundCourse);
        log.traceExit();
    }

    public void delete(Long id) {
        log.traceEntry();
        repo.deleteById(id);
        log.traceExit();
    }    
    
}
