package ua.com.levelup.test.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.levelup.test.springmvc.dto.User;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping
public class AuthController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/auth")
    public String  buildForm(ModelMap m){
        User u = new User();
        u.setUsername("login");
        u.setEmail("sdf@sdf.fs");
        u.setFirstname("O");
        u.setLastname("Myk");
        m.addAttribute("user", u);
        return "registration";
    }

    @PostMapping("/registerProcess")
    public String saveForm(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model){
        if(result.hasErrors()) {
            return "registration";
        }
        model.addAttribute("generalInfo",
                messageSource.getMessage("info.general", new String[]{user.getUsername(),user.getFirstname(),user.getLastname()},new Locale("uk", "UA")));
        model.addAttribute("contactInfo", user.getAddress()+", "+user.getEmail()+", "+user.getPhone());
        return "userview";
    }

}
