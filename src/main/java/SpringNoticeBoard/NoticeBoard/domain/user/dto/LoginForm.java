package SpringNoticeBoard.NoticeBoard.domain.user.dto;

import SpringNoticeBoard.NoticeBoard.validator.annotation.WithoutSpace;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginForm {

    @Email
    private String email;

    @NotBlank
    @Length(min = 1, max = 20)
    @WithoutSpace
    private String password;
}
