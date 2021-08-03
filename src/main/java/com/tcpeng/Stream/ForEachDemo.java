package com.tcpeng.Stream;

import com.tcpeng.java8.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tcp
 * @date 2021/7/30 11:59
 * @description 多个集合通过foreach  d
 **/
public class ForEachDemo {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setId("1001");
        p1.setName("张三");
        p1.setAge("20");
        Person p2 = new Person();
        p2.setId("1002");
        p2.setName("张三");
        p2.setAge("20");

        List<Person> list1 = new ArrayList<>();
        list1.add(p1);
        list1.add(p2);
        List<Person> list2 = new ArrayList<>();
        list2.add(p1);


        for (Person person1 : list1) {
            for (Person person2 : list2) {
                if (person1.getId().equals(person2.getId())) {
                    person1.setStatus("选中");
                }
            }
        }
        System.out.println(list1.toString());

        /**
         * foreach和上面的双层for循环的作用相同
         */
        list1.stream().forEach(l1 -> list2.stream().allMatch(l2 -> {
            if (l2.getId().equals(l1.getId())) {
                l1.setStatus("重复");
            }
            return true;
        }));
        System.out.println(list1.toString());


        list1.stream().forEach(l1->list2.stream().forEach(l2->{
            if(l1.getId().equals(l2.getId())){
                l1.setStatus("选择");
            }
        }));
        System.out.println(list1.toString());

        list1.forEach(l1->list2.forEach(l2->{
            if(l1.getId().equals(l2.getId())){
                l1.setStatus("选择1");
            }
        }));
        System.out.println(list1.toString());
    }
}
