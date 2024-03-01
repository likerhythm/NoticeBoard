package SpringNoticeBoard.NoticeBoard.repository.mybatis;

import SpringNoticeBoard.NoticeBoard.domain.user.User;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.UserProfileEditDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    void add(User user);

    //repository에서 User 반환해야
    void editUser(UserProfileEditDto user);

    List<User> findAll();

    Optional<User> findByEmail(String email);

    Optional<User> findByName(String name);

    User findByIdUser(Long id);

    void removeUser(Long id);
}
