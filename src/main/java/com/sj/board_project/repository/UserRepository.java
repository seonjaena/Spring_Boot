package com.sj.board_project.repository;

import com.sj.board_project.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public User login(String id, String pw) {
        try {
            User user = em.createQuery("SELECT u FROM User u WHERE u.user_id = :user_id AND u.user_pw = :user_pw AND u.is_delete = :is_delete", User.class)
                    .setParameter("user_id", id)
                    .setParameter("user_pw", pw)
                    .setParameter("is_delete", 0)
                    .getSingleResult();
            return user;
        } catch(Exception e) {
            return null;
        }
    }

}
