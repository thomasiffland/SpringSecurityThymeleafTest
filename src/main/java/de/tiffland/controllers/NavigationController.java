package de.tiffland.controllers;

import de.tiffland.entities.User;
import de.tiffland.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Thomas on 01.02.16.
 */
@Controller
public class NavigationController {

    @Autowired
    UserRepository repository;

    @RequestMapping("/")
    public String root() {
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(path="/register",method= RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user",new User());
        return "register";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }




}
