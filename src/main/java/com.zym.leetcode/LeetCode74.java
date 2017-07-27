package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/27.
 */
/*
 给定一个数组，n个对象分别为红色、白色或蓝色，将它们排序，使同一颜色的对象相邻，颜色依次为红色、白色和蓝色。
 在这里，我们将使用整数0, 1和2分别代表红色、白色和蓝色。
 本题可以使用计数法统计0，1和2出现的次数，然后覆盖元数组
 你能提出一个只用常数空间的单程算法吗？
 */
public class LeetCode74 {
    public static void main(String[] args) {
        int[] A = {2, 0, 1, 2, 0, 0, 2, 2};
        sortColors(A);
        for (int num : A) {
            System.out.println(num);
        }
    }

    public static void sortColors(int[] A) {
        int begin = 0;
        int end = A.length - 1;
        for (int i = 0; i <= end; i++) {
            while (A[i] == 2 && i < end) {
                int temp = A[i];
                A[i] = A[end];
                A[end--] = temp;
            }
            while (A[i] == 0 && i > begin) {
                int temp = A[i];
                A[i] = A[begin];
                A[begin++] = temp;
            }
        }
    }
}
