package SpringNoticeBoard.NoticeBoard.domain.user;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private static final Map<Long, User> store = new HashMap<>();

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
