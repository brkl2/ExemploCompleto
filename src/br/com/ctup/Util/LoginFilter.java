package br.com.ctup.Util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.ctup.controller.PessoaController;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
		PessoaController pc = (PessoaController)((HttpServletRequest) request).getSession().getAttribute("pessoaSessao");
		 //Verifica se a sessão não expirou, se sim volta para a página de login
	        HttpSession session = ((HttpServletRequest)request).getSession(false);
	        if(session != null && !session.isNew()) {
	            chain.doFilter(request, response);
	        } else {
	            //Retorna para a página de login
	        	((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/Login.jsp");
	        }
     
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
