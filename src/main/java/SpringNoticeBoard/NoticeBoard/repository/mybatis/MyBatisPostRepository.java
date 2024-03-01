package SpringNoticeBoard.NoticeBoard.repository.mybatis;

import SpringNoticeBoard.NoticeBoard.domain.post.Post;
import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostEditDto;
import SpringNoticeBoard.NoticeBoard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyBatisPostRepository implements PostRepository {

    private final PostMapper postMapper;

    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public Post findById(Long id) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public List<Post> findAllByUser(String userName) {
        return null;
    }

    @Override
    public void edit(Long id, PostEditDto dto, String modifyDate) {
        postMapper.editPost(id, dto, modifyDate);
    }

    @Override
    public void remove(Long id) {
        postMapper.removePost(id);
    }
}
