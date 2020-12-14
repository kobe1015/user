package com.toris.user.model.entity.seulshine;


import com.toris.user.model.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Device extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deviceNo;

    private String name;
    private String os;
    private String appVersion;
    private String pushToken;
    private String uid;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
