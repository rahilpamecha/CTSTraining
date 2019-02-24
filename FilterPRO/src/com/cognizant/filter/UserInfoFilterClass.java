package com.cognizant.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserInfoFilterClass
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, filterName = "UserInfoFilter", urlPatterns = { "/UserInfoFilter" }, servletNames = { "ComputeServlet" })
public class UserInfoFilterClass implements Filter {

    /**
     * Default constructor. 
     */
    public UserInfoFilterClass() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletResponse httpResponse=(HttpServletResponse)response;
		String userBrowserInfo=httpResponse.getHeader("User-Agent");
		PrintWriter out=response.getWriter();
		out.println("</br>"+userBrowserInfo);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
