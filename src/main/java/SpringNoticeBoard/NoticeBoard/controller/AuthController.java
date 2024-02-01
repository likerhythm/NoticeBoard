package SpringNoticeBoard.NoticeBoard.controller;

import SpringNoticeBoard.NoticeBoard.SessionConst;
import SpringNoticeBoard.NoticeBoard.domain.user.User;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.AddUserForm;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.LoginForm;
import SpringNoticeBoard.NoticeBoard.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    //회원가입
    @PostMapping("/add")
    public String addUser(@ModelAttribute AddUserForm form, Model model) {
        User user = userService.add(form);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    //로그인
    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm form,
                        HttpServletRequest request) {
        User loginUser = userService.login(form);
        if (loginUser == null) {
            return "redirect:/login";
        }
        // 세션에 정보 저장 TODO
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);
        return "redirect:/main";
    }
}
