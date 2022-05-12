package com.ashok.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashok.example.model.Employee;
@Repository
public interface IEmployeeDAO extends JpaRepository<Employee, Integer>{

}
