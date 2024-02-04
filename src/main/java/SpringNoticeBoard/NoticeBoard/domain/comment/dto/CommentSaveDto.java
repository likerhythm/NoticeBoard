package SpringNoticeBoard.NoticeBoard.domain.comment.dto;

import lombok.Data;

@Data
public class CommentSaveDto {

    private String userName;
    private String text;
    private Long postId;

    public CommentSaveDto(String userName, String text, Long postId) {
        this.userName = userName;
        this.text = text;
        this.postId = postId;
    }
}
