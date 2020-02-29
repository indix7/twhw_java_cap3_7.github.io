package com.thoughtworks;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.LinkedHashMap;

public class ResultDetail implements Result {
    private LinkedHashMap<String, String> resultMap = new LinkedHashMap<>();

    @Override
    public void add(String input, String compareResult) {
        this.resultMap.put(input, compareResult);
    }

    public void add(LinkedHashSet<Integer> input, String compareResult) {
        int num = 0;
        for (int inputNum : input) {
            num = num * 10 + inputNum;
        }
        this.resultMap.put(String.valueOf(num), compareResult);
    }


    @Override
    public void show() {
        for (Map.Entry<String, String> entry : this.resultMap.entrySet()){
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : this.resultMap.entrySet()){
            stringBuilder.append(entry.getKey()).append("    ").append(entry.getValue()).append("\n");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }

    @Override
    public void clear() {
        this.resultMap.clear();
    }
}
