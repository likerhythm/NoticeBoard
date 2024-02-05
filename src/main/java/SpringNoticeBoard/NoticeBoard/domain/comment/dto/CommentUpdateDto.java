package SpringNoticeBoard.NoticeBoard.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentUpdateDto {

    private Long id;

    private String text;

    private Long postId; //redirect
}
