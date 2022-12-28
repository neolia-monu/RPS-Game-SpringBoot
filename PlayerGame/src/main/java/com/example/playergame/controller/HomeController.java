package com.example.playergame.controller;

import com.example.playergame.service.FetchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    @Autowired
    private FetchData fetchData;

    private final Set<String> set = new HashSet<>(Arrays.asList("rock", "paper", "scissor"));

    @GetMapping("/{userInput}")
    public String index(@PathVariable(name = "userInput") String data){

        String userData = data.toLowerCase();
//        System.out.println(userData);

        if(!set.contains(userData))
            return "{ Error: 'Invalid Data.' }";

        String response = fetchData.compService(userData);

//        System.out.println(response);

        return response;
    }
}
