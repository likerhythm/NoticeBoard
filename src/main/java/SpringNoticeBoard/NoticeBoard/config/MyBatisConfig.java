//package SpringNoticeBoard.NoticeBoard.config;
//
//import SpringNoticeBoard.NoticeBoard.repository.CommentRepository;
//import SpringNoticeBoard.NoticeBoard.repository.PostRepository;
//import SpringNoticeBoard.NoticeBoard.repository.UserRepository;
//import SpringNoticeBoard.NoticeBoard.repository.mybatis.*;
//import SpringNoticeBoard.NoticeBoard.service.CommentService;
//import SpringNoticeBoard.NoticeBoard.service.PostService;
//import SpringNoticeBoard.NoticeBoard.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
////MyBatis Repository 사용 설정
//@Configuration
//@RequiredArgsConstructor
//public class MyBatisConfig {
//
//    private final CommentMapper commentMapper;
//    private final PostMapper postMapper;
//    private final UserMapper userMapper;
//
//    @Bean
//    public CommentService commentService() {
//        return new CommentService(commentRepository());
//    }
//
//    @Bean
//    public CommentRepository commentRepository() {
//        return new MyBatisCommentRepository(commentMapper);
//    }
//
//    @Bean
//    public PostService postService() {
//        return new PostService(postRepository());
//    }
//
//    @Bean
//    public PostRepository postRepository() {
//        return new MyBatisPostRepository(postMapper);
//    }
//
//    @Bean
//    public UserService userService() {
//        return new UserService(userRepository(), postRepository());
//    }
//
//    @Bean
//    public UserRepository userRepository() {
//        return new MyBatisUserRepository(userMapper);
//    }
//}
