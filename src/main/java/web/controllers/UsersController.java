package web.controllers;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.config.WebConfig;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class UsersController {

    @GetMapping(value = "/")
    public String printUsers(ModelMap model) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        UserService userService = context.getBean(UserService.class);
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "users";
    }

}