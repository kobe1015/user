package com.toris.user.model.dto;

import com.toris.user.model.enums.JoinChannel;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {

    public Long userId;
    public String email;
    public String password;
    public LocalDateTime changedPasswordAt;
    public String name;
    public String zipCode;
    public String address;
    public String addressDetail;
    public String phoneNumber;
    public LocalDateTime joinedAt;
    public JoinChannel joinChannel;
    public String extraEmail;
}
