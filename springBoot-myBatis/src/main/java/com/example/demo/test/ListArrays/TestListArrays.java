package com.example.demo.test.ListArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestListArrays {
    public static void main(String[] args) {
          /*不能输出长度，asList 方法的参数必须是对象或者对象数组，
        而原生数据类型不是对象——这也正是包装类出现的一个主要原因。
        当传入一个原生数据类型数组时，asList 的真正得到的参数就不是数组中的元素，
        而是数组对象本身！此时List 的唯一元素就是这个数组*/
//        int[] myArray = { 1, 2, 3 };

        Integer[] myArray = { 1, 2, 3 };
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());

//        int[] intArray = { 5, 10, 21 };
        //Java 8 新引入的 Stream 操作
//        List myList1 = Arrays.stream(intArray).boxed().collect(Collectors.toList());

        //asList方法产生的 ArrayList不能修改大小，那我们就自行创建一个真正的ArrayList
        String[] myArray1 = { "Apple", "Banana", "Orange" };
        List<String> myList1 = new ArrayList<String>(Arrays.asList(myArray1));
        myList1.add("Guava");

        //跟上述方法一样，把数组塞进list中，这个缺点是代码相对冗长
        String[] myArray2 = { "Apple", "Banana", "Orange" };
        List<String> myList2 = new ArrayList<String>();
        for (String str : myArray2) {
            myList2.add(str);
        }
        System.out.println(myList2.size());
    }
}

