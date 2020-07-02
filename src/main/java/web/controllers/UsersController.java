package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class UsersController {

    UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String printUsers(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/saveUser")
    public void saveUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String adress = request.getParameter("adress");
        String email = request.getParameter("email");
        User user = new User(name, adress, email);
        userService.add(user);
        response.setContentType("text/html;charset=utf-8");
        response.sendRedirect("/users");
    }

    @GetMapping(value = "/deleteUser")
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String inputId = request.getParameter("id");
        long id = Long.parseLong(inputId);
        userService.deleteUser(id);
        response.setContentType("text/html;charset=utf-8");
        response.sendRedirect("/users");
    }

    @PostMapping(value = "/updateUser")
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String inputId = request.getParameter("id");
        long id = Long.parseLong(inputId);
        String name = request.getParameter("name");
        String adress = request.getParameter("adress");
        String email = request.getParameter("email");
        String inputOldId = request.getParameter("oldId");
        long oldId = Long.parseLong(inputOldId);
        userService.updateUser(new User(id,name,adress,email), oldId);
        response.sendRedirect("/users");
    }
}