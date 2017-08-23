package com.csy.server.filter;

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

import com.csy.module.wx.entity.BWxUser;

public class WxAccessFilter implements Filter {

  @Override
  public void destroy(){
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException{
    HttpServletRequest req = (HttpServletRequest) request;  
    HttpServletResponse res = (HttpServletResponse) response;  
    
    String url = req.getRequestURI();
    if(url.contains("/wx/") && !url.contains("/wx/baseAuthorize") && !url.contains("/wx/kckpTest")){
      HttpSession session = req.getSession(true);
      BWxUser user = (BWxUser)session.getAttribute("bWxUser");
      if(user == null){
        session.setAttribute("wx_targetUrl", url);
        res.sendRedirect(session.getServletContext().getContextPath() + "/wx/baseAuthorize");
      }
      chain.doFilter(req, res);
    }else{
      chain.doFilter(req, res);
    }
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException{
    
  }
  
}
