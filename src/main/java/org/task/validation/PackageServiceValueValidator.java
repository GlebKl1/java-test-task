package org.task.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PackageServiceValueValidator implements ConstraintValidator<PackageServiceValue, Integer> {
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer >= -1;
    }
}
