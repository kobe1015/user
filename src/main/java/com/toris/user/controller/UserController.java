package com.toris.user.controller;

import com.toris.user.model.dto.UserDto;
import com.toris.user.model.entity.seulshine.User;
import com.toris.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 요청 값으로 User Entity 대신에 별도의 DTO를 받는다.
     */
    @PostMapping("/save")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid
                                                     CreateMemberRequest request) {
        User user = new User();
        user.setName(request.getName());
        String name = userService.join(user);
        return new CreateMemberResponse(name);
    }

    @Data
    static class CreateMemberRequest {
        private String name;
    }
    @Data
    class CreateMemberResponse {
        private String name;
        public CreateMemberResponse(String name) {
            this.name = name;
        }
    }

    /**
     * 수정 API! (회원 이름만 수정)
     */
    @PutMapping("/update")
    public UpdateMemberResponse updateMemberV2(@RequestBody @Valid UpdateMemberRequest request) {
        userService.update(request.getName(), request.getPassword());
        User findUser = userService.fineByName(request.getName());
        return new UpdateMemberResponse(findUser.getName());
    }


    @Data
    static class UpdateMemberRequest {
        private String name;
        private String password;
    }
    @Data
    @AllArgsConstructor
    class UpdateMemberResponse {
        private String name;
    }
    
    /**
     * Entity 가 노출되지 않게 DTO 생성해서 반환!!
     */
    @GetMapping("/api/users/findAll")
    public Result membersV2() {
        List<User> findUsers = userService.findUsers();
        //엔티티 -> DTO 변환
        List<UserDto> collect = findUsers.stream()
                .map(u -> new UserDto(u.getId(), u.getName(), u.getEmail()))
                .collect(Collectors.toList());
        return new Result(collect);
    }
    @Data
    @AllArgsConstructor
    class Result<T> {
        private T data;
    }
}
