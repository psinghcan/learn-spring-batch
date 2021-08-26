package com.psinghcan.learnspringbatch.controller;

import com.psinghcan.learnspringbatch.service.BatchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchJobController {


    public BatchJobController(BatchService batchService) {
        this.batchService = batchService;
    }

    @RequestMapping("/start")
    public String handle() throws Exception {
        batchService.startBatchJob("is this ka kya matlab hai");
        return "batch job has been started";
    }

    private BatchService batchService;
}
