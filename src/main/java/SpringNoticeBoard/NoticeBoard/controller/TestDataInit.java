package SpringNoticeBoard.NoticeBoard.controller;

import SpringNoticeBoard.NoticeBoard.domain.comment.Comment;
import SpringNoticeBoard.NoticeBoard.repository.CommentRepository;
import SpringNoticeBoard.NoticeBoard.repository.memoryrepository.MemoryCommentRepository;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.AddUserForm;
import SpringNoticeBoard.NoticeBoard.service.CommentService;
import SpringNoticeBoard.NoticeBoard.service.PostService;
import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostSaveDto;
import SpringNoticeBoard.NoticeBoard.service.UserService;
import SpringNoticeBoard.NoticeBoard.utils.TimeValue;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final PostService postService;
    private final CommentRepository commentRepository;
    private final UserService userService;

    @EventListener(ApplicationReadyEvent.class)
    public void initUser() {
        userService.add(new AddUserForm("dd@dd", "test1", "test1", 10));
        userService.add(new AddUserForm("ss@ss", "test2", "test2", 10));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initComment() {
        commentRepository.save(new Comment(100L, "test1", "테스트 댓글1", TimeValue.setDate(), "", 1L));
        commentRepository.save(new Comment(101L, "test2", "테스트 댓글2", TimeValue.setDate(), "", 1L));
        commentRepository.save(new Comment(102L, "test1", "테스트 댓글3", TimeValue.setDate(), "", 2L));
        commentRepository.save(new Comment(103L, "test2", "테스트 댓글4", TimeValue.setDate(), "", 2L));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initPost() {
        postService.save(new PostSaveDto("test1", "테스트 제목1", "테스트 본문1"));
        postService.save(new PostSaveDto("test2", "테스트 제목2", "테스트 본문2"));
    }
}
