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

/**
 * Servlet Filter implementation class PerformanceFilterClass
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, filterName = "PerformanceFilter", urlPatterns = { "/PerformanceFilter" }, servletNames = { "ComputeServlet" })
public class PerformanceFilterClass implements Filter {

    /**
     * Default constructor. 
     */
    public PerformanceFilterClass() {
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

		long before=System.currentTimeMillis();
		// pass the request along the filter chain
		chain.doFilter(request, response);
		long after=System.currentTimeMillis();
		
		//PrintWriter out=response.getWriter();
		//out.println("</br>Servlet took :"+(after-before));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
