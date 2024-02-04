package SpringNoticeBoard.NoticeBoard.domain.post;

import lombok.Data;

import java.util.Date;

@Data
public class Post {

    private Long id;          //관리용 id

    private String writeDate;   //작성 시간

    private String modifyDate;  //최종 수정 시간

    private String userName;    //작성자 닉네임

    private String title;     //제목

    private String mainText;  //본문
}
