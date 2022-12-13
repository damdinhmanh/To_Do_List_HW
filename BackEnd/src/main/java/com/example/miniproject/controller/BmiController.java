package com.example.miniproject.controller;

import com.example.miniproject.request.upsertBmi;
import com.example.miniproject.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BmiController {

    @Autowired
    private BmiService bmiService;

    //GET http://localhost:8080/bmi?height=[heightValue]&weight=[weightValue]
    @GetMapping("bmi")
    public float getBmiValue(@RequestParam(name="height") float height, @RequestParam(name="weight") float weight) throws Exception {
        if (height < 0 || weight < 0) {
            throw new Exception("Invalid input value");
        }
        return bmiService.getBmiValue(height, weight);
    }

    @PostMapping("bmi") 
    public float addBmiData(@RequestBody upsertBmi request) {
       return bmiService.getBmiValue(request.getHeight(), request.getWeight());
    }

}
