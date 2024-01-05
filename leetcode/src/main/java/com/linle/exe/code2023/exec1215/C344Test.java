package com.linle.exe.code2023.exec1215;

import org.junit.Test;

/**
 * @author chendeli
 * @Description: 反转字符串
 * @date 2022/12/15 10:02
 */
public class C344Test {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     */
    @Test
    public void test344(){
        String s1  = "abcdfdkfjk";
        char[] s = s1.toCharArray();

        int left = 0,right = s.length-1;
        while(left < right){
            swap(left,right,s);
            left++;
            right--;
        }
    }

    private void swap(int left, int right, char[] s) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
