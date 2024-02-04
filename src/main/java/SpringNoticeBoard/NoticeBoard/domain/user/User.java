package SpringNoticeBoard.NoticeBoard.domain.user;

import SpringNoticeBoard.NoticeBoard.validator.annotation.WithoutConsecutiveSpaces;
import SpringNoticeBoard.NoticeBoard.validator.annotation.WithoutSpace;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class User {

    @NotBlank
    private Long id;         //관리용 id

    @Email
    private String email;    //이메일

    @NotBlank
    @WithoutSpace
    private String password; //비밀번호

    @NotBlank
    private String joinDate; //가입 날짜

    @NotBlank
    @WithoutConsecutiveSpaces
    private String name;     //닉네임

    @Range(min = 10, max = 100)
    private int age;         //나이
}
