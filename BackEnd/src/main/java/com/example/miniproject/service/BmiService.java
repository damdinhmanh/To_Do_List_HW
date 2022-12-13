package com.example.miniproject.service;

import org.springframework.stereotype.Service;

@Service
public class BmiService {
    public float getBmiValue(float height, float weight) {
        float h1 = (float) (height/100);

        return weight/(h1 * 2) ;
    }
}
