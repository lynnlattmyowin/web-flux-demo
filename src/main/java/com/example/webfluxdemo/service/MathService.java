package com.example.webfluxdemo.service;

import com.example.webfluxdemo.dto.Response;
import com.example.webfluxdemo.util.SleepUtil;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {
    public Response findSquare(int input){
        return new Response(input * input);
    }
    public List<Response> multiplicationTable(int input){
        return IntStream.rangeClosed(1,10)
                .peek(i -> SleepUtil.sleepSeconds(3))
                .mapToObj(i -> new Response(i * input))
                .collect(Collectors.toList());
    }
}
