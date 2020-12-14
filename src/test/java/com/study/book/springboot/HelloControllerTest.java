package com.study.book.springboot;


import com.study.book.springboot.config.auth.SecurityConfig;
import com.study.book.springboot.web.HelloController;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자 실행  //스프링부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class,
excludeFilters = {  //webMvcTest 어노테이션은 repository, service, component 어노테이션을 스캔하지x
        // securityConfig를 읽었지만, CustomOAuth2UserService를 읽을수 없어서 에러가 발생하니
        // 스캔대상에서 securityConfig 제거
        // (에러 코드 :no qualifying bean of type 'com.~~~.springboot.config.auth.CustomOAuth2UserService'
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
}) //spring mvc에 집중할 수 있는 어노테이션, jpa 기능 작동하지 x
public class HelloControllerTest {
    @Autowired  //스프링이 관리하는 빈을 주입 받음
    private MockMvc mvc;    //웹 API 테스트 할 때 사용 //스프링 mvc 테스트의 시작점  //이 클래스를 통해 http, get, post 대한 테스트 가능

    @Test
    @WithMockUser(roles="USER")
    public void hello가_리턴된다() throws  Exception{
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }

    @Test
    @WithMockUser(roles="USER")
    public void helloDto가_리턴된다() throws  Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is(name)))
                .andExpect(jsonPath("$.amount",Matchers.is(amount)));
    }
}
