package edu.depaul.cdm.se452.concept.dao.school.complex;

import org.springframework.data.repository.CrudRepository;

public interface UniversityRepository extends CrudRepository<University, Long> { 
    public University findByName(String name);
}