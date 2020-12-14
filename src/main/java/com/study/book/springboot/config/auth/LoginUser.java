package com.study.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  //이 어노테이션이 생성될 수 있는 위치 지정. 파라미터로 지정했으니 메소드의 파라미터로 선언된 객체에서만 사용할 수 있음 (클래스 선언문에 쓸 수 있는 type)
@Retention(RetentionPolicy.RUNTIME) //어느 시점까지 어노테이션의 메모리를 가져갈 지 설정하고
public @interface LoginUser {
    //이 파일을 어노테이션 클래스로 지정

}
