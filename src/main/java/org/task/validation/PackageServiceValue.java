package org.task.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=PackageServiceValueValidator.class)
public @interface PackageServiceValue {
    String message() default "Value must be bigger than -1";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
