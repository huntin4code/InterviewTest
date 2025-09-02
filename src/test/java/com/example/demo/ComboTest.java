package com.example.demo;

import com.example.demo.service.CombinationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ComboTest {

    @Autowired
    CombinationService combinationService = new CombinationService();

    @Test
    public void testComboService(){

        List<String> inventory = new ArrayList<String>();
        inventory.add("Lettuce1");
        inventory.add("Cheese1");
        inventory.add("Chicken3");
        inventory.add("Bread1");
        inventory.add("Bean Patty2");

        List<Integer> price = new ArrayList<Integer>();
        price.add(1);
        price.add(1);
        price.add(3);
        price.add(1);
        price.add(2);

        List<List<String>> inventoryCombos = new ArrayList<List<String>>();

        String let = "Lettuce1";
        String bread = "Bread1";
        String cheese = "Cheese1";
        String chicken = "Chicken3";
        String bean = "Bean Patty2";

        List<String> temp = new ArrayList<>();
        temp.add("Lettuce1");
        temp.add("Bread1");
        inventoryCombos.add(temp);

        List<String> temp2 = new ArrayList<>();

        temp2.add("Cheese1");
        temp2.add("Chicken3");
        temp2.add("Bread1");
        temp2.add("Bean Patty2");

        inventoryCombos.add(temp2);

        List<String> temp3 = new ArrayList<>();
        temp3.add(let);
        temp3.add(cheese);
        temp3.add(chicken);
        temp3.add(bread);
        temp3.add(bread);

        inventoryCombos.add(temp3);


        List<String> temp4 = new ArrayList<>();
        temp4.add(let);
        temp4.add(cheese);
        temp4.add(bread);
        temp4.add(bean);

        inventoryCombos.add(temp4);
        List<String> temp5 = new ArrayList<>();

        temp5.add(chicken);
        temp5.add(bread);
        temp5.add(bean);

        inventoryCombos.add(temp5);

        List<String> temp6 = new ArrayList<>();
        temp6.add(cheese);
        temp6.add(bread);
        temp6.add(bean);

        inventoryCombos.add(temp6);

        System.out.println(combinationService.determineCombination(inventory, price, inventoryCombos, 5));
        // more


    }

}
