package SpringNoticeBoard.NoticeBoard.repository.mybatis;

import SpringNoticeBoard.NoticeBoard.domain.comment.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CommentMapper {

    Optional<Comment> findByIdComment(Long id);

    List<Comment> findByUserId(String userId);

    List<Comment> findByPostId(Long postId);

    void saveComment(Comment comment);

    void removeComment(Long id);

    void update(@Param("text") String text, @Param("id") Long id);
}
