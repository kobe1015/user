package com.toris.user.model.entity.seulshine;

import com.toris.user.model.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;
    private String email; // 탈퇴했다가 재가입 계정이랑 중복될 수 있으니까 unique X, 탈퇴 내역도 로그로 남겨야 함
    private String password;
    private String nickName;

    // Entity가 생성되어 저장될 때 시간이 자동 저장됩니다.
    @CreatedDate
    private LocalDateTime createdDate;

    // 조회한 Entity 값을 변경할 때 시간이 자동 저장됩니다.
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Enumerated(EnumType.STRING)
    private RoleType roleType; // function 으로 등급 가져올 수 있지 않을까?? (ex) 주문 횟수 계산 혹은 포인트 합산 계산 함수)
    // 회원은 여러개의 권한(role)을 가진다 ??
    private String phoneNumber;
    private String contactedEmail;
    private String registerChannel;
}
