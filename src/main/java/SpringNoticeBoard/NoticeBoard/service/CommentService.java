package SpringNoticeBoard.NoticeBoard.service;

import SpringNoticeBoard.NoticeBoard.domain.comment.Comment;
import SpringNoticeBoard.NoticeBoard.repository.CommentRepository;
import SpringNoticeBoard.NoticeBoard.repository.memoryrepository.MemoryCommentRepository;
import SpringNoticeBoard.NoticeBoard.domain.comment.dto.CommentSaveDto;
import SpringNoticeBoard.NoticeBoard.utils.TimeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 작성
    public void save(CommentSaveDto dto, String loginUserName) {
        Comment saveComment = setComment(dto, loginUserName);
        commentRepository.save(saveComment);
    }
    //댓글 삭제
    public void remove(Long id) {
        commentRepository.remove(id);
    }

    //댓글 수정
    public void update(String text, Long id) {
        commentRepository.update(text, id);
    }

    //게시글별 댓글 찾기
    public List<Comment> findByPostId(Long id) {
        return commentRepository.findByPostId(id);
    }

    private static Comment setComment(CommentSaveDto dto, String loginUsername) {
        Comment saveComment = new Comment();
        saveComment.setUserName(loginUsername);
        saveComment.setText(dto.getText());
        saveComment.setWriteDate(TimeValue.setDate());
        saveComment.setModifyDate("");
        saveComment.setPostId(dto.getPostId());
        return saveComment;
    }
}
