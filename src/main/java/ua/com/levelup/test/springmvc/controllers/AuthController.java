package ua.com.levelup.test.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.levelup.test.springmvc.dto.User;

@Controller
@RequestMapping
public class AuthController {

    @GetMapping("/auth")
    public ModelAndView  buildForm(){
        User u = new User();
        u.setUsername("login");
        u.setEmail("sdf@sdf.fs");
        u.setFirstname("O");
        u.setLastname("Myk");
        return new ModelAndView("registration", "user", u);
    }

    @PostMapping("/registerProcess")
    public String saveForm(@ModelAttribute("user") User user, ModelMap model){

        model.addAttribute("generalInfo", user.getFirstname()+" "+user.getLastname() +" :: "+user.getUsername());
        model.addAttribute("contactInfo", user.getAddress()+", "+user.getEmail()+", "+user.getPhone());
        return "userview";
    }


}
