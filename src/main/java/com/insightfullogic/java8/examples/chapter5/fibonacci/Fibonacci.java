package com.insightfullogic.java8.examples.chapter5.fibonacci;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * @Author: 陶鹏飞
 * @Description:
 * @Date: 2018/9/13-9:58
 * @email: taopengfei1223@foxmail.com
 **/
public class Fibonacci {

    public static void main(String[] args) {

        //常规实现
        /*Fibonacci fibonacci = new Fibonacci();
        int n = 50;
        int[] fibonacciArray = new int[n];
        for (int i = 0; i < n; i++) {
            fibonacciArray[i] = fibonacci.fibonacci(i);//将n处的值存入数组中
        }
        System.out.println(Arrays.toString(fibonacciArray));*/

        //Lambda表达式实现
        System.out.println(Arrays.toString(Fibonacci.generateFibonacciSequence().limit(50).parallel().toArray()));

    }

    /**
     * Lambda表达式实现
     * @return
     */
    public static IntStream generateFibonacciSequence() {
        return IntStream.iterate(1, new IntUnaryOperator() {
            private int prev = 0;
            @Override
            public int applyAsInt(int operand) {
                int temp = operand + prev;
                prev = operand;
                return temp;
            }
        });

    }

    /**
     * 常规递归实现
     * @param n
     * @return
     */
    private int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else if (n > 1) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        } else {
            return 0;
        }
    }

}
