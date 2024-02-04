package SpringNoticeBoard.NoticeBoard.validator;

import SpringNoticeBoard.NoticeBoard.validator.annotation.WithoutConsecutiveSpaces;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WithoutConsecutiveSpacesValidator implements ConstraintValidator<WithoutConsecutiveSpaces, String> {
    @Override
    public void initialize(WithoutConsecutiveSpaces constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || !value.matches(".*\\s{2,}.*");
    }
}
