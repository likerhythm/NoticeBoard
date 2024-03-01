package SpringNoticeBoard.NoticeBoard.repository;

import SpringNoticeBoard.NoticeBoard.domain.post.Post;
import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostEditDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostRepository {

    Post save(Post post);

    Post findById(Long id);

    List<Post> findAll();

    List<Post> findAllByUser(String userName);

    void edit(Long id, PostEditDto dto, String modifyDate);

    void remove(Long id);
}
