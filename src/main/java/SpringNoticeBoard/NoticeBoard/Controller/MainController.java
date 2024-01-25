package SpringNoticeBoard.NoticeBoard.Controller;

import SpringNoticeBoard.NoticeBoard.Service.PostService;
import SpringNoticeBoard.NoticeBoard.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final PostService postService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/users/add")
    public String addUserForm() {
        return "addUserForm";
    }

    @GetMapping("/login")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/main")
    public String main(Model model) {

        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "main";
    }
}
