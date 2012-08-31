/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.other;

import java.io.IOException;
import java.io.Serializable;
import javax.servlet.*;

/**
 *
 * @author ---GPL---
 */
public class CharacterEncodingFilter implements Filter, Serializable 
{
    private static final long serialVersionUID = -4246457499875267088L;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new NotSupportedException("Is it necessary to realize me ??");
    }

    @Override
    public void destroy() {
        //throw new NotSupportedException("Is it necessary to realize me ??");
    }
}