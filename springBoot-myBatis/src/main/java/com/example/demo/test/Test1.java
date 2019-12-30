package com.example.demo.test;

import com.alibaba.fastjson.JSON;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        /*int number = 1;
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(7);
        formatter.setGroupingUsed(false);
        String s = formatter.format(number);
        s=s+1;
        System.out.println(s);*/
        List<Map<String,Object>> lm11 = new ArrayList<>();
        Map<String,Object> m11 = new HashMap<>();
        m11.put("mdm_code","2");
        m11.put("name","银行档案1");
        lm11.add(m11);

        List<Map<String,Object>> lm22 = new ArrayList<>();
        Map<String,Object> m22 = new HashMap<>();
        m22.put("mdm_code","3");
        m22.put("name","银行档案2");
        lm22.add(m22);

        Map<String,Object> m1 = new HashMap<>();
        m1.put("code","2");
        m1.put("name","银行信息1");
        m1.put("bankaccount",lm11);
        m1.put("banktype","1");

        Map<String,Object> m2 = new HashMap<>();
        m2.put("code","3");
        m2.put("name","银行信息2");
        m2.put("bankaccount",lm22);
        m2.put("banktype","2");

        List<Map<String,Object>> ms = new ArrayList<>();
        ms.add(m1);
        ms.add(m2);

        Map<String,Object> m = new HashMap<>();
        m.put("code","1");
        m.put("name","客商");
        m.put("bodymdm_merchants_yhxx",ms);
        List<Map<String,Object>> datas = new ArrayList<>();
        datas.add(m);
        System.out.println(m);

        List<Map<String,Object>> lm = (List<Map<String, Object>>) m.get("bodymdm_merchants_yhxx");
        if(lm.size()!=0){
            List<Map<String, Object>> l = (List<Map<String, Object>>) m.get("bodymdm_merchants_yhxx");
            for(Map<String, Object> mmm1:l){
                List<Map<String, Object>> m_bankaccount = (List<Map<String, Object>>) mmm1.get("bankaccount");
//                String m_banktype = (String) mmm1.get("banktype");
                for(Map<String, Object> mmm2: m_bankaccount){
                    String mdm_code = (String) mmm2.get("mdm_code");
                    mmm1.put("banktype",mdm_code);
                }
            }
        }
        System.out.println(m);

    }


}
