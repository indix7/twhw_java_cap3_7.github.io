package com.thoughtworks;

import java.util.LinkedHashSet;
import java.util.Set;

public class InputDetail implements Input {
    private int numLength = 4;
    private Set<Integer> num = new LinkedHashSet<>();

    @Override
    public void checkKeyboardIn(String originStr) throws WrongInputException {
        this.num.clear();
        this.checkNum(originStr);
    }

    /**
     * 检查输入的数
     *  1. 是否是指定长度
     *  2. 是否可以转换为整数
     *  3. 是否重复
     * @param originStr 输入的字符串
     * @throws WrongInputException 不是标准格式则抛出此异常
     */
    private void checkNum(String originStr) throws WrongInputException{
        String exceptionMessage = "Wrong input";
        if (originStr.length() != this.numLength) {
            throw new WrongInputException(exceptionMessage);
        }
        for (char c : originStr.toCharArray()) {
            if (c > '9' || c < '0') {
                throw new WrongInputException(exceptionMessage);
            } else {
                this.num.add(c - '0');
            }
        }

        if (this.num.size() != this.numLength) {
            throw new WrongInputException(exceptionMessage);
        }
    }

    @Override
    public void setNumLength(int len) {
        this.numLength = len;
    }

    @Override
    public Set<Integer> getNum() {
        return this.num;
    }
}
