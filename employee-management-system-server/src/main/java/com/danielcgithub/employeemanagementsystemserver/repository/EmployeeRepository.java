package com.danielcgithub.employeemanagementsystemserver.repository;

import com.danielcgithub.employeemanagementsystemserver.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeRepository
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}