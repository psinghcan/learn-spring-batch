package com.psinghcan.learnspringbatch.batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.psinghcan.learnspringbatch.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.*;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;



@Component
public class JobProgressListener implements JobExecutionListener,
        ItemWriteListener<Person>,
        ItemReadListener<Person>,
        ItemProcessListener<Person, Person> {

    public JobProgressListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("!!! JOB about to start");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

//            List<Person> results = jdbcTemplate.query("SELECT first_name, last_name,email,age FROM person", new RowMapper<Person>() {
//                @Override
//                public Person mapRow(ResultSet rs, int row) throws SQLException {
//                    return new Person(rs.getString(1), rs.getString(2),rs.getString(3),rs.getInt(4));
//                }
//            });
//
//            for (Person person : results) {
//                log.info("Found <" + person + "> in the database.");
//            }
        }
    }

    private static final Logger log = LoggerFactory.getLogger(JobProgressListener.class);
    private final JdbcTemplate jdbcTemplate;


    @Override
    public void beforeProcess(Person person) {
        log.info("starting process " + person.getFirstName());
    }

    @Override
    public void afterProcess(Person person, Person person2) {
        log.info("starting process " + person.getFirstName());
    }

    @Override
    public void onProcessError(Person person, Exception e) {

    }

    @Override
    public void beforeRead() {
        System.out.println("before-read");
    }

    @Override
    public void afterRead(Person person) {
        System.out.println("after-read " + person.getFirstName());
    }

    @Override
    public void onReadError(Exception e) {

    }

    @Override
    public void beforeWrite(List<? extends Person> list) {
        System.out.println("before-write " + list.size());
    }

    @Override
    public void afterWrite(List<? extends Person> list) {
        System.out.println("after-write " + list.size());
    }

    @Override
    public void onWriteError(Exception e, List<? extends Person> list) {

    }
}