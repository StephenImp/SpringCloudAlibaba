package com.cn.demoserver1.model;


import java.io.Serializable;

/**
 * User
 *
 * @author wupw
 * @date 2020/12/11
 */
public class User implements Serializable {

    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
