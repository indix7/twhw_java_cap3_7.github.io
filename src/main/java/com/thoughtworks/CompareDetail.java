package com.thoughtworks;

import java.util.Set;
import java.util.Iterator;

public class CompareDetail implements Compare {
    private boolean allRight = false;

    public String compareTwoNumber(Set<Integer> input, Set<Integer> target) {
        int correct = 0;
        int wrongPosition = 0;
        Iterator<Integer> inputIterator = input.iterator();
        Iterator<Integer> targetIterator = target.iterator();
        while (inputIterator.hasNext()) {
            int current = inputIterator.next();
            if (current == targetIterator.next()) {
                correct ++;
                continue;
            }
            if (target.contains(current)) {
                wrongPosition ++;
            }
        }
        if (correct == input.size()) {
            this.allRight = true;
        }
        return correct + "A" + wrongPosition + "B";
    }

    public boolean checkResult() {
        return this.allRight;
    }
}
