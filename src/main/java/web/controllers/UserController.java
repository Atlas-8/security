package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @GetMapping(value = "/user")
    public String printUsers(ModelMap model, HttpServletRequest request) {


        return "userPage";
    }
}
