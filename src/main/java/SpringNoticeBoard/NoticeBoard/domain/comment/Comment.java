package SpringNoticeBoard.NoticeBoard.domain.comment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Comment {

    private Long id;         //관리용 id

    private String userName;     //작성자 닉네임

    private String text;     //내용

    private String writeDate;  //작성 날짜

    private String modifyDate; //최종 수정 날짜

    private Long postId;   //등록된 게시글 id

    public Comment() {}
}
