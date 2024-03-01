package SpringNoticeBoard.NoticeBoard.repository.mybatis;

import SpringNoticeBoard.NoticeBoard.domain.comment.Comment;
import SpringNoticeBoard.NoticeBoard.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
public class MyBatisCommentRepository implements CommentRepository {

    private final CommentMapper commentMapper;

    @Override
    public Comment findById(Long id) {
        return commentMapper.findByIdComment(id).orElse(null);
    }

    @Override
    public List<Comment> findByUserId(String userId) {
        return commentMapper.findByUserId(userId);
    }

    @Override
    public List<Comment> findByPostId(Long postId) {
        return commentMapper.findByPostId(postId);
    }

    @Override
    public void save(Comment comment) {
        commentMapper.saveComment(comment);
    }

    @Override
    public void remove(Long id) {
        commentMapper.removeComment(id);
    }

    @Override
    public void update(String text, Long id) {
        commentMapper.update(text, id);
    }
}
