package SpringNoticeBoard.NoticeBoard.validator.annotation;

import SpringNoticeBoard.NoticeBoard.validator.WithoutConsecutiveSpacesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = WithoutConsecutiveSpacesValidator.class) //검증 클래스
@Target({ElementType.FIELD, ElementType.PARAMETER})                //사용범위
@Retention(RetentionPolicy.RUNTIME)                                //런타임에도 애노테이션이 유효하도록
public @interface WithoutConsecutiveSpaces {
    String message() default "값에 연속된 공백이 포함되어 있습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
