package SpringNoticeBoard.NoticeBoard.repository;

import SpringNoticeBoard.NoticeBoard.domain.comment.Comment;

import java.util.List;

public interface CommentRepository {

    Comment findById(Long id);

    List<Comment> findByUserId(String userId);

    List<Comment> findByPostId(Long postId);

    void save(Comment comment);

    void remove(Long id);

    void update(String text, Long id);
}
