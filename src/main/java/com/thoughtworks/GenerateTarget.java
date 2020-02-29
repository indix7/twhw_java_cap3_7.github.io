package com.thoughtworks;

import java.util.Set;

public interface GenerateTarget {
    /**
     * 检查文件是否存在，以及文件夹中的数是否是指定长度的数，是否不重复
     * @return 检查结果的boolean
     */
    boolean checkFile();

    /**
     * 生成规定长度的不重复数字
     */
    void generateRandomNum();

    /**
     * 规定数的长度
     * @param targetLength 长度
     */
    void setTargetLength(int targetLength);

    /**
     * 返回作为结果的数
     * @return 结果数的Set
     */
    Set<Integer> getTarget();

}
