package edu.depaul.cdm.se452.concept.dao.school.complex;

import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long> { 
    public Instructor findByName(String name);
}
