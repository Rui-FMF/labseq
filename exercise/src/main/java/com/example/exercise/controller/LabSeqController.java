package com.example.exercise.controller;

import com.example.exercise.service.LabSeqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/labseq")
public class LabSeqController {

    private LabSeqService labSeqService;

    @Autowired
    public LabSeqController(LabSeqService labSeqService) {
        this.labSeqService = labSeqService;
    }

    @GetMapping("/{n}")
    public long getLabSeqValue(@PathVariable int n) {
        return labSeqService.calculateLabSeq(n);
    }
}