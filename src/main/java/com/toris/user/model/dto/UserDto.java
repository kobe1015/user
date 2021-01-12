package com.toris.user.model.dto;

import com.toris.user.model.entity.seulshine.Address;
import com.toris.user.model.entity.seulshine.Device;
import com.toris.user.model.entity.seulshine.Role;
import com.toris.user.model.enums.JoinChannel;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Set;


@Data
@AllArgsConstructor
@Getter @Setter
public class UserDto {

    private Long id;
    private String name;
    private String email;
}
