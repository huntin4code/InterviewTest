package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CombinationService {

    // # Problem 2
    public List<List<String>> determineCombination(List<String> inventoryList, List<Integer> inventoryPrices, List<List<String>> possibleCombos, Integer budget){

        HashMap<String, Integer> inventoryMap = new HashMap<>();

        inventoryMap = loadInventory(inventoryList, inventoryPrices);

        HashMap<List<String>, Integer> comboCost = new HashMap<>();

        comboCost = loadComboCost(possibleCombos, inventoryMap);

        return findBudgetCombo(possibleCombos, comboCost, budget);

    }

    // #3 Problem 3
    public List<List<String>> findAllCombos(List<String> inventoryList, List<Integer> inventoryPrices, Integer budget){
        // Backtrace recursively
        HashMap<String, Integer> inventoryMap = new HashMap<>();

        inventoryMap = loadInventory(inventoryList, inventoryPrices);


        List<List<String>> resultList = new ArrayList<>();

        List<String> currentList = new ArrayList<>();
        int currentTotal = 0;
        resultList = findNextItem(resultList, currentList, inventoryMap,budget,currentTotal, 0);

        return resultList;
    }

    private List<List<String>> findNextItem(List<List<String>> resultList, List<String> currentList, HashMap<String, Integer> inventoryMap, Integer budget, int currentTotal, int loc) {
        for(int i = loc; i < inventoryList.size(); i++){
            if(currentTotal <= budget){
                String nextItem = inventoryList.get(i);
                int nextCost = inventoryPrices.get(nextItem);
            }
        }

    }

    private HashMap<List<String>, Integer> loadComboCost(List<List<String>> possibleCombos, HashMap<String, Integer> inventoryMap) {
        HashMap<List<String>, Integer> comboCost = new HashMap<>();
        int total;
        for(List<String> combo : possibleCombos){
            total = 0;
            for(String item : combo){
                total += inventoryMap.get(item);
            }
            comboCost.put(combo, total);
        }
        return comboCost;
    }

    private List<List<String>> findBudgetCombo(List<List<String>> possibleCombos, HashMap<List<String>, Integer> comboCost, Integer budget) {
        List<List<String>> resultComboList = new ArrayList<>();

        int currentComboCost;
        for(List<String> combo : possibleCombos){
            // tODO: What happens if fails
            currentComboCost = comboCost.get(combo);
            if(currentComboCost <= budget){
                resultComboList.add(combo);
            }

        }

        return resultComboList;
    }

    private HashMap<String, Integer> loadInventory(List<String> inventoryList, List<Integer> inventoryPrices) {
        HashMap<String, Integer> inventoryMap = new HashMap<>();

        for(int i = 0; i < inventoryList.size(); i++){
            inventoryMap.put(inventoryList.get(i),inventoryPrices.get(i));

        }
        return inventoryMap;

    }
}
