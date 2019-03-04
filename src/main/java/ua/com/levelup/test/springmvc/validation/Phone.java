package ua.com.levelup.test.springmvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {


    String message() default "{validation.errors.phone}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}