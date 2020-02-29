package com.thoughtworks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class GenerateTargetDetail implements GenerateTarget{
    private int targetLength = 4;
    private Set<Integer> target = new LinkedHashSet<>();

    /**
     * 文件中的数不合格则生成随机数
     */
    public GenerateTargetDetail() {
        if (!checkFile()) {
            generateRandomNum();
        }
    }

    @Override
    public boolean checkFile() {
        final String NUMBER_FILE_PATH = "src\\main\\resources\\answer.txt";
        File file = new File(NUMBER_FILE_PATH);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] data = new byte[targetLength + 1];
            if (fileInputStream.read(data) != -1) {
                return checkNum(data);
            } else {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 验证nums中的数
     * 1. 是否以\r结尾，即文件是否只包含numLength个数；
     * 2. 文件中的字符是否是0-9；
     * 3. 文件中的字符是否重复；
     * @param data 读入文件中的byte数组
     * @return 是否满足1、2、3要求
     */
    private boolean checkNum(byte[] data) {
        if (data[targetLength] != '\r'){
            return false;
        }
        this.target.clear();
        for(byte bt : Arrays.copyOf(data,data.length-1)) {
            if (bt < '0' || bt > '9') {
                return false;
            }
            this.target.add(bt - '0');
        }
        return (this.target.size() == targetLength);
    }

    @Override
    public void generateRandomNum() {
        Random random = new Random();
        target.clear();
        while (target.size() < targetLength) {
            target.add(random.nextInt(9) + 1);
        }
    }

    @Override
    public Set<Integer> getTarget() {
        return this.target;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : target) {
            sb.append(i);
        }
        return sb.toString();
    }

    public int getTargetLength() {
        return targetLength;
    }

    @Override
    public void setTargetLength(int targetLength) {
        this.targetLength = targetLength;
    }
}
