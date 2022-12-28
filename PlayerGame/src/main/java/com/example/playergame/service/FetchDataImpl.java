package com.example.playergame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FetchDataImpl implements FetchData {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String compService(String userData) {

        int compNo = (int)((Math.random() * (4 - 1) + 1));
//        System.out.println("Computer no: " + compNo);

        String data = restTemplate.getForObject("http://localhost:8081/api/v1/" + compNo, String.class);
//        System.out.println("Computer data: " + data.toLowerCase());

        String res = checkWinner(data.toLowerCase(), userData);
//        System.out.println("Service response: " + res);

        return res;
    }

    private String checkWinner(String compData, String userData) {

        StringBuilder response = new StringBuilder();

        if(compData == null || userData == null)
            return "{ Error: 'Invalid Computer Data.' }";

        switch(userData){
            case "rock":
                if(compData.equals("paper"))
                    response.append("Computer wins");
                else if(compData.equals("rock"))
                    response.append("It is a tie");
                else
                    response.append("Player wins");
                break;
            case "paper":
                if(compData.equals("scissor"))
                    response.append("Computer wins");
                else if(compData.equals("paper"))
                    response.append("It is a tie");
                else
                    response.append("Player wins");
                break;
            case "scissor":
                if(compData.equals("rock"))
                    response.append("Computer wins");
                else if(compData.equals("scissor"))
                    response.append("It is a tie");
                else
                    response.append("Player wins");
                break;
        }

        return response.toString();
    }
}
