package SpringNoticeBoard.NoticeBoard.service;

import SpringNoticeBoard.NoticeBoard.domain.post.Post;
import SpringNoticeBoard.NoticeBoard.domain.post.PostRepository;
import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostSaveDto;
import SpringNoticeBoard.NoticeBoard.domain.post.dto.PostEditDto;
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

    public List<Post> findAllByUser(String userName) {
        return postRepository.findAllByUser(userName);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void edit(Long id, PostEditDto dto) {
        String modifiedDate = setDate();
        postRepository.edit(id, dto, modifiedDate);
    }

    public Post save(PostSaveDto dto) {
        Post savePost = setPost(dto);
        return postRepository.save(savePost);
    }

    public void remove(Long id) {
        postRepository.remove(id);
    }

    private static Post setPost(PostSaveDto dto) {
        Post savePost = new Post();
        savePost.setTitle(dto.getTitle());
        savePost.setMainText(dto.getMainText());
        savePost.setWriteDate(setDate());
        savePost.setModifyDate("");
        savePost.setUserName(dto.getUserName());
        return savePost;
    }

    private static String setDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToString = dateFormat.format(date);
        return dateToString;
    }
}
