package com.psinghcan.learnspringbatch.controller;

import com.psinghcan.learnspringbatch.model.Person;
import com.psinghcan.learnspringbatch.service.BatchService;
import com.psinghcan.learnspringbatch.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {


    public TestController(BatchService batchService, PersonService personService) {
        this.batchService = batchService;
        this.personService = personService;
    }

    @GetMapping("/list")
    public List<Person> list() throws Exception {
        return personService.getAll();
    }


//    @RequestMapping("/start")
//    public String handle() throws Exception {
//        batchService.startBatchJob("is this ka kya matlab hai");
//        return "batch job has been started";
//    }

    private BatchService batchService;
    private PersonService personService;
}
