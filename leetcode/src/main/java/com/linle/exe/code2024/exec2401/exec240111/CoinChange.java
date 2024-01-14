package com.linle.exe.code2024.exec2401.exec240111;

import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * @description: 322. 零钱兑换 middle
 * @author: chendeli
 * @date: 2024-01-11 11:06
 */
public class CoinChange {
    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 示例 1：
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     * <p>
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：coins = [1], amount = 0
     * 输出：0
     * <p>
     * 提示：
     * <p>
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 10^4
     */
    @Test
    public void test() {
        int[] i = new int[]{411,412,413,414,415,416,417,418,419,420,421,422};
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int i1 = coinChange1(i, 9864);
        stopWatch.stop();
        double totalTimeSeconds = stopWatch.getTotalTimeSeconds();
        System.out.println(totalTimeSeconds);
        System.out.println(i1);
    }

    /**
     * 解题思路： f(n) = f(n-1) + min(f(x))
     *
     * @param coins
     * @param amount
     * @return
     */
    int minChangeCount = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        getChange(coins,amount,0, coins.length-1);
        return minChangeCount == Integer.MAX_VALUE ? -1 : minChangeCount;
    }

    private void getChange(int[] coins, int amount,int count,int l) {
        for (int i = l; i >= 0 ; i--) {
            if(count >= minChangeCount-1){
                return;
            }
            if(amount>=coins[i]) {
                amount -= coins[i];
                if(amount ==  0 ){
                    minChangeCount = count + 1;
                    break;
                }
                getChange(coins, amount, count + 1,i);
                amount += coins[i];
            }
        }
    }

    /**
     * dg解决   dp(n) = min(dp(n),dp(n-x)+1)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        int[] sub = new int[amount+1];
        Arrays.fill(sub, amount+1);
        sub[0] = 0;
        for (int i = 0; i < sub.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0) {
                    sub[i] = Math.min(sub[i], sub[i - coins[j]]+1) ;
                }
            }
        }
        return sub[amount];
    }
}