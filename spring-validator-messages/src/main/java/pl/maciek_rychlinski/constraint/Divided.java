package pl.maciek_rychlinski.constraint;

import pl.maciek_rychlinski.divider.NumberDivideValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = NumberDivideValidator.class)
@Target({CONSTRUCTOR, TYPE, FIELD, PARAMETER, METHOD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Divided {
    String message() default "{pl.maciek_rychlinski.Divided.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int by() default 1;
}
