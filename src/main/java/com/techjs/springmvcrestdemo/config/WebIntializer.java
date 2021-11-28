package com.techjs.springmvcrestdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebIntializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    @Override
    protected Class<?>[] getRootConfigClasses() 
    {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() 
    {
        return new Class[]{MyConfig.class};
    }

    @Override
    protected String[] getServletMappings() 
    {
        return new String[]{"/"};
    }
}
