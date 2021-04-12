package com.sj.board_project.repository;

import com.sj.board_project.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

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

    public void join(User user) {
        em.persist(user);
    }

    public String checkUserIdExist(String user_id) {
        try {
            String user = em.createQuery("SELECT u.user_id FROM User u WHERE u.user_id = :user_id", String.class)
                    .setParameter("user_id", user_id)
                    .getSingleResult();
            return "true";
        }catch(Exception e) {
            return "false";
        }
    }

    public String checkUserNickNameExist(String user_nickname) {
        try {
            String user = em.createQuery("SELECT u.user_nickname FROM User u WHERE u.user_nickname = :user_nickname", String.class)
                    .setParameter("user_nickname", user_nickname)
                    .getSingleResult();
            return "true";
        }catch(Exception e) {
            return "false";
        }
    }

    public void deleteUserId() {
    }

}
