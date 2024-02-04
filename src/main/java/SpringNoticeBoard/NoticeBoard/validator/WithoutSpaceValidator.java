package SpringNoticeBoard.NoticeBoard.validator;

import SpringNoticeBoard.NoticeBoard.validator.annotation.WithoutSpace;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WithoutSpaceValidator implements ConstraintValidator<WithoutSpace, String> {
    @Override
    public void initialize(WithoutSpace constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.contains(" ");
    }
}
