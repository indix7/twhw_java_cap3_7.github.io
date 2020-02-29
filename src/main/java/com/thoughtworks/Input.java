package com.thoughtworks;

import java.util.Set;

public interface Input {
    /**
     * 检查键盘输入的字符串是否是一个合格的整数，是否满足长度，是否不包含重复
     * @param originStr 键盘输入的字符串
     * @throws WrongInputException 不符合要求则抛出该异常
     */
    void checkKeyboardIn(String originStr) throws WrongInputException;

    /**
     * 设置字符串长度的标准
     * @param len 字符串长度
     */
    void setNumLength(int len);

    /**
     * 返回字符串输入的数的LinkedHashSet
     * @return 键盘键入数的Set
     */
    Set<Integer> getNum();
}
