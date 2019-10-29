package com.example.demo.test;

import com.example.demo.model.Girl;
import com.example.demo.utils.CommonUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    /**
     * 判断字符串中是否包含中文
     * @param str
     * 待校验字符串
     * @return 是否为中文
     * @warn 不能校验是否为中文标点符号
     */
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /*String a = "2018-12-29 17:16:52";
        String b = "2018-12-29 17:16:52";
        if(a != b) {
            System.out.println("不相同");
        }else {
            System.out.println("相同");
        }*/
        /*String a = "0";
        boolean b = a.equals("0");
        if (b){
            System.out.println(b);
        }else{
            System.out.println(b);
        }*/
        /*Map<String, Object> m = new HashMap<>();
        m.put("a","");
//        String b = (String) m.get("a");
        if(m.get("a")=="1"){
            m.put("a",2);
            System.out.println(1);
            System.out.println(m);
        }
        System.out.println(2);
        System.out.println(m);*/

//        String dataS = "27-9月 -14 12.00.00.000000000 上午 ";
//        DateFormat format = new SimpleDateFormat("");

        /*Map<String,String> map = new HashMap<>();
        map.put("a","91441803MA4WXEKJ4L");
        String a = map.put("a","91441803MA4WXEKJ4L");
        map.put("b","我是中国人123XML");
        String b = map.put("b","我是中国人123XML");
        System.out.println("a的长度=" + a.length());
        System.out.println("b的长度=" + b.length());

        boolean a_isChinese = isContainChinese(a);
        boolean b_isChinese = isContainChinese(b);
        System.out.println("a字符串有没包含中文字：" + a_isChinese);
        System.out.println("b字符串有没包含中文字：" + b_isChinese);*/

        /*Girl girl = new Girl();
        girl.setId(1);
        girl.setAge(16);
        girl.setCupSize("36D");
        CommonUtil a = new CommonUtil();
        Map<String,Object> girlmap= a.beanToMap(girl);
        System.out.println(girlmap);*/

        String a = "唯品会Java开发手册》1.0版.pdf";
        String b = a.split("\\.")[a.split("\\.").length-1];
        System.out.println(b);

        /*String uuid = UUID.randomUUID().toString().replace("-","").toLowerCase();
        System.out.println(uuid);*/



    }
}
