package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    public int findFibonacciNumber(int highValue){
        int previous = 0;

        // TODO: can we solve procedurally
        if(highValue == 0){
            return previous;
        }

        int current = 1;
        int placeholder = 0;

        // possible recursion
        for(int i = 1; i < highValue; i++){
            placeholder = current;
            current = findNextFibonacciNumber(current, previous);
            previous = placeholder;
        }

        return current;
    }

    public static int findNextFibonacciNumber(int current, int previous){
        return current + previous;
    }
}
