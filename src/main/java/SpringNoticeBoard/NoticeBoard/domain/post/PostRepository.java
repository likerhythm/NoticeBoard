package SpringNoticeBoard.NoticeBoard.domain.post;

import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostEditDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Slf4j
@Repository
public class PostRepository {

    private static final Map<Long, Post> store = new HashMap<>();
    private static long sequence = 0L;

    public Post save(Post post) {
        post.setId(++sequence);
        store.put(post.getId(), post);
        return post;
    }

    public Post findById(Long id) {
        return store.get(id);
    }

    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    public List<Post> findAllByUser(Long userId) {
        List<Post> posts = store.values().stream()
                            .filter(p -> p.getUserName().equals(userId))
                            .collect(Collectors.toList());
        log.info("posts={}", posts);
        return posts;
    }

    public void edit(Long id, PostEditDto dto, String modifyDate) {
        Post findPost = findById(id);
        findPost.setTitle(dto.getTitle());
        findPost.setMainText(dto.getMainText());
        findPost.setModifyDate(modifyDate);
    }

    public void remove(Long id) {
        store.remove(id);
    }

    public void clear() {
        store.clear();
    }
}
