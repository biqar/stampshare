package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/13/13
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */

@WebFilter(filterName = "LoginFilter", servletNames = "Faces Servlet", urlPatterns = {"/*"})
public class LoginFilter implements Filter {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private String requestedUri;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        request = (HttpServletRequest) servletRequest;
        response = (HttpServletResponse) servletResponse;
        session = request.getSession(false);
        requestedUri = request.getRequestURI().toString();

        System.out.println("doFilter: " + requestedUri);

        if (requestedUri.equals("/stampshare/home")) {
            redirect(servletRequest, servletResponse, filterChain);
        } else if (requestedUri.equals("/stampshare/add_stamp")) {
            redirect(servletRequest, servletResponse, filterChain);
        } else if (requestedUri.equals("/stamp_share/show_user_profile")) {
            redirect(servletRequest, servletResponse, filterChain);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void redirect(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if ((session == null || session.getAttribute("user") == null)) {
            response.sendRedirect("/stampshare/index");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}