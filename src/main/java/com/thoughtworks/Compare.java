package com.thoughtworks;

import java.util.Set;

public interface Compare {
    /**
     * 返回比较两数的结果
     * @param input 输入的数
     * @param target 目标结果
     * @return 比较的结果，格式为 correct A wrongPosition B
     */
    String compareTwoNumber(Set<Integer> input, Set<Integer> target);

    /**
     * 检查输入数字是否全对
     * @return 是否全对的boolean
     */
    boolean checkResult();
}
