package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/28.
 */
/*
 给定一个字符串数组和一个长度L，格式化数组，保证每行长度是L，
 左右对齐，每行尽可能多的放入单词，必要时填充空格，如果不能保证
 空格平均分配，左边间隙要多余右边间隙的空格。最后一行如果只有单词
 左对齐。例如words=["This", "is", "an", "example", "of", "text", "justification."]
                L=16，返回：[
                                "This    is    an",
                                "example  of text",
                                "justification.  "
                                                    ]
 */
public class LeetCode81 {
    public static void main(String[] args) {
        String[] words = {"What","must","be","shall","be."};
        int L = 12;
        System.out.println(fullJustify(words, L));
    }

    public static ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<>();
        int sum = 0;
        ArrayList<String> temp = new ArrayList<>();
        int wordNum = 0;
        for (int i = 0; i < words.length; i++) {
            sum += words[i].length();
            if (sum + wordNum++ <= L) {
                temp.add(words[i]);
            } else {
                wordNum-=2;
                sum -= words[i].length();
                if (wordNum > 0) {
                    int spaceNum = L - sum;
                    int eachSpaceNum = spaceNum / wordNum;
                    int surplus = spaceNum % wordNum;
                    String line = "";
                    for (int j = 0; j < temp.size() - 1; j++) {
                        line += temp.get(j);
                        for (int k = 0; k < eachSpaceNum; k++) {
                            line += " ";
                        }
                        if (surplus-- > 0) {
                            line += "";
                        }
                    }
                    line += temp.get(temp.size() - 1);
                    result.add(line);
                }else {
                    String line = temp.get(0);
                    for (int k = 0;k<L-line.length();k++){
                        line += " ";
                    }
                    result.add(line);
                }
                temp.clear();
                sum = 0;
                wordNum = 0;
                i--;
            }
        }
        if (temp.size()>0){
            wordNum-=1;
            if (wordNum > 0) {
                int spaceNum = L - sum;
                int eachSpaceNum = spaceNum / wordNum;
                int surplus = spaceNum % wordNum;
                String line = "";
                for (int j = 0; j < temp.size() - 1; j++) {
                    line += temp.get(j);
                    for (int k = 0; k < eachSpaceNum; k++) {
                        line += " ";
                    }
                    if (surplus-- > 0) {
                        line += "";
                    }
                }
                line += temp.get(temp.size() - 1);
                result.add(line);
            }else {
                String line = temp.get(0);
                for (int k = 0;k<L-line.length();k++){
                    line += " ";
                }
                result.add(line);
            }
        }
        return result;
    }
}
