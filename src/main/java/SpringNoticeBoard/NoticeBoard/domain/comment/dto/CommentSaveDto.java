package SpringNoticeBoard.NoticeBoard.domain.comment.dto;

import lombok.Data;

@Data
public class CommentSaveDto {

    private String userId;
    private String text;
    private Long postId;

    public CommentSaveDto(String userId, String text, Long postId) {
        this.userId = userId;
        this.text = text;
        this.postId = postId;
    }
}
