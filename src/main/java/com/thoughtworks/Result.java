package com.thoughtworks;
public interface Result {
    /**
     * 保存猜测结果和正确率
     * @param input 输入的数
     * @param compareResult 比较的结果
     */
    void add(String input, String compareResult);

    /**
     * 打印历次比较结果
     */
    void show();

    /**
     * 以字符串形式返回历次结果
     * @return 历次记录
     */
    String toString();

    /**
     * 清空结果记录
     */
    void clear();
}
