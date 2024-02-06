package SpringNoticeBoard.NoticeBoard.domain.user.dto;

import SpringNoticeBoard.NoticeBoard.domain.post.Post;
import SpringNoticeBoard.NoticeBoard.domain.user.User;
import lombok.Data;

import java.util.List;

@Data
public class UserProfileDto {

    private Long id;

    private String name;

    private String introduction;

    private List<Post> posts;

    public UserProfileDto(User user, List<Post> posts) {
        this.id = user.getId();
        this.name = user.getName();
        this.introduction = user.getIntroduction();
        this.posts = posts;
    }
}
