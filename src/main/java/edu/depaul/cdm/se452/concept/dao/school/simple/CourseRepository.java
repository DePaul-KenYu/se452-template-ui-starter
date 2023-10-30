package edu.depaul.cdm.se452.concept.dao.school.simple;

import org.springframework.data.repository.CrudRepository;

/**
 * @see JpaRepository that extends PagingAndSortingRepository that expends CrudRepository
 */
public interface CourseRepository extends CrudRepository<Course, Long> {
    
}
