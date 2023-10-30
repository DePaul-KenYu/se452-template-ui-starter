package edu.depaul.cdm.se452.concept.dao.school.complex;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
    Address findByLocation(String location);
}