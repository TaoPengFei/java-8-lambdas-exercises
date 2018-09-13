package com.insightfullogic.java8.examples.chapter5.partitioning.group;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: 陶鹏飞
 * @Description:
 * @Date: 2018/9/12-15:09
 * @email: taopengfei1223@foxmail.com
 **/
public class PartitioningByAndGroupBy {

    public static void main(String[] args) {
        Stream<Person> stream = Stream.of(new Person("1", "林肯"), new Person("2", "冰儿"));
        Map<String, List<Person>> collect = stream.collect(Collectors.groupingBy(Person::getId));
        for (String string : collect.keySet()) {
            System.out.println(string + "-->" + collect.get(string));
        }

        System.out.println("==================================================");

        Stream<Person> stream1 = Stream.of(new Person("1", "林肯"), new Person("2", "冰儿"), new Person("3", "忽忽"));
        Map<Boolean, List<Person>> collect2 = stream1.collect(Collectors.partitioningBy(Person::isMyLove));
//        Map<Boolean, List<Person>> collect2 = stream1.collect(Collectors.partitioningBy(Person::getId));
        for (boolean string : collect2.keySet()) {
            System.out.println(string + "-->" + collect2.get(string));
        }
    }
}
