package com.toris.user.model.entity.seulshine;

import com.toris.user.model.entity.BaseEntity;
import com.toris.user.model.entity.kobe.Role;
import com.toris.user.model.enums.JoinChannel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;
    private String email; // 탈퇴했다가 재가입 계정이랑 중복될 수 있으니까 unique X, 탈퇴 내역도 로그로 남겨야 함
    private String password;
    private String nickname;

    // Entity가 생성되어 저장될 때 시간이 자동 저장됩니다.
//    @CreatedDate
//    private LocalDateTime createdDate;

    // 조회한 Entity 값을 변경할 때 시간이 자동 저장됩니다.
//    @LastModifiedDate
//    private LocalDateTime modifiedDate;

    private String phoneNumber;
    private String contactedEmail;
    private JoinChannel joinChannel;

    private String ci; // 쿠폰 테이블에 저장하면 빈 컬럼이 너무 많으니깐..?

    @OrderBy("role_id asc")
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns =  @JoinColumn(name ="USER_ID"), inverseJoinColumns= @JoinColumn(name="ROLE_ID"))
    private Set<Role> roles = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<Address> addresses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<Device> devices = new LinkedHashSet<>();
}
