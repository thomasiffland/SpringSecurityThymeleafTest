package de.tiffland.controllers;

import de.tiffland.entities.User;
import de.tiffland.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by Thomas on 01.02.16.
 */
@Controller
public class RegisterController extends WebMvcConfigurerAdapter {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@Valid User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "register";
        }


        userRepository.insert(user);
        System.out.println(userRepository.findAll());
        return "newuser";
    }
}
