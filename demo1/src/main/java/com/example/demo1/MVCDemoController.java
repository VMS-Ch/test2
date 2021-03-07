package com.example.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * @author zms
 * @date 2021/03/05 15:23
 */
@Controller
@Slf4j
public class MVCDemoController {
    @GetMapping("/user")
    public String hello(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        return "success";
    }

    @GetMapping("/check")
    public String check() {
        return "check";
    }

    @GetMapping("/success")
    public ModelAndView success() {
        ModelAndView modelAndView = new ModelAndView();
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(23, 1, "zms"));
        users.add(new User(24, 2, "vms"));
        modelAndView.addObject("userList", users);
        return modelAndView;
    }

}
