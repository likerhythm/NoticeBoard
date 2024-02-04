package SpringNoticeBoard.NoticeBoard.validator.annotation;

import SpringNoticeBoard.NoticeBoard.validator.WithoutSpaceValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = WithoutSpaceValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface WithoutSpace {
    String message() default "값에 공백이 포함되어 있습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
