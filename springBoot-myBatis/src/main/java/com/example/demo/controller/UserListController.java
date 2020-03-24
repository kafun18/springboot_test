package com.example.demo.controller;

import com.example.demo.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class UserListController {

    @GetMapping("/userList")
    public String user(Model model){
        List<Users> users = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<10; i++){
            Users user = new Users();
            user.setId((long) i);
            user.setUsername("科比"+i);
            user.setAddress("詹皇"+i);
            user.setGender(random.nextInt(3));//0表示男 1表示女 其他数字表示未知
            users.add(user);
        }
        model.addAttribute("users",users);
        return "user";
    }

    @GetMapping("/ditu")
    public String ditu(){
        return "ditu";
    }

}
