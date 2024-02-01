package SpringNoticeBoard.NoticeBoard.service;

import SpringNoticeBoard.NoticeBoard.domain.post.Post;
import SpringNoticeBoard.NoticeBoard.domain.post.PostRepository;
import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostSaveDto;
import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findAllByUser(Long id) {
        return postRepository.findAllByUser(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void update(Long id, PostUpdateDto dto) {
        postRepository.update(id, dto);
    }

    public Post save(PostSaveDto dto) {
        Post savePost = setPost(dto);
        return postRepository.save(savePost);
    }

    private static Post setPost(PostSaveDto dto) {
        Post savePost = new Post();
        savePost.setTitle(dto.getTitle());
        savePost.setMainText(dto.getMainText());
        savePost.setWriteDate(setDate());
        savePost.setModifyDate("");
        savePost.setUserId(dto.getUserId());
        return savePost;
    }

    private static String setDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToString = dateFormat.format(date);
        return dateToString;
    }
}
