package SpringNoticeBoard.NoticeBoard.domain.post.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostSaveDto {

    @NotNull
    private String userId;
    @NotNull
    private String title;
    @NotNull
    private String mainText;

    public PostSaveDto(String userId, String title, String mainText) {
        this.userId = userId;
        this.title = title;
        this.mainText = mainText;
    }
}
