package com.in28minutes.springboot.basics.springbootin10steps;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int num = 0;
        int i;
        Arrays.sort(A);
        if (A.length == 1) {
            if (A[0] < 0) {
                return 1;
            } else if (A[0] == 0){
                return 1;
            }else if(A[0] == 1){
                return 2;
            }else {
                return A[0] - 1;
            }
        }
        for (i = 1; i < A.length; i++) {
            if (A[i - 1] < 0 && A[i] < 0) {
                continue;
            } else if ((A[i - 1] < 0 && A[i] >= 0) ||
                    (A[i - 1] >= 0 && A[i] >= 0)) {
                num = A[i - 1];
                if (A[i] == A[i - 1] + 1 ||
                        A[i] == A[i - 1] ||
                        A[i - 1] < 0 && A[i] >= 0) {
                    continue;
                } else {
                    break;
                }
            }
        }
        if (num <= 0 ) {
            return 1;
        } else if (i == A.length) {
            return A[A.length - 1] + 1;
        } else {
            return num + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().solution(new int[]{0,8,3,7,35,45,27,95,102,158,147,123,198})
        );
    }
}