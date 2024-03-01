package SpringNoticeBoard.NoticeBoard.repository.mybatis;

import SpringNoticeBoard.NoticeBoard.domain.post.Post;
import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostEditDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {

    void save(Post post);

    Post findById(Long id);

    List<Post> findAll();

    List<Post> findAllByUser(String userName);

    void editPost(@Param("id") Long id, @Param("dto") PostEditDto dto, @Param("modifyDate") String modifyDate);

    void removePost(Long id);
}
