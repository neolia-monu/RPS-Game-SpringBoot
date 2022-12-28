package com.example.rpsproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/")
public class Home {

    @GetMapping("/{data}")
    public String index(@PathVariable(name="data") int idx){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Rock");
        map.put(2, "Paper");
        map.put(3, "Scissor");

        return map.getOrDefault(idx, "null");
    }
}
