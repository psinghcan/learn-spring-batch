package com.psinghcan.learnspringbatch.service;

import com.psinghcan.learnspringbatch.model.Person;
import com.psinghcan.learnspringbatch.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getStepOne(){
        return personRepository.getAllByStatusId(10);
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public List<Person> getStepTwo(){
        return personRepository.getAllByStatusId(11);
    }

    public void updateStatus(Person person, int newStatus){
        if (person.getPersonId() > 0 && person.getStatusId() != newStatus){
            personRepository.updateStatus(person.getPersonId(), newStatus);
        }
    }

    private final PersonRepository personRepository;
}
