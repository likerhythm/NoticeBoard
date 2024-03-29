package SpringNoticeBoard.NoticeBoard.controller;

import SpringNoticeBoard.NoticeBoard.SessionConst;
import SpringNoticeBoard.NoticeBoard.domain.comment.dto.CommentSaveDto;
import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostEditDto;
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
    public String savePost(HttpServletRequest request, Model model) {

        User loginUser = setSession(request);
        String loginUserName = loginUser.getName();
        model.addAttribute("loginUserName", loginUserName);

        return "savePost";
    }

    private static User setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        return loginUser;
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
        String loginUserName = setLoginUserName(request);
        setModelAttribute(model, findPost, findComments, loginUserName);

        return "post";
    }

    private static String setLoginUserName(HttpServletRequest request) {
        String loginUserName = (String) request.getAttribute("loginUserName");
        if (loginUserName == null) {
            loginUserName = "null";
        }
        return loginUserName;
    }

    private static void setModelAttribute(Model model, Post findPost, List<Comment> findComments, String loginUserName) {
        model.addAttribute("post", findPost);
        model.addAttribute("comments", findComments);
        model.addAttribute("loginUserName", loginUserName);
        model.addAttribute("commentSave", new CommentSaveDto());
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Post editPost = postService.findById(id);
        PostEditDto dto = new PostEditDto(id, editPost.getTitle(), editPost.getMainText());

        model.addAttribute("post", dto);

        return "editPost";
    }

    @GetMapping("/{id}/remove")
    public String remove(@PathVariable Long id) {

        postService.remove(id);
        return "redirect:/";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute PostEditDto dto) {

        postService.edit(dto.getId(), dto);
        return "redirect:/";
    }
}
