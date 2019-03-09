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
import ua.com.levelup.test.springmvc.model.User;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public String  buildForm(ModelMap m){
        m.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String saveForm(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model){

        if(result.hasErrors()) {
            return "registration";
        }
        model.addAttribute("generalInfo",
                messageSource.getMessage("info.general", new String[]{user.getLogin(),user.getFirstname(),user.getLastname()},new Locale("uk", "UA")));
        model.addAttribute("contactInfo", user.getAddress()+", "+user.getEmail()+", "+user.getPhone());
        return "userview";
    }

}
