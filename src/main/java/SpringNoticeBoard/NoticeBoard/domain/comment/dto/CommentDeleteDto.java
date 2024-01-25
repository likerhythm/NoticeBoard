package SpringNoticeBoard.NoticeBoard.domain.comment.dto;

import lombok.Data;

@Data
public class CommentDeleteDto {

    private Long id;
    private Long postId; //redirect
}
