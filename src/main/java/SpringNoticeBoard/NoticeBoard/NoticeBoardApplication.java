package SpringNoticeBoard.NoticeBoard;

//import SpringNoticeBoard.NoticeBoard.config.MyBatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Import(MyBatisConfig.class)
//@SpringBootApplication(scanBasePackages = {
//		"SpringNoticeBoard.NoticeBoard.controller",
//		"SpringNoticeBoard.NoticeBoard.interceptor"})
@SpringBootApplication
public class NoticeBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoticeBoardApplication.class, args);
	}

}
