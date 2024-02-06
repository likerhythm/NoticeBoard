package SpringNoticeBoard.NoticeBoard.controller;

import SpringNoticeBoard.NoticeBoard.SessionConst;
import SpringNoticeBoard.NoticeBoard.domain.user.User;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.AddUserForm;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.LoginForm;
import SpringNoticeBoard.NoticeBoard.service.PostService;
import SpringNoticeBoard.NoticeBoard.domain.post.Post;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final PostService postService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {

        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);

        if (loginUser != null) {
            return "redirect:/main";
        }
        return "home";
    }

    @GetMapping("/add")
    public String addUserForm(@ModelAttribute AddUserForm addUserForm) {
        return "addUserForm";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm) {
        return "loginForm";
    }

    @GetMapping("/main")
    public String main(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);

        if (loginUser != null) {
            model.addAttribute("user", loginUser);
        } else {
            model.addAttribute("user", new User());
        }

        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "main";
    }
}
