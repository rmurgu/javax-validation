package javaxvalidation.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {EndavaEmailValidator.class})
public @interface EndavaEmail {

    String message() default "Must be a valid Endava email address";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };
}