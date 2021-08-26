package com.psinghcan.learnspringbatch.batch;

import com.psinghcan.learnspringbatch.model.Person;
import org.springframework.batch.item.ItemProcessor;

import java.util.Locale;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {
    @Override
    public Person process(Person person) throws Exception {
        String firstName = person.getFirstName().toUpperCase();
        String lastName = person.getLastName().toUpperCase();
        Person output = new Person(firstName, lastName, person.getEmail(), person.getAge());
        return output;
    }
}
