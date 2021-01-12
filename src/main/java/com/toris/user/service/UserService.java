package com.toris.user.service;

import com.toris.user.model.entity.seulshine.User;
import com.toris.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // final 있는 것만으로 생성자 만들어 줌! 생성자 injection 필요 없음!
public class UserService {

    private final UserRepository userRepository;

    /**
     *
    @Autowired // 이젠 Spring 에서 생성자 생성 시점에 Autowired 해줘서 안해줘도 됨!
    public UserService(UserRepository userRepository) { // 생성자 injection
        this.userRepository = userRepository;
    }

    */

    /**
     * 회원 가입
     * @param user
     * @return
     */
    @Transactional // 기본이 readOnly = false
    public String join(User user){

        // validateDuplicateUser(user);
        userRepository.save(user);

        return user.getName();
    }

    private void validateDuplicateUser(User user){
        // Exception
        User result = userRepository.findOne(user.getId());

        // isEmpty 가 에러남!!
//        if(!result.isEmpty()) {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }
    }



    //회원 전체 조회
    public List<User> findUsers() {
        return userRepository.findAll();
    }


    //회원 한 명 조회
    public User fineOne(Long id) {
        return userRepository.findOne(id);
    }

    //회원 한 명 조회
    public User fineByName(String name) {
        return userRepository.findByName(name);
    }

    /**
     * 회원 수정
     */
    @Transactional
    public void update(String name, String password) {
        User user = userRepository.findByName(name); // 영속성 Context 에서 객체 올리고
        // jpa 변경 감지!!
        user.setName(name); // Transaction 관련 AOP 가 끝나는 시점에 (COMMIT 시점 ) 영속성 Context flush 하고 database transaction commit
        user.setPassword(password);
    }

}
