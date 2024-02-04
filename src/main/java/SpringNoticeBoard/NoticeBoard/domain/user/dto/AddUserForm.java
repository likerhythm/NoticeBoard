package SpringNoticeBoard.NoticeBoard.domain.user.dto;

import SpringNoticeBoard.NoticeBoard.validator.annotation.WithoutConsecutiveSpaces;
import SpringNoticeBoard.NoticeBoard.validator.annotation.WithoutSpace;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
public class AddUserForm {

    @Email
    private String email;

    @NotBlank
    @Length(min = 1, max = 20)
    @WithoutSpace
    private String password;

    @NotBlank
    @Length(min = 1, max = 10)
    @WithoutConsecutiveSpaces
    private String name;

    @Range(min = 10, max = 100)
    private int age = 10;
}
