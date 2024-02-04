package SpringNoticeBoard.NoticeBoard.domain.comment.dto;

import lombok.Data;

@Data
public class CommentUpdateDto {

    private Long id;

    private String text;

    private Long postId; //redirect
}
