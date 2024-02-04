package SpringNoticeBoard.NoticeBoard.domain.post.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostSaveDto {

    @NotNull
    private String userName;
    @NotNull
    private String title;
    @NotNull
    private String mainText;

    public PostSaveDto(String userName, String title, String mainText) {
        this.userName = userName;
        this.title = title;
        this.mainText = mainText;
    }
}
