package SpringNoticeBoard.NoticeBoard.domain.user.dto;

import lombok.Data;

@Data
public class AddUserForm {

    private String email;
    private String password;
    private String name;
}
