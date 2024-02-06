package SpringNoticeBoard.NoticeBoard.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentSaveDto {

    @NotBlank
    private String text;

    private Long postId;

    public CommentSaveDto(String text, Long postId) {
        this.text = text;
        this.postId = postId;
    }
}
