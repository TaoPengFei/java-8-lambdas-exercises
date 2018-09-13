package com.insightfullogic.java8.examples.chapter5.factorial;

/**
 * @Author: 陶鹏飞
 * @Description:
 * @Date: 2018/9/13-10:08
 * @email: taopengfei1223@foxmail.com
 **/
public class FactorialRecursion {

    public static void main(String[] args) {
//        FactorialRecursion factorialRecursion = new FactorialRecursion();
//        System.out.println(factorialRecursion(100_000));    //堆栈溢出
//        System.out.println(factorialTailRecursion(1,100_000));      //堆栈溢出
        System.out.println(factorialTailRecursionLambda(1,10_000_000).invoke());
    }

    /**
     * 阶乘计算 -- 递归解决
     *  这种方法计算阶乘比较大的数很容易就栈溢出了，原因是每次调用下一轮递归的时候在栈中都需要保存之前的变量
     * 5
     *   4
     *     3
     *       2
     *         1
     * ------------------->
     *       栈的深度
     * @param number 当前阶乘需要计算的数值
     * @return number!
     */
    private static int factorialRecursion(final int number) {
        if (number == 1) {
            return number;
        } else {
            return number * factorialRecursion(number - 1);
        }
    }

    /**
     * 阶乘计算 -- 尾递归解决
     *  通过每轮递归结束后刷新当前的栈空间，复用了栈，就克服了递归的栈溢出问题，像这样的return后面不附带任何变量的递归写法，也就是递归发生在函数最尾部,我们称之为'尾递归'。
     * @param factorial 上一轮递归保存的值
     * @param number 当前阶乘需要计算的数值
     * @return number!
     */
    public static int factorialTailRecursion(final int factorial, final int number) {
        if (number == 1) {
            return factorial;
        } else {
            return factorialTailRecursion(factorial * number, number - 1);
        }
    }

    /**
     * 阶乘计算 -- 使用尾递归接口完成
     * @param factorialLambda 当前递归栈的结果值
     * @param numberLambda 下一个递归需要计算的值
     * @return 尾递归接口,调用invoke启动及早求值获得结果
     */
    /*private static TailRecursion<Integer> factorialTailRecursionLambda(final int factorialLambda, final int numberLambda) {
        if (numberLambda == 1) {
            return TailInvoke.done(factorialLambda);
        } else {
            return TailInvoke.call(() -> factorialTailRecursionLambda(factorialLambda + numberLambda, numberLambda - 1));
        }
    }*/
    public static TailRecursion<Long> factorialTailRecursionLambda(final long factorialLambda, final long numberLambda) {
        if (numberLambda == 1) {
            return TailInvoke.done(factorialLambda);
        } else {
            return TailInvoke.call(() -> factorialTailRecursionLambda(factorialLambda + numberLambda, numberLambda - 1));
        }
    }

}
