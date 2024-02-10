package SpringNoticeBoard.NoticeBoard.interceptor;

import SpringNoticeBoard.NoticeBoard.SessionConst;
import SpringNoticeBoard.NoticeBoard.domain.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    //TODO 서버에 존재하지 않는 페이지로 이동할 때도 로그인을 요구함.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession(false);
        log.info("[PREHANDLE]requestURI={}", requestURI);


        //로그인 상태가 아닌 경우
        if (session == null || session.getAttribute(SessionConst.LOGIN_USER) == null) {
            if (!requestURI.startsWith("/post") || "/post/save".equals(requestURI)) {
                response.sendRedirect("/login?redirectURL=" + requestURI);
                return false;
            }
        }

        String loginUserName;
        if (session != null && session.getAttribute(SessionConst.LOGIN_USER) == null) {
            loginUserName = ((User) session.getAttribute(SessionConst.LOGIN_USER)).getName();
        } else {
            loginUserName = "";
        }
        request.setAttribute("loginUserName", loginUserName);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("[INTERCEPTOR - PostHandler] ModelAndView.getModel()={}", modelAndView.getModel());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
