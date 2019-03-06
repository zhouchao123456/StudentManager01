package com.qfedu.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*.html")
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String username = (String) request.getSession().getAttribute("username");
        String servletPath = request.getServletPath();

        if("/ajaxLogin.html".equals(servletPath)){
            chain.doFilter(request,response);

        }else if ("/ajaxRegister.html".equals(servletPath)){
            chain.doFilter(request,response);
        } else if (username==null){
            response.sendRedirect("ajaxLogin.html");
        }else{
            chain.doFilter(request,response);
        }

    }

    }

