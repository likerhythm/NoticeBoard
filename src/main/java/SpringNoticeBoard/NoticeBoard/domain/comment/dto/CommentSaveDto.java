package SpringNoticeBoard.NoticeBoard.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentSaveDto {

    @NotBlank
    private String userName;

    @NotBlank
    private String text;

    private Long postId;

    public CommentSaveDto(String userName, String text, Long postId) {
        this.userName = userName;
        this.text = text;
        this.postId = postId;
    }
}
