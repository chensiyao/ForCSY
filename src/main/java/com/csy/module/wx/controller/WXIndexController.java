package com.csy.module.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("menu")
public class WXIndexController{
  
  @RequestMapping("/{pageName}")
  public ModelAndView wxSearchIndex(@PathVariable String pageName){
    return new ModelAndView("/weixin/index/" + pageName);
  }
  
}
