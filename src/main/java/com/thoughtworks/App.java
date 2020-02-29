package com.thoughtworks;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        process();
    }

    public static void process() {
        Input input = new InputDetail();
        GenerateTarget generateTarget = new GenerateTargetDetail();
        Compare compare = new CompareDetail();
        Result result = new ResultDetail();
        Scanner scanner = new Scanner(System.in);

        // 可以尝试的机会和数字长度
        int chance = 6;
        int numLength = 4;

        //设置字符长度
        input.setNumLength(numLength);
        generateTarget.setTargetLength(numLength);

        StringBuilder sb = new StringBuilder();
        sb.append("开始猜数字游戏， 你有 ").append(6).append(" 次机会猜到一个 ")
                .append(numLength).append("位数长度的整数，当看见本条消息，即可开始游戏！");
        System.out.println(sb.toString());

        int index = 0;
        while (index < chance) {
            String originStr = scanner.nextLine();

            try{
                // 检查输入的字符串是否为纯数字，长度是否满足numLength， 是否不包含重复数字。如果否，抛出WrongInputException
                input.checkKeyboardIn(originStr);
                // 比较两个数
                String compareResult = compare.compareTwoNumber(input.getNum(), generateTarget.getTarget());
                // 保存输入的数和结果
                result.add(originStr, compareResult);
                index ++;
                if (compare.checkResult()) {
                    System.out.println("Congratulations, you win!");
                    return;
                }
            } catch (WrongInputException wie) {
                result.add(originStr, wie.getMessage());
            }
            System.out.println(result);

        }
        sb.delete(0, sb.length());
        sb.append("Unfortunately, you have no chance, the answer is ").append(generateTarget).append("!");
        System.out.println(sb.toString());
    }

}
