package SpringNoticeBoard.NoticeBoard.controller;

import SpringNoticeBoard.NoticeBoard.SessionConst;
import SpringNoticeBoard.NoticeBoard.domain.user.User;
import SpringNoticeBoard.NoticeBoard.service.CommentService;
import SpringNoticeBoard.NoticeBoard.service.PostService;
import SpringNoticeBoard.NoticeBoard.domain.comment.Comment;
import SpringNoticeBoard.NoticeBoard.domain.post.Post;
import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostSaveDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @GetMapping("/save")
    public String savePost() {
        return "savePost";
    }

    @PostMapping
    public String savePost(@ModelAttribute PostSaveDto dto) {
        Post savedPost = postService.save(dto);
        log.info("savedPost={}", savedPost);
        return "redirect:/post/" + String.valueOf(savedPost.getId());
    }

    @GetMapping("/{id}")
    public String post(@PathVariable Long id, Model model,
                       HttpServletRequest request) {
        Post findPost = postService.findById(id);
        List<Comment> findComments = commentService.findByPostId(id);
        HttpSession session = request.getSession();
        if (session == null) {
            return "home";
        }
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        String loginUserName = loginUser.getName();

        model.addAttribute("post", findPost);
        model.addAttribute("comments", findComments);
        model.addAttribute("loginUserName", loginUserName);

        return "post";
    }
}
