package com.psinghcan.learnspringbatch.model;

import lombok.Data;

@Data
public class JobProgressMessage {
    private String status;
    private String description;
    private double percentageComplete;
}
