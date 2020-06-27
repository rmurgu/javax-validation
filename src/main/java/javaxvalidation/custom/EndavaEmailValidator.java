package javaxvalidation.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EndavaEmailValidator implements ConstraintValidator<EndavaEmail, String> {

    @Override
    public void initialize(EndavaEmail emailValue) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        return value.endsWith("@endava.com");
    }
}