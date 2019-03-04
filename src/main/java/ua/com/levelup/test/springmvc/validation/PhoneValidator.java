package ua.com.levelup.test.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone paramA) {
    }

    @Override
    public boolean isValid(String phone,
                           ConstraintValidatorContext cxt) {
        return phone != null && phone.matches("[0-9]+")
                && (phone.length() > 8) && (phone.length() < 14);
    }

}
