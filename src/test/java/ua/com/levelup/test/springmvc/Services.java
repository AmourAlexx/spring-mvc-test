package ua.com.levelup.test.springmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RunWith(JUnit4.class)
public class Services {



    @Test
    public void encodeBCrypt() {
        PasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.println(pe.encode("admin"));
    }
}
