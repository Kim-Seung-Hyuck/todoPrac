package org.zerock.spring1.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * web.xml 을 대신할 설정 파일
 *
 * 내부적으로 AbstractAnnotationConfigDispatcherServletInitializer는 DispatcherServlet과 ContextLoaderListener를 생성한다.
 *     -> ContextLoaderListener는 RootApplicationContext를 생성하는 클래스
 *
 * */

//web.xml을 대신한다.
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    //root는 배열.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class}; //class = reflection
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ZerockServletConfig.class};
    }

    //어떤 경로를 통해서 하겠냐.
    //한 번 해주면 더 이상 수정해주지 않아도 된다.
    //여러개 나눠서 쓸 때는 수정해야하긴 함.

    /*
     * Front Controller Pattern
     * 지정된 경로로 들어오는 모든 요청이 거쳐서 간다
     * */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters(){
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        return new Filter[] {filter};
    }
}
