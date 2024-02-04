package SpringNoticeBoard.NoticeBoard.domain.comment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class CommentRepository {

    private static final Map<Long, Comment> store = new HashMap<>();
    private static long sequence = 0L;
    //사용자 닉네임으로 댓글 찾기
    public List<Comment> findByUserId(String userId) {
        return store.values().stream()
                .filter(c -> c.getUserName().equals(userId))
                .collect(Collectors.toList());
    }

    //게시글별 댓글 찾기
    public List<Comment> findByPostId(Long postId) {
        return store.values().stream()
                .filter(c -> c.getPostId().equals(postId))
                .collect(Collectors.toList());
    }

    //댓글 등록
    public void save(Comment comment) {
        log.info("save comment={}", comment);
        comment.setId(sequence++);
        store.put(comment.getId(), comment);
    }

    //댓글 삭제
    public void delete(Long id) {
        store.remove(id);
    }

    //댓글 수정
    public void update(String text, Long id) {
        store.get(id).setText(text);
    }
}
