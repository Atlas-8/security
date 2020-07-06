package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printUsers(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/saveUser")
    public String addition(ModelMap model) {
        model.addAttribute("user", new User());
        return "addition";
    }

    @PostMapping(value = "/saveUser")
    public void saveUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String adress = request.getParameter("adress");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(name, adress, email, username, password);
        try {
            userService.add(user);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        response.setContentType("text/html;charset=utf-8");
        response.sendRedirect("/admin/");
    }

    @GetMapping(value = "/deleteUser/{id}")
    public void deleteUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id) throws IOException, SQLException {
        userService.deleteUser(id);
        response.setContentType("text/html;charset=utf-8");
        response.sendRedirect("/admin/");
    }

    @GetMapping(value = "/updateUser/{id}")
    public String updation(ModelMap model, @PathVariable("id") long id){
        model.addAttribute("user", userService.getById(id));
        return "updation";
    }

    @PostMapping(value = "/updateUser/{oldId}")
    public void updateUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("oldId") long oldId) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String adress = request.getParameter("adress");
        String email = request.getParameter("email");
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        userService.updateUser(new User(oldId,name,adress,email, login, password), oldId);
        response.sendRedirect("/admin/");
    }
}