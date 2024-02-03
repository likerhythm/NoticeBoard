package SpringNoticeBoard.NoticeBoard.domain.user;

import lombok.Data;

@Data
public class User {

    private Long id;         //관리용 id
    private String email;    //이메일
    private String password; //비밀번호
    private String joinDate; //가입 날짜
    private String name;     //닉네임
    private int age;         //나이
}
