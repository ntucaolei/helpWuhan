package main.java;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {
	public CorsFilter() {

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		httpServletResponse.setContentType("application/json;charset=utf-8");

		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Headers",
				"User-Agent,Origin,Cache-Control,Content-type,Date,Server,withCredentials,AccessToken");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
//		httpServletResponse.setHeader("Expires", "-1");
//		httpServletResponse.setHeader("Cache-Control", "no-cache");
//		httpServletResponse.setHeader("pragma", "no-cache");

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}