package com.study.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 룸복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);  //assertJ라는 테스트 검증 라이브러리의 검증 메소드
        assertThat(dto.getAmount()).isEqualTo(amount);  //isEqualTo : assertThat 에 있는 값과  isEqualTo 값을 비교해서 같을 때만 성공

    }
}
