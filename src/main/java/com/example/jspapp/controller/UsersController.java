package com.example.jspapp.controller;

import com.example.jspapp.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersMapper usersMapper;

    @GetMapping("/getUsers")
    public ModelAndView getAllUsers() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("allUsers", usersMapper.getAllUsers());
        mav.setViewName("users");
        return mav;
    }

}
