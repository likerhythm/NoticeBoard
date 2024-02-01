package SpringNoticeBoard.NoticeBoard.controller;

import SpringNoticeBoard.NoticeBoard.service.CommentService;
import SpringNoticeBoard.NoticeBoard.service.PostService;
import SpringNoticeBoard.NoticeBoard.domain.comment.dto.CommentSaveDto;
import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostSaveDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final PostService postService;
    private final CommentService commentService;

    @PostConstruct
    public void initComment() {
        commentService.save(new CommentSaveDto("1", "테스트 댓글1", 1L));
        commentService.save(new CommentSaveDto("2", "테스트 댓글2", 1L));
        commentService.save(new CommentSaveDto("1", "테스트 댓글3", 2L));
        commentService.save(new CommentSaveDto("2", "테스트 댓글4", 2L));
    }

    @PostConstruct
    public void initPost() {
        postService.save(new PostSaveDto("1", "테스트 제목1", "테스트 본문1"));
        postService.save(new PostSaveDto("2", "테스트 제목2", "테스트 본문2"));
    }
}
