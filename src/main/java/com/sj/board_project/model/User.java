package com.sj.board_project.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
public class User {

    @Column(name = "USER_IDX")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_idx;

    @Column(name = "USER_NAME")
    private String user_name;

    @Column(name = "USER_EMAIL")
    private String user_email;

    @Column(name = "USER_ID")
    private String user_id;

    @Column(name = "USER_PW")
    private String user_pw;

    @Column(name = "USER_NICKNAME")
    private String user_nickname;

    @Column(name = "IS_DELETE")
    private int is_delete;

    @Column(name = "ZIP_CODE")
    private String zip_code;

    @Column(name = "MAIN_ADDR")
    private String main_addr;

    @Column(name = "REFERENCE_ADDR")
    private String reference_addr;

    @Column(name = "DETAIL_ADDR")
    private String detail_addr;

    @Column(name = "IS_VALIDATION")
    private int is_validation;

    public static User createJoinUser(String user_name, String user_email, String user_id, String user_pw, String user_nickname, String zip_code, String main_addr, String reference_addr, String detail_addr) {
        User user = new User();
        user.setUser_name(user_name);
        user.setUser_email(user_email);
        user.setUser_id(user_id);
        user.setUser_pw(user_pw);
        user.setUser_nickname(user_nickname);
        user.setZip_code(zip_code);
        user.setMain_addr(main_addr);
        user.setReference_addr(reference_addr);
        user.setDetail_addr(detail_addr);
        return user;
    }

}
