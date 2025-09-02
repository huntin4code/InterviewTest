package com.example.demo;

import com.example.demo.service.FibonacciService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {
    @Autowired
    FibonacciService service = new FibonacciService();

    @Test
    public void testFindFib(){
        int testInt = 30;

        System.out.println(service.findFibonacciNumber(testInt));
    }
}
