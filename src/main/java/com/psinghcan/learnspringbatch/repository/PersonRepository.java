package com.psinghcan.learnspringbatch.repository;

import com.psinghcan.learnspringbatch.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> getAllByStatusId(int statusId);

    @Modifying
    @Query("update Person p set p.statusId = :statusId where p.personId = :id")
    void updateStatus(@Param(value = "id") long id, @Param(value = "status_id") int statusId);
}
