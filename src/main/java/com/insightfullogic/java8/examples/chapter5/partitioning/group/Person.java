package com.insightfullogic.java8.examples.chapter5.partitioning.group;

/**
 * @Author: 陶鹏飞
 * @Description:
 * @Date: 2018/9/12-15:06
 * @email: taopengfei1223@foxmail.com
 **/
public class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isMyLove() {
        if ("冰儿".equals(name)) {
            return true;
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
