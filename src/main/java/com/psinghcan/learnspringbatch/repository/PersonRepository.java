package com.psinghcan.learnspringbatch.repository;

import com.psinghcan.learnspringbatch.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> getAllByStatusId(int statusId);
}
