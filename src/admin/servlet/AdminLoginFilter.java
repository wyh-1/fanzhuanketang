package admin.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminLoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session =req.getSession();
		if(session.getAttribute("userid")!=null && "2".equals(session.getAttribute("usertype"))){
			chain.doFilter(request, response);
		}else{
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
