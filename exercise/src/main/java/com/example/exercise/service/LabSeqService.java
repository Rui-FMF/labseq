package com.example.exercise.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class LabSeqService {
    
    private Map<Integer, Long> cache;

    public LabSeqService() {
        this.cache = new HashMap<>();
    }

    public long calculateLabSeq(int n) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        if (n < 0) {
            throw new IllegalArgumentException("Provided value 'n' must be a non-negative integer");
        }

        long result;

        if (n <= 1) {
            result = n;
        } else if (n <=3) {
            result = n-2;
        } else {
            result = calculateLabSeq(n - 4) + calculateLabSeq(n - 3);
        }

        cache.put(n, result);
        return result;
    }
}