package com.toris.user.model.entity.seulshine;

import com.toris.user.model.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;
    private String name;
    private String nickname;
    private String zipCode;
    private String address;
    private String addressDetail;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
