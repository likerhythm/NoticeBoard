package SpringNoticeBoard.NoticeBoard.controller;

import SpringNoticeBoard.NoticeBoard.SessionConst;
import SpringNoticeBoard.NoticeBoard.domain.user.User;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.AddUserForm;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.LoginForm;
import SpringNoticeBoard.NoticeBoard.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    //회원가입
    @PostMapping("/add")
    public String addUser(@Validated @ModelAttribute AddUserForm addUserForm,
                          BindingResult bindingResult,
                          Model model) {
        if (hasBindingError(bindingResult)) {
            log.error("errors={}", bindingResult);
            return "/addUserForm";
        }
        addUser(addUserForm, model);
        return "redirect:/";
    }

    private void addUser(AddUserForm addUserForm, Model model) {
        User user = userService.add(addUserForm);
        model.addAttribute("user", user);
    }

    //로그인
    @PostMapping("/login")
    public String login(@ModelAttribute @Validated LoginForm loginForm,
                        BindingResult bindingResult,
                        HttpServletRequest request,
                        @RequestParam(defaultValue = "/main") String redirectURL) {

        if (hasBindingError(bindingResult)) {
            return "/loginForm";
        }

        User loginUser = userService.login(loginForm);
        if (loginUser == null) {
            return "redirect:/login?redirectURL=" + redirectURL;
        }
        //세션에 정보 저장
        setSession(request, loginUser);
        return "redirect:" + redirectURL;
    }

    private static boolean hasBindingError(BindingResult bindingResult) {
        return bindingResult.hasErrors();
    }

    private static void setSession(HttpServletRequest request, User loginUser) {
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);
    }

    //로그아웃
    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/main";
    }
}
