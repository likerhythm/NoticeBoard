package SpringNoticeBoard.NoticeBoard.Controller;

import SpringNoticeBoard.NoticeBoard.Service.CommentService;
import SpringNoticeBoard.NoticeBoard.Service.PostService;
import SpringNoticeBoard.NoticeBoard.domain.comment.Comment;
import SpringNoticeBoard.NoticeBoard.domain.post.Post;
import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostSaveDto;
import jakarta.annotation.PostConstruct;
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
    public String post(@PathVariable Long id, Model model) {
        Post findPost = postService.findById(id);
        //댓글 가져와서 model에 등록 TODO
        List<Comment> findComments = commentService.findByPostId(id);

        model.addAttribute("post", findPost);
        model.addAttribute("comments", findComments);

        return "post";
    }
}
