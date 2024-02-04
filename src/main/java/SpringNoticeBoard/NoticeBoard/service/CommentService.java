package SpringNoticeBoard.NoticeBoard.service;

import SpringNoticeBoard.NoticeBoard.domain.comment.Comment;
import SpringNoticeBoard.NoticeBoard.domain.comment.CommentRepository;
import SpringNoticeBoard.NoticeBoard.domain.comment.dto.CommentSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 작성
    public void save(CommentSaveDto dto) {
        Comment saveComment = setComment(dto);
        commentRepository.save(saveComment);
    }
    //댓글 삭제
    public void delete(Long id) {
        commentRepository.delete(id);
    }

    //댓글 수정
    public void update(String text, Long id) {
        commentRepository.update(text, id);
    }

    //게시글별 댓글 찾기
    public List<Comment> findByPostId(Long id) {
        return commentRepository.findByPostId(id);
    }

    private static Comment setComment(CommentSaveDto dto) {
        Comment saveComment = new Comment();
        saveComment.setUserName(dto.getUserName());
        saveComment.setText(dto.getText());
        saveComment.setWriteDate(setDate());
        saveComment.setModifyDate("");
        saveComment.setPostId(dto.getPostId());
        return saveComment;
    }

    private static String setDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToString = dateFormat.format(date);
        return dateToString;
    }
}
