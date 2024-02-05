package SpringNoticeBoard.NoticeBoard.domain.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostEditDto {

    private Long id;

    private String title;

    private String mainText;
}
