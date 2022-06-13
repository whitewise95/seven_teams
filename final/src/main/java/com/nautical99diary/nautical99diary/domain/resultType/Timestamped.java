package com.nautical99diary.nautical99diary.domain.resultType;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public abstract class Timestamped {

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
