package edu.nf.gc.web.interceptors;

import edu.nf.gc.entity.Staff;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Fu
 * @date 2019/12/20
 */
public class AuthorityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        url=url.substring(url.lastIndexOf("/"));
        Staff staff = (Staff) request.getSession().getAttribute("staff");
        List<String> staffAuthUrl = staff.getStaff_Authority();
        if(!staffAuthUrl.contains(url)){
            response.getWriter().println("<script>window.parent.location.href='500.html'</script>");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
