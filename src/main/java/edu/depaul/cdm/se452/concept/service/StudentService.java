package edu.depaul.cdm.se452.concept.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se452.concept.dao.school.simple.Student;
import edu.depaul.cdm.se452.concept.dao.school.simple.StudentRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public List<Student> list() {
        log.traceEntry("Enter list");

        var retval = StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());

        log.traceExit("Exit list", retval);
        return retval;
    }

    public Student save(Student student) {
        log.traceEntry("enter save", student);
        repo.save(student);
        log.traceExit("exit save", student);
        return student;
    }


    public void delete(Long id ) {
        log.traceEntry("Enter delete", id);
        repo.deleteById(id);
        log.traceExit("Exit delete");
    }           
    
}
