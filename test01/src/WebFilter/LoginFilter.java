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
		//ȡ��SESSION�е�loginUser����
//		User user = (User)hsq.getSession().getAttribute("loginUser");
		HttpSession session = hsq.getSession();
		User user = (User) session.getAttribute("loginUser");
//		System.out.println(user.getName());
		if(user==null || "".equals(user)){
			//����û�û�е�¼����ô����ֱ����ת����½ҳ��
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
