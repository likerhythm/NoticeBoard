package SpringNoticeBoard.NoticeBoard.Controller;

import SpringNoticeBoard.NoticeBoard.domain.user.dto.AddUserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    //회원가입
    @PostMapping("/add")
    public String addUser(@ModelAttribute AddUserForm form) {

    }
}
