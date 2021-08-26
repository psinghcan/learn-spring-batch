package com.psinghcan.learnspringbatch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
