package SpringNoticeBoard.NoticeBoard.service;

import SpringNoticeBoard.NoticeBoard.domain.post.Post;
import SpringNoticeBoard.NoticeBoard.domain.post.PostRepository;
import SpringNoticeBoard.NoticeBoard.domain.user.User;
import SpringNoticeBoard.NoticeBoard.domain.user.UserRepository;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.AddUserForm;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.LoginForm;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.UserProfileDto;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.UserProfileEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public User add(AddUserForm form) {
        User user = setUser(form);
        return userRepository.add(user);
    }

    public UserProfileDto edit(UserProfileEditDto dto) {
        User user = userRepository.edit(dto);
        List<Post> posts = postRepository.findAllByUser(user.getName());
        return new UserProfileDto(user, posts);
    }

    public User login(LoginForm form) {
        return userRepository.login(form);
    }

    private static User setUser(AddUserForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setJoinDate(setDate());
        user.setName(form.getName());
        user.setAge(form.getAge());
        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User findByName(String name) {
        return userRepository.findByName(name).orElse(null);
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public void remove(Long id) {
        userRepository.remove(id);
    }

    private static String setDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToString = dateFormat.format(date);
        return dateToString;
    }
}
