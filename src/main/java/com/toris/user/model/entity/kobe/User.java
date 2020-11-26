package com.toris.user.model.entity.kobe;

import com.toris.user.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class User extends BaseEntity {
    private String name;
    private String password;
    private String email;
}
