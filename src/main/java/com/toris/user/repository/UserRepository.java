package com.toris.user.repository;

import com.toris.user.model.entity.seulshine.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository // @Component + alpha
@RequiredArgsConstructor
public class UserRepository {

//    @PersistenceContext // Spring이 생성한 JPA EntityManager를 알아서 넣어줌!
//    private EntityManager em;

    private final EntityManager em; // 생성자 injection!


    public void save(User user){
        em.persist(user);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList(); // UserList를 반환!
        // SQL은 테이블을 대사으로 쿼리를 날리는데 entity 대상으로 쿼리를 날림!
        // entity User 를 alias를 u 로 주고 날림~
    }

    public User findByName(String name) {
        return em.createQuery("select u from User u where u.name = :name",
                User.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}