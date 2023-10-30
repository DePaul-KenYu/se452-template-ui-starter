package edu.depaul.cdm.se452.concept.dao.school.complex;

import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Long> { 
    public School findByName(String name);
}