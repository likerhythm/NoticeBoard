package SpringNoticeBoard.NoticeBoard.domain.user;

import SpringNoticeBoard.NoticeBoard.domain.user.dto.AddUserForm;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.LoginForm;
import SpringNoticeBoard.NoticeBoard.domain.user.dto.UserProfileEditDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class UserRepository {

    private static final Map<Long, User> store = new HashMap<>();
    private Long sequence = 0L;

    public User add(User user) {
        user.setId(++sequence);
        store.put(user.getId(), user);
        log.info("[ADD USER]={}", user);
        return user;
    }

    public User login(LoginForm form) {
        log.info("[LOGIN]={}", form);
        return findByEmail(form.getEmail())
                .filter(u -> u.getPassword().equals(form.getPassword()))
                .orElse(null);
    }

    public User edit(UserProfileEditDto user) {
        store.get(user.getId()).setIntroduction(user.getIntroduction());
        return store.get(user.getId());
    }

    //findAll
    public List<User> findAll() {
        return new ArrayList<User>(store.values());
    }

    //findByEmail
    public Optional<User> findByEmail(String email) {
        return store.values().stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();
    }

    //findByName
    public Optional<User> findByName(String name) {
        return store.values().stream()
                .filter(u -> u.getName().equals(name))
                .findFirst();
    }

    //findById
    public User findById (Long id) {
        return store.get(id);
    }

    //clear
    public void clear() {
        store.clear();
    }

    //delete
    public void remove (Long id) {
        store.remove(id);
    }
}
