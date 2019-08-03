package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.book.model.Student;



public interface StudentRepository extends PagingAndSortingRepository<Student,Long>,JpaRepository<Student,Long>
{

}
