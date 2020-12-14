package com.toris.user;


import com.toris.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class UserApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void userTest() {
        userRepository.findAll()
                .stream()
                .map(i -> i.toString());
    }

}
