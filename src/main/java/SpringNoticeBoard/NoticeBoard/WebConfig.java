package SpringNoticeBoard.NoticeBoard;

import SpringNoticeBoard.NoticeBoard.interceptor.AuthenticInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //뒤로가기 방지
        registry.addInterceptor(new AuthenticInterceptor())
                .order(1)
                .addPathPatterns("/**");
    }
}
