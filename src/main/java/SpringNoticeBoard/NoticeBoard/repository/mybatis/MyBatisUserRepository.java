package SpringNoticeBoard.NoticeBoard.repository.mybatis;

import SpringNoticeBoard.NoticeBoard.domain.user.User;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.UserProfileEditDto;
import SpringNoticeBoard.NoticeBoard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MyBatisUserRepository implements UserRepository {

    private final UserMapper userMapper;

    @Override
    public User add(User user) {
        userMapper.add(user);
        return userMapper.findByIdUser(user.getId());
    }

    @Override
    public User edit(UserProfileEditDto user) {
        userMapper.editUser(user);
        return userMapper.findByIdUser(user.getId());
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public User findById(Long id) {
        return userMapper.findByIdUser(id);
    }

    @Override
    public void remove(Long id) {
        userMapper.removeUser(id);
    }
}
