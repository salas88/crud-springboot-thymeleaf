package com.vlad.thymeleaf.thymeleaf333.daojpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlad.thymeleaf.thymeleaf333.entity.Student;

public interface JpaDao extends JpaRepository<Student,Integer>{

}
