package com.netease.demo_02.bean;

/**
 * Created by wuxiangkun on 2018/3/21.
 * Contact by bjwuxiangkun@corp.netease.com
 */

public class Person {
  String name;
  int  age;
  String phone;

  public Person(String name, int age, String phone) {
    this.name = name;
    this.age = age;
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
