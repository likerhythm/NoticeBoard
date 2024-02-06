package SpringNoticeBoard.NoticeBoard.controller;

import SpringNoticeBoard.NoticeBoard.domain.post.Post;
import SpringNoticeBoard.NoticeBoard.domain.user.User;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.AddUserForm;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.LoginForm;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.UserProfileDto;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.UserProfileEditDto;
import SpringNoticeBoard.NoticeBoard.service.PostService;
import SpringNoticeBoard.NoticeBoard.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PostService postService;

    @GetMapping("/profile/{name}")
    public String profile(@PathVariable String name, Model model, HttpServletRequest request) {
        User user = userService.findByName(name);
        List<Post> posts = postService.findAllByUser(name);
        UserProfileDto dto = new UserProfileDto(user, posts);
        model.addAttribute("profileData", dto);
        model.addAttribute("loginUserName", request.getAttribute("loginUserName"));
        return "profile";
    }

    @PostMapping("/profile/edit")
    public String edit(@ModelAttribute UserProfileEditDto dto, Model model) {
        UserProfileDto profileData = userService.edit(dto);
        model.addAttribute("profileData", profileData);
        return "redirect:/profile/" + profileData.getName();
    }
}
