package com.study.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate, modifiedDate)도 칼럼으로 인식하도록함
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity 클래스에 Auditing(자동으로 넣어줌) 기능을 포함시킴
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private  LocalDateTime modifiedDate;

}
