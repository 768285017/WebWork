package WebFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

public class LoginFilter implements Filter {
	@Override
	public void destroy() {
 
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsq = (HttpServletRequest)req;
		//取得SESSION中的loginUser对象
//		User user = (User)hsq.getSession().getAttribute("loginUser");
		HttpSession session = hsq.getSession();
		User user = (User) session.getAttribute("loginUser");
//		System.out.println(user.getName());
		if(user==null || "".equals(user)){
			//如果用户没有登录，那么将会直接跳转到登陆页面
			req.getRequestDispatcher("/login.html").forward(req, resp);
			
		}else{
			chain.doFilter(req, resp);
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

 
}
