package SpringNoticeBoard.NoticeBoard.repository;

import SpringNoticeBoard.NoticeBoard.domain.user.User;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.UserProfileEditDto;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User add(User user);

    User edit(UserProfileEditDto user);

    List<User> findAll();

    Optional<User> findByEmail(String email);

    Optional<User> findByName(String name);

    User findById(Long id);

    void remove(Long id);
}
