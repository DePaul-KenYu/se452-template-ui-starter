package edu.depaul.cdm.se452.concept.dao.school.complex.inheritance;

import jakarta.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class HourlyEmployee extends Employee {
    private double rate;
}
